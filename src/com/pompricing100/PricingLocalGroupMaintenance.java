package com.pompricing100;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pricingcommon.ExcelReader;
import com.pricingcommon.WebControls;

public class PricingLocalGroupMaintenance  {
	WebControls wc = new WebControls();
	ExcelReader er = new ExcelReader();	
	public String LOCALPRICE_GROUPID_TXTBOX_XPATH="//*[@id='C0_14']";
	public String LOCALPRICE_GROUPDESC_TXTBOX_XPATH="//*[@id='C0_20']";
	public String LOCALPRICE_USERID_TXTBOX_XPATH="//*[@id='C0_16']";
	public String LOCALPRICE_CONTROLFLAG_TXTBOX_XPATH="//*[@id='C0_18']";
	public String LOCALPRICE_SAVE_BTN_XPATH="//*[@id='hc_OK']";
	public String LOCALPRICE_CANCEL_BTN_XPATH="//*[@id='hc_Cancel']";
	//Locators for getLPGID
	public String LOCALPRICE_GROUPID_TEXT_BTN_XPATH="//*[@id='qbeRow0_1']/td[3]/div/nobr/input";
	public String LOCALPRICE_CUSTOMERS_BTN_XPATH="//*[@id='div']/font";
	public String LOCALPRICE_CUSTOMER_NBR_TXTBOX_XPATH="//*[@id='C0_16']";	
	public String LOCALPRICE_TERMINATION_DATE_TXTBOX_XPATH="//*[@id='C0_20']";
	public String LOCALPRICE_GET_CUSTOMERNUM_TXTBOX_XPATH="//*[@id='G0_1_R0']/td[4]/div";
	//Locators for addPriceRuleGroup.
	public String LOCALPRICE_ADD_BTN_XPATH="//*[@id='hc_Add']";
	
	
	public void addDataForLocalGroups(String groupID,String grpDesc,String userID,String crprtCntrlFlg) throws Exception{
		wc.webActions("Enter the Value in Group ID Field","SETTEXT", "XPATH", LOCALPRICE_GROUPID_TXTBOX_XPATH, "Group ID", groupID, "");
		wc.webActions("Enter the Value in Group Description","SETTEXT", "XPATH", LOCALPRICE_GROUPDESC_TXTBOX_XPATH, "Group Description", grpDesc, "");
		wc.webActions("Enter the value in User ID Field","SETTEXT", "XPATH", LOCALPRICE_USERID_TXTBOX_XPATH, "User ID", userID, "");
		wc.webActions("Enter the Value in Corporate Control Flag","SETTEXT", "XPATH", LOCALPRICE_CONTROLFLAG_TXTBOX_XPATH, "Corporate Control Flag", crprtCntrlFlg, "");				
		wc.setTimeOut(5);
		wc.webActions("Click on Save Button","click", "XPATH", LOCALPRICE_SAVE_BTN_XPATH, "Save", "", "");			
		wc.setTimeOut(5);
		wc.webActions("Click on Cancel Button","click", "XPATH", LOCALPRICE_CANCEL_BTN_XPATH, "Cancel", "", "");				
		wc.setTimeOut(5);
	}
	
	public void getLPGID(String groupID) throws Exception{
		wc.webActions("Enter the Value in Group ID","settext", "xpath", LOCALPRICE_GROUPID_TEXT_BTN_XPATH, "Group ID", groupID, "");				
		wc.setTimeOut(2);
		wc.webActions("Press Enter in Group ID field","enter", "xpath", LOCALPRICE_GROUPID_TEXT_BTN_XPATH, "Group ID","", "");				
		wc.setTimeOut(5);
		String LPGID = wc.returnTextFromElement("Get the LPG ID","xpath", "//*[@id='G0_1_R0']/td[2]");
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cLPGID", 2, LPGID);
		wc.webActions("Click on Customers Button","click", "xpath", LOCALPRICE_CUSTOMERS_BTN_XPATH, "Customers", "", "");				
		wc.setTimeOut(3);				
	}
	
	public void addPriceRuleGrup(String custNumber,String termDate) throws Exception{
		wc.setTimeOut(5);
		wc.webActions("Click on Add Button","click","xpath", LOCALPRICE_ADD_BTN_XPATH, "Add", "", "");				
		wc.setTimeOut(5);
		wc.webActions("Enter Customer in the Customer Number Field","settext","xpath", LOCALPRICE_CUSTOMER_NBR_TXTBOX_XPATH, "Customer Number", custNumber, "");
		wc.webActions("Enter the Termination Date","settext","xpath", LOCALPRICE_TERMINATION_DATE_TXTBOX_XPATH, "Termination Date", termDate, "");				
		wc.setTimeOut(3);
		wc.webActions("Click on Save Button","click","xpath", LOCALPRICE_SAVE_BTN_XPATH, "Save", "", "");				
		wc.setTimeOut(5);
		wc.webActions("Click on Cancel Button","click","xpath", LOCALPRICE_CANCEL_BTN_XPATH, "Cancel", "", "");				
		wc.setTimeOut(5);		
	}
	

}
