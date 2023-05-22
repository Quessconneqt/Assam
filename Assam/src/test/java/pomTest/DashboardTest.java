package pomTest;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.DataProvider;


public class DashboardTest extends BaseTest {
	
	@DataProvider(name="meterNumberData")
	public String [][] getData() throws IOException
	{
		//get the data from excel
		String path=".\\MeterData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String paymentData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				paymentData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				//System.out.println(paymentData[i-1][j]);
			}
				
		}
		
		return paymentData;
	}

	@Test(priority = 2)
	public void clickAsset() throws InterruptedException {
		
		db.assetQueryClick();
	}
	
  @Test(priority =3, dataProvider = "meterNumberData")
		
		public void searchBadge(String Meter_Number) throws InterruptedException {
			
			db.searchBadgeNumber(Meter_Number);
			db.deleteInreceipt();
		}


//@Test(priority =4)
//public void meterDelete() throws InterruptedException {
//	
//	db.deleteInreceipt();
//}
  }
    
	


