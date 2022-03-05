package copters;

import airplane.Airplane;

import java.util.Objects;

public class Helicopter extends Airplane {
    protected int cylindersCount;
    protected int creationYear;
    protected int passengerCapacity;

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

    public int getCylindersCount() {
        return cylindersCount;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setCylindersCount(int cylindersCount) {
        this.cylindersCount = cylindersCount;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public String toString() {
        return super.toString() + " It also has " + cylindersCount + " cilinders, a passenger capacity of " + passengerCapacity +
                ", and was created in the year " + creationYear;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Helicopter that = (Helicopter) o;
        return cylindersCount == that.cylindersCount && creationYear == that.creationYear && passengerCapacity == that.passengerCapacity;
    }
}
