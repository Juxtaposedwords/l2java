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
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String input = dna.toLowerCase();
        int start = input.indexOf(startCodon.toLowerCase());
        if (start == -1) {
            return "";
        }
        int stop = input.indexOf(stopCodon.toLowerCase(), start + 3);
        if ((stop - start) % 3 == 0) {
            return input.substring(start, stop + 3);
        }
        return "";
    }

    public boolean twoOccurrences(String subject, String corpus) {
        String text = corpus;
        int occurrences = 0;
        while (text.indexOf(subject) != -1) {
            text = text.substring(text.indexOf(subject) + 1);
            occurrences++;
        }
        return occurrences == 2;
    }

    public String lastPart( String subject,String corpus){
        String[]  parts =  corpus.split(subject,2);
        if (parts.length == 2) {
			return parts[1];
		}
		return corpus;
	}
}
