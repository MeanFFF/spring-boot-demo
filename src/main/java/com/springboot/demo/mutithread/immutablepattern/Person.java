package com.springboot.demo.mutithread.immutablepattern;

/**
 * Immutable参与者是一个字段值无法更改的类，也没有任何用来更改字段值的方法。
 * 当Immutable参与者的实例建立后，状态就完全不再变化。
 *
 * Immutable模式的优点在于，“不需要使用synchronized保护”。
 * 而“不需要使用synchronized保护”的最大优点就是可在不丧失安全性与生命性的前提下，提高程序的执行性能。
 * 若实例由多数线程所共享，且访问非常频繁，Immutable模式就能发挥极大的优点。
 * @author gangping.liu
 * @date 2019/11/22
 */
public class Person {
    private String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this. age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
