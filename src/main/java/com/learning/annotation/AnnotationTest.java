package com.learning.annotation;

@TestOne("get class value")
public class AnnotationTest {

    public static void main(String[] args) {
        TestOne t = AnnotationTest.class.getAnnotation(TestOne.class);
        System.out.println(t.value());
        TestMethod tm = null;
        try {
            tm = AnnotationTest.class.getDeclaredMethod("test",null).getAnnotation(TestMethod.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tm.value());
    }

    @TestMethod("get method value")
    public void test() {
        System.out.println();
    }
}
