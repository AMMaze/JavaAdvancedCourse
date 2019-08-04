package Lesson_7;

public class Main {

    public static void main(String[] args) {
        try {
            TestClassInvoker.start(Tests.class);
        } catch (IllegalAccessException|InstantiationException e) {
            e.printStackTrace();
        }
    }

}
