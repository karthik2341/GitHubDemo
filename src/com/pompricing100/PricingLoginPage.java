package com.pompricing100;

import com.pricingcommon.StringEncrypt;
import com.pricingcommon.WebControls;

public class PricingLoginPage {
	
	public String LP_USERNAME_TB_XPATH="//*[@id='User']";
	public String LP_PASSWORD_TB_XPATH="//*[@id='Password']";
	public String LP_SIGNIN_BTN_CSS=".buttonstylenormal.margin-top5";
	
	public void login() throws Exception{
		StringEncrypt s = new StringEncrypt();
		WebControls wc = new WebControls();
		String key = "lockUnlock";
		String decodedPwd = StringEncrypt.decryptXOR("DR8RAjlfWQ==", key);
		wc.webActions("settext","xpath",LP_USERNAME_TB_XPATH,"User ID","e1tst01","");
		wc.webActions("settext","xpath",LP_PASSWORD_TB_XPATH,"Password",decodedPwd,"");
		wc.webActions("click","css",LP_SIGNIN_BTN_CSS,"Sign In","","");	
		
	}
	

}
