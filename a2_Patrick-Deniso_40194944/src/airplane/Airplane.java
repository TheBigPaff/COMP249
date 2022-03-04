package airplane;

public class Airplane {
    private String brand;
    private double price;
    private int horsepower;

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


}
