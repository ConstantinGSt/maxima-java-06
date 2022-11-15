package org.example;

public class Plane extends Transport {

	public Plane(String name, int capacity, int speed, float costOfKm) {
		super(name, capacity, speed, costOfKm);
	}

	public float getPrice(City city) {
		if(city.hasAirport() == true) {
			return (float) (city.getDistanceKm() * getCostOfKm());
		} else return 0;
	}
}
