package com.pompricing100;



import com.pricingcommon.WebControls;

public class PricingContractHeader {
	    //Classes Creation
	    WebControls wc = new WebControls();
	    //Contract Headers
		public String CM_MCKESSONCONTRACTID= "//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
		public String CM_CHECKBOX = "//*[@id='G0_1_R0']/td[1]/div/input";
		public String CM_ROW_BTN ="//*[@id='ROW_EXIT_BUTTON']";
		public String CM_INQUIRIES_BTN ="//*[@id='SubMenu_HE0_117']/span/nobr";
		public String CM_ITEMS_BTN ="//*[@id='HE0_105']/tbody/tr/td[2]/span/nobr";
		//Contract Items
		public String CM_CHK_BOX="//*[@id='G0_1_R0']/td[1]/div/input";
		public String CM_CLICK_RIGHT ="//*[@id='hc_Select']";
		//Contract Item Maintenance
		public String CM_DOC_CNTRL_NUM="//*[@id='C0_36']";
		public String CM_ITEMENDDATE="//*[@id='G0_1_R0']/td[14]/div/input";
		public String CM_SAVE_BTN="//*[@id='hc_OK']";
		//Verify Price Rule
		public String PI_VERRULELEVEL="//*[@id='C0_354']";
		//Price Inquiry
		public String PI_CUSTOMERNUMBER="//*[@id='C0_421']";
		public String PI_ITEMNUMBER ="//*[@id='C0_16']";
		public String PI_GETPRICE ="//*[@id='C0_393']";
		public String PI_PRICEDATE="//*[@id='C0_20']";
		
		public void workWithContractHeaders(String mckGPOId) throws Exception{
			wc.webActions("Enter Text in McKesson Contract ID field", "settext", "xpath", CM_MCKESSONCONTRACTID, "McKesson Contract ID", mckGPOId, "");
			wc.webActions("", "enter", "xpath", CM_MCKESSONCONTRACTID, "", "", "");			
			wc.setTimeOut(3);
			wc.webActions("Click on McKesson Contract ID Check box", "click", "xpath", CM_CHECKBOX, "McKesson Contract ID Check box","", "");
			wc.webActions("Click on Row Button", "click", "xpath", CM_ROW_BTN, "Row Button", "", "");			
			wc.setTimeOut(2);
			wc.webActions("Click on Inquiries Button", "click", "xpath", CM_INQUIRIES_BTN, "Inquiries Button", "", "");
			wc.setTimeOut(2);
			wc.webActions("Click on Items Button", "click", "xpath", CM_ITEMS_BTN, "Items Button", "", "");			
			wc.setTimeOut(5);			
		}
		public void workWithContractItems() throws Exception{
			wc.webActions("Click on Check Box", "click", "xpath", CM_CHK_BOX, "Check Box", "", "");
			wc.webActions("Click on Right Button", "click", "xpath", CM_CLICK_RIGHT, "Right Button", "", "");
			wc.setTimeOut(3);		
		}
		public void contractItemMaintenance(String docCntrlNumber,String ItemEndDate) throws Exception{
			wc.webActions("Enter Text in Document Control Number field", "settext", "xpath", CM_DOC_CNTRL_NUM, "Document Control Number", docCntrlNumber, "");
			wc.webActions("Enter Text in Item End Date field", "settext", "xpath", CM_ITEMENDDATE, "Item End Date", ItemEndDate, "");
			wc.webActions("Click Save Button", "click", "xpath", CM_SAVE_BTN, "Save Button", "", "");			
			wc.setTimeOut(3);
		}

}
