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

    class TestOccurrence {
        public String description;
        public String corpus;
        public String subject;
        public boolean want;

        TestOccurrence(String description, String corpus, String subject, boolean want) {
            this.description = description;
            this.corpus = corpus;
            this.subject = subject;
            this.want = want;
        }
    }

    @Test
    public void testTwoOccurrences() {
        TestOccurrence[] tests = new TestOccurrence[] {
                new TestOccurrence(
                        "subject exist in corpus 2 times",
                        "abca",
                        "a",
                        true),
                new TestOccurrence(
                        "subject not in corpus",
                        "abc",
                        "d",
                        false),
                new TestOccurrence(
                        "subject exist in corpus 3 times",
                        "abaca",
                        "a",
                        false),
                new TestOccurrence(
                        "subject exists in corpus once",
                        "abc",
                        "a",
                        false) };
        for (TestOccurrence tc : tests) {
            boolean got = new Week2().twoOccurrences(tc.subject, tc.corpus);
            assertEquals(String.format("\n%s\n", tc.description), tc.want, got);
        }
    }

    class TestLast {
        public String description;
        public String corpus;
        public String subject;
        public String want;

        TestLast(String description, String corpus, String subject, String want) {
            this.description = description;
            this.corpus = corpus;
            this.subject = subject;
            this.want = want;
        }
    }

    @Test
    public void testLastPart() {
        TestLast[] tests = new TestLast[] {
                new TestLast(
                        "subject exist in corpus many times",
                        "abca",
                        "a",
                        "bca"),
                new TestLast(
                        "subject not in corpus",
                        "abc",
                        "d",
                        "abc"),
                new TestLast(
                        "subject exists in corpus once",
                        "abc",
                        "a",
                        "bc"),
                new TestLast(
                        "provided example",
                        "banana",
                        "an",
                        "ana"),
                new TestLast(
                        "second provide example",
                        "forest",
                        "zoo",
                        "forest") };
        for (TestLast tc : tests) {
            String got = new Week2().lastPart(tc.subject, tc.corpus);
            assertEquals(String.format("\n%s\n", tc.description), tc.want, got);
        }
    }

}
