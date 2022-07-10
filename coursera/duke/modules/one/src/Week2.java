public class Week2 {
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
}
