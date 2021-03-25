package com.javahw;

public class Main {

    public static void main(String[] args) {
        TimeSpan timeSpan1 = new TimeSpan(5, 59);
        TimeSpan timeSpan2 = new TimeSpan(2, 10);
        TimeSpan timeSpan3 = new TimeSpan(0, 10);
        System.out.println(timeSpan1);
        timeSpan1.mult(0.5);
        timeSpan1.add(timeSpan2);
        timeSpan1.sub(timeSpan3);
        System.out.println(timeSpan1);
    }
}