import edu.duke.*;
import java.io.*;


public class  Part3 {

    public boolean twoOccurrences(String subject, String corpus){

        String text = corpus;
        int occurences = 0;
        for (int i = 0; i < 2; i++){
            if (text.indexOf(subject) == -1) {
                return false;
            }
            text = text.substring(text.indexOf(subject)+1);
        }
        return true;
    }
    public String lastPart( String subject,String corpus){
        String[]  parts =  corpus.split(subject,2);
        if (parts.length == 2) {
			return parts[1];
		}
		return corpus;
	}
	public void testing(){
		testLastPart();
		testTwoOccurences();

	}
	class testOccurence {
        public String description;
        public String corpus;
        public String subject;
        public boolean want;
        testOccurence(String description, String corpus, String subject, boolean want){
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
        public String want;
        testLast(String description, String corpus, String subject, String want){
            this.description = description;
            this.corpus = corpus;
            this.subject= subject;
            this.want = want;
        }
    }
	private void testLastPart(){
		 testLast[] tests = new testLast[] {
        new testLast( 
            "subject exist in corpus many times",
            "abca",
            "a",
            "bca"),
        new testLast(
            "subject not in corpus",
            "abc",
            "d",
            "abc"),
        new testLast(
            "subject exists in corpus once",
            "abc",
            "a",
            "bc"),
        new testLast(
            "provided example",
            "banana",
            "an",
            "ana"),
        new testLast(
            "second provide example",
            "forest",
            "zoo",
            "forest")};
        for ( testLast tc: tests ) {
            System.out.printf("Test lastPart %s:\n",tc.description);
            String got =  lastPart(tc.subject,tc.corpus);
            if (  ! got.equals(tc.want) ) {
                System.out.printf("  Status: FAIL\n");
                System.out.printf("  GOT:  %s\n", got);
                System.out.printf("  WANT: %s\n", tc.want);
            } 
            
        } 

	}
	private void testTwoOccurences(){
        testOccurence[] tests = new testOccurence[] {
            new testOccurence( 
                "subject exist in corpus 2 times",
                "abca",
                "a",
                true),
            new testOccurence(
                "subject not in corpus",
                "abc",
                "d",
                false),
            new testOccurence(
                "subject exists in corpus once",
                "abc",
                "a",
                false)};
        for ( testOccurence tc: tests ) {
            System.out.printf("Test twoOccurences %s:\n",tc.description);
            boolean got =  twoOccurrences(tc.subject,tc.corpus);
            if ( got != tc.want ) {
                System.out.printf("  Status: FAIL\n");
                System.out.printf("  GOT:  %s\n", got);
                System.out.printf("  WANT: %s\n", tc.want);
            } 
            
	   }
    }
}
