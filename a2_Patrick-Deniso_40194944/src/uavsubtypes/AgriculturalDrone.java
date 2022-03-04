package uavsubtypes;

import uav.UAV;

public class AgriculturalDrone extends UAV {
    private String brand;
    private int carryCapacity;

    public AgriculturalDrone(){
        super();
        brand = "UNKNOWN";
        carryCapacity = 2;
    }

    public AgriculturalDrone(AgriculturalDrone ad){
        super(ad);
        this.brand = ad.brand;
        this.carryCapacity = ad.carryCapacity;
    }

    public AgriculturalDrone(double weight, double price, String brand, int carryCapacity){
        super(weight, price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }
}
