package bpskenya.ke.co.bpsapp.models;
import bpskenya.ke.co.bpsapp.models.reciever;
import bpskenya.ke.co.bpsapp.models.sender;

public class Parcel {

    public int id;
    public String description;
    public int weight;
    public int quantity;
    public int price;
    public String payment;
    public String paid;
    public String status;
    public String date;
    public sender sender;
    public  reciever reciever;
    public String encodedId;

    public Parcel() {
    }

    public Parcel(int id, String description, int weight, int quantity, int price, String payment, String paid, String status, String date, bpskenya.ke.co.bpsapp.models.sender sender, bpskenya.ke.co.bpsapp.models.reciever reciever, String encodedId) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.quantity = quantity;
        this.price = price;
        this.payment = payment;
        this.paid = paid;
        this.status = status;
        this.date = date;
        this.sender = sender;
        this.reciever = reciever;
        this.encodedId = encodedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public bpskenya.ke.co.bpsapp.models.sender getSender() {
        return sender;
    }

    public void setSender(bpskenya.ke.co.bpsapp.models.sender sender) {
        this.sender = sender;
    }

    public bpskenya.ke.co.bpsapp.models.reciever getReciever() {
        return reciever;
    }

    public void setReciever(bpskenya.ke.co.bpsapp.models.reciever reciever) {
        this.reciever = reciever;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }
}
