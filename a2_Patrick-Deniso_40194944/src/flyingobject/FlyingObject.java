package flyingobject;

public abstract class FlyingObject {
    protected double price;

    public FlyingObject(){ }
    public FlyingObject(FlyingObject flyingObject){
        this.price = flyingObject.price;
    }
    public FlyingObject(double price){
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
