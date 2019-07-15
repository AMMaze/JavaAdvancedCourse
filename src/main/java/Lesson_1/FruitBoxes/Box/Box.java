package Lesson_1.FruitBoxes.Box;

import Lesson_1.FruitBoxes.Fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Box<T extends Fruit> {
    private ArrayList<T> container;

    public Box() {
        container = new ArrayList<T>();
    }

    public double getWeight() {
        return container.size() == 0 ? 0 : container.size() * container.get(0).getWeight();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void addFruits(T... fruits) {
        if (!Arrays.asList(fruits).contains(null))
            container.addAll(Arrays.asList(fruits));
    }

    public void addFruits(Collection<T> fruits) {
        if (!fruits.contains(null))
            container.addAll(fruits);
    }

    public void pourOut(Box<T> box) {
        box.addFruits(container);
    }
}
