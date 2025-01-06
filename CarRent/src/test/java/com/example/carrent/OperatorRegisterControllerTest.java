package com.example.carrent;

import database_layer.ClientEntity;
import database_layer.HibernateSetup;
import database_layer.OperatorEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorRegisterControllerTest {
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

        OperatorEntity operatorEntity = null;
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();


            //clientEntity = new ClientEntity()Entity(4000, CarCategory.SUV, CarClass.CITY, CarBrand.AUDI);
            operatorEntity = new OperatorEntity("Stoyan Stanoev","0882656768");
            session.persist(operatorEntity);

            //client

//            session.persist(clientEntity);
            //operator
//            OperatorEntity operatorEntity = new OperatorEntity("Ivan Ivanov","0882347343");
//            session.persist(operatorEntity);


            transaction.commit();

            OperatorEntity selectedOperator = session.get(OperatorEntity.class, operatorEntity.getId());
            assertNotNull(selectedOperator);
            assertEquals("Stoyan Stanoev", selectedOperator.getName());

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (operatorEntity != null) {
                session.beginTransaction();
                session.remove(operatorEntity);
                session.getTransaction().commit();
            }

            session.close();
        }
    }

}