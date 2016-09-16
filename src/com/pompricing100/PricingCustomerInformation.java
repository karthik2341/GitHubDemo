package com.pompricing100;



import org.openqa.selenium.Keys;

import com.pricingcommon.WebControls;


public class PricingCustomerInformation {
	WebControls wc = new WebControls();
	//Frame
	public String PCI_SWITCH_FRAME_XPATH="//iframe[@id='e1menuAppIframe']";	
	public String PCI_ADD_BTN_XPATH="//img[@id='C0_37']";	
	//Constants for Customer Contacts tab.
	public String PCI_ALPHA_NAME_INPUT_XPATH="//*[@id='C0_25_26']";
	public String PCI_MAILING_NAME_INPUT_XPATH="//*[@id='C0_25_44']";
	public String PCI_ADDRESS_LINE1_INPUT_XPATH="//*[@id='C0_25_36']";
	public String PCI_CITY_TEXT_INPUT_XPATH="//*[@id='C0_25_46']";
	public String PCI_STATE_INPUT_XPATH="//*[@id='C0_25_48']";	
	public String PCI_POSTAL_CODE_XPATH="//*[@id='C0_25_50']";
	//Constants for Customer Master
	public String PCI_CUSTOMERMASTER_TAB_XPATH="//a[starts-with(@title,'Customer Master')]";
	public String PCI_PYMT_TERMS_XPATH="//*[@id='C0_76_20']";
	public String PCI_PYMT_CRED_MAN_XPATH="//*[@id='C0_76_60']";
	public String PCI_PYMT_COLL_MAN_XPATH="//*[@id='C0_76_62']";
	public String PCI_PYMT_COMM_CODE1_XPATH="//*[@id='C0_76_94']";
	public String PCI_PYMT_MARK_CLASS_XPATH="//*[@id='C0_76_153']";
	public String PCI_PYMT_CREDIT_LIMIT_XPATH="//*[@id='C0_76_159']";	
	//Constants for Customer Additional Info
	public String PCI_CUSTOMER_ADDI_INFO_TAB_XPATH="//*[@id='CT0_23.1']";
	public String PCI_CUSTOMER_ADDI_MARKET_CLASS_XPATH="//*[@id='C0_27_26']";
	public String PCI_CUSTMAINT_CUSTOMER_ADDI_MARK_SUB_CLA_XPATH="//*[@id='C0_27_28']";
	public String PCI_CUSTMAINT_CUSTOMER_ADDI_MARK_SPEC_XPATH="//*[@id='C0_27_34']";
	public String PCI_CUSTMAINT_CUSTOMER_ADDI_CASH_ASSO_XPATH="//*[@id='C0_27_30']";
	public String PCI_CUSTMAINT_CUSTOMER_ADDI_CRED_ASSO_XPATH="//*[@id='C0_27_32']";
	//Constants to click on Save Button
	public String PCI_CUSTOMER_SAVE_BUTTON="//*[@id='C0_42']";
	public String PCI_CONFIRMCDS_SAVE_BTN="//*[@id='hc_OK']";
	//Get the billTo Number
	public String PCI_BILLTO_NUMBER="//*[@id='C0_25_24']";
	//Customer Master for Ship To
	public String PCI_BILLING_ADDRESSTYPE_XPATH="//*[@id='C0_76_70']";
	public String PCI_CUSTOMER_MASTER_PYMT_COLL_MAN_XPATH="//*[@id='C0_76_62']";
	public String PCI_CUSTMAINT_SHIPTO_XPATH="//*[@id='C0_76_156']";
	//Additional Info for Ship To
	public String PCI_CUSTOMER_ADDI_3RD_ADD_NUMBER_XPATH="//*[@id='C0_27_72']";
	public String PCI_CUSTMAINT_CUSTOMER_ADDI_PRCA_ACCOUNT_XPATH="//*[@id='C0_27_48']";
	public String PCI_SHIPTO_CUSTMAINT_CUSTOMER_ADDI_CRED_ASSO_XPATH="//*[@id='C0_27_32']";
	//Ship To Number
	public String PCI_SHIPTO_NUMBER="//*[@id='C0_25_24']";
	//Cams Process
	public String CAMS_FAST_PATH_XPATH="//*[@id='TE_FAST_PATH_BOX']";
	public String CAMS_FAST_PATH_CLICK_XPATH="//*[@id='e1MFastpathForm']/a/img";
	public String CAMS_CUSTMAINT_BATCH_APPLICATION_XPATH="//*[@id='C0_11']";
	public String CAMS_CUSTMAINT_BATCH_APPLICATION_ACTIVE_CLICK_XPATH="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String CAMS_CUSTMAINT_BATCH_APPLICATION_ACTIVATE_JM0001_XPATH="//*[@id='G0_1_R1']/td[1]/div/input";
	public String CAMS_CUSTMAINT_CLICK_RIGHT_BUTTON_XPATH="//*[@id='hc_Select']";
	public String CAMS_CUSTMAINT_SUBMIT_BTN_XPATH="//*[@id='hc0']";
	public String CAMS_CUSTMAINT_BATCH_VERSION_RIGHT_BTN_FORM_BTN_XPATH="//*[@id='FORM_EXIT_BUTTON']";
	public String CAMS_CUSTMAINT_BATCH_ADVANCED_BUTTON_XPATH="//*[@id='HE0_29hc_Form_Exit']";
	public String CAMS_CUSTMAINT_BATCH_VERSION_DATA_SELECTION_OVERRIDE_CHKBOX_XPATH="//*[@id='C0_23']";
	public String CAMS_CUSTMAINT_BATCH_VERSION_ADVANCED_SELECTION_XPATH="//*[@id='HE0_36']/tbody/tr/td[2]/span/nobr";
	public String CAMS_CUSTMAINT_ADDRESS_BOOK_BATCH_VERSION_INPUT_XPATH="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String CAMS_CUSTMAINT_ADDRESS_SELECT_DROP_DOWN_XPATH="//*[@id='LeftOperand1']";
	public String CAMS_CUSTMAINT_CAMS_SELECT_DRPDWN_RIGHT_XPATH="//*[@id='RightOperand1']";
	public String CAMS_CUSTMAINT_CAMS_INPUT_LITERAL_XPATH="//*[@id='LITtf']";	
	public String CAMS_PCI_CONFIRMCDS_SAVE_BTN="//*[@id='hc_OK']";
	public String CAMS_CUSTMAINT_ADDRESS_RIGHT_BUTTON_XPATH="//*[@id='hc_Select']";
	
	
	
	
	public void enterTextCustomerContacts(String AlphaName,String MailingName,String AddressLine1,String City,String State,String postalCode) throws Exception{	
		wc.webActions("Enter text in 'AlphaName' Field","SETTEXT", "xpath", PCI_ALPHA_NAME_INPUT_XPATH, "Alpha Name", AlphaName, "");
		//wc.webActions("CLICK", "xpath", PCI_MAILING_NAME_INPUT_XPATH, "MailingName","", "");
		wc.setTimeOut(7);
		wc.webActions("Enter text in 'Mailing Name' Field","SETTEXT", "xpath", PCI_MAILING_NAME_INPUT_XPATH, "Mailing Name", MailingName, "");
		wc.webActions("Enter text in 'Address Line1' Field","SETTEXT", "xpath", PCI_ADDRESS_LINE1_INPUT_XPATH, "Address Line1", AddressLine1, "");
		wc.webActions("Enter text in 'City' Field","SETTEXT", "xpath", PCI_CITY_TEXT_INPUT_XPATH, "City", City, "");
		wc.webActions("Enter text in 'State' Field","SETTEXT", "xpath", PCI_STATE_INPUT_XPATH, "State", State, "");
		wc.webActions("Enter text in 'Postal Code' Field","SETTEXT", "xpath", PCI_POSTAL_CODE_XPATH, "Postal Code", postalCode, "");
		wc.setTimeOut(3);
		wc.webActions("Enter text in 'City' Field","SETTEXT", "xpath", PCI_CITY_TEXT_INPUT_XPATH, "City", City, "");
		wc.webActions("Enter text in 'State' Field","SETTEXT", "xpath", PCI_STATE_INPUT_XPATH, "State", State, "");
		wc.webActions("Enter text in 'Postal Code' Field","SETTEXT", "xpath", PCI_POSTAL_CODE_XPATH, "Postal Code", postalCode, "");	
		wc.webActions("Enter text in 'Alpha Name' Field","SETTEXT", "xpath", PCI_ALPHA_NAME_INPUT_XPATH, "Alpha Name", AlphaName, "");
	}
	
