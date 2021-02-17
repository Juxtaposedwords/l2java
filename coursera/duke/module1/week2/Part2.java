import edu.duke.*;
import java.io.*;



public class  Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String input = dna.toLowerCase();
        int start = input.indexOf(startCodon.toLowerCase());
        if (start == -1) {
            return "";
        }
        int stop = input.indexOf(stopCodon.toLowerCase(), start+3);
        if ((stop - start) % 3 == 0) {
            return input.substring(start, stop+3);
        }
        return "";
    }   
    class testCase {
        public String description;
        public String have;
        public String want;
        testCase(String description, String have, String want){
            this.description = description;
            this.have = have;
            this.want = want;
        }
    }
    public void testSimpleGene(){
        testCase[] tests = new testCase[] {
        new testCase( 
            "happy path: has ATG and TAG",
            "AATGAAATAGA",
            "atgaaatag"),
        new testCase(
            "duplicate ATG",
            "ATGATGTAG",
            "atgatgtag"),
        new testCase(
            "duplicate TAG",
            "ATGTAGTAG",
            "atgtag"),
        new testCase(
            "no response:has ATG, no TAG",
            "ATGAGTA",
            ""),
        new testCase(
            "no response: no ATG",
            "TATATATATATATATATG",
            ""),
        new testCase(
            "no response: not modulo 3",
            "AGTTTTAAAGGATT",
            "")};
        for ( testCase tc: tests ) {
            System.out.printf("Test %s:\n",tc.description);
            System.out.printf("  Status:");
            String got =  findSimpleGene(tc.have, "aTg", "TaG");
            if (! got.equals(tc.want)) {
                System.out.printf("FAIL\n");
                System.out.printf("  GOT:  %s\n", got);
                System.out.printf("  WANT: %s\n", tc.want);
            } else {
                System.out.printf("PASS\n");
            }
            
        }
    }
}
