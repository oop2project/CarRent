package database_layer;

import jakarta.persistence.*;

@Entity
@Table(name = "rented_cars")
public class RentedCarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = false)
    private OperatorEntity operator;


    public RentedCarsEntity() {
    }

    public RentedCarsEntity(CarEntity car, ClientEntity client, OperatorEntity operator) {
        this.car = car;
        this.client = client;
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public OperatorEntity getOperator() {
        return operator;
    }

    public void setOperator(OperatorEntity operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "RentedCarsEntity{" +
                "id=" + id +
                ", car=" + car +
                ", client=" + client +
                ", operator=" + operator +
                '}';
    }
}
