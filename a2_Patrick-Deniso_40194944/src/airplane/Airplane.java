package airplane;

import java.util.Objects;

public class Airplane {
    protected String brand;
    protected double price;
    protected int horsepower;

    public Airplane(){
        brand = "UNKNOWN";
        price = 100000000; // avg price of a multi engine airplane
        horsepower = 30000; // avg horsepower
    }

    public Airplane(Airplane p){
        this.brand = p.brand;
        this.price = p.price;
        this.horsepower = p.horsepower;
    }

    public Airplane(String brand, double price, int horsepower){
        this.brand = brand;
        this.price = price;
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
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

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "This airplane is manufactured by " + brand + ". It costs " + price + "$, and has a horsepower of " + horsepower + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Double.compare(airplane.price, price) == 0 && horsepower == airplane.horsepower && Objects.equals(brand, airplane.brand);
    }
}
