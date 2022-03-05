package uavsubtypes;

import uav.UAV;

import java.util.Objects;

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

    public String getModel() {
        return model;
    }

    public double getSize() {
        return size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ". It's of the model " + model + " and its size is " + size + "cm.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MAV mav = (MAV) o;
        return Double.compare(mav.size, size) == 0 && Objects.equals(model, mav.model);
    }
}