	public void enterTextCustomerMaster(String PaymentTerms,String creditMan,String collManager,String commCode1,String marketClass,String creditLimit) throws Exception{		
		wc.setTimeOut(3);		
		wc.webActions("Click 'Customer Master' Field","click", "xpath",PCI_CUSTOMERMASTER_TAB_XPATH, "Customer Master Tab", "", "");
		wc.setTimeOut(5);	
		wc.webActions("Enter text in 'Payment Terms' Field","SETTEXT", "xpath", PCI_PYMT_TERMS_XPATH, "Payment Terms", PaymentTerms, "");
		wc.webActions("Enter text in 'Credit Manager' Field","SETTEXT", "xpath", PCI_PYMT_CRED_MAN_XPATH, "Credit Manager", creditMan, "");
		wc.webActions("Enter text in 'Collection Manager' Field","SETTEXT", "xpath", PCI_PYMT_COLL_MAN_XPATH, "Collection Manager", collManager, "");
		wc.webActions("Enter text in 'Commision Code' Field","SETTEXT", "xpath", PCI_PYMT_COMM_CODE1_XPATH, "Commission Code", commCode1, "");
		wc.webActions("Enter text in 'Payment Terms' Field","click", "xpath",PCI_PYMT_TERMS_XPATH, "Payment Terms", "", "");
		wc.setTimeOut(3);
		wc.webActions("Enter text in 'Market Class' Field","SETTEXT", "xpath",PCI_PYMT_MARK_CLASS_XPATH, "Market Class",marketClass, "");
		wc.webActions("Enter text in 'Credit Limit' Field","SETTEXT", "xpath",PCI_PYMT_CREDIT_LIMIT_XPATH, "Credit Limit",creditLimit, "");
				
	}
	
