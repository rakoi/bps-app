package bpskenya.ke.co.bpsapp.models;

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
    public Sender sender;
    public Reciever reciever;
    public String encodedId;

    public Parcel() {
    }

    public Parcel(int id, String description, int weight, int quantity, int price, String payment, String paid, String status, String date, Sender sender, Reciever reciever, String encodedId) {
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

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Reciever getReciever() {
        return reciever;
    }

    public void setReciever(Reciever reciever) {
        this.reciever = reciever;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }
}
