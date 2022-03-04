package uav;

public class UAV {
    private double weight;
    private double price;

    public UAV(){
        weight = 150; // avg weight in lbs for an enterprise drone
        price = 1000; // average price
    }

    public UAV(UAV u){
        this.weight = u.weight;
        this.price = u.price;
    }

    public UAV(double weight, double price){
        this.weight = weight;
        this.price = price;
    }
}
