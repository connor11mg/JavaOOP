package oodj_assignment;

public class Sport {
    private String id, sport_name;
    private double price;

    public Sport(String id, String sport_name, double price){
        this.id = id;
        this.sport_name = sport_name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
