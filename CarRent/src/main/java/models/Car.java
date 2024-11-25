package models;

import enums.CarCategory;
import enums.CarClass;
import enums.ReturnStatus;

public class Car {
    private double price;
    private CarCategory carCategory;
    private CarClass carClass;
    private ReturnStatus returnStatus;

    public Car(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carCategory=" + carCategory +
                ", carClass=" + carClass +
                ", returnStatus=" + returnStatus +
                '}';
    }
}
