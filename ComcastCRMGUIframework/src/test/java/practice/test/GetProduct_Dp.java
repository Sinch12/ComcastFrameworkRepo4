package practice.test;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProduct_Dp {
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		ExcelUtility eLib = new ExcelUtility();
		int	rowcount =eLib.getRowcount("product1");
		Object[][] objarr = new Object[rowcount][2];
		for(int i = 0;i<rowcount;i++) {
			objarr[i][0]	= eLib.getDataFromExcel("product", i+1, 0);
			objarr[i][1]	= eLib.getDataFromExcel("product", i+1, 1);
			}
			return objarr;}
		
		
	}


