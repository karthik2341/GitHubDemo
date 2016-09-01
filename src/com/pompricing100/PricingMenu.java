package com.pompricing100;

public class PricingMenu {
	
	public String HOME_HOME_BTN_XPATH="//*[@id='drop_home']";
	public String HOME_TITLE_XPATH="//span[@id='Sot13']";
	public String HOME_NAVIGATOR_BTN_XPATH="//div[contains(text(),'Navigator')]";
	public String HOME_MASTERDATA_BTN_XPATH="//span[contains(text(),'Master Data')]";	
	public String HOME_CUSTOMERINFO_BTN_XPATH = ".//*[starts-with(@id,'submenufloatingDiv')]//child::div[12]//span[starts-with(@id,'fldnode')]";
	public String HOME_CUSTOMERMAINT_BTN_XPATH = "//table/tbody/tr/td/div[28]/div[1]//child::a[text()='Customer Maintenance']";	
	public String HOME_CONTRACTS_PRICING_REBATES_BTN=".//*[text()='Contracts, Pricing and Rebates']";	
	public String HOME_PRICING_MENU_BTN="(//span[text()='Pricing Menu'])[2]";
	public String HOME_LOCAL_GROUPS_MAINTENANCE_BTN="(//a[contains(text(),'Local Price Groups Maintenance')])[2]";

}
