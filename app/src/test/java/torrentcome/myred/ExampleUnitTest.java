package torrentcome.myred;

import org.testng.annotations.AfterTest;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @AfterTest
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}