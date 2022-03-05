import airplane.Airplane;
import copters.Helicopter;
import copters.Quadcopter;
import flyingobject.FlyingObject;
import multirotor.Multirotor;
import uav.UAV;
import uavsubtypes.AgriculturalDrone;
import uavsubtypes.MAV;

public class Main {

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
        FlyingObject[] flyingObjects2 = new FlyingObject[15];

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
        for (FlyingObject flyingObject : flyingObjects1) {
            System.out.println(flyingObject);
        }

        flyingObjects2[0] = a1;
        flyingObjects2[1] = a2;
        flyingObjects2[2] = h1;
        flyingObjects2[3] = q1;
        flyingObjects2[4] = q2;
        flyingObjects2[5] = q3;
        flyingObjects2[6] = m1;
        flyingObjects2[7] = m2;
        flyingObjects2[8] = new Helicopter();
        flyingObjects2[9] = new Helicopter("BEST BRAND EVER", 75000.25, 241, 5, 2019, 4);
        flyingObjects2[10] = new Multirotor(m2);
        flyingObjects2[11] = new Multirotor(m1);
        flyingObjects2[12] = new Quadcopter();
        flyingObjects2[13] = new Multirotor();
        flyingObjects2[14] = new Quadcopter("Worst Brand Inc.", 27500, 425, 4, 2006, 7, 175);

        // TEST equals()
        System.out.println();
        System.out.println("equals() method TEST");
        System.out.println("Helicopter 1 equal to Quadcopter 3? " + h1.equals(q3));
        System.out.println("Multirotor 1 equal to Multirotor 2? " + m1.equals(m2));
        System.out.println("Agricultural Drone 1 equal to Agricultural Drone 2? " + ad1.equals(ad2));

        // TEST findLeastAndMostExpensiveUAV implementation
        System.out.println();
        System.out.println("LEAST AND MOST EXPENSIVE UAVS IN ARRAY 1");
        findLeastAndMostExpensiveUAV(flyingObjects1);
        System.out.println();
        System.out.println("LEAST AND MOST EXPENSIVE UAVS IN ARRAY 2");
        findLeastAndMostExpensiveUAV(flyingObjects2);
    }

    public static void findLeastAndMostExpensiveUAV(FlyingObject[] objects){
        int UAVCount = 0;
        UAV leastExpensiveUAV = new UAV();
        UAV mostExpensiveUAV = new UAV();

        for (FlyingObject object : objects) {
            if(object instanceof UAV){
                UAV UAVobj = (UAV) object; // cast object to UAV

                // first UAV found, set it as the most and least expensive
                if(UAVCount == 0){
                    leastExpensiveUAV.setPrice(UAVobj.getPrice());
                    mostExpensiveUAV.setPrice(UAVobj.getPrice());
                }
                // from the second UAV found, check if it's less or more expensive than the previous one.
                else{
                    if(UAVobj.getPrice() < leastExpensiveUAV.getPrice()){
                        leastExpensiveUAV = UAVobj;
                    }
                    if(UAVobj.getPrice() > mostExpensiveUAV.getPrice()){
                        mostExpensiveUAV = UAVobj;
                    }
                }

                UAVCount++;
            }
        }

        if(UAVCount == 0){
            System.out.println("No UAVs were found.");
        }
        else{
            System.out.println("Least expensive UAV is: {" + leastExpensiveUAV + "}");
            System.out.println("Most expensive UAV is: {" + mostExpensiveUAV + "}");
        }
    }
}
