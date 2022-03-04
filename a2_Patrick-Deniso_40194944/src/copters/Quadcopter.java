package copters;

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
}
