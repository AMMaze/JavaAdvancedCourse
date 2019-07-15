package Lesson_1;

import Lesson_1.FruitBoxes.Box.Box;
import Lesson_1.FruitBoxes.Fruits.Apple;
import Lesson_1.FruitBoxes.Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static <T> void swapArrayElems(T[] arr, int idx1, int idx2) {
        T tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        swapArrayElems(arr, 2, 5);
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> arrList = arrayToArrayList(arr);
        System.out.println(arrList.toString());


        Box<Orange> box1 = new Box<Orange>();
        for (int i = 0; i < 5; i++)
            box1.addFruits(new Orange());

        Box<Apple> box2 = new Box<Apple>();
        for (int i = 0; i < 3; i++)
            box2.addFruits(new Apple());

        System.out.println(box1.compare(box2));

        Box<Apple> box3 = new Box<Apple>();
        for (int i = 0; i < 4; i++)
            box3.addFruits(new Apple());

        System.out.println("Box3 weight before: " + box3.getWeight());
        box2.pourOut(box3);
        System.out.println("Box3 weight after: " + box3.getWeight());

    }
}
