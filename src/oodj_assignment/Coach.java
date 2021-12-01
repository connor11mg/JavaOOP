package oodj_assignment;

public class Coach extends Account {
    
    private String date_joined, date_terminated, Sports_Center, sport, feedback, address;
    private float hourly_rate;
    private double rating;

    public Coach(String name, String DOB, String password, String gender, String email, String IC, String phone_number, String ID, String Theme, String date_joined, String date_terminated, String sports_Center, String sport, String feedback, String address, float hourly_rate, double rating) {
        super(name, DOB, password, gender, email, IC, phone_number, ID, Theme);
        this.address = address;
        this.date_joined = date_joined;
        this.date_terminated = date_terminated;
        this.Sports_Center = sports_Center;
        this.sport = sport;
        this.feedback = feedback;
        this.hourly_rate = hourly_rate;
        this.rating = rating;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public String getDate_terminated() {
        return date_terminated;
    }

    public void setDate_terminated(String date_terminated) {
        this.date_terminated = date_terminated;
    }

    public String getSports_Center() {
        return Sports_Center;
    }

    public void setSports_Center(String sports_Center) {
        Sports_Center = sports_Center;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public float getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(float hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}