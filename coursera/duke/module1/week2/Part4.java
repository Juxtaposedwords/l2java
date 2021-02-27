import edu.duke.*;
import java.io.*;

public class  Part4 {
	public String url(String input) {
		String lowerInput =  input.toLowerCase();
		String anchor = "href=\"";
		int tokenIndex = lowerInput.indexOf(anchor); 
		if (tokenIndex == -1){
			return "";
		}
		input = input.substring(tokenIndex+anchor.length());
		anchor = "\">";
		tokenIndex =input.indexOf(anchor);
		if (tokenIndex == -1) {
			 System.out.printf("failed to find ending token for %s\n",input);	
			 return "";
		}
		return  input.substring(0,input.indexOf(anchor));
	}
	public void scrape() {
		URLResource site = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
		for ( String line: site.lines()){
			String lineURL =  url(line);
			if (lineURL.toLowerCase().contains("youtube.com")) {					
			 	System.out.printf("%s\n",lineURL);	
			}
		}
	}
}