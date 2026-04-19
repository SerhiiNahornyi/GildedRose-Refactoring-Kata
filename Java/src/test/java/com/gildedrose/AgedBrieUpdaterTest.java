package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieUpdaterTest {

    private final ItemUpdater updater = new AgedBrieUpdater();

    private Item update(int sellIn, int quality) {
        Item item = new Item("Aged Brie", sellIn, quality);
        updater.update(item);
        return item;
    }

    @Test
    void increasesInQuality() {
        Item item = update(10, 20);
        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void increasesTwiceAsFast_afterSellDate() {
        Item item = update(0, 20);
        assertEquals(-1, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = update(5, 50);
        assertEquals(50, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty_afterSellDate() {
        Item item = update(0, 49);
        assertEquals(50, item.quality);
    }
}
