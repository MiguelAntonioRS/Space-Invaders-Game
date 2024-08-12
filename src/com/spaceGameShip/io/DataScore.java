package com.spaceGameShip.io;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataScore {

    private String date;
    private int score;

    public DataScore(int score) {
        this.score = score;

        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = simpleDateFormat.format(today);
    }

    public DataScore() {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
