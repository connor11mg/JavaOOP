package oodj_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class OODJ_Assignment {
    
    //public static String login_user = "testing";
    public static ArrayList<Student> allStudent = new ArrayList<Student>();
    public static ArrayList<Admin> allAdmin = new ArrayList<Admin>();
    public static ArrayList<Coach> allCoach = new ArrayList<Coach>();
    public static ArrayList<Sport> allSport = new ArrayList<Sport>();
    public static ArrayList<SportsCentre> allSportsCentre = new ArrayList<SportsCentre>();
    public static ArrayList<Schedule> allSchedule = new ArrayList<Schedule>();
    public static ArrayList<RegisteredSport> allRegisteredSport = new ArrayList<>();
    public static ArrayList<RateCoach> allRateCoach = new ArrayList<RateCoach>();
    public static Account acc_login = null;
    
    public static Home_Page homePage = new Home_Page();
    public static Login_Page loginPage = new Login_Page();
    public static Forget_Password forgetPassword = new Forget_Password();
    public static Register_Page registerPage = new Register_Page();
    public static Student_Page studentPage = new Student_Page();
    public static Modify_Student_Information modifyStudentInfo = new Modify_Student_Information();
    public static Student_View_Schedule studentViewSchedule = new Student_View_Schedule();
    public static Rate_Coach rateCoach = new Rate_Coach();
    public static Sports_Available sportsAvailable = new Sports_Available();
    public static Admin_Page adminPage = new Admin_Page();
    public static Modify_Admin_Information modifyAdminInfo = new Modify_Admin_Information();
    public static Admin_Manage_Coaches adminManageCoaches = new Admin_Manage_Coaches();
    public static Admin_Manage_Sports adminManageSports = new Admin_Manage_Sports();
    public static Admin_Manage_Schedule adminManageSchedule = new Admin_Manage_Schedule();
    public static Admin_Manage_Students adminManageStudents = new Admin_Manage_Students();
    public static Admin_Manage_Centre adminManageCentre = new Admin_Manage_Centre();
    public static Admin_Manage_Admin adminManageAdmin = new Admin_Manage_Admin();
    public static Coach_Page coachPage = new Coach_Page();
    public static Modify_Coach_Information modifyCoachInformation = new Modify_Coach_Information();
    public static View_Registered_Students viewRegisteredStudents = new View_Registered_Students();
    
    public static void main(String[] args) {
        
        //read all students from the student text file
        try {
            Scanner student_scan = new Scanner(new File("student.txt"));
            while (student_scan.hasNext()) {
                String id = student_scan.nextLine();
                String name = student_scan.nextLine();
                String dob = student_scan.nextLine();
                String occupation = student_scan.nextLine();
                String gender = student_scan.nextLine();
                String email = student_scan.nextLine();
                String ic = student_scan.nextLine();
                String phone_number = student_scan.nextLine();
                String blood_type = student_scan.nextLine();
                String password = student_scan.nextLine();
                String question1 = student_scan.nextLine();
                String answer1 = student_scan.nextLine();
                String question2 = student_scan.nextLine();
                String answer2 = student_scan.nextLine();
                String theme = student_scan.nextLine();
                student_scan.nextLine();
                Student std = new Student(name, dob, password, occupation, gender, email, ic, phone_number, id, theme, blood_type, question1, answer1, question2, answer2);
                allStudent.add(std);
            }
            student_scan.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all admins from the admin text file
        try{
            Scanner admin_scan = new Scanner(new File("admin.txt"));
            while (admin_scan.hasNext()){
                String id = admin_scan.nextLine();
                String name = admin_scan.nextLine();
                String dob = admin_scan.nextLine();
                String gender = admin_scan.nextLine();
                String email = admin_scan.nextLine();
                String ic = admin_scan.nextLine();
                String phone_number = admin_scan.nextLine();
                String password = admin_scan.nextLine();
                String theme = admin_scan.nextLine();
                admin_scan.nextLine();

                Admin admin = new Admin(name, dob, password, gender, email, ic, phone_number, id, theme);
                allAdmin.add(admin);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }

        //read all coaches from the coach text file
        try{
            Scanner coach_scan= new Scanner(new File("coach.txt"));
            while (coach_scan.hasNext()){
                String id = coach_scan.nextLine();
                String name = coach_scan.nextLine();
                String dob = coach_scan.nextLine();
                String gender = coach_scan.nextLine();
                String email = coach_scan.nextLine();
                String ic = coach_scan.nextLine();
                String phone_number = coach_scan.nextLine();
                String password = coach_scan.nextLine();
                String address = coach_scan.nextLine();
                String date_joined = coach_scan.nextLine();
                String date_terminated = coach_scan.nextLine();
                String sports_center = coach_scan.nextLine();
                String sport = coach_scan.nextLine();
                String feedback = coach_scan.nextLine();
                float hourly_rate = Float.parseFloat(coach_scan.nextLine());
                double rating = Double.parseDouble(coach_scan.nextLine());
                String theme = coach_scan.nextLine();
                coach_scan.nextLine();

                Coach coach = new Coach(name, dob, password, gender, email, ic, phone_number, id, theme, date_joined, date_terminated, sports_center, sport, feedback, address, hourly_rate, rating);
                allCoach.add(coach);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all sports from the sport text file
        try {
            Scanner sport_scan = new Scanner(new File("sport.txt"));
            while (sport_scan.hasNext()){
                String id = sport_scan.nextLine();
                String sport_name = sport_scan.nextLine();
                Double price = Double.parseDouble(sport_scan.nextLine());
                sport_scan.nextLine();

                Sport sport = new Sport(id, sport_name, price);
                allSport.add(sport);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all centres from the centre text file
        try {
            Scanner sportsCentre_scan = new Scanner(new File("sports_centre.txt"));
            while (sportsCentre_scan.hasNext()){
                String id = sportsCentre_scan.nextLine();
                String name = sportsCentre_scan.nextLine();
                String location = sportsCentre_scan.nextLine();
                String sports = sportsCentre_scan.nextLine();
                sportsCentre_scan.nextLine();

                ArrayList<Sport> sport = new ArrayList<Sport>();
                List<String> sportList = Arrays.asList(sports.split(">>"));
                for (int a=0; a<sportList.size(); a++) {                            //adding sports class arraylist into sports list, which will be added into sports centre arraylist.
                    for (int i = 0; i < OODJ_Assignment.allSport.size(); i++) {
                        if (sportList.get(a).equals(OODJ_Assignment.allSport.get(i).getSport_name())){
                            sport.add(OODJ_Assignment.allSport.get(i));
                        }
                    }
                }
                SportsCentre sports_centre = new SportsCentre(id, name, location,sport);
                allSportsCentre.add(sports_centre);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all schedules from the schedule text file
        try {
            Scanner schedule_scan = new Scanner(new File("schedule.txt"));
            while (schedule_scan.hasNext()){
                String id = schedule_scan.nextLine();
                String sports = schedule_scan.nextLine();
                String centre_name = schedule_scan.nextLine();
                String day = schedule_scan.nextLine();
                String time = schedule_scan.nextLine();
                String coach = schedule_scan.nextLine();
                schedule_scan.nextLine();

                ArrayList<Sport> sport = new ArrayList<Sport>();
                List<String> sportList = Arrays.asList(sports.split(">>"));
                for (int a=0; a<sportList.size(); a++) {                            //adding sports class arraylist into sports list, which will be added into schedule sport arraylist.
                    for (int i = 0; i < OODJ_Assignment.allSport.size(); i++) {
                        if (sportList.get(a).equals(OODJ_Assignment.allSport.get(i).getSport_name())){
                            sport.add(OODJ_Assignment.allSport.get(i));
                        }
                    }
                }

                Schedule sd = new Schedule(id, centre_name, coach, Day.valueOf(day), Time.valueOf(time), sport);
                allSchedule.add(sd);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all registered sports from the registered sport text file
        try {
            Scanner registered_sport_scan = new Scanner(new File("registered_sport.txt"));
            while (registered_sport_scan.hasNext()){
                String id = registered_sport_scan.nextLine();
                String student_email = registered_sport_scan.nextLine();
                String schedule_id = registered_sport_scan.nextLine();
                registered_sport_scan.nextLine();

                ArrayList<Student> student = new ArrayList<Student>();
                List<String> studentList = Arrays.asList(student_email.split(">>"));
                for (int a=0; a<studentList.size();a++) {
                    for (int i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
                        if (studentList.get(a).equals(OODJ_Assignment.allStudent.get(i).getEmail())){
                            student.add(OODJ_Assignment.allStudent.get(i));
                        }
                    }
                }

                ArrayList<Schedule> schedule = new ArrayList<Schedule>();
                for (int i=0; i<OODJ_Assignment.allSchedule.size();i++){
                    if (OODJ_Assignment.allSchedule.get(i).getId().equals(schedule_id)){
                        schedule.add(OODJ_Assignment.allSchedule.get(i));
                    }
                }

                RegisteredSport rs = new RegisteredSport(id, student, schedule);
                allRegisteredSport.add(rs);

            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        //read all coach ratings from the rate coach text file
        try {
            Scanner rate_coach_scan = new Scanner(new File("rate_coach.txt"));
            while (rate_coach_scan.hasNext()){
                String id = rate_coach_scan.nextLine();
                String coach_id = rate_coach_scan.nextLine();
                String feedback = rate_coach_scan.nextLine();
                String rating = rate_coach_scan.nextLine();
                rate_coach_scan.nextLine();

                RateCoach rc = new RateCoach(id, coach_id, feedback, Integer.parseInt(rating));
                allRateCoach.add(rc);

            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        
        for (int i=0; i<OODJ_Assignment.allCoach.size();i++) {
            for (int a = 0; a < OODJ_Assignment.allRateCoach.size(); a++) {
                if (OODJ_Assignment.allCoach.get(i).getID().equals(OODJ_Assignment.allRateCoach.get(a).getCoach_id())) {
                    coach_rating(OODJ_Assignment.allCoach.get(i).getID());
                }
            }
        }
    }
    
    //method to check whether the date selected is valid
    public static boolean checkDOB(int date, int month, int year){
        boolean flag = true;
        if (month ==2){
            if(year%4!=0){
                if(date == 29||date ==30|| date==31){
                    flag= false;

                }
            }else{
                if (date==30||date==31){
                    flag = false;
                }
            }
        } else if (month==4|| month==6|| month==9|| month==11) {
            if (date==31){
                flag=false;
            }
        }
        return flag;
    }
    
    //method to calculate the average ratings of a coach
    public static void coach_rating(String coach_id){
        double count=0;
        double total_rating=0;
        for (int i=0; i<OODJ_Assignment.allRateCoach.size(); i++){
            if (OODJ_Assignment.allRateCoach.get(i).getCoach_id().equals(coach_id)){
                total_rating=total_rating+OODJ_Assignment.allRateCoach.get(i).getRating();
                count=count+1;
            }

        }

        for (int i=0; i<OODJ_Assignment.allCoach.size();i++){
            if (OODJ_Assignment.allCoach.get(i).getID().equals(coach_id)){
                String rating = String.format("%.2f", total_rating/count);
                //String rating = String.valueOf(total_rating/count).substring(0,4);
                OODJ_Assignment.allCoach.get(i).setRating(Double.parseDouble(rating));
                
            }
        }
    }
    
    //method to check whether the phone number entered is valid
    public static boolean checkPhoneNumber(String phoneNumber){
        char[] c = phoneNumber.toCharArray();
        if (c.length>=8) {
            if (c[3] == '-') {
                phoneNumber= phoneNumber.replace('-','3');
            }
        }else {
            //JOptionPane.showMessageDialog(null, "phone number is less than 9 digits.");
            return false;
        }
        if (phoneNumber.matches("\\d+")){
            return true;
        }else {
            return false;
        }
    }
    
    //method to check whether the text field only contains alphabet
    public static boolean checkAlphabetOnly(String string){
        string=string.replace(' ','a');
        if (string.replace(' ','a').matches("[a-zA-Z]+")){
            return true;
        }else return false;
    }
    
}
