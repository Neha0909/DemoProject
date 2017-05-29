package PropertyFileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	public String PropReader (String Property) throws FileNotFoundException{
		String Getprop="";
		try{
		FileReader reader=new FileReader("C:\\Users\\ne321427\\workspace\\Project1\\Config.properties");  
		
		Properties p=new Properties();  
	    p.load(reader); 
	    Getprop = p.getProperty(Property);
	    System.out.println("Prop is"+Getprop);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Getprop;
	}
	
}
