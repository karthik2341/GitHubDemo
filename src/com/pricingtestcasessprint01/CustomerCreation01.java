package com.pricingtestcasessprint01;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingMenu;
import com.pompricing100.PricingLoginPage;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.JdbcConnection;
import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;




public class CustomerCreation01  {
	
	@Parameters({"prjName","testEnvironment","testBrowser"})
	@BeforeClass
	public void oneTimeSetup(String prjName,String testEnvironment,String testBrowser) throws Exception{
		String tcName   = this.getClass().getSimpleName();
		String userName = System.getProperty("user.name");
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 	    
	    String date = formatter1.format(cal.getTime());						
		String envPath = System.getenv("Automation_Path");			
		HTMLReport hm1 = new HTMLReport(prjName,testEnvironment,testBrowser,tcName,userName,date,envPath);	
		hm1.htmlBuilder();		
		ReadObject rc = new ReadObject();
		Properties p = rc.getObjectRepository();
		WebControls wc = new WebControls();
		wc.startSelenium("URL should be opened",p,testBrowser);		
	}
	
	@Test(priority=1)
	@Parameters({"prjName","testEnvironment","testBrowser"})
	public void customerCreation() throws Exception{
		try{
					
			
		//Classes Creation		
		WebControls wc = new WebControls();
		PricingLoginPage pl = new PricingLoginPage();	
		PricingMenu pm = new PricingMenu();
		PricingCustomerInformation pci = new PricingCustomerInformation();
		ExcelReader er = new ExcelReader();	
	    HTMLReport hr = new HTMLReport();
		
		//Store the data from excel Sheet into hashMap
		LinkedHashMap<String,String> hm = (LinkedHashMap<String, String>) er.getKnownGoodMap(System.getProperty("user.dir") + "\\TestData\\Customer_Creation.xls", "Customer_Creation", 1);
		
		//login into application
		hr.writeStepInformation("Step 1 : Login into JDEdwards Application ");
		pl.login();		
		//verify title
		
		hr.writeStepInformation("Step 2 : Navigate to Customer Maintenance from the Drop Down Menu");
		wc.verifyHomePageTitle("Verify the home page title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
		//Click Navigator Button
		wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
		//Click Master Data
		wc.webActions("Click on Master Data","click","xpath",pm.HOME_MASTERDATA_BTN_XPATH, "Master Data", "", "");
		//Click Customer Information
		wc.webActions("Click on Customer Information","click","xpath",pm.HOME_CUSTOMERINFO_BTN_XPATH, "Customer Information", "", "");
		//Click Customer Maintenance
		wc.webActions("Click on Customer Maintenance","click","xpath",pm.HOME_CUSTOMERMAINT_BTN_XPATH, "Customer Maintenance", "", "");		
		// Wait for 3 seconds
		wc.setTimeOut(3);
		//Switch the frame
		wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
		//Click on Add Button
		wc.webActions("Click on Add Button","click","xpath",pci.PCI_ADD_BTN_XPATH, "Add Button", "", "");
		// Wait for 5 seconds
		wc.setTimeOut(5);
		
		
		//*************************************************Bill To Creation********************************************************************************************************************************
		hr.writeStepInformation("Step 3 : Enter AlphaName,MailingName,AddressLine1,City,State and Postal Code in Customer Contacts tab for Bill-To");
		// Enter Data in Contacts Tab
		pci.enterTextCustomerContacts(hm.get("AlphaName"),hm.get("MailingName"),hm.get("AddressLine1"),hm.get("City"),hm.get("State"),hm.get("Postal Code"));
		// Enter Data in Customer Master Tab		
		hr.writeStepInformation("Step 4 : Enter Payment Terms,Credit Manager,Collection Manager,Commission Code1,Market Class and Credit Limit in Customer Master tab for Bill-To");
		pci.enterTextCustomerMaster(hm.get("Payment Terms"), hm.get("Credit Manager"), hm.get("Collection Manager"), hm.get("Commission Code1"), hm.get("Market Class"), hm.get("Credit Limit"));
		//Enter Data in Customer Addition Information Tab.		
		hr.writeStepInformation("Step 5 : Enter Market Sub Class,Market Speciality,Cash Associate,Credit Associate and Market Class in Customer Additional Information tab for Bill-To");
		pci.enterTextCustomerAdditionalInfo(hm.get("Market Sub Class"), hm.get("Market Speciality"), hm.get("Cash Associate"), hm.get("Credit Associate"), hm.get("Market Class"));
		//Click On Save Button
		hr.writeStepInformation("Step 6: Click on Save Button");
		pci.click_Save();
		//Get the BillToNumber
		hr.writeStepInformation("Step 7 : Validate Bill To is created");
		String billToNumber = wc.returnTextFromValueAttribute("Get the Bill To Number","xpath",pci.PCI_BILLTO_NUMBER,"Bill To Number");
		//Update the BillToNumber in the Master Spread Sheet.
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cBillToCustomer", 2, billToNumber);
		//*****************************************************End Of Bill-To Creation************************************************************************************************************
		
		//*****************************************************Ship-To Creation******************************************************************************************************************
		//Click on Add Button.
		hr.writeStepInformation("Step 8 : Click on Add Button for the Ship to Creation");
		wc.webActions("Click on 'Add'","click","xpath",pci.PCI_ADD_BTN_XPATH, "Add Button", "", "");
		//wait for 10 seconds.
		wc.setTimeOut(10);
		// Enter Data in Contacts Tab
		hr.writeStepInformation("Step 9 : Enter AlphaName,MailingName,AddressLine1,City,State and Postal Code in Customer Contacts tab for Ship-To");
		pci.enterTextCustomerContacts(hm.get("AlphaName"),hm.get("MailingName"),hm.get("AddressLine1"),hm.get("City"),hm.get("State"),hm.get("Postal Code"));
		// Enter Data in Customer Master Tab	
		hr.writeStepInformation("Step 10 : Enter Payment Terms,Credit Manager,Collection Manager,Commission Code1,Market Class and Credit Limit in Customer Master tab for Ship-To");
		pci.enterTextCustomerMaster(hm.get("Payment Terms"), hm.get("Credit Manager"), hm.get("Collection Manager"), hm.get("Commission Code1"), hm.get("Market Class"), hm.get("Credit Limit"));
		// Enter Additional Data in Customer Master Tab.
		hr.writeStepInformation("Step 11: Enter the Bill-To in Customer Master");
		pci.change_Customer_Master(billToNumber, hm.get("AddressType"));
		//Enter Data in Customer Addition Information Tab.	
		hr.writeStepInformation("Step 12 : Enter Market Sub Class,Market Speciality,Cash Associate,Credit Associate and Market Class in Customer Additional Information tab for Ship-To");
		pci.enterTextCustomerAdditionalInfo(hm.get("Market Sub Class"), hm.get("Market Speciality"), hm.get("Cash Associate"), hm.get("Credit Associate"), hm.get("Market Class"));
		//Enter Data in Customer Additional Information Tab.
		hr.writeStepInformation("Step 13 : Enter the Bill to Number in Customer additional Info Tab for Ship-To creation");
		pci.customer_additional_info_2(billToNumber);
		//Click On Save Button
		pci.click_Save();
		//Get the ShipToNumber
		hr.writeStepInformation("Step 14 : Validate Ship To is created");
		String shipToNumber = wc.returnTextFromValueAttribute("Get the Ship To Number","xpath",pci.PCI_SHIPTO_NUMBER,"Ship To Number");
		//Update the ShipToNumber in the Master Spread Sheet.
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cShipToCustomer", 2, shipToNumber);
		//*****************************************************End of Ship-To Creation**********************************************************************************************************************
		
		//CAMS Process for Bill-to
		hr.writeStepInformation("Step 15 : CAMS Process for Bill-To");
		pci.customer_maint_CAMS_Process(billToNumber, hm.get("Fast Path"), hm.get("Batch"), hm.get("BatchVersion"));
		//CAMS Process for Ship-to
		hr.writeStepInformation("Step 16 : CAMS Process for Ship-To");
		pci.customer_maint_CAMS_Process(shipToNumber, hm.get("Fast Path"), hm.get("Batch"), hm.get("BatchVersion"));
		//Update SQL results in the Master Spread Sheet.
		JdbcConnection.jdbcConnection("SELECT IMITM,IMPRP0,IMSTKT,IMCARP,IMSRP4,IMSRP2,IMSRTX,DATE(DIGITS(DECIMAL(\"CIY55IENDT\" + 1900000,7,0))) AS ENDDATE, RAND() AS IDX FROM CRPDTA.F4101,CRPDTA.F5521020 WHERE IMSTKT ='P' AND IMSRP4='A' AND IMSRP2<>'' AND DATE(DIGITS(DECIMAL(\"CIY55IENDT\" + 1900000,7,0))) < '01/01/2013' AND CRPDTA.F5521020.CILITM =CRPDTA.F4101.IMLITM ORDER BY IDX FETCH FIRST 1 ROWS ONLY","jdbc:as400://10.16.64.5:446/","efub73cx","Dinu_aug14");
		
		}
		catch(Exception e){
		e.printStackTrace();
		}
		
		
	}
	
	@AfterClass
	public void oneTearDown() throws Exception 
	{
		HTMLReport hm1 = new HTMLReport();
		String tcName   = this.getClass().getSimpleName();
		hm1.writeToHTMLAfterClass(tcName);
		WebControls wc = new WebControls();
		wc.stopSelenium();		
	}
	
	
}
