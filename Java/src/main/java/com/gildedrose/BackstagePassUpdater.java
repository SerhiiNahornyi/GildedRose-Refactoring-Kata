package com.gildedrose;

class BackstagePassUpdater implements ItemUpdater {
    private static final int DOUBLE_INCREASE_THRESHOLD = 10;
    private static final int TRIPLE_INCREASE_THRESHOLD = 5;
    private static final int TRIPLE_RATE = 3;
    private static final int DOUBLE_RATE = 2;

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.sellIn < EXPIRED) {
            item.quality = MIN_QUALITY;
        } else if (item.sellIn < TRIPLE_INCREASE_THRESHOLD) {
            item.quality = Math.min(MAX_QUALITY, item.quality + TRIPLE_RATE);
        } else if (item.sellIn < DOUBLE_INCREASE_THRESHOLD) {
            item.quality = Math.min(MAX_QUALITY, item.quality + DOUBLE_RATE);
        } else {
            item.quality = Math.min(MAX_QUALITY, item.quality + NORMAL_RATE);
        }
    }
}
