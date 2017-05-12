package PropertyFileReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	public String PropertyReader(String Property){
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try{
			input = new FileInputStream("Config.properties");
			prop.load(input);
			prop.getProperty(Property);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return Property;
		
	}
	
	
	

}
