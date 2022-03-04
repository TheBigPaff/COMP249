package copters;

import airplane.Airplane;

public class Helicopter extends Airplane {
    private int cylindersCount;
    private int creationYear;
    private int passengerCapacity;

    public Helicopter(){
        super();
        cylindersCount = 1;
        creationYear = 2022;
        passengerCapacity = 1;
    }

    public Helicopter(Helicopter h){
        super(h);
        this.cylindersCount = h.cylindersCount;
        this.creationYear = h.creationYear;
        this.passengerCapacity = h.passengerCapacity;
    }

    public Helicopter(String brand, double price, int horsepower, int cylindersCount, int creationYear, int passengerCapacity){
        super(brand, price, horsepower);
        this.cylindersCount = cylindersCount;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }
}
