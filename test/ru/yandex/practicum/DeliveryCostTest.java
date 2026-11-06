package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    @Test
    void testStandardCost() {
        StandardParcel parcel = new StandardParcel("test", 2.0, "addr", 1);
        assertEquals(4.0, parcel.calculateDeliveryCost());
    }

    @Test
    void testFragileCost() {
        FragileParcel parcel = new FragileParcel("test", 1.0, "addr", 1);
        assertEquals(4.0, parcel.calculateDeliveryCost());
    }

    @Test
    void testPerishableCost() {
        PerishableParcel parcel = new PerishableParcel("test", 3.0, "addr", 1,
                5);
        assertEquals(9.0, parcel.calculateDeliveryCost());
    }
}
