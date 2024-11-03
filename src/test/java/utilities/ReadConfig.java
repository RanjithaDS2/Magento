package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties p;
	
	public ReadConfig() 
	{
		File src = new File("./src\\test\\java\\utilities\\config.properties");

		try {
			
			FileInputStream f = new FileInputStream(src);
			p = new Properties();
			p.load(f);
		    } 
		
		catch (Exception e) 
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getValue(String keyValue)
	{
		String url1=p.getProperty(keyValue);
		return url1;
	} 
}
	