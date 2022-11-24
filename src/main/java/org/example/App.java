package org.example;

import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello Spring");
        City s = new City("null", 75, true);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Logistics logic = context.getBean(Logistics.class);
        logic.getShipping(s, 5,10);

        System.out.println(logic);

    }
}
