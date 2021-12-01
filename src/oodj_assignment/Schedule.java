package oodj_assignment;

import java.util.ArrayList;

public class Schedule {
    private String id, centre_name, coach;
    private ArrayList<Sport> sport= new ArrayList<Sport>();
    Time time;
    Day day;


    public Schedule(String id, String location, String coach, Day day, Time time, ArrayList sport){
        this.id = id;
        this.centre_name = location;
        this.coach = coach;
        this.time = time;
        this.sport = sport;
        this.day = day;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCentre_name() {
        return centre_name;
    }

    public void setCentre_name(String centre_name) {
        this.centre_name = centre_name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public ArrayList<Sport> getSport() {
        return sport;
    }

    public void setSport(ArrayList<Sport> sport) {
        this.sport = sport;
    }
}
