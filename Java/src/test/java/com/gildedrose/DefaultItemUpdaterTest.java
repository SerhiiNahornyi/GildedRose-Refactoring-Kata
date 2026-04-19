package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultItemUpdaterTest {

    private final ItemUpdater updater = new DefaultItemUpdater();

    private Item update(int sellIn, int quality) {
        Item item = new Item("Normal Item", sellIn, quality);
        updater.update(item);
        return item;
    }

    @Test
    void degradesByOne_beforeSellDate() {
        Item item = update(10, 20);
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void degradesByTwo_afterSellDate() {
        Item item = update(0, 20);
        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void qualityNeverNegative() {
        Item item = update(5, 0);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityNeverNegative_afterSellDate() {
        Item item = update(-1, 1);
        assertEquals(0, item.quality);
    }
}
