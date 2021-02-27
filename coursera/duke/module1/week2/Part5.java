import edu.duke.*;
import java.io.*;

public class Part5 {
    class tuple {
        int start;
        int end;
        tuple(int start, int end){
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
            return output;
        }
        output.start = startIndex;
        int stopIndex = dna.length()-1; // we can never have this value (not mod 3).
        for ( String codon: endCodons ) {
            int index = dna.indexOf(codon, startIndex+3);
            if (index != -1 && index <= stopIndex) {
                stopIndex = index;
            }
        }
        if (stopIndex == dna.length()-1) {
            return output;
        }
        output.start = startIndex;
        output.end = stopIndex;
        return output;
    }
    class testCase {
        String dna;
        tuple want;
    }
    public void testFindProtein(){
        
    }
}