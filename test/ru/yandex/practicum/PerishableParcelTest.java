package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableParcelTest {
    @Test
    void notExpired() {
        PerishableParcel p = new PerishableParcel("desc", 1.0, "addr", 5,
                3);
        assertFalse(p.isExpired(6));
    }

    @Test
    void expired() {
        PerishableParcel p = new PerishableParcel("desc", 1.0, "addr", 5,
                3);
        assertTrue(p.isExpired(10));
    }

    @Test
    void boundaryDay() {
        PerishableParcel p = new PerishableParcel("desc", 1.0, "addr", 5,
                3);
        assertFalse(p.isExpired(8));
    }
}
