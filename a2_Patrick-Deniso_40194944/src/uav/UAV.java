package uav;

import flyingobject.FlyingObject;

/**
 * The UAV is a type of FlyingObject, and is itself a parent class for other drones.
 */
public class UAV extends FlyingObject {
    protected double weight;

    /**
     * Default constructor fills initializes attributes to sample data.
     */
    public UAV(){
        super();
        weight = 150; // avg weight in lbs for an enterprise drone
        price = 1000; // average price
    }

    public UAV(UAV u){
        super(u);
        this.weight = u.weight;
    }

    public UAV(double weight, double price){
        super(price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        String flyingObjectName = this.getClass().getSimpleName();
        return "This " + flyingObjectName + " weighs " + weight + "lbs and it costs " + price + '$';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UAV uav = (UAV) o;
        return Double.compare(uav.weight, weight) == 0 && Double.compare(uav.price, price) == 0;
    }
}
