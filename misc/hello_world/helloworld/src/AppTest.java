import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

    @Test
    public void test() {
        assertEquals(new App().toString(), "circle 1: Circle [radius=10.0, xCenter=5.0, yCenter=5.0] circle 2: Circle [radius=5.0, xCenter=0.0, yCenter=0.0] circle 3: Circle [radius=0.0, xCenter=0.0, yCenter=0.0]");
    }
}