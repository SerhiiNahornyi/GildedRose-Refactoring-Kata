package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasUpdaterTest {

    private final ItemUpdater updater = new SulfurasUpdater();

    private Item update(int sellIn, int quality) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
        updater.update(item);
        return item;
    }

    @Test
    void neverChanges() {
        Item item = update(10, 80);
        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void neverChanges_afterSellDate() {
        Item item = update(-1, 80);
        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);
    }
}
