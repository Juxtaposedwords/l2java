import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
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
            String got = new App().findSimpleGene(tc.have);
            assertEquals(String.format("\n%s\n", tc.description), got, tc.want);
        }
    }
}
