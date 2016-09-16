package com.pompricing100;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pricingcommon.WebControls;

public class PricingPCCAMaintenance {
	WebControls wc = new WebControls();
	public String PCCA_ADD_BTN="//*[@id='hc_Add']";
	public String PCCA_RECORD_TYPE_TXT="//*[@id='G0_1_R0']/td[3]/div/input";
	public String PCCA_GROUP_ID_TXT="//*[@id='G0_1_R0']/td[4]/div/input";
	public String PCCA_GROUP_PCCA_TXT="//*[@id='G0_1_R0']/td[5]/div/input";
	public String PCCA_GROUP_PCCA_EFF_FRM_TXT="//*[@id='G0_1_R0']/td[6]/div/input";
	public String PCCA_GROUP_PCCA_EFF_THR_TXT="//*[@id='G0_1_R0']/td[7]/div/input";
	public String PCCA_SAVE_BTN="//*[@id='hc_OK']";
	public String PCCA_Customer_GRP_ID ="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	
	
	public void enter_textInPCCAMaintenance(String recType,String groupID,String lpgIDE,String effFrom,String effThrough) throws Exception{
		wc.webActions("Click on Add Button","click", "xpath", PCCA_ADD_BTN, "Add", "", "");
		wc.setTimeOut(3);
		wc.webActions("Enter text in Record Type","settext", "xpath", PCCA_RECORD_TYPE_TXT, "Record Type", recType, "");
		wc.webActions("Enter text in group ID","settext", "xpath", PCCA_GROUP_ID_TXT, "Group ID", groupID, "");
		wc.webActions("Enter Text in LPG ID","settext", "xpath", PCCA_GROUP_PCCA_TXT, "LPG ID", lpgIDE, "");
		wc.webActions("Enter text in Effective From","settext", "xpath", PCCA_GROUP_PCCA_EFF_FRM_TXT, "Effective From", effFrom, "");
		wc.webActions("Enter text in Effective through","settext", "xpath", PCCA_GROUP_PCCA_EFF_THR_TXT, "Effective Through", effThrough, "");		
		wc.setTimeOut(3);
		wc.webActions("Click on Save Button","click", "xpath", PCCA_SAVE_BTN, "Save", "", "");
		wc.setTimeOut(5);
		wc.webActions("Enter text in Group ID","settext", "xpath", PCCA_Customer_GRP_ID, "Group ID", groupID, "");
		wc.webActions("Click Enter","ENTER", "xpath", PCCA_Customer_GRP_ID, "","", "");		
		wc.setTimeOut(5);
		
	}
}
