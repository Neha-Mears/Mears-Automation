package com.sat.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sat.testbase.TestBase;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/sat/config/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	 public String getSelenium() {
		 String s1 = properties.getProperty("selenium");
		 if(s1 != null) {
			 return s1;
			 
		 }
		 else {
			 throw new RuntimeException("s1 not specified in the Configuration.properties file.");
		 }
	 }

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public void refresh() {
		TestBase.getDriver().navigate().refresh();
	}

	public String fileUpload(String fileName) {
		String file_Name = properties.getProperty(fileName);
		if (file_Name != null)
			return file_Name;
		else
			throw new RuntimeException("File path not Specified in the configuration path");
	}

	public String getMCMApplicationUrl() {
		String url = properties.getProperty("MCMtestUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("MCM App url not specified in the Configuration.properties file.");
	}
	public String getMearsHomeUrl() {
		String url = properties.getProperty("MearsHomeApp");
		if (url != null)
			return url;
		else
			throw new RuntimeException("MCM App url not specified in the Configuration.properties file.");
	}

	public String MCMUserName(){
		String UserID =properties.getProperty("MCMViewHMUsername");
		System.out.println(UserID);
		if(UserID!= null)
			return UserID;
		else throw new RuntimeException("UserID not specified in the Configuration properties file");
	}
	
	public String getUserName(String username){
		System.out.println(username);
		String UserName =properties.getProperty(username);
		System.out.println(UserName);
		if(UserName!= null)
			return UserName;
		else throw new RuntimeException("UserID not specified in the Configuration properties file");
	}
	public String MearsUserName(){
		String UserID =properties.getProperty("MearsUserName");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("MCM UserID not specified in the Configuration.properties file");
	}
	public String MearsHomePassword()
	{
		String Password =properties.getProperty("MearsPassword");
		if(Password!= null) return Password;
		else throw new RuntimeException("MCM Password not specified in the Configuration.properties file");
	}
	
	public String MCMUserPassword()
	{
		String Password =properties.getProperty("MCMAppUserPassword");
		System.out.println(Password);
		if(Password!= null) return Password;
		else throw new RuntimeException("Password not specified in the Configuration.properties file");
	}
	
	public String getuserPassword(String userpassword)
	{
		String Password =properties.getProperty(userpassword);
		System.out.println(Password);
		if(Password!= null) 
			return Password;
		else 
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}
	}


	

