package com.gildedrose;

class ConjuredUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        int degradation = item.sellIn < EXPIRED ? EXPIRED_RATE * 2 : NORMAL_RATE * 2;
        item.quality = Math.max(MIN_QUALITY, item.quality - degradation);
    }
}
