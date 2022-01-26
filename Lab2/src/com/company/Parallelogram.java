package com.company;

import java.util.Objects;

public class Parallelogram {
    private double base;
    private double height;

    public Parallelogram(double b, double h){
        base = b;
        height = h;
    }
    public Parallelogram(Parallelogram p){
        this.base = p.base;
        this.height = p.height;
    }


    public double getBase() {
        return base;
    }
    public double getHeight() {
        return height;
    }

    public void setBase(double base) {
        if(base < 0) this.base = 0;
        else this.base = base;
    }
    public void setHeight(double height) {
        if(height < 0) this.height = 0;
        else this.height = height;
    }

    static public double getTotalArea(Parallelogram[] parallelograms){
        double totalArea = 0;
        for(Parallelogram p : parallelograms){
            totalArea += p.getArea();
        }
        return totalArea;
    }

    public double getArea(){
        return base * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parallelogram p = (Parallelogram) o;
        return Double.compare(p.base, base) == 0 && Double.compare(p.height, height) == 0;
    }

    @Override
    public String toString() {
        return "Base: " + base + "\nHeight: " + height + "\nArea: " + getArea();
    }
}
