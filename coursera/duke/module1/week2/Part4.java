import edu.duke.*;
import java.io.*;
import java.util.*;

public class  Part4 {
    public ArrayList<String> urls(String source) {
        ArrayList<String> output =  new ArrayList<String>();
        URLResource site = new URLResource(source);
        for (String line: site.lines()){
            String lowerLine=  line.toLowerCase();
            String anchor = "href=\"";
            int tokenIndex = lowerLine.indexOf(anchor); 
            if (tokenIndex == -1){
                continue;
            }
            line = line.substring(tokenIndex+anchor.length());
            anchor = "\">";
            tokenIndex = line.indexOf(anchor);
            if (tokenIndex == -1) {
                 System.out.printf("failed to find ending token for %s\n",line);    
                 continue;
            } 
            output.add(line.substring(0,line.indexOf(anchor)));
        }
        return output;
    }
    public void scrape() {
        for ( String line: urls("https://www.dukelearntoprogram.com//course2/data/manylinks.html")){
            if (line.toLowerCase().contains("youtube.com")) {
            System.out.printf("%s\n",line);
        }
        }
    }
}