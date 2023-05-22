package shita.model;

import java.util.List;

public class Package {
    private int id;
    private double weightGrammes;
    private User sender;
    private User receiver;
    private List<Event> events;
    private boolean PayOnDelivery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeightGrammes() {
        return weightGrammes;
    }

    public void setWeightGrammes(double weightGrammes) {
        this.weightGrammes = weightGrammes;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public boolean isPayOnDelivery() {
        return PayOnDelivery;
    }

    public void setPayOnDelivery(boolean payOnDelivery) {
        PayOnDelivery = payOnDelivery;
    }
}
