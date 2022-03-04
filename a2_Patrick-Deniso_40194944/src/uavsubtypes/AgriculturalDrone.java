package uavsubtypes;

import uav.UAV;

import java.util.Objects;

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

    public String getBrand() {
        return brand;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    @Override
    public String toString() {
        return "This Agricultural Drone is manufactured by " + brand +
                ". It weighs " + weight + " lbs and it costs " + price + '$' +
                ". It has a carry capacity of " + carryCapacity;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AgriculturalDrone that = (AgriculturalDrone) o;
        return carryCapacity == that.carryCapacity && Objects.equals(brand, that.brand);
    }
}