	public void enterTextCustomerAdditionalInfo(String mktSubClass,String markSpec,String cashAsso,String credAsso,String mktClass) throws Exception{
		wc.setTimeOut(5);
		wc.webActions("Click 'Customer Additional Info' Tab","click", "xpath",PCI_CUSTOMER_ADDI_INFO_TAB_XPATH, "Customer Additional Info", "", "");
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Market Sub Class' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_MARK_SUB_CLA_XPATH, "Market Sub Class", mktSubClass, "");
		wc.webActions("Enter text in 'Market Speciality' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_MARK_SPEC_XPATH, "Market Speciality", markSpec, "");
		wc.webActions("Enter text in 'Cash Associate' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_CASH_ASSO_XPATH, "Cash Associate", cashAsso, "");
		wc.webActions("Enter text in 'Credit Associate' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_CRED_ASSO_XPATH, "Credit Associate", credAsso, "");
		wc.setTimeOut(3);
		wc.webActions("Enter text in 'Market Class' Field","SETTEXT", "xpath", PCI_CUSTOMER_ADDI_MARKET_CLASS_XPATH, "Market Class", mktClass,"");
		wc.webActions("Enter text in 'Market Sub Class' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_MARK_SUB_CLA_XPATH, "Market Sub Class", mktSubClass, "");
		
		
	}
	
	public void click_Save() throws Exception{
		wc.webActions("Click 'Save'","click", "xpath",PCI_CUSTOMER_SAVE_BUTTON, "Save Button", "", "");
		wc.setTimeOut(10);
		wc.webActions("Click 'Confirm Save Button' Field","click", "xpath",PCI_CONFIRMCDS_SAVE_BTN, "Confirm Save Button", "", "");
		wc.setTimeOut(10);
	}
	
	public void change_Customer_Master(String AddressNumber,String custAddressType) throws Exception{
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Customer Address Type' Field","SETTEXT", "xpath", PCI_BILLING_ADDRESSTYPE_XPATH, "Customer Address Type", custAddressType, "");
		wc.webActions("Enter text in 'Collection Manager' Field","click", "xpath", PCI_CUSTOMER_MASTER_PYMT_COLL_MAN_XPATH, "Collection Manager", "", "");
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Ship To' Field","SETTEXT", "xpath", PCI_CUSTMAINT_SHIPTO_XPATH, "Ship To", AddressNumber, "");
		wc.webActions("Enter text in 'Collection Manager' Field","click", "xpath", PCI_CUSTOMER_MASTER_PYMT_COLL_MAN_XPATH, "Collection Manager", "", "");
		wc.setTimeOut(5);
		
	}
	
	public void customer_additional_info_2(String custNumber) throws Exception{
		wc.setTimeOut(5);
		//wc.webActions("SETTEXT", "xpath", "PCI_CUSTOMER_ADDI_3RD_ADD_NUMBER_XPATH", "Bill To", custNumber, "");
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Bill To' Field","SETTEXT", "xpath", PCI_CUSTMAINT_CUSTOMER_ADDI_PRCA_ACCOUNT_XPATH, "Bill To", custNumber, "");
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Credit Associate' Field","click", "xpath", PCI_SHIPTO_CUSTMAINT_CUSTOMER_ADDI_CRED_ASSO_XPATH, "Credit Associate", "", "");
		wc.setTimeOut(5);	
		
	}
	
public void customer_maint_CAMS_Process(String customerNumber01,String fastPath,String batch,String batchVersion) throws Exception{
		
		wc.setTimeOut(6);		
		wc.switchToParentFrame();
		wc.webActions("Enter text in 'Fast Path' Field","SETTEXT", "XPATH", CAMS_FAST_PATH_XPATH, "Fast Path", fastPath, "");
		wc.webActions("Click 'Fast Path'","CLICK", "XPATH", CAMS_FAST_PATH_CLICK_XPATH, "Fast Path","", "");		
		wc.setTimeOut(7);
		wc.switchToSpecifiedFrame("xpath", PCI_SWITCH_FRAME_XPATH);
		wc.setTimeOut(3);
		wc.webActions("Enter text in 'Batch Application' Field","SETTEXT", "XPATH", CAMS_CUSTMAINT_BATCH_APPLICATION_XPATH, "Batch Application", batch, "");	
		wc.webActions("Click 'Check Box'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_APPLICATION_ACTIVE_CLICK_XPATH, "Check Box","", "");
		wc.setTimeOut(5);
		wc.webActions("Click 'Activate Button'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_APPLICATION_ACTIVATE_JM0001_XPATH, "Activate Button","", "");
		wc.webActions("Click 'Right Button'","CLICK", "XPATH", CAMS_CUSTMAINT_CLICK_RIGHT_BUTTON_XPATH, "Right Button","", "");				
		wc.setTimeOut(5);	
		wc.webActions("Click 'OverRide Check Box'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_VERSION_DATA_SELECTION_OVERRIDE_CHKBOX_XPATH, "OverRide Check Box","", "");		
		wc.setTimeOut(3);
		wc.webActions("Click 'Right Button'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_VERSION_RIGHT_BTN_FORM_BTN_XPATH, "Right Button","", "");			
		wc.setTimeOut(4);
		wc.webActions("Click 'Advance Button'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_ADVANCED_BUTTON_XPATH, "Advance Button","", "");				
		wc.setTimeOut(3);
		wc.webActions("Click 'Advanced Button'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_VERSION_ADVANCED_SELECTION_XPATH, "Advanced Button","", "");					
		wc.setTimeOut(3);
		wc.webActions("Click 'OverRide Checkbox'","CLICK", "XPATH", CAMS_CUSTMAINT_BATCH_VERSION_DATA_SELECTION_OVERRIDE_CHKBOX_XPATH, "OverRide Checkbox","", "");			
		wc.setTimeOut(2);
		wc.webActions("Click 'Confirm CDS","CLICK", "XPATH", CAMS_PCI_CONFIRMCDS_SAVE_BTN, "Confirm CDS","", "");			
		wc.setTimeOut(5);
		wc.webActions("Click 'Submit'","CLICK", "XPATH", CAMS_CUSTMAINT_SUBMIT_BTN_XPATH, "Submit","", "");			
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Batch Version' Field","SETTEXT", "XPATH", CAMS_CUSTMAINT_ADDRESS_BOOK_BATCH_VERSION_INPUT_XPATH, "Batch Version", batchVersion, "");				
		wc.webActions("","ENTER", "XPATH", CAMS_CUSTMAINT_ADDRESS_BOOK_BATCH_VERSION_INPUT_XPATH, "", "", "");
		wc.setTimeOut(5);
		wc.webActions("Click 'Address Right'","CLICK", "XPATH", CAMS_CUSTMAINT_ADDRESS_RIGHT_BUTTON_XPATH, "Address Right","", "");				
		wc.setTimeOut(5);
		wc.webActions("Select  Value From Left Operand Drop Down","SELECTBYTEXT", "XPATH", CAMS_CUSTMAINT_ADDRESS_SELECT_DROP_DOWN_XPATH, "Left Operand","", "Address Number - 3rd (F0101) (AN83) [BC]");		
		wc.setTimeOut(5);
		wc.webActions("Select Value from Right Operand Button","SELECTBYTEXT", "XPATH", CAMS_CUSTMAINT_CAMS_SELECT_DRPDWN_RIGHT_XPATH, "Right Operand","", "Literal");
		wc.setTimeOut(5);
		wc.webActions("Enter text in 'Customer Number' Field","SETTEXT", "XPATH", CAMS_CUSTMAINT_CAMS_INPUT_LITERAL_XPATH, "Customer Number", customerNumber01, "");
		wc.webActions("Click 'Address Right'","CLICK", "XPATH", CAMS_CUSTMAINT_ADDRESS_RIGHT_BUTTON_XPATH, "Address Right","", "");					
		wc.setTimeOut(5);
		wc.webActions("Click 'Address Right'","CLICK", "XPATH", CAMS_CUSTMAINT_ADDRESS_RIGHT_BUTTON_XPATH, "Address Right","", "");	
		wc.setTimeOut(5);		
		wc.webActions("Click 'Confirm CDS'","CLICK", "XPATH", CAMS_PCI_CONFIRMCDS_SAVE_BTN, "Confirm CDS","", "");
		wc.setTimeOut(5);		
	}

}












