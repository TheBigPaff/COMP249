package multirotor;

import copters.Helicopter;

public class Multirotor extends Helicopter {
    private int rotorsCount;

    public Multirotor(){
        super();
        rotorsCount = 3; // multirotors have more than 2 rotors
    }

    public Multirotor(Multirotor m){
        super(m);
        this.rotorsCount = m.rotorsCount;
    }

    public Multirotor(String brand, double price, int horsepower, int cylindersCount, int creationYear, int passengerCapacity, int rotorsCount){
        super(brand, price, horsepower, cylindersCount, creationYear, passengerCapacity);
        this.rotorsCount = rotorsCount;
    }
}
