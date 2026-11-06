package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + this.deliveryAddress);
    }

    @Override
    protected double getBaseCost() {
        return 3.0;
    }

    public boolean isExpired(int currentDay) {
        int sumDay = sendDay + timeToLive;
        if (currentDay <= sumDay) {
            return false;
        }
        return true;
    }
}
