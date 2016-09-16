package com.pompricing100;



import com.pricingcommon.Driver;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.WebControls;

public class PricingEnquiry extends Driver {
	WebControls wc = new WebControls();
	HTMLReport hr = new HTMLReport();
	public String PR_FORMBUTTON = "//*[@id='FORM_EXIT_BUTTON']";
	public String PR_PRICERULEIMPORT = "//*[@id='HE0_68']/tbody/tr/td[2]/span/nobr";
	public String PR_ADDBUTTON = "//*[@id='hc_Add']";
	public String PR_CODE="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String PR_RIGHT="//*[@id='hc_Select']";
	public String PR_BATCHNUM="//*[@id='C0_15']";
	public String PR_EFFECTIVEDATE="//*[@id='G0_1_R0']/td[2]/div/input";
	public String PR_TERMINATIONDATE="//*[@id='G0_1_R0']/td[3]/div/input";
	public String PR_ITEMNUMBER="//*[@id='G0_1_R0']/td[4]/div/input";
	public String PR_RULETYPE = "//*[@id='G0_1_R0']/td[5]/div/input";
	public String PR_PERCENTAGE="//*[@id='G0_1_R0']/td[6]/div/input";
	public String PR_SAVE="//*[@id='hc_OK']";
	public String PR_BATCHNUMBER="//*[@id='qbeRow0_1']/td[2]/div/nobr/input";
	public String PR_GETBATCHNUMBER="//*[@id='G0_1_R0']/td[2]/div";
	public String PI_CUSTOMERNUMBER="//*[@id='C0_421']";
	public String PI_ITEMNUMBER ="//*[@id='C0_16']";
	public String PI_GETPRICE ="//*[@id='C0_393']";
	public String PI_VERRULELEVEL="//*[@id='C0_354']";
	public String PM_VENDORFAMILY="//*[@id='G0_1_R0']/td[11]/div/input";
	public String PM_GPONUMBER="//*[@id='G0_1_R0']/td[12]/div/input";
	public String PI_PRICEDATE="//*[@id='C0_20']";
	public String PI_UM ="//*[@id='G0_1_R0']/td[7]/div/input";
	public String PI_ALLOWZERO= "//*[@id='G0_1_R0']/td[9]/div/input";
	public String PI_UM2_015="//*[@id='G0_1_R0']/td[8]/div/input";
	
