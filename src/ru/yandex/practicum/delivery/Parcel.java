package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, double weight, String deliveryAddress,
                  int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public abstract void deliver();

    public double calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    protected abstract double getBaseCost();

}
