package com.gildedrose;

class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        int degradation = item.sellIn < EXPIRED ? EXPIRED_RATE : NORMAL_RATE;
        item.quality = Math.max(MIN_QUALITY, item.quality - degradation);
    }
}
