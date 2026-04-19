package com.gildedrose;

import java.util.List;
import java.util.Map;

class GildedRose {
    List<Item> items;

    private static final ItemUpdater DEFAULT_UPDATER = new DefaultItemUpdater();
    private static final Map<String, ItemUpdater> UPDATERS = Map.of(
        "Aged Brie", new AgedBrieUpdater(),
        "Sulfuras", new SulfurasUpdater(),
        "Backstage passes", new BackstagePassUpdater()
    );

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            findUpdater(item.name).update(item);
        }
    }

    private static ItemUpdater findUpdater(String name) {
        for (Map.Entry<String, ItemUpdater> entry : UPDATERS.entrySet()) {
            if (name.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return DEFAULT_UPDATER;
    }
}
