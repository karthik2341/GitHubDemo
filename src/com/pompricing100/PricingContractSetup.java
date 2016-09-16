package com.pompricing100;





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pricingcommon.Driver;
import com.pricingcommon.WebControls;

public class PricingContractSetup extends Driver {
	WebControls wc = new WebControls();
	public String CONTRACT_SETUP_ADD_BUTTON="//*[@id='hc_Add']";
	public String CONTRACT_HEADER_MAINT_DOCUMENT_CONTROL_NUMBER="//*[@id='C0_65']";
	public String CONTRACT_HEADER_MAINT_MAN_NUMBER="//*[@id='C0_70']";
	public String CONTRACT_HEADER_MAINT_CONTRACT_ID="//*[@id='C0_14']";
	public String CONTRACT_HEADER_MAINT_CONTRACT_NAME = "//*[@id='C0_18']";
	public String CONTRACT_HEADER_MAINT_CONTRACT_TYPE = "//*[@id='C0_88']";
	public String CONTRACT_HEADER_MAINT_GPO_NUMBER = "//*[@id='C0_76']";
	public String CONTRACT_HEADER_MAINT_MAN_START_DATE="//*[@id='C0_30']";
	public String CONTRACT_HEADER_MAINT_MAN_END_DATE="//*[@id='C0_32']";
	public String CONTRACT_HEADER_MAINT_INIT_RCPT_DATE="//*[@id='C0_22']";
	public String CONTRACT_HEADER_MAINT_SAVE_BTN="//*[@id='hc_OK']";
	//USE TO GET THE CUSTOMER NUMBER TO VERIFY THE RECORD AFTER PRESSING FIND
	public String CONTRACT_HEADER_MAINT_TIER1="//*[@id='G0_1_R0']/td[2]/div/input";
	public String CONTRACT_ITEM_MAINT_ITEMNUMBER="//*[@id='G0_1_R0']/td[3]/div/input";
	public String CONTRACT_ITEM_MAINT_PRICE="//*[@id='C0_85']";
	
	public String CONTRACT_ITEM_MAINT_SUPPLIERUM="//*[@id='G0_1_R0']/td[5]/div/input";
	public String CONTRACT_ITEM_MAINT_MCKUM="//*[@id='G0_1_R0']/td[6]/div/input";
	public String CONTRACT_ITEM_MAINT_SUPP_CONT_COST="//*[@id='G0_1_R0']/td[4]/div/input";
	public String CONTRACT_ITEM_MAINT_AQUISITION_COST="//*[@id='G0_1_R0']/td[7]/div/input";
	//USE AFTER FIND TO CLEAR THE BOX
	public String CONTRACT_ITEM_MAINT_MCKESSON_CONTRACT_ID="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String CONTRACT_ITEM_MAINT_CHECK_BOX_RECORD="//*[@id='G0_1_R0']/td[1]/div/input";
	public String CONTRACT_ITEM_MAINT_ROW_BUTTON="//*[@id='ROW_EXIT_BUTTON']";
	public String CONTRACT_ITEM_MAINT_INQUIRES_BUTTON="//*[@id='SubMenu_HE0_117']/span/nobr";
	public String CONTRACT_ITEM_MAINT_CUSTOMER_ELIGIBILITY_BTN="//*[@id='HE0_123']/tbody/tr/td[2]/span/nobr";
	public String CONTRACT_ITEM_MAINT_DOCUMENT_CONTROL_NUMBER="//*[@id='C0_57']";
	public String CONTRACT_ITEM_MAINT_ADDRESS_NUMBER="//*[@id='G0_1_R0']/td[3]/div/input";
	public String CONTRACT_ITEM_MAINT_FIND_BUTTON="//*[@id='hc_Find']";
	public String CONTRACT_ITEM_VERIFY_REORD="//*[@id='rownumber_gridheader']";
	//Mckesson Contract ID.
	public String CONTRACT_ITEM_MCKESSON_CONTRACTID="//*[@id='C0_34']";
	
	public void setupGPOContract(String docNum,String manNum,String contractID,String contractName,String contractType,String GPO,String recDate,String startDate,String endDate) throws Exception{
		wc.setTimeOut(6);
		wc.webActions("Enter Text in Document Contol Number Field","settext", "xpath", CONTRACT_HEADER_MAINT_DOCUMENT_CONTROL_NUMBER, "Document Control Number", docNum, "");	
		wc.webActions("Enter Text in Manufacturer Number Field","settext", "xpath", CONTRACT_HEADER_MAINT_MAN_NUMBER, "Manufacturer Number", manNum, "");
		wc.setTimeOut(5);
		wc.webActions("Enter Text in Contract ID Field","settext", "xpath", CONTRACT_HEADER_MAINT_CONTRACT_ID, "Contract ID", contractID, "");
		wc.webActions("Enter Text in Contract Name Field","settext", "xpath", CONTRACT_HEADER_MAINT_CONTRACT_NAME, "Contract Name", contractName, "");		
		wc.webActions("Enter Text in Contract Type", "settext", "xpath",CONTRACT_HEADER_MAINT_CONTRACT_TYPE, "Contract Type",contractType,"");	
		wc.setTimeOut(5);
		if(contractType.equalsIgnoreCase("GPO")){
		wc.webActions("Enter Text GPO Field","settext", "xpath", CONTRACT_HEADER_MAINT_GPO_NUMBER, "GPO", GPO, "");
		}
		wc.webActions("Enter Text in Initial Received Date Field","settext", "xpath", CONTRACT_HEADER_MAINT_INIT_RCPT_DATE, "Initial Received Date", recDate, "");
		wc.webActions("Enter Text in Start Date Field","settext", "xpath", CONTRACT_HEADER_MAINT_MAN_START_DATE, "Start Date", startDate, "");
		wc.webActions("Enter Text in End Date Field","settext", "xpath", CONTRACT_HEADER_MAINT_MAN_END_DATE, "End Date", endDate, "");
		
		wc.setTimeOut(5);
		wc.webActions("Click Save","click", "xpath", CONTRACT_HEADER_MAINT_SAVE_BTN, "Save", "", "");
		wc.setTimeOut(7);
	}
	


