package com.telran.remindly.model;

public class Reminder {
    private String title;
    private String type;
    private int number;
    private String month;
    private int index;
    private String type1;
    private String year;
    private String td;
    private int x;
    private int y;
    private int z;
    private int p;
    private String numberRepeat;
    private String timeRepeat;

    public Reminder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Reminder setType(String type) {
        this.type = type;
        return this;
    }

    public Reminder setNumber(int number) {
        this.number = number;
        return this;
    }

    public Reminder setMonth(String month) {
        this.month = month;
        return this;
    }

    public Reminder setIndex(int index) {
        this.index = index;
        return this;
    }

    public Reminder setType1(String type1) {
        this.type1 = type1;
        return this;
    }

    public Reminder setYear(String year) {
        this.year = year;
        return this;
    }

    public Reminder setTd(String td) {
        this.td = td;
        return this;
    }

    public Reminder setX(int x) {
        this.x = x;
        return this;
    }

    public Reminder setY(int y) {
        this.y = y;
        return this;
    }

    public Reminder setNumberRepeat(String numberRepeat) {
        this.numberRepeat = numberRepeat;
        return this;
    }

    public Reminder setTimeRepeat(String timeRepeat) {
        this.timeRepeat = timeRepeat;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public String getMonth() {
        return month;
    }

    public int getIndex() {
        return index;
    }

    public String getType1() {
        return type1;
    }

    public String getYear() {
        return year;
    }

    public String getTd() {
        return td;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNumberRepeat() {
        return numberRepeat;
    }

    public String getTimeRepeat() {
        return timeRepeat;
    }
}
