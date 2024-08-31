package org.group39fsworkingproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyExtraLogic implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // логика, которая выполняется при запуске приложения

        System.out.println("Приложение запущено");
    }
}
