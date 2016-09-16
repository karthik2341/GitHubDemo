package com.pricingcommon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;
public class JdbcConnection {
	    @Test
		public static void jdbcConnection(String query,String url,String userName,String pwd) throws ClassNotFoundException, SQLException {
			
			String outPutPath = System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			ExcelReader er = new ExcelReader();	
			
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");		
		    Connection con= DriverManager.getConnection(url,userName,pwd);		
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
				System.out.println(itemNumber+"  "+salesGroup + " " + manNumber + " " + prodCat);	
				
			}
			con.close();
			
		}
	

}
