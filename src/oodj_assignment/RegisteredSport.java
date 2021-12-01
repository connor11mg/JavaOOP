package oodj_assignment;

import java.util.ArrayList;

public class RegisteredSport {
    private String id;
    private ArrayList<Student> student= new ArrayList<Student>();
    private ArrayList<Schedule> schedule= new ArrayList<Schedule>();

    public RegisteredSport(String id, ArrayList student, ArrayList schedule){
        this.id=id;
        this.student=student;
        this.schedule=schedule;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }
}
