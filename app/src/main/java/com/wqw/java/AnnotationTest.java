package com.wqw.java;

/**
 * 注解测试
 *
 * @author WangQiuWei
 * @since 2018/7/3
 */
@TestAnnotation(id = 34, msg = "test")
public class AnnotationTest {
    public static void main(String[] args) {
        boolean hasAnnotation = AnnotationTest.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation) {
            TestAnnotation testAnnotation = AnnotationTest.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
    }
}
