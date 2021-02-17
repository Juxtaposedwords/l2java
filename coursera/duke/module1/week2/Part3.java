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
		testLastPart();

	}
	class testCase {
        public String description;
        public String corpus;
        public String subject;
        public String want;
        testCase(String description, String corpus, String subject, String want){
            this.description = description;
            this.corpus = corpus;
            this.subject= subject;
            this.want = want;
        }
    }
    class testLast {
        public String description;
        public String corpus;
        public String subject;
        public boolean want;
        testCase(String description, String corpus, String subject, boolean want){
            this.description = description;
            this.corpus = corpus;
            this.subject= subject;
            this.want = want;
        }
    }
	public void testLastPart(){
		 testCase[] tests = new testCase[] {
        new testLast( 
            "subject exist in corpus many times",
            "bodybody"
            "dy",
            true),
        new testLast(
            "subject not in corpus",
            "bodybody",
            "flegm",
            false),
        new testLast(
            "subject exists in corpus once",
            "ayebody",
            "dy",
            true)};
        for ( testLast tc: tests ) {
            System.out.printf("Test %s:\n",tc.description);
            System.out.printf("  Status:");
            boolean got =  lastPart(tc.corpus.tc.subject);
            if (! got.equals(tc.want)) {
                System.out.printf("FAIL\n");
                System.out.printf("  GOT:  %s\n", got);
                System.out.printf("  WANT: %s\n", tc.want);
            } else {
                System.out.printf("PASS\n");
            }
            
        } 

	}
	public void testStringsFirstAssignments(){

	}
}
