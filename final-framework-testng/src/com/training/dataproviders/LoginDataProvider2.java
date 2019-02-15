package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.TC077_LoginBean1;
import com.training.dao.CyclosDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelRead1;
import com.training.readexcel.ApachePOIExcelRead2;
import com.training.readexcel.ReadExcel;

public class LoginDataProvider2 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<TC077_LoginBean1> list = new CyclosDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(TC077_LoginBean1 temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getmemlogin(); 
			obj[1] = temp.getAmount(); 
			obj[1] = temp.getDescription();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "Sheet1")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\AnushiPattan\\Desktop\\TetsDataSheet1.xlsx";
		String sheetname="Sheet1";  
		return new ApachePOIExcelRead2().getExcelContent(fileName,sheetname); //
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\AnushiPattan\\Desktop\\TetsDataSheet1.xlsx", "Sheet1"); // my excel sheet with particular test data
	}
}


