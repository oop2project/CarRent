package models;

import enums.CarCategory;
import enums.CarClass;
import enums.RentStatus;

public class Car {
    private double price;
    private CarCategory carCategory;
    private CarClass carClass;
    private RentStatus rentStatus;

    public Car(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carCategory=" + carCategory +
                ", carClass=" + carClass +
                ", returnStatus=" + rentStatus +
                '}';
    }
}
