    package database_layer;

    import enums.*;
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
        private RentStatus rentStatus;

        @Enumerated(EnumType.STRING)
        private ReturnStatus returnStatus;

        @Enumerated(EnumType.STRING)
        private CarBrand carBrand;



        public CarEntity() {
        }

        public CarEntity(double price){
            this.price = price;
        }

        public CarEntity(double price, CarCategory carCategory, CarClass carClass, CarBrand carBrand) {
            this.price = price;
            this.carBrand = carBrand;
            this.carCategory = carCategory;
            this.carClass = carClass;
            this.rentStatus = RentStatus.NOT_RENTED;
            this.returnStatus = ReturnStatus.NO_PROBLEM;
        }

        //        public CarEntity(double price, CarCategory carCategory, CarClass carClass, RentStatus rentStatus) {
//            this.price = price;
//            this.carCategory = carCategory;
//            this.carClass = carClass;
//            this.rentStatus = rentStatus;
//        }

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

        public RentStatus getRentStatus() {
            return rentStatus;
        }

        public void setRentStatus(RentStatus rentStatus) {
            this.rentStatus = rentStatus;
        }

        public ReturnStatus getReturnStatus() {
            return returnStatus;
        }

        public void setReturnStatus(ReturnStatus returnStatus) {
            this.returnStatus = returnStatus;
        }

        public CarBrand getCarBrand() {
            return carBrand;
        }

        public void setCarBrand(CarBrand carBrand) {
            this.carBrand = carBrand;
        }

        //        @Override
//        public String toString() {
//            return "CarEntity{" +
//                    "id=" + id +
//                    ", price=" + price +
//                    ", carCategory=" + carCategory +
//                    ", carClass=" + carClass +
//                    ", rentStatus=" + rentStatus +
//                    '}';
//        }


//        @Override
//        public String toString() {
//            return "CarEntity{" +
//                    "id=" + id +
//                    ", price=" + price +
//                    ", carCategory=" + carCategory +
//                    ", carClass=" + carClass +
//                    ", rentStatus=" + rentStatus +
//                    ", returnStatus=" + returnStatus +
//                    '}';
//        }

        @Override
        public String toString() {
            return
                    "Brand: " + carBrand +
                    ", Price per day: " + price +
                    ", Category: " + carCategory +
                    ", Class: " + carClass;
        }
    }
