package com.pricingcommon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
public class JdbcConnection {
	    @Test
		public static void jdbcConnection() throws ClassNotFoundException, SQLException {
			
			String outPutPath = System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			ExcelReader er = new ExcelReader();	
			String query="SELECT IMITM,IMPRP0,IMSTKT,IMCARP,IMSRP4,IMSRP2,IMSRTX,DATE(DIGITS(DECIMAL(\"CIY55IENDT\" + 1900000,7,0))) AS ENDDATE, RAND() AS IDX FROM CRPDTA.F4101,CRPDTA.F5521020 WHERE IMSTKT ='P' AND IMSRP4='A' AND IMSRP2<>'' AND DATE(DIGITS(DECIMAL(\"CIY55IENDT\" + 1900000,7,0))) < '01/01/2013' AND CRPDTA.F5521020.CILITM =CRPDTA.F4101.IMLITM ORDER BY IDX FETCH FIRST 1 ROWS ONLY";
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");		
		    Connection con= DriverManager.getConnection("jdbc:as400://10.16.64.5:446/","efub73cx","Dinu_aug14");		
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			while(rs1.next()){
				String itemNumber = rs1.getString(1);
				String salesGroup = rs1.getString(2);
				String manNumber = rs1.getString(4);
				String prodCat = rs1.getString(6);
				er.setCellData(outPutPath,"Global", "cItemNumber",2, itemNumber);
				er.setCellData(outPutPath,"Global", "cSalesGroup",2, salesGroup);
				er.setCellData(outPutPath,"Global", "cMFGNumber",2, manNumber);
				er.setCellData(outPutPath,"Global", "cProdCat",2, prodCat);			
				System. out.println(itemNumber+"  "+salesGroup + " " + manNumber + " " + prodCat);	
				
			}
			con.close();
			
		}
	

}
