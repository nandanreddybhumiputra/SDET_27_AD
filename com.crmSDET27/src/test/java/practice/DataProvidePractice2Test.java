package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePractice2Test {

	
	@Test(dataProvider="getData")
	public void readDataFromDataProviderTest(String Name,int Seats,String Type) {
		
		System.out.println("BusName----->"+Name+"    SeatsAvailable------->"+Seats+"     Type------>"+Type);
			
	}
	
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArr=new Object[5][3];
		
		
		objArr[0][0] = "Amaravathi";
		objArr[0][1] = 10;
		objArr[0][2] = "Ac";
		
		objArr[1][0] = "Iravatha";
		objArr[1][1] = 20;
		objArr[1][2] = "Ac";
		
		
		objArr[2][0] = "APSRTC SuperLuxury";
		objArr[2][1] = 30;
		objArr[2][2] = "Non AC";
		
		objArr[3][0] = "KSRTC";
		objArr[3][1] = 15;
		objArr[3][2] = "Non AC";
		
		objArr[4][0] = "APSRTC AC Bus";
		objArr[4][1] = 35;
		objArr[4][2] = "AC";
		
		
		return objArr;
		
	}
	
	
	
}
