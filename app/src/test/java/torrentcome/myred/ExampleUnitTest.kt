package torrentcome.myred

import org.junit.Assert
import org.testng.annotations.AfterTest

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @AfterTest
    fun addition_isCorrect() {
        Assert.assertEquals(4, 2 + 2.toLong())
    }
}