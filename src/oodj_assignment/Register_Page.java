package oodj_assignment;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Register_Page extends JDialog implements ActionListener, ComponentListener {
    
    private CardLayout cl = new CardLayout();
    private JButton button_next, button_return, button_save_answer;
    private ButtonGroup bg; 
    private JComboBox combobox_date, combobox_month, combobox_year, combobox_blood_type, combobox_question1, combobox_question2;
    private JLabel label_name, label_ic_number, label_birth_date, label_gender, label_email, label_phone_number, 
            label_occupation, label_blood_type, label_password, label_confirm_password, label_dash1, label_dash2, 
            label_empty1, label_empty2, label_security_questions, label_description, label_question1, label_answer1,
            label_question2, label_answer2, label_empty3;
    private JPanel panel_info, panel_questions, panel_cards;
    private JPasswordField passwordField_password, passwordField_confirm_password;
    private JRadioButton radioButton_male, radioButton_female;
    private JTextField textField_name, textField_ic_number, textField_email, textField_phone_number, textField_occupation, 
            textField_answer1, textField_answer2;
    
    public Register_Page(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(900,600);
        setLocation(650,250);
        setTitle("Student Registration");
        
        panel_cards = new JPanel();
        panel_cards.setLayout(cl);
        add(panel_cards);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //1st panel
        panel_info = new JPanel(new GridBagLayout());
        TitledBorder b = BorderFactory.createTitledBorder("Student Registration");
        b.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_info.setBorder(b);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_name = new JLabel("Name:");
        label_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,30);
        textField_name = new JTextField();
        textField_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_name.setPreferredSize(new Dimension(260,30));
        panel_info.add(textField_name,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,50,5,0);
        label_ic_number = new JLabel("IC/Passport No.:");
        label_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_ic_number,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,50,0,20);
        textField_ic_number = new JTextField();
        textField_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_ic_number.setPreferredSize(new Dimension(260,30));
        panel_info.add(textField_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_birth_date = new JLabel("Birth Date:");
        label_birth_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_birth_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,0);
        String items3[] = {"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012",
                            "2011","2010","2009","2008","2007","2006","2005","2004","2003","2002",
                            "2001","2000","1999","1998","1997","1996","1995","1994","1993","1992",
                            "1991","1990","1989","1988","1987","1986","1985","1984","1983","1982",
                            "1981","1980","1979","1978","1977","1976","1975","1974","1973","1972",
                            "1971","1970","1969","1968","1967","1966","1965","1964","1963","1962",
                            "1961","1960","1959","1958","1957","1956","1955","1954","1953","1952",
                            "1951","1950","1949","1948","1947","1946","1945","1944","1943","1942",
                            "1941","1940","1939","1938","1937","1936","1935","1934","1933","1932",
                            "1931","1930","1929","1928","1927","1926","1925","1924","1923","1922"};
        combobox_year = new JComboBox(items3);
        combobox_year.setEditable(true);
        combobox_year.setSelectedItem("Year");
        combobox_year.setEditable(false);
        combobox_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(combobox_year,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10,0,0,0);
        label_dash1 = new JLabel("-");
        label_dash1.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_dash1,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,0,0,0);
        String items2[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        combobox_month = new JComboBox(items2);
        combobox_month.setEditable(true);
        combobox_month.setSelectedItem("Month");
        combobox_month.setEditable(false);
        combobox_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(combobox_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10,0,0,0);
        label_dash2 = new JLabel("-");
        label_dash2.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_dash2,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,0,0,30);        
        String items1[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        combobox_date = new JComboBox(items1);
        combobox_date.setEditable(true);
        combobox_date.setSelectedItem("Date");
        combobox_date.setEditable(false);
        //combobox_date.setMaximumSize(new Dimension(40,30));
        combobox_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(combobox_date,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,50,5,0);
        label_gender = new JLabel("Gender:");
        label_gender.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_gender,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,50,0,10);
        radioButton_male = new JRadioButton("Male");
        radioButton_male.setFont(new Font("Cambria Math",Font.PLAIN,20));
        this.radioButton_male.setActionCommand("Male");
        panel_info.add(radioButton_male,gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,0,0,0);
        label_empty1 = new JLabel("");
        label_empty1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_empty1,gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,0,0,15);
        radioButton_female = new JRadioButton("Female");
        radioButton_female.setFont(new Font("Cambria Math",Font.PLAIN,20));
        this.radioButton_female.setActionCommand("Female");
        panel_info.add(radioButton_female,gbc);
        
        gbc.gridx = 8;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,0,0,0);
        label_empty2 = new JLabel("");
        label_empty2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_empty2,gbc);
        
        bg = new ButtonGroup();
        bg.add(radioButton_male);
        bg.add(radioButton_female);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_email = new JLabel("Email:");
        label_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,30);
        textField_email = new JTextField();
        textField_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_name.setPreferredSize(new Dimension(260,30));
        panel_info.add(textField_email,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,50,5,0);
        label_phone_number = new JLabel("Phone Number:");
        label_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_phone_number,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,50,0,20);
        textField_phone_number = new JTextField();
        textField_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_phone_number.setPreferredSize(new Dimension(260,30));
        panel_info.add(textField_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_occupation = new JLabel("Occupation:");
        label_occupation.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_occupation,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,30);
        textField_occupation = new JTextField();
        textField_occupation.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_occupation.setPreferredSize(new Dimension(260,30));
        panel_info.add(textField_occupation,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,50,5,0);
        label_blood_type = new JLabel("Blood Type:");
        label_blood_type.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_blood_type,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 7;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,50,0,20);
        String items4[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        combobox_blood_type = new JComboBox(items4);
        combobox_blood_type.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(combobox_blood_type,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_password = new JLabel("Password:");
        label_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,30);
        passwordField_password = new JPasswordField();
        passwordField_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        passwordField_password.setPreferredSize(new Dimension(260,30));
        passwordField_password.setEchoChar('*');
        panel_info.add(passwordField_password,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 8;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,50,5,0);
        label_confirm_password = new JLabel("Confirm Password:");
        label_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(label_confirm_password,gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,50,0,20);
        passwordField_confirm_password = new JPasswordField();
        passwordField_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        passwordField_confirm_password.setPreferredSize(new Dimension(260,30));
        passwordField_confirm_password.setEchoChar('*');
        panel_info.add(passwordField_confirm_password,gbc);
                        
        gbc.gridx = 9;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,0,20);
        button_next = new JButton("Next");
        button_next.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_info.add(button_next,gbc);
        button_next.addActionListener(this);
        
        //2nd panel
        panel_questions = new JPanel(new GridBagLayout());
        panel_questions.setBorder(b);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,120,5,0);
        //gbc.insets = new Insets(5,50,5,0);
        label_security_questions = new JLabel("Security Questions");
        label_security_questions.setFont(new Font("Cambria Math",Font.BOLD,26));
        panel_questions.add(label_security_questions,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,125,5,0);
        //gbc.insets = new Insets(5,50,5,0);
        label_description = new JLabel("<html>This question will help us verify your identity if you<br>forget your password.</html>");
        label_description.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(label_description,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_question1 = new JLabel("Question 1:");
        label_question1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_question1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(label_question1,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,50,5,80);
        String items5[] = {"What is your mother's first name?","What is the name of your secondary school?","What is your favourite animal?"};
        combobox_question1 = new JComboBox(items5);
        combobox_question1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(combobox_question1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_answer1 = new JLabel("Answer:");
        label_answer1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_answer1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(label_answer1,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,50,5,80);
        textField_answer1 = new JTextField();
        textField_answer1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_answer1.setPreferredSize(new Dimension(260,30));
        panel_questions.add(textField_answer1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_question2 = new JLabel("Question 2:");
        label_question2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_question2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(label_question2,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,50,5,80);
        String items6[] = {"What is the name of your first pet?","Where do you live when you were 10 years old?","What is the last name of your best friend?"};
        combobox_question2 = new JComboBox(items6);
        combobox_question2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(combobox_question2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_answer2 = new JLabel("Answer:");
        label_answer2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_answer2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(label_answer2,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,50,5,80);
        textField_answer2 = new JTextField();
        textField_answer2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_answer2.setPreferredSize(new Dimension(260,30));
        panel_questions.add(textField_answer2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,50,5,0);
        button_return = new JButton("Return");
        button_return.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(button_return,gbc);
        button_return.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_empty3 = new JLabel("");
        label_empty3.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_empty3.setPreferredSize(new Dimension(250,30));
        panel_questions.add(label_empty3,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,100,5,50);
        button_save_answer = new JButton("Save Answers");
        button_save_answer.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_questions.add(button_save_answer,gbc);
        button_save_answer.addActionListener(this);
        
        panel_cards.add(panel_info, "info");
        panel_cards.add(panel_questions, "questions");
        
        setModal(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_next) {
            
            //if all the information is filled and is valid, open the next page to set up security questions
            if (!textField_name.getText().isEmpty() && !textField_email.getText().isEmpty() && !String.valueOf(passwordField_confirm_password.getPassword()).isEmpty() && !String.valueOf(passwordField_password.getPassword()).isEmpty() && !textField_occupation.getText().isEmpty() && !textField_ic_number.getText().isEmpty() && !textField_phone_number.getText().isEmpty() && !combobox_blood_type.getSelectedItem().toString().isEmpty() &&
                    !combobox_date.getSelectedItem().equals("Date") && !combobox_month.getSelectedItem().equals("Month") && !combobox_year.getSelectedItem().equals("Year") && bg.getSelection() != null) {
                if (OODJ_Assignment.checkPhoneNumber(textField_phone_number.getText())) {
                    if (OODJ_Assignment.checkAlphabetOnly(textField_name.getText()) && OODJ_Assignment.checkAlphabetOnly(textField_occupation.getText())) {
                        if (passwordField_password.getPassword().length >= 6){
                            if (String.valueOf(passwordField_confirm_password.getPassword()).equals(String.valueOf(passwordField_password.getPassword()))) {
                                if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_date.getSelectedItem().toString()), Integer.parseInt(combobox_month.getSelectedItem().toString()), Integer.parseInt(combobox_year.getSelectedItem().toString()))) {
                                    cl.next(panel_cards);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid Date");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Password not the same as confirm password.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Password must have at least 6 digits.");
                        }                        
                    }else {
                        JOptionPane.showMessageDialog(null, "Name and occupation only contains alphabets.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Phone number! Please check if it contains more than 9 numerical digits.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill up the info");
            }
            
        }else if(e.getSource()==combobox_month){

            
            
        } else if (e.getSource() == button_return) {
            
            cl.show(panel_cards, "info");
            
        } else if (e.getSource() == button_save_answer) {
            
            //if both of the security questions are answered
            if (textField_answer1.getText().isEmpty() || textField_answer2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please answer both of the questions.");
                return;
            }
            String email = textField_email.getText();
            boolean flag1 = true;
            for (int i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
                String eemail = OODJ_Assignment.allStudent.get(i).getEmail();
                if (email.equals(eemail)) {
                    flag1 = false;
                    break;
                }

            }
            if (flag1) {
                String DOB= combobox_date.getSelectedItem()+"-"+combobox_month.getSelectedItem()+"-"+combobox_year.getSelectedItem();

                String id_count = String.valueOf(OODJ_Assignment.allStudent.size() + 1);
                
                //generate a new student id
                if (id_count.length() == 1) {
                    id_count = "ST" + "000" + id_count;
                } else if (id_count.length() == 2) {
                    id_count = "ST" + "00" + id_count;
                } else if (id_count.length() == 3) {
                    id_count = "ST" + "0" + id_count;
                } else if (id_count.length() == 4) {
                    id_count = "ST" + id_count;
                }
                String theme="light";

                Student std = new Student(textField_name.getText(), DOB, String.valueOf(passwordField_password.getPassword()), textField_occupation.getText(), bg.getSelection().getActionCommand(), textField_email.getText(), textField_ic_number.getText(),
                        textField_phone_number.getText(), id_count, theme, combobox_blood_type.getSelectedItem().toString(), combobox_question1.getSelectedItem().toString(), textField_answer1.getText(), combobox_question2.getSelectedItem().toString(), textField_answer2.getText());
                OODJ_Assignment.allStudent.add(std);

                //add to allStudent ArrayList and update text file
                try {
                    PrintWriter p = new PrintWriter("student.txt");
                    for (int i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
                        Student s = OODJ_Assignment.allStudent.get(i);
                        p.println(s.getID());
                        p.println(s.getName());
                        p.println(s.getDOB());
                        p.println(s.getOccupation());
                        p.println(s.getGender());
                        p.println(s.getEmail());
                        p.println(s.getIC());
                        p.println(s.getPhone_number());
                        p.println(s.getBlood_type());
                        p.println(s.getPassword());
                        p.println(s.getQuestion1());
                        p.println(s.getAnswer1());
                        p.println(s.getQuestion2());
                        p.println(s.getAnswer2());
                        p.println(s.getTheme());
                        p.println();
                    }
                    p.close();

                    JOptionPane.showMessageDialog(null, "Registered!");
                    this.setVisible(false);

                } catch (FileNotFoundException fileNotFoundException) {
                    //fileNotFoundException.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email taken.");
            }

        }
    }
    
    public void componentShown(ComponentEvent e){

    }
        
    //reset the page when it is hidden
    public void componentHidden(ComponentEvent e){
        cl.show(panel_cards, "info");
        textField_name.setText("");
        textField_ic_number.setText("");
        combobox_date.setEditable(true);
        combobox_date.setSelectedItem("Date");
        combobox_date.setEditable(false);
        combobox_month.setEditable(true);
        combobox_month.setSelectedItem("Month");
        combobox_month.setEditable(false);
        combobox_year.setEditable(true);
        combobox_year.setSelectedItem("Year");
        combobox_year.setEditable(false);
        bg.clearSelection();
        textField_email.setText("");
        textField_phone_number.setText("");
        textField_occupation.setText("");
        combobox_blood_type.setSelectedItem("A+");
        passwordField_password.setText("");
        passwordField_confirm_password.setText("");
        textField_answer1.setText("");
        textField_answer2.setText("");
        OODJ_Assignment.loginPage.setVisible(true);
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    }
    
    public void componentClosed(ComponentEvent e){
        
    }
}
