package uav;

import java.util.Objects;

public class UAV {
    protected double weight;
    protected double price;

    public UAV(){
        weight = 150; // avg weight in lbs for an enterprise drone
        price = 1000; // average price
    }

    public UAV(UAV u){
        this.weight = u.weight;
        this.price = u.price;
    }

    public UAV(double weight, double price){
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "This UAV weighs " + weight + "lbs and it costs " + price + '$';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UAV uav = (UAV) o;
        return Double.compare(uav.weight, weight) == 0 && Double.compare(uav.price, price) == 0;
    }
}
