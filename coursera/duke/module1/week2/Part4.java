import edu.duke.*;
import java.io.*;

public class  Part4 {
	public void scrape() {
		URLResource site = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
		for ( String line: site.lines()){
		 	System.out.printf("%s\n",line);	
		}
	}
}