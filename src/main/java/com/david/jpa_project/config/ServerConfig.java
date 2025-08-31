package com.david.jpa_project.config;

import com.david.jpa_project.controller.router.Routes;

import static spark.Spark.*;

public class ServerConfig {

    public static void start() {
        System.out.println("Inicializando base de datos...");
        DatabaseConfig.initialize();

        port(VariablesConfig.PORT);
        Routes.getRoutes();

        awaitInitialization();
        System.out.println("Servidor iniciado en puerto " + VariablesConfig.PORT);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Cerrando conexión a base de datos...");
            DatabaseConfig.close();
        }));
    }

}
