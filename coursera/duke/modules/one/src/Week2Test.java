import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Week2Test {
    class TestSimpleGeneCase {
        public String description;
        public String have;
        public String want;

        TestSimpleGeneCase(String description, String have, String want) {
            this.description = description;
            this.have = have;
            this.want = want;
        }
    }

    @Test
    public void testFindSimpleGene() {
        TestSimpleGeneCase[] tests = new TestSimpleGeneCase[] {
                new TestSimpleGeneCase(
                        "happy path: has ATG and TAG",
                        "AATGAAATAGA",
                        "ATGAAATAG"),
                new TestSimpleGeneCase(
                        "duplicate ATG",
                        "ATGATGTAG",
                        "ATGATGTAG"),
                new TestSimpleGeneCase(
                        "duplicate TAG",
                        "ATGTAGTAG",
                        "ATGTAG"),
                new TestSimpleGeneCase(
                        "no response:has ATG, no TAG",
                        "ATGAGTA",
                        ""),
                new TestSimpleGeneCase(
                        "no response: no ATG",
                        "TATATATATATATATATG",
                        ""),
                new TestSimpleGeneCase(
                        "no response: not modulo 3",
                        "AGTTTTAAAGGATT",
                        "") };
        for (TestSimpleGeneCase tc : tests) {
            String got = new Week2().findSimpleGene(tc.have);
            assertEquals(String.format("\n%s\n", tc.description), tc.want, got);
        }
        // now we do the second version of findSimpleGene

        tests = new TestSimpleGeneCase[] {
                new TestSimpleGeneCase(
                        "happy path: has ATG and TAG",
                        "AATGAAATAGA",
                        "atgaaatag"),
                new TestSimpleGeneCase(
                        "duplicate ATG",
                        "ATGATGTAG",
                        "atgatgtag"),
                new TestSimpleGeneCase(
                        "duplicate TAG",
                        "ATGTAGTAG",
                        "atgtag"),
                new TestSimpleGeneCase(
                        "no response:has ATG, no TAG",
                        "ATGAGTA",
                        ""),
                new TestSimpleGeneCase(
                        "no response: no ATG",
                        "TATATATATATATATATG",
                        ""),
                new TestSimpleGeneCase(
                        "no response: not modulo 3",
                        "AGTTTTAAAGGATT",
                        "") };
        for (TestSimpleGeneCase tc : tests) {
            String got = new Week2().findSimpleGene(tc.have, "aTg", "TaG");
            assertEquals(String.format("\n%s\n", tc.description), tc.want, got);
        }
    }

    class testOccurence {
        public String description;
        public String corpus;
        public String subject;
        public boolean want;

        testOccurence(String description, String corpus, String subject, boolean want) {
            this.description = description;
            this.corpus = corpus;
            this.subject = subject;
            this.want = want;
        }
    }

    @Test
    public void testTwoOccurences() {
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
                        "subject exist in corpus 3 times",
                        "abaca",
                        "a",
                        false),
                new testOccurence(
                        "subject exists in corpus once",
                        "abc",
                        "a",
                        false) };
        for (testOccurence tc : tests) {
            boolean got = new Week2().twoOccurrences(tc.subject, tc.corpus);
            assertEquals(String.format("\n%s\n", tc.description), tc.want, got);
        }
    }

}
