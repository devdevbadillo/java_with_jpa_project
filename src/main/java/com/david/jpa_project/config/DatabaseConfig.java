package com.david.jpa_project.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConfig {

    private static EntityManagerFactory entityManagerFactory;

    public static void initialize() {
        try {
            // Esto forzará la creación de las tablas
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-unit");
            System.out.println("EntityManagerFactory creado correctamente");

            // Crear un EntityManager para forzar la conexión
            EntityManager em = entityManagerFactory.createEntityManager();
            em.close();
            System.out.println("Conexión a base de datos verificada");

        } catch (Exception e) {
            System.err.println("Error al inicializar JPA: " + e.getMessage());
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