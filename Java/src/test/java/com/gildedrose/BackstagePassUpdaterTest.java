package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassUpdaterTest {

    private final ItemUpdater updater = new BackstagePassUpdater();

    private Item update(int sellIn, int quality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        updater.update(item);
        return item;
    }

    @ParameterizedTest
    @CsvSource({
        "15, 20, 21",
        "11, 20, 21",
    })
    void increasesBy1_moreThan10Days(int sellIn, int quality, int expectedQuality) {
        Item item = update(sellIn, quality);
        assertEquals(expectedQuality, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
        "10, 20, 22",
        "6,  20, 22",
    })
    void increasesBy2_between6And10Days(int sellIn, int quality, int expectedQuality) {
        Item item = update(sellIn, quality);
        assertEquals(expectedQuality, item.quality);
    }

    @ParameterizedTest
    @CsvSource({
        "5, 20, 23",
        "1, 20, 23",
    })
    void increasesBy3_5DaysOrLess(int sellIn, int quality, int expectedQuality) {
        Item item = update(sellIn, quality);
        assertEquals(expectedQuality, item.quality);
    }

    @Test
    void dropsToZero_afterConcert() {
        Item item = update(0, 50);
        assertEquals(0, item.quality);
    }

    @Test
    void qualityNeverExceedsFifty() {
        Item item = update(5, 49);
        assertEquals(50, item.quality);
    }
}
