package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
            String userName = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + userName + "!");
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
