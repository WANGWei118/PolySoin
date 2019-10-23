package com.polysoin.dummy;

import java.util.Calendar;

public class DummyItem {
    public final int id;
    public final String title;
    public final String details;
    public boolean isTaken;
    public final Calendar date;

    public DummyItem(int id, String title, String details, boolean isTaken, Calendar date) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.isTaken = isTaken;
        this.date = date;
    }

    @Override
    public String toString() {
        return title;
    }
}