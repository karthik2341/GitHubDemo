package com.pricingcommon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class HTMLReport extends Driver{
    //public static WebDriver driver;
    public static StringBuilder htmlStringBuilder=new StringBuilder();
    public static int repFlag = 0;
    public static StringBuilder htmlSummaryStringBuilder = new StringBuilder();
    public static String autoPath="C:\\Users\\lchalla\\eclipse_workspace\\";
    public static int iStepCount=1;    
    public static int iScreenShotCount =1;
    public static String startTime;
    public static String endTime;
    public static int flag = 0;
    public static String summaryfileName;
    public static String testCsName;
    public static int setFlag = 0;
    public String projectName,testEnv,browser,testCaseName,UserName,date,automationPath;
    public HTMLReport(){
    	
    }
    public HTMLReport(String projectName,String testEnv,String browser,String testCaseName,String UserName,String date,String automationPath){
    	this.projectName=projectName;
        this.testEnv =testEnv;
        this.browser=browser;
        this.testCaseName=testCaseName;
        this.UserName=UserName;
        this.date=date;
        this.automationPath=automationPath;
        //this.driver=driver;
    }	
    
    
	@Test 		
	public void htmlBuilder(){
	try{
		
		htmlStringBuilder.append("<html><head><title>Report Viewer</title>");
		htmlStringBuilder.append("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		htmlStringBuilder.append("<style type=\"text/css\">.tableHeader{color: #0000FF;font-weight: bold;font-size: 15px;font-family: Verdana;background-color: #D9D9FF;text-align: center;padding: 3px 3px 1px;}.tableFooter{color: #AAAAAA;font-size: 13px;font-family: Verdana;text-align: center;padding: 3px 3px 1px;}.tableBorder{padding-top: 5px;padding-bottom: 5px;padding-left: 10px;border-top: 3px solid #ccc;border-bottom: 3px solid #ccc;border-left: 3px solid #ccc;border-right: 3px solid #ccc;border-width: 2px;border-color: #D9D9FF;}.table_hl{margin: 2px;padding: 5px;color: #990000;font-weight: bold;font-size: 11px;font-family: Verdana;border-top: 1px solid #669;border-bottom: 1px solid #669;border: 1px solid #666699;text-align: center;}.table_cell{margin: 2px;padding: 5px;color: #000000;font-size: 11px;font-family: Verdana;border-top: 1px solid #669;border-bottom: 1px solid #669;border: 1px solid #666699;text-align: left;}.envDetCaption{padding: 2px;font-family: verdana;font-size: 11px;color: #000000;font-weight: bold;}.envDetValue{font-family: verdana;font-size: 11px;color: #000000;}.envDetColon{font-family: verdana;font-size: 11px;font-weight: bold;color: #000000;}</style>");
		htmlStringBuilder.append("</head>");
		htmlStringBuilder.append("<body style=\"font-family: Verdana\">");
		htmlStringBuilder.append("<form runat=\"server\" id=\"form1\">");
		htmlStringBuilder.append("<table width=\"99%\"><tr><td style=\"text-align: center\"><h4>Reportviewer</h4></td></tr>"); 
		htmlStringBuilder.append("<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td class=\"tableHeader\">Environment Details</td></tr>");		
		htmlStringBuilder.append("<tr><td class=\"tableBorder\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-color: Black; overflow: visible\" border=\"0\" width=\"98%\"><tr><td width=\"15%\" class=\"envDetCaption\">Project</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:orange\" colspan=\"4\" class=\"envDetValue\">"+projectName+"</td></tr><tr>");
		htmlStringBuilder.append("<tr><td width=\"15%\" class=\"envDetCaption\">Environment</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">"+testEnv+"</td><td width=\"10%\" class=\"envDetCaption\">User</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"25%\" class=\"envDetValue\">"+UserName+"</td></tr><tr>");
		startTime = date;
		String status = "Pass";
		htmlStringBuilder.append("<tr><td width=\"15%\" class=\"envDetCaption\">TestCaseName</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">"+testCaseName+"</td><td width=\"10%\" class=\"envDetCaption\">Date</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"25%\" class=\"envDetValue\">"+date+" </td></tr>");
		htmlStringBuilder.append("<tr><td width=\"15%\" class=\"envDetCaption\">browser</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">chrome</td><td width=\"10%\" class=\"envDetCaption\">Result</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:#008000; font-weight:bold\" width=\"25%\" class=\"envDetValue\">"+status+"</td></tr></table>");
		htmlStringBuilder.append("<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td class=\"tableHeader\">Test Summary</td></tr><tr>");
		htmlStringBuilder.append("<td class=\"tableBorder\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-color: Black; overflow: visible\" border=\"0\" width=\"99%\"><tr><td width=\"2%\" class=\"table_hl\">SNo.</td><td width=\"36%\" class=\"table_hl\">Description</td><td width=\"36%\" class=\"table_hl\">Expected</td><td width=\"36%\" class=\"table_hl\">Actual</td><td width=\"26%\" class=\"table_hl\">Status</td></tr><tr>");
        
		//htmlStringBuilder.append("<tr><td width=\"2%\" class=\"table_cell\">1.</td><td width=\"36%\" class=\"table_cell\">Launching main page</td><td width=\"36%\" class=\"table_cell\">Successfully launched main page: http://mmse1py.mckesson.com/jde/E1Menu.maf in  chrome browser </td><td style=\"color: green; font-weight: bold\" width=\"9%\" class=\"table_cell\">Pass</td><td width=\"17%\" class=\"table_cell\">2016.08.05  at 01:53:34 </td></tr>");
		//WriteToFile(htmlStringBuilder.toString(),System.getenv("Automation_Path")+"\\Pricing\\Reports\\testfile.html");
		
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
	public void writeStepInformation(String textToBeWritten) throws Exception{
		 htmlStringBuilder.append("<tr><td colspan=\"5\"style=\"color:black;text-align: left;font-weight: bold\" width=\"100%\" bgcolor=\"#D9D9FF\" class=\"table_cell\"><i>"+textToBeWritten+"</i></td><td style=\"color: green; font-weight: bold\" width=\"28%\" bgcolor=\"#E6E6FA\" ></td><td style=\"color: green; font-weight: bold\" width=\"28%\" bgcolor=\"#E6E6FA\" ></td><td style=\"color: green; font-weight: bold\" width=\"28%\" bgcolor=\"#E6E6FA\" ></td></tr>");
		
	}
	public void writeSummaryReport(String tcName) throws Exception{
		testCsName=tcName;
		String summaryFilePath = this.buildSummaryFolderStructure();
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy"); 	    
	    String date = formatter1.format(cal.getTime());	 		
	    summaryfileName = summaryFilePath + "\\" +  "ConsolidatedReport_" + date + ".html";
		//WriteToSummaryFile(htmlSummaryStringBuilder.toString(),summaryFilePath + "\\" +  "ConsolidatedReport_" + date + ".html");
		File file = new File(summaryfileName);    
        
        
        try {
        	if(file.exists()){
        		System.out.println("File Already Exists");
        	}
        	else{
        		System.out.println("Creating New file");
        		htmlSummaryStringBuilder.append("<html>");
        		htmlSummaryStringBuilder.append("<head>");
        		htmlSummaryStringBuilder.append("<title>Summary Report</title>");
        		htmlSummaryStringBuilder.append("<style type=\"text/css\">.tableHeader{color: #0000FF;font-weight: bold;font-size: 15px;font-family: Verdana;background-color: #D9D9FF;text-align: center;padding: 3px 3px 1px;}.tableFooter{color: #AAAAAA;font-size: 13px;font-family: Verdana;text-align: center;padding: 3px 3px 1px;}.tableBorder{padding-top: 5px;padding-bottom: 5px;padding-left: 10px;border-top: 3px solid #ccc;border-bottom: 3px solid #ccc;border-left: 3px solid #ccc;border-right: 3px solid #ccc;border-width: 2px;border-color: #D9D9FF;}.table_hl{margin: 2px;padding: 5px;color: #990000;font-weight: bold;font-size: 11px;font-family: Verdana;border-top: 1px solid #669;border-bottom: 1px solid #669;border: 1px solid #666699;text-align: center;}.table_cell{margin: 2px;padding: 5px;color: #000000;font-size: 11px;font-family: Verdana;border-top: 1px solid #669;border-bottom: 1px solid #669;border: 1px solid #666699;text-align: left;}.envDetCaption{padding: 2px;font-family: verdana;font-size: 11px;color: #000000;font-weight: bold;}.envDetValue{font-family: verdana;font-size: 11px;color: #000000;}.envDetColon{font-family: verdana;font-size: 11px;font-weight: bold;color: #000000;}</style>");
        		htmlSummaryStringBuilder.append("</head>");
        		htmlSummaryStringBuilder.append("<body style=\"font-family: Verdana\">");
        		htmlSummaryStringBuilder.append("<form runat=\"server\" id=\"form1\">");
        		htmlSummaryStringBuilder.append("<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td style=\"text-align: center\" class=\"tableHeader\">Test Case Summary</td></tr>");
        		htmlSummaryStringBuilder.append("<tr><td class=\"tableBorder\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-color: Black; overflow: visible\" border=\"0\" width=\"99%\"><tr><td style=\"text-align: left\" width=\"36%\" class=\"table_hl\">Test Case Name</td><td style=\"text-align: left\" width=\"36%\" class=\"table_hl\">Result</td></tr>");
        		htmlSummaryStringBuilder.append("<tr><td style=\"font-weight: bold\" width=\"36%\" class=\"table_cell\">"+tcName+"</td><td style=\"color: green; font-weight: bold\" width=\"36%\" class=\"table_cell\">Pass</td></tr>");		
        	    int startIndex = htmlSummaryStringBuilder.indexOf("<tr><td style=\"font-weight: bold\" width=\"36%\"");
        	    int endIndex = htmlSummaryStringBuilder.indexOf("Pass</td></tr>");        	    		
        	    System.out.println(startIndex);
        	    System.out.println(endIndex);
        		file.createNewFile();
        		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile(),false);
        	    Writer writer=new OutputStreamWriter(outputStream);
        	    writer.write(htmlSummaryStringBuilder.toString());
        	    writer.close();
        		
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        String content = FileUtils.readFileToString(file);
		System.out.println(content);
		
		content.replaceFirst("(.*)Pass</td></tr>(.*)","Fail</td></tr>");
		System.out.println(content);
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile(),false);
	    Writer writer=new OutputStreamWriter(outputStream);
	    writer.write(content.toString());
	    writer.close();
         
        
    
    
			
	}
	public void writeToHTML(String verification,String expText,String actualText,String status) throws IOException{		
		if (setFlag==0){
	    htmlStringBuilder.append("<tr><td width=\"2%\" class=\"table_cell\">"+iStepCount+"</td><td width=\"32%\" class=\"table_cell\">"+verification+"</td><td width=\"32%\" class=\"table_cell\">"+expText+"</td><td width=\"32%\" class=\"table_cell\">"+actualText+"</td><td style=\"color: green; font-weight: bold\" width=\"6%\" class=\"table_cell\">"+status+"</td></tr>");	    
		iStepCount = iStepCount +1;	
		}
	}
	
	public void writeToHTMWithScreenShot(String verification,String expText,String actualText,String status,String tcName) throws Exception{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss"); 	    
	    String date = formatter1.format(cal.getTime());	 
	   	String[] time = date.split(" ");
	    String filePath = autoPath + "\\Pricing\\Reports\\"+ time[0] + "\\ScreenShots\\"+ time[0] + "\\" +time[1] + "\\";
	    File files =  new File(filePath);
	    if(!files.exists()){
	    	if(files.mkdirs()){
	    		
	    	}
	    	else{
	    		System.out.println("Directories are not created successfully");
	    	}
	    	
	    }
        String fileName = filePath + tcName + iScreenShotCount + ".png";   
        iScreenShotCount = iScreenShotCount+1;
        System.out.println(fileName);        
        FileUtils.copyFile(scrFile, new File(fileName));
		htmlStringBuilder.append("<tr><td width=\"2%\" class=\"table_cell\">"+iStepCount + "." + "</td><td width=\"32%\" class=\"table_cell\">"+verification+"</td><td width=\"30%\" class=\"table_cell\">"+expText+"</td><td width=\"30%\" class=\"table_cell\">"+actualText+"<br><a target=\"_blank\" href="+fileName+">"+fileName+"</a></td><td style=\"color: green; font-weight: bold\" width=\"26%\" class=\"table_cell\">"+status+"</td></tr><tr>");
		iStepCount = iStepCount +1;
	}
	
	public void writeToHTMWithScreenShotWithFailure(String verification,String expText,String actualText,String status,String tcName) throws Exception{		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss"); 	    
	    String date = formatter1.format(cal.getTime());	 
	    String[] time = date.split(" ");
	    String filePath = autoPath + "\\Pricing\\Reports\\"+ time[0] + "\\ScreenShots\\"+ time[0] + "\\" +time[1] + "\\";
	    File files =  new File(filePath);
	    if(!files.exists()){
	    	if(files.mkdirs()){
	    		//System.out.println("Directories are created successfully");
	    	}
	    	else{
	    		System.out.println("Directories are not created successfully");
	    	}
	    	
	    }
        String fileName = filePath + tcName + iScreenShotCount + ".png";  
        iScreenShotCount = iScreenShotCount+1;
        FileUtils.copyFile(scrFile, new File(fileName));  
        /*
        int index1 = htmlStringBuilder.indexOf("<tr><td width=\"15%\" class=\"envDetCaption\">browser");
        int index2 = htmlStringBuilder.indexOf("/td></tr></table>");
        //String s = htmlStringBuilder.substring(2468,2816);
        //System.out.println(s);
        System.out.println(index1);
        System.out.println(index2); 
        */       
        if(repFlag == 0){
        htmlStringBuilder.replace(2455,2785,"<tr><td width=\"15%\" class=\"envDetCaption\">browser</td><td width=\"5%\" class=\"envDetColon\">:</td><td width=\"40%\" class=\"envDetValue\">chrome</td><td width=\"10%\" class=\"envDetCaption\">Result</td><td width=\"5%\" class=\"envDetColon\">:</td><td style=\"color:#FF0000; font-weight:bold\" width=\"25%\" class=\"envDetValue\">"+status+"</td></tr></table>");
        repFlag = 1;
        }
		htmlStringBuilder.append("<tr><td width=\"2%\" class=\"table_cell\">"+iStepCount + "." + "</td><td width=\"36%\" class=\"table_cell\">"+verification+"</td><td width=\"36%\" class=\"table_cell\">"+expText+"</td><td width=\"36%\" class=\"table_cell\">"+actualText+"<br><a target=\"_blank\" href="+fileName+">"+fileName+"</a></td><td style=\"color:Red; font-weight: bold\" width=\"26%\" class=\"table_cell\">"+status+"</td></tr><tr>");
		//writeFailureStatusInSummaryReport();		
		iStepCount = iStepCount +1;
	}
	
	public void writeToHTMLAfterClass(String tcName) throws Exception{
		String filePath = this.buildFolderStructure();
		
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("ddMMMyyyyHHmmss"); 	    
	    String date = formatter1.format(cal.getTime());	 	     	    
	    SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
	    endTime = formatter2.format(cal.getTime());	
	    
	    Date d1 = null;
		Date d2 = null;

		try {
			d1 = formatter2.parse(startTime);
			d2 = formatter2.parse(endTime);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			//long diffDays = diff / (24 * 60 * 60 * 1000);
			
			String diffHrs = Long.toString(diffHours);
			if(diffHrs.length()==1){
				diffHrs = "0" + diffHrs ;
			}
			
			String diffMin = Long.toString(diffMinutes);
			if(diffMin.length()==1){
				diffMin =  "0" + diffMin ;
			}
			
			String diffSec = Long.toString(diffSeconds);
			if(diffSec.length()==1){
				diffSec = "0" + diffMin  ;
			}
			String timeTaken = diffHrs + ":" + diffMin + ":" + diffSec;
			String timeCust = endTime.replace(" "," at ");
			htmlStringBuilder.append("<tr><td width=\"2%\" class=\"table_cell\">"+iStepCount + "." + "</td><td width=\"32%\" class=\"table_cell\">Execution Time should be displayed</td><td width=\"30%\" class=\"table_cell\">Execution Time:(HH:MM:SS)</td><td width=\"30%\" class=\"table_cell\">Time Taken for Execution is "+ timeTaken +"</td><td style=\"color: green; font-weight: bold\" width=\"26%\" class=\"table_cell\">Pass</td></tr>");
		    iStepCount = iStepCount + 1;

			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WriteToFile(htmlStringBuilder.toString(),filePath + "\\" + tcName + "_" + date + ".html");
		
		
	}
	
	public String buildFolderStructure() throws Exception{
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss"); 	    
	    String date = formatter1.format(cal.getTime());	 
	    String[] time = date.split(" ");
	    //String filePath = System.getenv("Automation_Path")+ "\\Pricing\\Reports\\"+ time[0] + "\\" +time[1];
	    String filePath = autoPath + "\\Pricing\\Reports\\"+ time[0];
	    File files =  new File(filePath);
	    if(!files.exists()){
	    	if(files.mkdirs()){
	    		//System.out.println("Directories are created successfully");
	    	}
	    	else{
	    		System.out.println("Directories are not created successfully");
	    	}
	    	
	    }
	    return filePath;
		
	}
	
	public String buildSummaryFolderStructure() throws Exception{
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss"); 	    
	    String date = formatter1.format(cal.getTime());	 
	    String[] time = date.split(" ");
	    //String filePath = System.getenv("Automation_Path")+ "\\Pricing\\Reports\\"+ time[0] + "\\" +time[1];
	    String filePath = autoPath + "\\Pricing\\Reports\\" + time[0];
	    File files =  new File(filePath);
	    if(!files.exists()){
	    	if(files.mkdirs()){
	    		//System.out.println("Directories are created successfully");
	    	}
	    	else{
	    		System.out.println("Directories are not created successfully");
	    	}
	    	
	    }
	    return filePath;
		
	}
	 public void WriteToFile(String fileContent,String fileName) throws IOException {
	        //String projectPath = System.getProperty("user.dir");
	        //String tempFile = projectPath + File.separator+fileName;
	        File file = null;
	        // if file does exists, then delete and create a new file
	        
	        
	            try {
	            	file = new File(fileName);	                
	            	file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        
	        
	        //write to file with OutputStreamWriter
	        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile(),false);
	        Writer writer=new OutputStreamWriter(outputStream);
	        writer.write(fileContent);
	        writer.close();
	        

	  }
	
	 public void writeFailureStatusInSummaryReport() throws Exception{
		 flag =1;	
		 
		 System.out.println(htmlSummaryStringBuilder.toString());
		
     	    
		 
		 
	 }
	 
	 
	 
	

}
	