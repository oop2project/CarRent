    package database_layer;

    import enums.CarCategory;
    import enums.CarClass;
    import enums.ReturnStatus;
    import jakarta.persistence.*;

    @Entity
    @Table(name = "Car")
    public class CarEntity {

        @Id
        private int id;

        private double price;

        @Enumerated(EnumType.STRING)
        private CarCategory carCategory;

        @Enumerated(EnumType.STRING)
        private CarClass carClass;

        @Enumerated(EnumType.STRING)
        private ReturnStatus returnStatus;


        
        public CarEntity() {
        }

        public CarEntity(double price){
            this.price = price;
        }
    }
