public class Week2 {
    /**
     * 
     * @param dna
     * @return
     */
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAG", start + 3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop + 3);
        }
        return "";
    }

    /**
     * 
     * @param dna
     * @param startCodon
     * @param stopCodon
     * @return
     */
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
}
