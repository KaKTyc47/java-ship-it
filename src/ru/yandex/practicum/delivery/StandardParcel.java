package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + this.deliveryAddress);
    }

    @Override
    protected double getBaseCost() {
        return 2.0;
    }
}
