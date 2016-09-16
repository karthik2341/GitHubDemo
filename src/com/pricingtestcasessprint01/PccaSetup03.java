package com.pricingtestcasessprint01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingLoginPage;
import com.pompricing100.PricingMenu;
import com.pompricing100.PricingPCCAMaintenance;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;

public class PccaSetup03 {
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
		wc.startSelenium("URL Should get opened",p,testBrowser);		
	}
	@Test
	public void pccaSetup03() throws Exception {
		
		try{
			//Classes Creation		
			WebControls wc = new WebControls();
			PricingLoginPage pl = new PricingLoginPage();	
			PricingMenu pm = new PricingMenu();
			ExcelReader er = new ExcelReader();		
			PricingCustomerInformation pci = new PricingCustomerInformation();						
			PricingPCCAMaintenance ppm = new PricingPCCAMaintenance();
			HTMLReport hr = new HTMLReport();
			//Store the filepath of the MasterSpread Sheet.
			String filePath =System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			//Login Into The Application
			hr.writeStepInformation("Step 1 : Login into application");
			pl.login();
			//verify title
			hr.writeStepInformation("Step 2 : Navigate to PCCA Maintenance from the menu Bar");
			wc.verifyHomePageTitle("Veify home Page title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click Contracts,Pricing and Rebates Button
			wc.webActions("Click on Contracts Pricing and Rebates","click","xpath",pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			//Click On Pricing Menu Button
			wc.webActions("Click on Pricing Button","click","xpath",pm.HOME_PRICING_MENU_BTN, "Pricing", "", "");
			//Click on PCCA Maintenance Button.
			wc.webActions("Click PCCA Maintenance Button","click", "xpath", pm.HOME_PCCA_MAINTENANCE_BTN_XPATH, "PCCA Maintenance", "", "");
			//Wait for three Seconds.
			wc.setTimeOut(3);
			//Switch the frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Enter Text in Pricing Maintenance.
			hr.writeStepInformation("Step 3 : Enter the LPGID,Ship-To,PCCA Start Date and PCCA End Date");
			ppm.enter_textInPCCAMaintenance("L", er.getCellData(filePath, "Global", "cLPGID", 2), er.getCellData(filePath, "Global", "cShipToCustomer", 2), er.getCellData(filePath, "Global", "cPCCAStartDate", 2), er.getCellData(filePath, "Global", "cPCCAEndDate", 2));
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
