package com.polysoin.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugHistoryDummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMSHISTORY = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAPHISTORY = new HashMap<String, DummyItem>();

    public static void addItem(DummyItem item) {
        ITEMSHISTORY.add(item);
        ITEM_MAPHISTORY.put(String.valueOf(item.id), item);
    }

    public static DummyItem createDummyItem(int position, String title, String details, Date date) {
        return new DummyItem(position, title, details, false, date);
    }
}
