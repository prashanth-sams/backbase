package ecommerce.propertyfinderae.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configProperty {
	Properties property;
	
	public configProperty() {
		try {
			File src = new File("./src/test/java/ecommerce/propertyfinderae/datasource/config.property");
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is == " + e.getMessage());
		}
        
	}
	
	public String getChromePath () {
		String path = property.getProperty("chromeDriver");
		
		return path;
	}
	
	public String getFirefoxPath () {
		String path = property.getProperty("firefoxDriver");
		
		return path;
	}
	
	public String getPhantomjsPath () {
		String path = property.getProperty("phantomjs");
		
		return path;
	}
	
	public String getPageURL () {
		String path = property.getProperty("URL");
		
		return path;
	}
	
	
}
