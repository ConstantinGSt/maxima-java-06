package org.example.services;

import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Logistics {
    private Transport[] vehicles;
    private ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private TransportFactory transportFactory;

    public Logistics(TransportFactory transportFactory, Transport... vehicles) {
        this.vehicles = vehicles;
        this.transportFactory = transportFactory;
    }
    @Autowired
    public Logistics() {
    }

    public Transport getShipping(City city, int weight, int hours) {
        Transport min = null; // подмена на getShipping
        for(int i = 0, counter = 0; i < vehicles.length; i++) {
            if(isShippingAvailable(getVehicles(), city, weight, hours, i)) {
                counter++;
                if(counter > 1) {
                    min = vehicles[i].getPrice(city) < min.getPrice(city) ? vehicles[i] : min;
                } else {
                    min = vehicles[i];
                }
            }
        } if(min == null) {
            transportFactory = context.getBean(TransportFactory.class);
            min = transportFactory.getTransport(city, weight, hours);
        } return min;
    }

    private boolean isShippingAvailable(Transport[] vehicle, City city, int weight, int hours, int i) {
        if(vehicles[i].isRepairing()) {
            return false;
        } return (vehicles[i].getPrice(city) > 0 && vehicles[i].getCapacity() >= weight &&
                                         (city.getDistanceKm() / vehicles[i].getSpeed() <= hours || hours == 0));
    }

    public Transport[] getVehicles() {
        return vehicles;
    }
}

