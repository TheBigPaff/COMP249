package flyingobject;

import java.util.Objects;

/**
 * This is the base class for every FlyingObject. The only common attribute between the objects is the price.
 * <br>FlyingObject is abstract because it only serves as a base class, it cannot be instantiated by itself.
 * getPrice() and setPrice() methods aren't abstract, because they won't differ between classes.
 *
 * <br>All FlyingObject classes (so also all children of this class) have 3 constructors, a default one which fills the attributes with sample data, a copy constructor which copies the attributes from another object and the third constructor takes in all attributes values.
 * <br>The class also sets the two methods toString() and equals() to abstract, since all child classes will have to implement them themselves.
 */
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

    public abstract String toString();
    public abstract boolean equals(Object o);
}