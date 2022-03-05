package airplane;

import flyingobject.FlyingObject;

import java.util.Objects;

/**
 * The Airplane class extends from FlyingObject and is also itself the parent class for other flying objects, like various helicopters.
 */
public class Airplane extends FlyingObject {
    protected String brand;
    protected int horsepower;

    /**
     * Default constructor fills initializes attributes to sample data.
     */
    public Airplane(){
        super();
        brand = "UNKNOWN";
        price = 100000000; // avg price of a multi engine airplane
        horsepower = 30000; // avg horsepower
    }

    public Airplane(Airplane p){
        super(p);
        this.brand = p.brand;
        this.horsepower = p.horsepower;
    }

    public Airplane(String brand, double price, int horsepower){
        super(price);
        this.brand = brand;
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        String flyingObjectName = this.getClass().getSimpleName();
        return "This " + flyingObjectName + " is manufactured by " + brand + ". It costs " + price + "$, and has a horsepower of " + horsepower + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Double.compare(airplane.price, price) == 0 && horsepower == airplane.horsepower && Objects.equals(brand, airplane.brand);
    }
}
