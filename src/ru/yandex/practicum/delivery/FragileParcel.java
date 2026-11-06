package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + this.deliveryAddress);
    }

    @Override
    protected double getBaseCost() {
        return 4.0;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description +
                " изменила местоположение на " + newLocation);
    }
}
