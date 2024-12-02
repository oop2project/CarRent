    package database_layer;

    import enums.CarCategory;
    import enums.CarClass;
    import enums.ReturnStatus;
    import jakarta.persistence.*;

    @Entity
    @Table(name = "car")
    public class CarEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        public CarEntity(double price, CarCategory carCategory, CarClass carClass, ReturnStatus returnStatus) {
            this.price = price;
            this.carCategory = carCategory;
            this.carClass = carClass;
            this.returnStatus = returnStatus;
        }

        public CarCategory getCarCategory() {
            return carCategory;
        }

        public void setCarCategory(CarCategory carCategory) {
            this.carCategory = carCategory;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public CarClass getCarClass() {
            return carClass;
        }

        public void setCarClass(CarClass carClass) {
            this.carClass = carClass;
        }

        public ReturnStatus getReturnStatus() {
            return returnStatus;
        }

        public void setReturnStatus(ReturnStatus returnStatus) {
            this.returnStatus = returnStatus;
        }

        @Override
        public String toString() {
            return "CarEntity{" +
                    "id=" + id +
                    ", price=" + price +
                    ", carCategory=" + carCategory +
                    ", carClass=" + carClass +
                    ", returnStatus=" + returnStatus +
                    '}';
        }
    }
