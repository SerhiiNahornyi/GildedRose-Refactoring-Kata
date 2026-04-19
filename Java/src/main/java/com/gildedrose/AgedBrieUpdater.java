package com.gildedrose;

class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        int improvement = item.sellIn < EXPIRED ? EXPIRED_RATE : NORMAL_RATE;
        item.quality = Math.min(MAX_QUALITY, item.quality + improvement);
    }
}
