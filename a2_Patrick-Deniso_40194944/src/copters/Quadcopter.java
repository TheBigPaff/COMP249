package copters;

import java.util.Objects;

public class Quadcopter extends Helicopter{
    private int maxFlyingSpeed;


    public Quadcopter(){
        super();
        maxFlyingSpeed = 70; // avg speed
    }

    public Quadcopter(Quadcopter q){
        super(q);
        this.maxFlyingSpeed = q.maxFlyingSpeed;
    }

    public Quadcopter(String brand, double price, int horsepower, int cylindersCount, int creationYear, int passengerCapacity, int maxFlyingSpeed){
        super(brand, price, horsepower, cylindersCount, creationYear, passengerCapacity);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    public int getMaxFlyingSpeed() {
        return maxFlyingSpeed;
    }

    public void setMaxFlyingSpeed(int maxFlyingSpeed) {
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    @Override
    public String toString() {
        return "This quadcopter is manufactured by " + brand + ". It costs " + price + "$, and has a horsepower of " + horsepower + "." +
                "It also has " + cylindersCount + " cilinders, a passenger capacity of " + passengerCapacity +
                ", and was created in the year " + creationYear + ". It has a max flying speed of " + maxFlyingSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quadcopter that = (Quadcopter) o;
        return maxFlyingSpeed == that.maxFlyingSpeed;
    }
}
