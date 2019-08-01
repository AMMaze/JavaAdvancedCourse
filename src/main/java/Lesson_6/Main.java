package Lesson_6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] fourTail(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            if (ints[i] == 4) {
                return Arrays.copyOfRange(ints, i+1, ints.length);
            }
        }
        throw new RuntimeException();
    }

    public static boolean onesAndFours(int[] ints) {
        boolean one = false, four = false;
        for (int it: ints) {
            one = it == 1 || one;
            four = it == 4 || four;
            if (one && four)
                return true;
        }
        return false;
    }

}
