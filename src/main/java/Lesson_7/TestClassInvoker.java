package Lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClassInvoker {

    public static void start(Class testClass) throws IllegalAccessException, InstantiationException{
        Object instance = testClass.newInstance();
        Method[] methods = testClass.getMethods();

        List<Method> beforeSuit = annotatedMethods(methods, BeforeSuit.class);
        if (beforeSuit.size() > 1)
            throw new RuntimeException();
        try {
            if (beforeSuit.size() == 1)
                invokeVoid(beforeSuit.get(0), instance);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        List<Method> tests = annotatedMethods(methods, Test.class);
        tests.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(Test.class).value()).reversed());
        for (Method it : tests) {
            try {
                invokeVoid(it, instance);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        List<Method> afterSuit = annotatedMethods(methods, AfterSuit.class);
        if (afterSuit.size() > 1)
            throw new RuntimeException();
        try {
            if (afterSuit.size() == 1)
                invokeVoid(afterSuit.get(0), instance);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static List<Method> annotatedMethods(Method[] methods, Class<? extends Annotation> annotation) {
        List<Method> foundMethods = new ArrayList<>();
        for (Method it : methods) {
            if(it.isAnnotationPresent(annotation)) {
                foundMethods.add(it);
            }
        }
        return foundMethods;
    }

    private static void invokeVoid(Method method, Object instance) throws IllegalAccessException, InvocationTargetException {
        if (!method.getReturnType().equals(Void.TYPE) || method.getParameterCount() != 0)
            throw new RuntimeException();
        method.invoke(instance);
    }

}
