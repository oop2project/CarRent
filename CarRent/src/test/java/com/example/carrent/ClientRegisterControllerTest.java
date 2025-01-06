package com.example.carrent;

import database_layer.CarEntity;
import database_layer.ClientEntity;
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

class ClientRegisterControllerTest {

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

        ClientEntity clientEntity = null;
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();


            //clientEntity = new ClientEntity()Entity(4000, CarCategory.SUV, CarClass.CITY, CarBrand.AUDI);
            clientEntity = new ClientEntity("Stoyan Stanoev","0882656768", "Varna");
            session.persist(clientEntity);

            //client

//            session.persist(clientEntity);
            //operator
//            OperatorEntity operatorEntity = new OperatorEntity("Ivan Ivanov","0882347343");
//            session.persist(operatorEntity);


            transaction.commit();

            ClientEntity selectedClient = session.get(ClientEntity.class, clientEntity.getId());
            assertNotNull(selectedClient);
            assertEquals("Stoyan Stoev", selectedClient.getName());

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (clientEntity != null) {
                session.beginTransaction();
                session.remove(clientEntity);
                session.getTransaction().commit();
            }

            session.close();
        }
    }
}