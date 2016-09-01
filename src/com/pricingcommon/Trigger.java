package com.pricingcommon;

import java.io.IOException;

public class Trigger {

	public static void main(String[] args) throws IOException{
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c","start");
			  pb.start();
	}
	
	
}
