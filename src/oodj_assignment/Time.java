package oodj_assignment;

public enum Time {
    
    $9AM$to$11AM (1),
    $10AM$to$12PM (2),
    $11AM$to$1PM (3),
    $1PM$to$3PM (4),
    $2PM$to$4PM (5),
    $3PM$to$5PM (6),
    $4PM$to$6PM (7),
    $5PM$to$7PM (8),
    $8PM$to$10PM (9);
    
    private final int timeCode;
    
    Time(int timeCode){
        this.timeCode = timeCode;
    }
    
    public int getCode(){
        return this.timeCode;
    }
    
}
