package org.example.services;

import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransportFactory {

    public TransportFactory() {}

    public Transport getTransport(City city, int weight, int hours) {
        final String planeName = "Airbase";
        final float planeCoast = 850;
        final String shipName = "Black Sail";
        final float shipCoast = 350;
        final String truckName = "Universal truck";
        final float truckCoast = 50;
        int speed = city.getDistanceKm() / hours;
        if((speed <= 40) && city.isOnWater()) {
            return  new Ship(shipName, roundedCapacity(weight), roundedSpeed(city, hours), shipCoast);
        } else if((speed >= 120) && city.hasAirport()) {
            return new Plane(planeName, roundedCapacity(weight), roundedSpeed(city, hours), planeCoast);
        }
        return new Truck(truckName, roundedCapacity(weight), roundedSpeed(city, hours), truckCoast);
    }

    private static int roundedSpeed(City city, int hours) {
        if((city.getDistanceKm() / hours) % 10 == 0) {
            return (city.getDistanceKm() / hours);
        }
        return ((city.getDistanceKm() / hours) / 10 * 10) + 10;
    }

    private static int roundedCapacity(int weight) {
        if(weight % 500 == 0) {
            return weight;
        }
        return ((weight) / 500 * 500) + 500;
    }
}
