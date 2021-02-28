import edu.duke.*;
import java.io.*;

public class Part5 {
    class tuple {
        int start;
        int end;
        tuple( int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public tuple findProtein(String dna) {
        tuple output = new tuple(0,0);
        String[] endCodons = {"taa","tag","tga"};
        String startCodon = "atg";
        dna = dna.toLowerCase();
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return new tuple(-1,-1);
        }
        output.start = startIndex;
        int stopIndex = 0;
        for ( String codon: endCodons ) {
        	int index = startIndex;
        	int instance =1;
        	while (index != -1 ){
        		index = dna.indexOf(codon,index+3);
        		//System.out.printf(" a: %b b: %b c: %b\n",index != -1,(index-startIndex) %3 == 0,(index < stopIndex || stopIndex==0));
        		if (index != -1 && (index-startIndex) %3 == 0 &&(index < stopIndex || stopIndex==0)){
        			stopIndex = index;
        		}  
        	}            
        }
        if (stopIndex == 0 ){
            return new tuple(startIndex,-1);
        }
        output.end = stopIndex+3;
        return output;
    }
    public class testCase {
        String description;
        String dna;
        tuple want;
        testCase( String description, String dna, tuple want ){
        	this.description = description;
        	this.dna = dna;
        	this.want = want;
        }
    }
    public void testFindProtein(){
		testCase[] tests = new testCase[] {
		        new testCase(
				"multiple pairs exists",
				"zzzATGzzzTGAzzzATGzzzTAGzz",
				new tuple(3,12)),
			new testCase(
				"happy path: no distance between",
				"ATGTAG",
				new tuple(0,6)),
			new testCase(
				"no end codon with modulo 3 distance",
				"ATGTATga",
				new tuple(0,-1)),
			new testCase(
				"first end codon not modulo 3 distance",
				"ATGTATga",
				new tuple(0,-1)),			
			new testCase(
				"no start",
				"AAAAAATTTTTTTTTTG",
				new tuple(-1,-1)),			
			};
        for ( testCase tc: tests ) {
        	tuple got = findProtein(tc.dna);
        	if (got.start != tc.want.start || got.end != tc.want.end ){
        		System.out.printf("Test: %s (GOT->WANT):\n",tc.description);
        		if (got.start != tc.want.start) {
	        		System.out.printf("  start: %d -> %d\n",got.start,tc.want.start);
        		}
        		if (got.end != tc.want.end ){
	        		System.out.printf("  end:   %d -> %d\n",got.end,tc.want.end);
        		}
        	}
        }

    }
}