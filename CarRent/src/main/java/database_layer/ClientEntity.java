package database_layer;

import jakarta.persistence.*;
import models.UpdateRentNumber;

@Entity
@Table(name = "client")
public class ClientEntity implements UpdateRentNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private int numberOfRents;

    public ClientEntity() {
    }

    public ClientEntity(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.numberOfRents = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public String toString() {
//        return "ClientEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }


    public int getNumberOfRents() {
        return numberOfRents;
    }

    public void setNumberOfRents(int numberOfRents) {
        this.numberOfRents = numberOfRents;
    }

    @Override
    public String toString() {
        return
                "Name: '" + name + '\'' +
                ", Phone Number: '" + phoneNumber + '\'' +
                ", Address: '" + address + '\'';
    }


    @Override
    public void updateRentNumber() {
        this.numberOfRents++;
    }
}
