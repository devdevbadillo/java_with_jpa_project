package com.david.jpa_project.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConfig {

    private static EntityManagerFactory entityManagerFactory;

    public static void initialize() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-unit");

            EntityManager em = entityManagerFactory.createEntityManager();
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            initialize();
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}