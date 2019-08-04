package Lesson_7;

public class Tests {
    @Test(value = 3)
    public void test1() {
        System.out.println("Priority 3");
    }


    @Test(value = 6)
    public void test2() {
        System.out.println("Priority 6");
    }

    @BeforeSuit
    public void test3() {
        System.out.println("Before");
    }
}
