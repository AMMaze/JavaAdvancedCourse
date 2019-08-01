package Lesson_6;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FourTailTest {

    @Test
    public void testNoFour() {
        Assertions.assertThrows(RuntimeException.class, () -> Main.fourTail(new int[]{1, 2, 3, 5, 6}));
    }

    @Test
    public void testOneFour() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, Main.fourTail(new int[]{1, 4, 1, 2, 3}));
    }

    @Test
    public void testMultipleFours() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, Main.fourTail(new int[]{3, 4, 1, 4, 1, 2, 3}));
    }

    @Test
    public void testLeftEdgeFour() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, Main.fourTail(new int[]{4, 1, 2, 3}));
    }

    @Test
    public void testRightEdgeFour() {
        Assertions.assertArrayEquals(new int[]{}, Main.fourTail(new int[]{3, 4, 1, 4, 1, 2, 3, 4}));
    }
}
