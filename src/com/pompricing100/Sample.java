package com.pompricing100;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.pricingcommon.ExcelReader;


public class Sample {
	
	public static void main(String [] args){
		StringBuilder sb = new StringBuilder();
		String browser = "chrome";
		String status = "Pass";
		
		sb.append("<tr><td width=\"15%\" class=\"envDetCaption\">browser</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">"+browser+"</td><td width=\"10%\" class=\"envDetCaption\">Result</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:#008000; font-weight:bold\" width=\"25%\" class=\"envDetValue\">"+status+"</td></tr></table>");
		int index2 = sb.indexOf("</table>");
		System.out.println(index2);
		sb.replace(0, 330, "<tr><td width=\"15%\" class=\"envDetCaption\">browser</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">chrome</td><td width=\"10%\" class=\"envDetCaption\">Result</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:#FF0000; font-weight:bold\" width=\"25%\" class=\"envDetValue\">"+status+"</td></tr></table>");
		System.out.println(sb);
	}
		 //htmlStringBuilder.replace(2468,2816,"<tr><td width=\"15%\" class=\"envDetCaption\">browser</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">chrome</td><td width=\"10%\" class=\"envDetCaption\">Result</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:#FF0000; font-weight:bold\" width=\"25%\" class=\"envDetValue\">"+status+"</td></tr></table></td></tr></table>");

}
