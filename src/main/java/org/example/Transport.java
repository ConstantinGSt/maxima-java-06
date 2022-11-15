package org.example;

public abstract class Transport implements Repairable {
    private String name;
    private int capacity;
    private int speed;
    private float costOfKm;
    private boolean repairing;

        public Transport(String name, int capacity, int speed, float costOfKm) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.costOfKm = costOfKm;
        this.repairing = false;
    }

    public abstract float getPrice(City city);

    public void startRepair() {
        setFinishRepair(true);
    }

    public void finishRepair() {
        setFinishRepair(false);
    }

    public boolean isRepairing() {
        if(isFinishRepair()) {
            return true;
        } return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getCostOfKm() {
        return costOfKm;
    }

    public void setCostOfKm(double costOfKm) {
        this.costOfKm = (float) costOfKm;
    }

    public boolean isFinishRepair() {
        return repairing;
    }

    public void setFinishRepair(boolean repairing) {
        this.repairing = repairing;
    }
    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", costOfKm=" + costOfKm +
                ", repairing=" + repairing +
                '}';
    }
}
