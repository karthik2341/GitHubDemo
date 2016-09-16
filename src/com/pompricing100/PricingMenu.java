package com.pompricing100;

public class PricingMenu {
	
	public String HOME_HOME_BTN_XPATH="//*[@id='drop_home']";
	public String HOME_TITLE_XPATH="//span[@id='Sot13']";
	public String HOME_NAVIGATOR_BTN_XPATH="//div[contains(text(),'Navigator')]";
	public String HOME_MASTERDATA_BTN_XPATH="//span[contains(text(),'Master Data')]";	
	public String HOME_CUSTOMERINFO_BTN_XPATH = "//*[starts-with(@id,'submenufloatingDiv')]//child::div[12]//span[starts-with(@id,'fldnode')]";
	public String HOME_CUSTOMERMAINT_BTN_XPATH = "//table/tbody/tr/td/div[28]/div[1]//child::a[text()='Customer Maintenance']";	
	public String HOME_CONTRACTS_PRICING_REBATES_BTN=".//*[text()='Contracts, Pricing and Rebates']";	
	public String HOME_PRICING_MENU_BTN="(//span[text()='Pricing Menu'])[2]";
	public String HOME_LOCAL_GROUPS_MAINTENANCE_BTN="(//a[contains(text(),'Local Price Groups Maintenance')])[2]";
	public String HOME_PCCA_MAINTENANCE_BTN_XPATH="(//a[contains(text(),'PCCA Maintenance')])[2]";
	//Cams Button
	public String HOME_CAMS_BTN="//span[text()='CAMS']";
	//Contract Administration button.
	public String HOME_CONTRACTS_ADMIN_BTN="(//span[contains(text(),'Contract Administration Tasks')])[2]";
	//GPO Master Maintenance Button.
	public String HOME_GPO_MASTER_MAINT_BTN="(//a[contains(text(),'GPO Master Maintenance')])[2]";
	//Contracts Header Maintenance.
	public String HOME_CONTRACTS_HEADER_MAINT="(//a[contains(text(),'Contract Header Maintenance')])[2]";
	//Add Button.
	public String HOME_ADD="//*[@id='hc_Add']";
	//Contracts pricing and Rebates.
	public String HOME_CONTRACTSHEADERMAINTENANCE="//span[contains(text(),'Contracts, Pricing and Rebates')]";
	//Pricing Menu
	public String HOME_PRICINGMENU_BTN="xpath=(//span[contains(text(),'Pricing Menu')])[2]";
	//Price Rules Maintenance
	public String HOME_PRICINGRULESMAINTENANCE="(//a[contains(text(),'Price Rules Maintenance')])[2]";
	//Navigate the the Pricing Rules Enquiry
	public String HOME_PRICINGRULESINQUIRY ="(//a[starts-with(text(),'Price Inquiry')])[2]";
	

}
