package bpskenya.ke.co.bpsapp.models;

public class Parcels {
    public int id;
    public String to;
    public String from;
    public String sender;
    public String reciever;
    public String description;
    public int weight;


    public Parcels(int id, String to, String from, String sender, String reciever, String description, int weight) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.sender = sender;
        this.reciever = reciever;
        this.description = description;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
