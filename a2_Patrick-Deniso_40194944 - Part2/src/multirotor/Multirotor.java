package multirotor;

import copters.Helicopter;

import java.util.Objects;

/**
 * The multirotor is a type of helicopter.
 */
public class Multirotor extends Helicopter {
    private int rotorsCount;

    /**
     * Default constructor fills initializes attributes to sample data.
     */
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

    public int getRotorsCount() {
        return rotorsCount;
    }

    public void setRotorsCount(int rotorsCount) {
        this.rotorsCount = rotorsCount;
    }

    @Override
    public String toString() {
        return super.toString() + ". It has " + rotorsCount + " rotors.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Multirotor that = (Multirotor) o;
        return rotorsCount == that.rotorsCount;
    }
}
