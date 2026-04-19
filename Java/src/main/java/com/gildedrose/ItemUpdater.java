package com.gildedrose;

interface ItemUpdater {
    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;
    int EXPIRED = 0;
    int NORMAL_RATE = 1;
    int EXPIRED_RATE = 2;

    void update(Item item);
}
