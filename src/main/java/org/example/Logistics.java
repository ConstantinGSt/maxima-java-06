package org.example;

public class Logistics {
    private Transport[] vehicles;

    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
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

//private boolean isShippingAvailable(Transport vehicle, City city, int weight, int hours) {
//    boolean isReachable = vehicle.getPrice(city)>0;
//    boolean isNotOverloaded = vehicle.getCapacity()>=weight;
//    boolean canShipInTime = city.getDistanceKm()/vehicle.getSpeed()<=hours;
//    return isReachable && isNotOverloaded && canShipInTime && !vehicle.isRepairing();
//}
