package com.pompricing100;

import com.pricingcommon.WebControls;

public class PricingGpoSetup04 {
	public String GPO_MASTER_MAINT_ADD="//*[@id='hc_Add']";
	public String GPO_MASTER_MAINT_ALPHANAME="//*[@id='C0_28']";
	public String GPO_MASTER_MAINT_ADDITIONAL1="//*[@id='CT0_13.2']";
	public String GPO_MASTER_MAINT_PAYABLESYNM="//*[@id='C0_64']";
	//public String GPO_MASTER_MAINT_CATCODE1TO10 ="//*[@id='CT0_13.5']";	
	public String GPO_MASTER_MAINT_CLICK_SAVE="//*[@id='hc_OK']";
	public String GPO_MASTER_MAINT_GET_GPO_NUM="//*[@id='C0_15']";
	public String GPO_STARTDATE="//*[@id='G0_1_R0']/td[3]/div/input";
	public String GPO_ENDDATE="//*[@id='G0_1_R0']/td[4]/div/input";
	public String GPO_DOCUMENTCONTROLNUMBER="//*[@id='G0_1_R0']/td[5]/div/input";
	public String GPO_MEDSURG_GPO="//*[@id='G0_1_R0']/td[6]/div/input";
	public String GPO_ROWBUTTON="//*[@id='ROW_EXIT_BUTTON']";
	public String GPO_GPOMEMBERSHIP="//*[@id='HE0_60']/tbody/tr/td[2]/span/nobr";
	//Enter Data in GPO
	public String GPO_CUSTOMERABNO="//*[@id='G0_1_R0']/td[3]/div/input";
	public String GPO_DOCUMENTCONTROLNUMBER_CLICK="//*[@id='G0_1_R0']/td[11]/div";
	public String GPO_DOCUMENTCONTROLNUMBER2="//*[@id='G0_1_R0']/td[11]/div/input";
	public String GPO_GPONUMBER="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String GPO_GPONUMBER3="//*[@id='C0_20']";
	WebControls wc = new WebControls();

	public String createGPO(String alphaName,String payables) throws Exception{
	wc.webActions("Click on Add Button","click", "xpath", GPO_MASTER_MAINT_ADD, "Add", "", "");
	wc.setTimeOut(7);
	wc.webActions("Enter text in the Alpha Name field","settext", "xpath", GPO_MASTER_MAINT_ALPHANAME, "Alpha Name", alphaName, "");	
	wc.webActions("Enter text in the Addition 1 Field","click", "xpath", GPO_MASTER_MAINT_ADDITIONAL1, "Additional 1", "", "");
	wc.setTimeOut(5);
	wc.webActions("Click on Payables Y/N/M Field","click", "xpath", GPO_MASTER_MAINT_PAYABLESYNM, "Payables Y/N/M", "", "");
	wc.setTimeOut(5);
	wc.webActions("Enter text in Payables Y/N/M field","settext", "xpath", GPO_MASTER_MAINT_PAYABLESYNM, "Payables Y/N/M", payables, "");
	wc.webActions("Click on Save Button","click", "xpath", GPO_MASTER_MAINT_CLICK_SAVE, "Save", "", "");
	wc.setTimeOut(5);
	String GPOID = wc.returnTextFromValueAttribute("Get the GPO Number","xpath", GPO_MASTER_MAINT_GET_GPO_NUM, "GPO Number is ");
	return GPOID;
	
	}

	public void setGPODates(String strtDat,String endDate,String docCntrlNum,String medSurg) throws Exception{
	
		wc.webActions("Enter text in GPO Start Date","settext", "xpath", GPO_STARTDATE, "GPO Start Date",strtDat, "");
		wc.webActions("Enter text in GPO End Date","settext", "xpath", GPO_ENDDATE, "GPO End Date",endDate, "");
		wc.webActions("Enter text in Document Control Number","settext", "xpath", GPO_DOCUMENTCONTROLNUMBER, "Document Control Number",docCntrlNum, "");
		wc.webActions("Enter text in Medical Surg GPO","settext", "xpath", GPO_MEDSURG_GPO, "Medical Surg GPO", medSurg, "");
		wc.webActions("Click Enter","enter", "xpath", GPO_MEDSURG_GPO, "", "", "");
		wc.setTimeOut(3);
		wc.webActions("Click Save","click", "xpath", GPO_MASTER_MAINT_CLICK_SAVE, "Save", "", "");
		wc.setTimeOut(3);
		
	}
	}











