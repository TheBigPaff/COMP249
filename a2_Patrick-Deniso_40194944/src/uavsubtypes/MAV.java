package uavsubtypes;

import uav.UAV;

public class MAV extends UAV {
    private String model;
    private double size;


    public MAV(){
        super();
        model = "UNKNOWN";
        size = 10; // avg size in centimeters
    }

    public MAV(MAV m){
        super(m);
        this.model = m.model;
        this.size = m.size;
    }

    public MAV(double weight, double price, String model, double size){
        super(weight, price);
        this.model = model;
        this.size = size;
    }
}
