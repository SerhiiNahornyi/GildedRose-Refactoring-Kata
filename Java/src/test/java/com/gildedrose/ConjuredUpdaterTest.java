package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredUpdaterTest {

    private final ItemUpdater updater = new ConjuredUpdater();

    private Item update(int sellIn, int quality) {
        Item item = new Item("Conjured Mana Cake", sellIn, quality);
        updater.update(item);
        return item;
    }

    @Test
    void degradesTwiceAsFast_beforeSellDate() {
        Item item = update(10, 20);
        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void degradesFourTimes_afterSellDate() {
        Item item = update(0, 20);
        assertEquals(-1, item.sellIn);
        assertEquals(16, item.quality);
    }

    @Test
    void qualityNeverNegative() {
        Item item = update(5, 1);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityNeverNegative_afterSellDate() {
        Item item = update(-1, 3);
        assertEquals(0, item.quality);
    }
}
