package com.javapro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyTest {
    @Test(value1 = 7, value2 = 10)
    public static int myTest(int var1, int var2) {
        return var1 + var2;
    }
}

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyTest myTest = new MyTest();
        Class<?> testClass = myTest.getClass();
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test testAnnotation = method.getAnnotation(Test.class);
                int result = (int)method.invoke(myTest, testAnnotation.value1(), testAnnotation.value2());
                System.out.println("MyTest result is: " + result);
            }
        }
    }
}
