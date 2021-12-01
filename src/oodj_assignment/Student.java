package oodj_assignment;

public class Student extends Account {

    private String occupation;
    private String blood_type;
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;

    public Student(String name, String dob, String password, String occupation, String gender, String email, String ic, String phone_number, String id, String Theme, String blood_type, String question1, String answer1, String question2, String answer2) {
        super(name, dob, password, gender, email, ic, phone_number, id, Theme);

        this.occupation = occupation;
        this.blood_type = blood_type;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
