package bpskenya.ke.co.bpsapp.models;

public class reciever {

    public int id;
    public String fname;
    public String lname;
    public String email;
    public String phone;
    public String address;
    public String town;
    public String businessname;
    public Parcel parcel;


    public reciever(String fname, String lname, String email, String phone, String address, String town, String businessname) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.town = town;
        this.businessname = businessname;
    }

    public reciever(int id, String fname, String lname, String email, String phone, String address, String town, String businessname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.town = town;
        this.businessname = businessname;
    }

    public reciever() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    @Override
    public String toString() {
        return "Firstname "+this.fname+" lastname"+this.lname+" email"+this.email+" phone "+this.phone.toString()+" Adress "+this.address+" town "+this.town+" businessname "+this.businessname;
    }

}

