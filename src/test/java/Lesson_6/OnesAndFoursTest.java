package Lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnesAndFoursTest {

    @Test
    public void testOnesOnly() {
        Assertions.assertFalse(Main.onesAndFours(new int[] {1, 1, 1}));
    }

    @Test
    public void testFoursOnly() {
        Assertions.assertFalse(Main.onesAndFours(new int[] {4, 4, 4}));
    }

    @Test
    public void testEmpty() {
        Assertions.assertFalse(Main.onesAndFours(new int[] {}));
    }

    @Test
    public void testOneAndFour() {
        Assertions.assertTrue(Main.onesAndFours(new int[] {1, 4}));
    }
}
