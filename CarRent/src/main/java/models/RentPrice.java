package models;

import database_layer.CarEntity;
import enums.CarClass;
import enums.ReturnStatus;

public interface RentPrice {
    double getRentPrice(int days, int kilometers, ReturnStatus returnStatus, CarEntity carEntity);
}
