package bpskenya.ke.co.bpsapp.models;

public class Trip {
    public int id;
    public String location;
    public String destination;
    public String type;
    public String status;

    public Trip(int id, String location, String destination, String type, String status) {
        this.id = id;
        this.location = location;
        this.destination = destination;
        this.type = type;
        this.status = status;
    }

    public Trip(String location, String destination, String type) {
        this.location = location;
        this.destination = destination;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
