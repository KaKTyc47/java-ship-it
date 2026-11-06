package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> listBox = new ArrayList<>();
    private double maxWeightBox;

    public ParcelBox(double maxWeightBox) {
        this.maxWeightBox = maxWeightBox;
    }

    public void addParcel(T parcel) {
        double currentWeight = 0;
        for (T existing : listBox) {
            currentWeight += existing.weight;
        }
        currentWeight += parcel.weight;
        if (currentWeight > maxWeightBox) {
            System.out.println("Превышен максимальный вес коробки!");
        } else {
            listBox.add(parcel);
        }
    }

    public List<T> getAllParcels() {
        return listBox;
    }

}
