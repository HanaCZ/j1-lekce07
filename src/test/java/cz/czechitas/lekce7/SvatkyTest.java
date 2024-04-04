package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Nataša"));
        assertFalse(svatky.jeVSeznamu("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        Set<String> seznamJmen = svatky.getSeznamJmen();
        assertEquals(37, seznamJmen.size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Ema", 8, 4);
        assertTrue(svatky.jeVSeznamu("Ema"));
        assertEquals(MonthDay.of(4, 8), svatky.vratKdyMaSvatek("Ema"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Ema", 8, Month.APRIL);
        assertTrue(svatky.jeVSeznamu("Ema"));
        assertEquals(MonthDay.of(Month.APRIL, 8), svatky.vratKdyMaSvatek("Ema"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Ema", (MonthDay.of(4, 8)));
        assertTrue(svatky.jeVSeznamu("Ema"));
        assertEquals(MonthDay.of(Month.of(4), 8), svatky.vratKdyMaSvatek("Ema"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        Svatky svatky = new Svatky();
        String jmenoKeSmazani = "Nataša";
        assertTrue(svatky.jeVSeznamu(jmenoKeSmazani));
        svatky.smazSvatek(jmenoKeSmazani);
        boolean jeJmenoSmazane = svatky.jeVSeznamu(jmenoKeSmazani);
        Set<String> seznamJmen = svatky.getSeznamJmen();
        assertEquals(36, seznamJmen.size());
        assertFalse(jeJmenoSmazane);
    }
}
