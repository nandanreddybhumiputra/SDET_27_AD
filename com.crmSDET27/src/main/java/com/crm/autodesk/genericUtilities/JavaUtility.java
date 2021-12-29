package com.crm.autodesk.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Nanda
 *
 */

public class JavaUtility {

	/**
     * it is used to generate random number
     * @return int data
     */
	public int getRanDomNumber() {
		Random random=new Random();
		int randomNum = random.nextInt(10000);
		return randomNum;	
	}
	
	 /**
	  *it is used to get system date and time in ist format
	  *@return 
	  */
	
	public String getsystemdateAndtime() {
		Date date=new Date();
		return date.toString();	
	}
	
	 /**
	   * it is used to get system date in YYYY-MM-DD format
	   * @return
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String dateFormat = YYYY+"-"+MM+"-"+DD;
		
		return dateFormat;
		
	}
	
	
	
}
