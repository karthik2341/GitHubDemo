package com.pricingtestcasessprint01;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
		wc.startSelenium(p,testBrowser);		
	}
	
	@Test
	public void customerCreation() throws Exception{
		try{
			
		//Classes Creation		
		WebControls wc = new WebControls();
		PricingLoginPage pl = new PricingLoginPage();	
		PricingMenu pm = new PricingMenu();
		PricingCustomerInformation pci = new PricingCustomerInformation();
		ExcelReader er = new ExcelReader();	
		
		//Store the data from excel Sheet into hashMap
		LinkedHashMap<String,String> hm = (LinkedHashMap<String, String>) er.getKnownGoodMap(System.getProperty("user.dir") + "\\TestData\\Customer_Creation.xls", "Customer_Creation", 1);
		
		//login into application
		pl.login();		
		//verify title
		wc.verifyHomePageTitle("xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
		//Click Navigator Button
		wc.webActions("click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
		//Click Master Data
		wc.webActions("click","xpath",pm.HOME_MASTERDATA_BTN_XPATH, "Master Data", "", "");
		//Click Customer Information
		wc.webActions("click","xpath",pm.HOME_CUSTOMERINFO_BTN_XPATH, "Customer Information", "", "");
		//Click Customer Maintenance
		wc.webActions("click","xpath",pm.HOME_CUSTOMERMAINT_BTN_XPATH, "Customer Maintenance", "", "");		
		// Wait for 3 seconds
		wc.setTimeOut(3);
		//Switch the frame
		wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
		//Click on Add Button
		wc.webActions("click","xpath",pci.PCI_ADD_BTN_XPATH, "Add Button", "", "");
		// Wait for 5 seconds
		wc.setTimeOut(5);
		
		
		//*************************************************Bill To Creation********************************************************************************************************************************
		// Enter Data in Contacts Tab
		pci.enterTextCustomerContacts(hm.get("AlphaName"),hm.get("MailingName"),hm.get("AddressLine1"),hm.get("City"),hm.get("State"),hm.get("Postal Code"));
		// Enter Data in Customer Master Tab		
		pci.enterTextCustomerMaster(hm.get("Payment Terms"), hm.get("Credit Manager"), hm.get("Collection Manager"), hm.get("Commission Code1"), hm.get("Market Class"), hm.get("Credit Limit"));
		//Enter Data in Customer Addition Information Tab.		
		pci.enterTextCustomerAdditionalInfo(hm.get("Market Sub Class"), hm.get("Market Speciality"), hm.get("Cash Associate"), hm.get("Credit Associate"), hm.get("Market Class"));
		//Click On Save Button
		pci.click_Save();
		//Get the BillToNumber
		String billToNumber = wc.returnTextFromValueAttribute("xpath",pci.PCI_BILLTO_NUMBER,"Bill To Number");
		//Update the BillToNumber in the Master Spread Sheet.
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cBillToCustomer", 2, billToNumber);
		//*****************************************************End Of Bill-To Creation************************************************************************************************************
		
		//*****************************************************Ship-To Creation******************************************************************************************************************
		//Click on Add Button.
		wc.webActions("click","xpath",pci.PCI_ADD_BTN_XPATH, "Add Button", "", "");
		//wait for 10 seconds.
		wc.setTimeOut(10);
		// Enter Data in Contacts Tab
		pci.enterTextCustomerContacts(hm.get("AlphaName"),hm.get("MailingName"),hm.get("AddressLine1"),hm.get("City"),hm.get("State"),hm.get("Postal Code"));
		// Enter Data in Customer Master Tab		
		pci.enterTextCustomerMaster(hm.get("Payment Terms"), hm.get("Credit Manager"), hm.get("Collection Manager"), hm.get("Commission Code1"), hm.get("Market Class"), hm.get("Credit Limit"));
		// Enter Additional Data in Customer Master Tab.
		pci.change_Customer_Master(billToNumber, hm.get("AddressType"));
		//Enter Data in Customer Addition Information Tab.		
		pci.enterTextCustomerAdditionalInfo(hm.get("Market Sub Class"), hm.get("Market Speciality"), hm.get("Cash Associate"), hm.get("Credit Associate"), hm.get("Market Class"));
		//Enter Data in Customer Additional Information Tab.
		pci.customer_additional_info_2(billToNumber);
		//Click On Save Button
		pci.click_Save();
		//Get the ShipToNumber
		String shipToNumber = wc.returnTextFromValueAttribute("xpath",pci.PCI_SHIPTO_NUMBER,"Ship To Number");
		//Update the ShipToNumber in the Master Spread Sheet.
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cShipToCustomer", 2, shipToNumber);
		//*****************************************************End of Ship-To Creation**********************************************************************************************************************
		
		//CAMS Process for Bill-to
		pci.customer_maint_CAMS_Process(billToNumber, hm.get("Fast Path"), hm.get("Batch"), hm.get("BatchVersion"));
		//CAMS Process for Ship-to
		pci.customer_maint_CAMS_Process(shipToNumber, hm.get("Fast Path"), hm.get("Batch"), hm.get("BatchVersion"));
		//Update SQL results in the Master Spread Sheet.
		JdbcConnection.jdbcConnection();
		
		}
		catch(Exception e){
			System.out.println(e);
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
