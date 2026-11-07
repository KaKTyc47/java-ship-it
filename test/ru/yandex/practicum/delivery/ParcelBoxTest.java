package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {

    @Test
    void shouldAddParcelIfWeightIsOk() {
        ParcelBox<StandardParcel> box = new ParcelBox(10.0);
        StandardParcel parcel = new StandardParcel("test", 5.0, "addr", 1);

        box.addParcel(parcel);

        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void shouldNotAddParcelIfWeightExceeded() {
        ParcelBox<StandardParcel> box = new ParcelBox(10.0);
        StandardParcel parcel1 = new StandardParcel("p1", 8.0, "addr", 1);
        StandardParcel parcel2 = new StandardParcel("p2", 5.0, "addr", 1);

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        assertEquals(1, box.getAllParcels().size());
    }
}
