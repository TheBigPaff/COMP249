// -----------------------------------------------------
// Part: Part 2
// Written by: Patrick Deniso (40194944)
// -----------------------------------------------------


import airplane.Airplane;
import copters.Helicopter;
import copters.Quadcopter;
import flyingobject.FlyingObject;
import multirotor.Multirotor;
import uav.UAV;
import uavsubtypes.AgriculturalDrone;
import uavsubtypes.MAV;

/**
 * <b> ASSIGNMENT 2 - PART 2 - WRITTEN BY PATRICK DENISO (40194944)</b>
 * <br>
 * The main class purpose is to test the functionality of the program, especially the driver class' static method copyFlyingObjects().
 *
 * @see FlyingObject FlyingObject is the base abstract class for all flying objects. <br>
 * @see Airplane Airplane inherits from FlyingObject and is the parent class for all other types of Airplanes <br>
 * @see Helicopter Helicopter inherits from Airplane and is the parent class for all Helicopters <br>
 * @see Quadcopter Quadcopter inherits from Helicopter <br>
 * @see Multirotor Multirotor inherits from Helicopter <br>
 * @see UAV UAV inherits from FlyingObject and is the parent class for all other types of UAVs <br>
 * @see AgriculturalDrone AgriculturalDrone inherits from UAV <br>
 * @see MAV MAV inherits from UAV
 */
public class Main {

    /**
     * The method creates an array of the same length as the passed array, copying all objects from the passed array to a new array, then returns the new array.
     * @param oldArr the array of flying objects to copy
     * @return the newly copied array
     */
    public static FlyingObject[] copyFlyingObjects(FlyingObject[] oldArr){
        FlyingObject[] newArr = new FlyingObject[oldArr.length];
        for (int i = 0; i < oldArr.length; i++) {

        }

        return newArr;
    }

    /**
     * Main method of the driver class that will test all functionalities of the program.
     * @param args
     */
    public static void main(String[] args) {
        Airplane a1 = new Airplane();
        Airplane a2 = new Airplane("NormalAirplanes", 525000000, 55000);
        Helicopter h1 = new Helicopter("GoodHelicopters", 50000.25, 500, 6, 2020, 5);
        Quadcopter q1 = new Quadcopter("GoodHelicopters", 50000.25, 400, 2, 1999, 7, 200);
        Quadcopter q2 = new Quadcopter("Worst Brand Inc.", 25000, 300, 3, 2010, 6, 150);
        Quadcopter q3 = new Quadcopter();
        Multirotor m1 = new Multirotor("GoodHelicopters", 50000.25, 750, 8, 2016, 12, 4);
        Multirotor m2 = new Multirotor("Multirotori S.P.A.", 2000000000, 300, 5, 1987, 4, 3);
        UAV uav1 = new UAV();
        UAV uav2 = new UAV(30.25, 100);
        AgriculturalDrone ad1 = new AgriculturalDrone(45.76, 678.99, "Cipolla", 400);
        AgriculturalDrone ad2 = new AgriculturalDrone(45.76, 678.99, "Cipolla", 400);
        AgriculturalDrone ad3 = new AgriculturalDrone(372.81, 1299.99, "Pomodoro", 250);
        MAV mav1 = new MAV(28.91, 252.99, "WF-1000XM4", 12.50);
        MAV mav2 = new MAV(10.32, 399.99, "XQC-7LLL", 9.61);
        MAV mav3 = new MAV(13.48, 188.6, "nlsxd-1946", 13.42);
        MAV mav4 = new MAV(mav3);

        FlyingObject[] flyingObjects1 = new FlyingObject[17];

        flyingObjects1[0] = a1;
        flyingObjects1[1] = a2;
        flyingObjects1[2] = h1;
        flyingObjects1[3] = q1;
        flyingObjects1[4] = q2;
        flyingObjects1[5] = q3;
        flyingObjects1[6] = m1;
        flyingObjects1[7] = m2;
        flyingObjects1[8] = uav1;
        flyingObjects1[9] = uav2;
        flyingObjects1[10] = ad1;
        flyingObjects1[11] = ad2;
        flyingObjects1[12] = ad3;
        flyingObjects1[13] = mav1;
        flyingObjects1[14] = mav2;
        flyingObjects1[15] = mav3;
        flyingObjects1[16] = mav4;

        // PRINT ALL OBJECTS CREATED SO FAR
        System.out.println("ARRAY BEFORE CALLING copyFlyingObjects()");
        for (FlyingObject flyingObject : flyingObjects1) {
            System.out.println(flyingObject);
        }


        // CALL copyFlyingObjects()
        FlyingObject[] flyingObjects2 = copyFlyingObjects(flyingObjects1);

        System.out.println();
        System.out.println("ARRAY AFTER CALLING copyFlyingObjects()");
        for (FlyingObject flyingObject : flyingObjects2) {
            System.out.println(flyingObject);
        }
    }
}
