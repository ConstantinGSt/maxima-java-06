package org.example;

import org.example.config.SpringConfig;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello Spring");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Logistics logic = context.getBean(Logistics.class);

        System.out.println(logic);

    }
}
