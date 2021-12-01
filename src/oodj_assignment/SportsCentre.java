package oodj_assignment;

import java.util.ArrayList;

public class SportsCentre {
    private String center_id, center_name, center_location;
    private ArrayList sport= new ArrayList<Sport>();

    public SportsCentre(String center_id, String center_name, String center_location, ArrayList Sport){
        this.sport = Sport;
        this.center_id = center_id;
        this.center_name = center_name;
        this.center_location = center_location;
    }

    public String getCenter_id() {
        return center_id;
    }

    public void setCenter_id(String center_id) {
        this.center_id = center_id;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }

    public String getCenter_location() {
        return center_location;
    }

    public void setCenter_location(String center_location) {
        this.center_location = center_location;
    }

    public ArrayList<Sport> getSport() {
        return sport;
    }

    public void setSport(ArrayList<Sport> sport) {
        this.sport = sport;
    }
}
