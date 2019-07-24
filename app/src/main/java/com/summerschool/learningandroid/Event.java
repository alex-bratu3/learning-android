package com.summerschool.learningandroid;

public class Event {

    String title;
    String type;
    int contPeople;

    public Event(
            String title,
            String type,
            int contPeople
    ) {
        this.title = title;
        this.type = type;
        this.contPeople = contPeople;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getContPeople() {
        return contPeople;
    }

    public void setContPeople(int contPeople) {
        this.contPeople = contPeople;
    }



}