	public void addItemNumberRecord(String suppUM,String mckUM,double supCost,double acqCost) throws Exception{
		wc.webActions("Click Menu Button","click", "xpath", "//*[@id='G0_1_R0']/td[5]/div", "Button", "", "");		
		wc.setTimeOut(5);
		wc.webActions("Enter Text in Supplier * UM Field","settext", "xpath", CONTRACT_ITEM_MAINT_SUPPLIERUM, "Supplier * UM", suppUM, "");	
		wc.webActions("Enter Text in Mck * UM Field","settext", "xpath", CONTRACT_ITEM_MAINT_MCKUM, "Mck * UM", mckUM, "");		
		wc.setTimeOut(3);
		String suppCost = Double.toString(supCost);
		wc.webActions("Enter Text in Supplier Contract Cost Field","settext", "xpath", CONTRACT_ITEM_MAINT_SUPP_CONT_COST, "Supplier Contract Cost", suppCost, "");		
		String acquCost = Double.toString(acqCost);
		wc.webActions("Enter Text in Acquisition Cost Field","settext", "xpath", CONTRACT_ITEM_MAINT_AQUISITION_COST, "Acquisition Cost", acquCost, "");
		wc.webActions("","enter", "xpath", CONTRACT_ITEM_MAINT_AQUISITION_COST, "s","", "");			
		wc.setTimeOut(3);	
		wc.webActions("Click on Save Button","click", "xpath", CONTRACT_HEADER_MAINT_SAVE_BTN, "Save Button", "", "");		
		wc.setTimeOut(4);
	}
	public void customerEligibilityScreen(String mckessContractID) throws Exception{
		wc.webActions("Enter Text in McKesson Contract ID Field","settext", "xpath", CONTRACT_ITEM_MAINT_MCKESSON_CONTRACT_ID, "McKesson Contract ID", mckessContractID, "");
		wc.webActions("","enter", "xpath", CONTRACT_ITEM_MAINT_MCKESSON_CONTRACT_ID, "", "", "");		
		wc.setTimeOut(4);
		wc.webActions("Click on Check box","click", "xpath", CONTRACT_ITEM_MAINT_CHECK_BOX_RECORD, "Check Box","", "");
		wc.webActions("Click on Row Button Menu","click", "xpath", CONTRACT_ITEM_MAINT_ROW_BUTTON, "Row Button Menu","", "");		
		wc.setTimeOut(2);
		wc.webActions("Click on Inquiries Button Menu","click", "xpath", CONTRACT_ITEM_MAINT_INQUIRES_BUTTON, "Inquiries Button menu","", "");		
		wc.setTimeOut(2);
		wc.webActions("Click on Customer Eligibility Button Menu","click", "xpath", CONTRACT_ITEM_MAINT_CUSTOMER_ELIGIBILITY_BTN, "Customer Eligibility Button Menu","", "");		
		wc.setTimeOut(3);		
		
	}

	public void addShipTo(String docNum,String addressNum) throws Exception{	
		wc.webActions("Enter Text in Document Control Number Field","settext", "xpath", CONTRACT_ITEM_MAINT_DOCUMENT_CONTROL_NUMBER, "Document Control Number", docNum, "");
		wc.webActions("Enter Text in Address Number Field","settext", "xpath", CONTRACT_ITEM_MAINT_ITEMNUMBER, "Address Number", addressNum, "");
		wc.webActions("","enter", "xpath", CONTRACT_ITEM_MAINT_ITEMNUMBER,"", "", "");		
		wc.setTimeOut(2);
		wc.webActions("Click Save Button","click", "xpath", CONTRACT_HEADER_MAINT_SAVE_BTN,"Save", "", "");			
		wc.setTimeOut(4);		
		driver.findElement(By.xpath(CONTRACT_ITEM_MAINT_MCKESSON_CONTRACT_ID)).clear();
		wc.setTimeOut(2);
		wc.webActions("Click Find Button","click", "xpath",CONTRACT_ITEM_MAINT_FIND_BUTTON,"Find Button", "", "");		
		wc.setTimeOut(3);		
	}











}
