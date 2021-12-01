package oodj_assignment;

public class RateCoach {
    private String id, feedback, coach_id;
    private int rating;


    public RateCoach(String id, String coach_id, String feedback, int rating){
        this.id = id;
        this.coach_id = coach_id;
        this.feedback = feedback;
        this.rating = rating;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
