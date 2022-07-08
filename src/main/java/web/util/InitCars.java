package web.util;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class InitCars {
    private static List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Peugeot","406", "Black"));
        carList.add(new Car("Mazda","323", "Green"));
        carList.add(new Car("Toyota","E100", "Yellow"));
        carList.add(new Car("Mazda","MX-5", "Red"));
        carList.add(new Car("Reno","Megan", "Pink"));
        carList.add(new Car("Honda","Civic", "Golden"));
        carList.add(new Car("Lada","Vesta", "Black"));
        carList.add(new Car("Hyundai","Solaris", "White"));
        carList.add(new Car("Rover", "r213", "White"));
        carList.add(new Car("Chery", "Tiggo", "Blue"));
    }

    public static List<Car> getCarList(){
        return carList;
    }
}


