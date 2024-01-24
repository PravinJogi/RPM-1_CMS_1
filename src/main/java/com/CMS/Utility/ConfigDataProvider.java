package com.CMS.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
    private Properties pro;
 public ConfigDataProvider() throws Exception {
		   String CD=System.getProperty("user.dir");
	  String path=CD+"\\Config\\Config.Properties";
	  File src=new File(path);
	  
	  FileInputStream file=new FileInputStream(src);
	  pro=new Properties();
	  pro.load(file);
	}
	
	public String getStageUrlProject() {
		return pro.getProperty("StageUrlProject");
	}
	public String getUserName() {
		return pro.getProperty("UserName");
	}
	public String getpassword() {
		return pro.getProperty("password");
	}
	public String getLiveUrlProject() {
		return pro.getProperty("LiveUrlProject");
	}
}
