import edu.duke.*;
import java.io.*;


public class  Part3 {

    public boolean StringsFirstAssignments(String subject, String corpus){
        if (corpus.split(subject).length >= 3){
            return true;
        }
        return false;
    }
    public String lastPart(String subject, String corpus){
        String[]  parts =  corpus.split(subject,2);
        if (parts.length == 2) {
			return parts[1];
		}
		return corpus;
	}
	public void testing(){

	}
	public void testLastPart(){

	}
	public void testStringsFirstAssignments(){

	}
}
