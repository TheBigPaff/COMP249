package com.company;

public class Main {

    public static void main(String[] args) {
	    Parallelogram p1 = new Parallelogram(5,5);
	    Parallelogram p2 = new Parallelogram(3,20);
	    Parallelogram p3 = new Parallelogram(p2);
        p3.setHeight(3);
        p3.setBase(3);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("Total area is " + Parallelogram.getTotalArea(new Parallelogram[]{p1, p2, p3}));

        System.out.println("\nAre p1 and p3 equal? " + p1.equals(p3));
        p3.setBase(p1.getBase());
        p3.setHeight(p1.getHeight());
        System.out.println(". . . Are p1 and p3 equal now? " + p1.equals(p3));
    }
}
