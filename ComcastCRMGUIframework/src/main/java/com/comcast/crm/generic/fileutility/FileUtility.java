package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertiesFile(String key) throws Throwable {
	FileInputStream fis = new FileInputStream(".\\configAppData\\integration.properties");
	Properties p = new Properties();
	p.load(fis);
	  String data = p.getProperty(key);
return data;
}}
