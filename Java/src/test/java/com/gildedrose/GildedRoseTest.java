package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item updateItem(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        new GildedRose(Collections.singletonList(item)).updateQuality();
        return item;
    }

    @Test
    void updateQuality_updatesAllItems() {
        List<Item> items = List.of(
            new Item("Normal Item", 10, 20),
            new Item("Aged Brie", 5, 10)
        );
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items.get(0).sellIn);
        assertEquals(4, items.get(1).sellIn);
    }

    @Test
    void unknownItem_usesDefaultUpdater() {
        Item item = updateItem("Unknown Item", 10, 20);
        assertEquals(19, item.quality);
    }

    @Test
    void unknownItem_qualityDoesNotGoBelowZero() {
        Item item = updateItem("Unknown Item", 0, 0);
        assertEquals(0, item.quality);
    }

    @Test
    void agedBrie_usesCorrectUpdater() {
        Item item = updateItem("Aged Brie", 10, 20);
        assertEquals(21, item.quality);
    }

    @Test
    void sulfuras_usesCorrectUpdater() {
        Item item = updateItem("Sulfuras, Hand of Ragnaros", 10, 80);
        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePass_usesCorrectUpdater() {
        Item item = updateItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        assertEquals(23, item.quality);
    }

    @Test
    void backstagePass_matchesByPrefix() {
        Item item = updateItem("Backstage passes to another concert", 5, 20);
        assertEquals(23, item.quality);
    }

    @Test
    void sulfuras_matchesByPrefix() {
        Item item = updateItem("Sulfuras, Legendary Sword", 10, 80);
        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void conjured_usesCorrectUpdater() {
        Item item = updateItem("Conjured Mana Cake", 10, 20);
        assertEquals(18, item.quality);
    }

    @Test
    void conjured_matchesByPrefix() {
        Item item = updateItem("Conjured Dark Staff", 10, 20);
        assertEquals(18, item.quality);
    }
}
