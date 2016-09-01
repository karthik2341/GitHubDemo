package com.pricingtestcasessprint01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;



public class InitialSheetSetup {
	
public static void main(String[] args) throws IOException{
	int arrID =0;
	int priceLevel=0;
	int priceLvlsBefore=0;
	int prceLvlsAftrTerm=0;
    String fileName=System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
    
    HSSFRow row;
    Cell cell;
    File file = new File(fileName);
    if(file.exists()){
    	file.delete();
    }
    else{
    	file.createNewFile();
    }
    //Creation of columns
    String[] columnNames ={"SelectRunId","cTestcaseName","cExecPriority","cPriceLevel",	"cLevelBeforeEffDate","cLevelAfterTerDate","cShipToCustomer","cBillToCustomer","cItemNumber","cSalesGroup","cMFGNumber","cProdCat","cGroupID","cLPGID","cDCNumber","cGPONumber","cMckGPOContractID","cMcKLocalContractID","cLPGEffDate","cLPGEndDate","cPCCAStartDate",	"cPCCAEndDate",	"cGPOStartDate","cGPOEndDate","cLocalMfgStartDate",	"cLocalMfgEndDate","cGpoMfgStartDate","cGpoMfgEndDate",	"cGpoItemStartDate","cGpoItemEndDate","cRulesEffDate","cRulesStartDate","cRulesTermDate","cPriceRulesId","cGpoItemTermDate","cLocalItemTermDate","cItemContractRestartDate","cItemContractRestartEndDate","cAcquisitionCost","cPriUom","cCostReduction","cContractCost","cGpoPriceFormulaID","cCustomerEndDate","cLocalCostReduction","cGPOTerminateDate","cLPGTerminateDate"};
    String[] dates=getDaysBetweenDates(180);
	HSSFWorkbook workbook = new HSSFWorkbook();	
	 HSSFSheet spreadsheet = workbook.createSheet("Global");
	// Map<String,String> m1 = cm.getKnownGoodMap(fileName, "Global");
	 //creation of first row with column names
	 for(int rowCreation = 0;rowCreation<=50;rowCreation++){
		 spreadsheet.createRow(rowCreation);
	 }
	 row = spreadsheet.getRow(0);
	 for(int i=0;i<=45;i++){
		 cell = row.createCell(i);			 
		 cell.setCellValue(columnNames[i]);         
	 
	 }
	
	 //Setting up Test Case Name in the second Column
	 String[] testCaseNames={"Pricing_level_006","Pricing_level_007","Pricing_level_010","Pricing_level_015","Pricing_level_020","Pricing_level_023","Pricing_level_025","Pricing_level_027","Pricing_level_028","Pricing_level_030","Pricing_level_050","Pricing_level_070","Pricing_level_080","Pricing_level_090","Pricing_level_100","Pricing_level_110","Pricing_level_120","Pricing_level_130","Pricing_level_140","Pricing_level_150","Pricing_level_160","Pricing_level_170","Pricing_level_180"};
	 //Setting up Price Levels in cPriceLevel Column
	 int[] priceLevels ={6,7,10,15,20,23,25,27,28,30,50,70,80,90,100,110,120,130,140,150,160,170,180};
	 int[] priceLevelsBefore={190,6,7,10,15,20,23,25,27,28,30,50,70,80,90,100,110,120,130,140,150,160,170};
	 int[] priceLevelsAfterTerminationDate={7,10,15,20,23,25,27,28,30,50,70,80,90,100,110,120,130,140,150,160,170,180,190};

	 
	 
	 
	 //creation of first Row data
	 row = spreadsheet.getRow(1);		 
	 
	 for(int j=18;j<=28;j=j+2){
		 cell = row.createCell(j);
		 cell.setCellValue(dates[0]);			 
	 }
	 for(int k=19;k<=29;k=k+2){
		  cell = row.createCell(k);
		 cell.setCellValue(dates[1]);			 
	 }
	 //creation of run value in the first column selectRunID
	 
	 for(int runID = 2;runID<=24;runID++){			 
		 row=spreadsheet.getRow(runID);
		 for(int colID =0;colID<=0;colID++){
		 cell = row.createCell(colID);
		 cell.setCellValue("run");
		 } 
		 
	 }
	 //setting Values in cTestCaseName Field.
	 for(int tcRowID =2 ;tcRowID<=25;tcRowID++){
		 row=spreadsheet.getRow(tcRowID);
		 
		 for(int colID =1;colID<=1;colID++){
			 cell = row.createCell(colID);
			 if(arrID!=23){
			 cell.setCellValue(testCaseNames[arrID]);
			 arrID=arrID+1;
			 }
			 } 
		 
	 }
	 
	 //Setting Values in cPriceLevel Field
	 for(int cpRowID =2 ;cpRowID<=25;cpRowID++){
		 row=spreadsheet.getRow(cpRowID);
		 
		 for(int colID =3;colID<=3;colID++){
			 cell = row.createCell(colID);
			 if(priceLevel!=23){
			 cell.setCellValue(priceLevels[priceLevel]);
			 priceLevel=priceLevel+1;
			 }
			 } 
		 
	 }
	//Setting Values in cLevelAfterTerDate column
	 for(int clRowID =2 ;clRowID<=25;clRowID++){
		 row=spreadsheet.getRow(clRowID);			 
		 for(int colID =4;colID<=4;colID++){
			 cell = row.createCell(colID);
			 if(priceLvlsBefore!=23){
			 cell.setCellValue(priceLevelsBefore[priceLvlsBefore]);
			 priceLvlsBefore=priceLvlsBefore+1;
			 }
			 } 
		 
	 }
	 
	//Setting Values in PriceLevelAfterTerminationDate
	 for(int rowID =2 ;rowID<=25;rowID++){
		 row=spreadsheet.getRow(rowID);			 
		 for(int colID =5;colID<=5;colID++){
			 cell = row.createCell(colID);
			 if(prceLvlsAftrTerm!=23){
			 cell.setCellValue(priceLevelsAfterTerminationDate[prceLvlsAftrTerm]);
			 prceLvlsAftrTerm=prceLvlsAftrTerm+1;
			 }
			 } 
		 
	 }
	 
	 
	 // Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel006
	 
	 String[] priceLevel006=getDaysBetweenDates(5);		 
	 row=spreadsheet.getRow(2);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel006[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel006[1]);
	  		 
	 //Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel007
	 String[] priceLevel007=getDateRange(6,11);			 
	 row=spreadsheet.getRow(3);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel007[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel007[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel010
	 String[] priceLevel008=getDateRange(12,17);	
	 row=spreadsheet.getRow(4);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel008[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel008[1]);
	
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel010
	 String[] priceLevel010=getDateRange(18,23);	
	 row=spreadsheet.getRow(5);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel010[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel010[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel015
	 String[] priceLevel015=getDateRange(24,29);	
	 row=spreadsheet.getRow(6);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel015[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel015[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel020
	 String[] priceLevel020=getDateRange(30,35);	
	 row=spreadsheet.getRow(7);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel020[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel020[1]);
	
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel023
	 String[] priceLevel023=getDateRange(36,41);	
	 row=spreadsheet.getRow(8);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel023[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel023[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel025
	 String[] priceLevel025=getDateRange(42,47);	
	 row=spreadsheet.getRow(9);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel025[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel025[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel027
	 String[] priceLevel027=getDateRange(48,53);	
	 row=spreadsheet.getRow(10);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel027[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel027[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel028
	 String[] priceLevel028=getDateRange(54,59);	
	 row=spreadsheet.getRow(11);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel028[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel028[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel030
	 String[] priceLevel030=getDateRange(60,65);	
	 row=spreadsheet.getRow(12);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel030[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel030[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel050
	 String[] priceLevel050=getDateRange(66,71);	
	 row=spreadsheet.getRow(13);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel050[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel050[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel070
	 String[] priceLevel070=getDateRange(72,77);	
	 row=spreadsheet.getRow(14);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel070[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel070[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel080
	 String[] priceLevel080=getDateRange(78,83);	
	 row=spreadsheet.getRow(15);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel080[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel080[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel090
	 String[] priceLevel090=getDateRange(84,89);	
	 row=spreadsheet.getRow(16);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel090[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel090[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel100
	 String[] priceLevel100=getDateRange(90,95);	
	 row=spreadsheet.getRow(17);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel100[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel100[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel110
	 String[] priceLevel110=getDateRange(96,101);	
	 row=spreadsheet.getRow(18);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel110[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel110[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel120
	 String[] priceLevel120=getDateRange(102,107);	
	 row=spreadsheet.getRow(19);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel120[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel120[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel130
	 String[] priceLevel130=getDateRange(103,108);	
	 row=spreadsheet.getRow(20);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel130[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel130[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel140
	 String[] priceLevel140=getDateRange(109,113);	
	 row=spreadsheet.getRow(21);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel140[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel140[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel150
	 String[] priceLevel150=getDateRange(114,119);	
	 row=spreadsheet.getRow(22);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel150[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel150[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel160
	 String[] priceLevel160=getDateRange(120,125);	
	 row=spreadsheet.getRow(23);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel160[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel160[1]);
	 
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel170
	 String[] priceLevel170=getDateRange(126,131);	
	 row=spreadsheet.getRow(24);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel170[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel170[1]);
	 /*
	//Setting Dates in cRulesEffDate and cRulesTermDate for PriceLevel180
	 String[] priceLevel180=getDateRange(132,137);	
	 row=spreadsheet.getRow(25);				 
	 cell = row.createCell(30);		 
	 cell.setCellValue(priceLevel180[0]);
	 cell = row.createCell(32);		 
	 cell.setCellValue(priceLevel180[1]);
     */
	 FileOutputStream fileOut = new FileOutputStream(fileName);
     workbook.write(fileOut);
     
     fileOut.close();
     
     
     			
		

}
public static String[] getDaysBetweenDates(int noOfDays)
{ 
	String[] dates = new String[2];
	Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    String strDate= formatter.format(date);  
    dates[0] = strDate;
    	    
    Calendar cal = Calendar.getInstance();	    
    cal.add(Calendar.DATE, noOfDays);	    
    SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy"); 	    
    String formatted = formatter1.format(cal.getTime());
    dates[1] = formatted;
    
    return dates;
   
    
}

public static String[] getDateRange(int startDate,int endDate)
{ 
	String[] dates = new String[2];
	
    Calendar cal = Calendar.getInstance();	    
    cal.add(Calendar.DATE, startDate);	    
    SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy"); 	    
    String formatted = formatter1.format(cal.getTime());
    dates[0] = formatted;
    
    Calendar cal1 = Calendar.getInstance();	    
    cal1.add(Calendar.DATE, endDate);	    
    SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy"); 	    
    String formatted1 = formatter2.format(cal1.getTime());
    dates[1] = formatted1;
    
    return dates;
   
    
}
		 

}
