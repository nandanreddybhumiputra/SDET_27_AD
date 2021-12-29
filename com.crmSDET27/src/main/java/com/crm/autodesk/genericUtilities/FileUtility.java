package com.crm.autodesk.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Nanda
 *
 */
public class FileUtility {
	/**
	 *it is used to read the data from properties file based on key which you pass as an argument
	 *@param key
	 * @throws Throwable  
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./docs/commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}

}
