package ecommerce.backbase.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configProperty {
	Properties property;
	
	public configProperty() {
		try {
			File src = new File("./src/test/java/ecommerce/backbase/datasource/config.property");
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

	public String getPhantomjsPath () {
		String path = property.getProperty("phantomjs");
		return path;
	}
	
	public String getPageURL (String URL) {
		String path = property.getProperty(URL);
		return path;
	}

	public String getPageTitle(String Title) {
		String title = property.getProperty(Title);
		return title;
	}

	public String getComputerName(String Name) {
		String name = property.getProperty(Name);
		return name;
	}	
	
}