	public void pricingRules_Enquiry()throws Exception{	
		wc.webActions("Click on Form Button", "click", "xpath", PR_FORMBUTTON, "Form Button", "", "");		
		wc.setTimeOut(2);
		wc.webActions("Click on Price Rules Import Button", "click", "xpath", PR_PRICERULEIMPORT, "Price Rules import button", "", "");
		wc.setTimeOut(5);		
		wc.webActions("Click on Add Button", "click", "xpath", PR_ADDBUTTON, "Add Button", "", "");		
		wc.setTimeOut(5);	
		
		}
	public void pricingRules_SelectUserDefinedCode(String Code)throws Exception{
	    driver.switchTo().frame(0);	
	    wc.webActions("Enter Text in Code Field", "settext", "xpath", PR_CODE, "Code", Code, "");
		wc.webActions("", "enter", "xpath", PR_CODE, "Code", "", "");		
		wc.setTimeOut(2);
		wc.webActions("Click on Right Button", "click", "xpath", PR_RIGHT, "Right Button", "", "");		
		wc.setTimeOut(6);		
	}

public void setValues_PriceRuleImportMaintenance(String effDate,String terDate,String itmNum,String rulTyp,String percentage,String um,String cusNum,String allZero,String rulNum)throws Exception{
	String ruleNumber = rulNum;
	if(rulNum.contains("6") || rulNum.contains("7") || rulNum.contains("10")){
	wc.webActions("Enter Text in Effective Date Field","settext","xpath",PR_EFFECTIVEDATE, "Effective Date", effDate, "");	
	wc.webActions("Enter Text in Termination Date Field","settext","xpath",PR_TERMINATIONDATE, "Termination Date", terDate, "");
	wc.webActions("Enter Text in  Item Number Field", "settext","xpath",PR_ITEMNUMBER, "Item Number", itmNum, "");
	wc.webActions("Enter Text in  Rule Type Field", "settext","xpath",PR_RULETYPE, "Rule Type", rulTyp, "");
	wc.webActions("Enter Text in  Percentage Field", "settext","xpath",PR_PERCENTAGE, "Percentage", percentage, "");
	wc.webActions("", "enter","xpath",PR_PERCENTAGE, "Percentage", "", "");	
	}
	if(rulNum.equalsIgnoreCase("10")){
		wc.webActions("Enter Text in UM", "settext", "xpath", PI_UM, "UM", um, "");		
	}
	if(rulNum.equalsIgnoreCase("15")){
		wc.webActions("Enter Text in Effective Date Field","settext","xpath",PR_EFFECTIVEDATE, "Effective Date", effDate, "");	
		wc.webActions("Enter Text in Termination Date Field","settext","xpath",PR_TERMINATIONDATE, "Termination Date", terDate, "");
		wc.webActions("Enter Text in  Customer Field", "settext","xpath",PR_ITEMNUMBER, "Customer", cusNum, "");
		wc.webActions("Enter Text in  Item Number", "settext","xpath",PR_RULETYPE, "Item Number", itmNum, "");
		wc.webActions("Enter Text in  Rule Type Field", "settext","xpath",PR_PERCENTAGE, "Rule Type", rulTyp, "");		
		wc.webActions("Enter Text in Fixed Price Field", "settext", "xpath", PI_UM, "Fixed Price", percentage, "");	
		wc.webActions("Enter text in Allow Zero Field", "settext", "xpath", PI_ALLOWZERO, "Allow Zero", allZero, "");		
		wc.webActions("Enter text in UM Field", "settext", "xpath", PI_UM2_015, "UM", um, "");
		wc.webActions("Enter text in Allow Zero Field", "settext", "xpath", PI_ALLOWZERO, "Allow Zero", allZero, "");
		
	}
	wc.setTimeOut(4);
	wc.webActions("Click Save Button", "click", "xpath", PR_SAVE, "Save", "", "");	
	wc.setTimeOut(4);
	
	
}
public void PR_WorkWithPriceRuleBatches(String BatchNumber) throws Exception{
	wc.webActions("Enter Text in  Batch Number Field", "settext","xpath",PR_BATCHNUMBER, "Batch Number", BatchNumber, "");
	wc.webActions("", "enter","xpath",PR_BATCHNUMBER, "Batch Number", BatchNumber, "");	
	wc.setTimeOut(3);
}
public void verify_getBatchNumber(String BatchNumber) throws Exception{
	String batNumGrey= wc.returnTextFromElement("Get the text from Batch Number field", "xpath", PR_GETBATCHNUMBER);	
	if(batNumGrey.equalsIgnoreCase(BatchNumber)){
		hr.writeToHTML("Batch Number Has to be populated","Batch Number Should be " + BatchNumber, "Batch Number is " + batNumGrey, "Pass");
		
	}
	else
	{
		hr.writeToHTMWithScreenShotWithFailure("Batch Number is not populated","Batch Number Should be " + BatchNumber, "Batch Number is " + batNumGrey, "Fail","PriceLevel006");
	}
	driver.switchTo().defaultContent();
}

public void PI_getPrice(String cusNum,String itmNum,String effDate)throws Exception{
	wc.webActions("Enter Text in Customer Number Field", "settext", "xpath", PI_CUSTOMERNUMBER, "Customer Number", cusNum, "");
	wc.webActions("Enter Text in Item Number Field", "settext", "xpath", PI_ITEMNUMBER, "Item Number", itmNum, "");
	wc.webActions("Enter Text in Effective Date Field", "settext", "xpath", PI_PRICEDATE, "Effective Date", effDate, "");
	
	wc.webActions("Click on Get Price", "click", "xpath", PI_GETPRICE, "Get Price", "", "");	
	wc.setTimeOut(5);
}
public void verify_PriceRule(String prcRule) throws Exception{
	String priceLevel = wc.returnTextFromValueAttribute("Get the Price Rule", "xpath",PI_VERRULELEVEL,"Price Rule should be populated");
	//System.out.println(priceLevel);
	if(priceLevel.equalsIgnoreCase(prcRule)){
		hr.writeToHTML("Price Rule Has to be populated","Price Rule should be  " + prcRule, "Price Rule is  " + prcRule, "Pass");
	}
	else
	{
		hr.writeToHTMWithScreenShotWithFailure("Price Rule is not populated","Price Rule should be  " + prcRule , "Price Rule populated is  " + priceLevel, "Fail","PriceLevel00" +prcRule);
	}
	
	
}


}
