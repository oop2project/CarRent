package com.example.carrent;

import database_layer.CarEntity;
import database_layer.HibernateSetup;
import enums.CarBrand;
import enums.CarCategory;
import enums.CarClass;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarRegisterControllerTest {

    private Session session;

    @BeforeEach
    void setUp() {
        session = HibernateSetup.getSessionFactory().openSession();
    }

    @AfterEach
    void tearDown() {
        if (session.isOpen()) {
            session.close();
        }
    }

    @Test
    void onRegisterButtonClick() {
//        if (operator != null) {
//            session.beginTransaction();
//            session.remove(operator);
//            session.getTransaction().commit();
//        }

        CarEntity carEntity = null;
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();


            carEntity = new CarEntity(4000, CarCategory.SUV, CarClass.CITY, CarBrand.AUDI);

            session.persist(carEntity);

            //client
//            ClientEntity clientEntity = new ClientEntity("Stoyan Stanoev","0882656768", "Varna");
//            session.persist(clientEntity);
            //operator
//            OperatorEntity operatorEntity = new OperatorEntity("Ivan Ivanov","0882347343");
//            session.persist(operatorEntity);


            transaction.commit();

            CarEntity selectedCar = session.get(CarEntity.class, carEntity.getId());
            assertNotNull(selectedCar);
            assertEquals(CarBrand.AUDI, selectedCar.getCarBrand());

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (carEntity != null) {
                session.beginTransaction();
                session.remove(carEntity);
                session.getTransaction().commit();
            }

            session.close();
        }
    }


//    @Test
//    void dataInput(){
//        assertEquals(2, 1 + 1);
//    }
  
}