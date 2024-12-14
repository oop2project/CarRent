package database_layer;

import jakarta.persistence.*;

@Entity
@Table(name = "operator")
public class OperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;

    public OperatorEntity() {
    }

    public OperatorEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

//    @Override
//    public String toString() {
//        return "OperatorEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return
                "Name: '" + name + '\'' +
                ", Phone Number: '" + phoneNumber + '\'';
    }
}
