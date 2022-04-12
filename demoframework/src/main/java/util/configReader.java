package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private Properties prop;
	public Properties init_prop()
	{
		prop=new Properties();//./src/test/resources/config/config.properties
		try {
			FileInputStream ip=new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
}
