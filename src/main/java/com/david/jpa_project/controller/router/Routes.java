package com.david.jpa_project.controller.router;
import static spark.Spark.*;

public class Routes {

    public static void getRoutes() {
        get("/", (request, response) -> "Hello World");
    }

}