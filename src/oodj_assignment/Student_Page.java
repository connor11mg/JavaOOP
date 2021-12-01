package oodj_assignment;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Student_Page extends JFrame implements ActionListener, ItemListener, ComponentListener, ListSelectionListener, FocusListener, DocumentListener, Theme_Setting{
    
    private ButtonGroup bg;
    private CardLayout cl = new CardLayout();
    private JButton button_home, button_logout, button_exit, button_modify, button_rate, button_view_schedule, button_register, button_settings_save_theme, button_settings_password_change,
            button_settings_password_save;
    private JComboBox combobox_registration_sport, combobox_registration_centre, combobox_registration_day, combobox_registration_time, combobox_settings_theme;
    private JLabel label_username, label_id, label_ic_numberL, label_birth_dateL, label_genderL, label_emailL, label_phone_numberL, label_occupationL, label_blood_typeL,
            label_ic_numberV, label_birth_dateV, label_genderV, label_emailV, label_phone_numberV, label_occupationV, label_blood_typeV,
            label_coaches, label_coach_name, label_coach_nameV, label_coach_sport, label_coach_sportV, label_coach_center, label_coach_centerV,
            label_coach_phone, label_coach_phoneV, label_coach_email, label_coach_emailV, label_coach_rating, label_coach_ratingV, label_registered_schedule, label_sport_registration,
            label_account_settings, label_settings_password_description, label_settings_current_password, label_settings_new_password, label_settings_confirm_password, label_statistic,
            label_statistic_sportsI, label_statistic_sportsV, label_statistic_sportsL, label_statistic_studentsI, label_statistic_studentsV, label_statistic_studentsL, label_statistic_coursesI,
            label_statistic_coursesV, label_statistic_coursesL;
    private JLabel labelPanel_profile, labelPanel_registration, labelPanel_schedule, labelPanel_coaches, labelPanel_statistic, labelPanel_settings;
    private JPanel panel_cards, panel_registration_sport, panel_registration_centre, panel_registration_day, panel_registration_time, panel_settings_theme, panel_settings_password, panel_settings_password_pg1,
            panel_settings_password_pg2;
    private JSeparator separator1, separator2;
    private JTable table_coaches, table_schedule;
    private JTextField textField_search_coach, textField_search_schedule, textField_settings_current_password, textField_settings_new_password, textField_settings_confirm_password;
    private JToggleButton toggleButton_profile, toggleButton_sport_registration, toggleButton_schedule, toggleButton_coaches, toggleButton_statistic, toggleButton_account_settings;
    private TableRowSorter<TableModel> rowSorter_coaches, rowSorter_schedule;
    
    public Student_Page(){
        
        //
        // The way of using GridBagLayout refers to (tutorialspoint, n.d.).
        //
        GridBagConstraints gbc = new GridBagConstraints();
        addComponentListener(this);
        
        setSize(1000,800);
        setLocation(600,150);
        setTitle("Student Page");
        setLayout(new GridBagLayout());
        this.setBackground(new Color(250,243,221));
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        Border b = BorderFactory.createRaisedBevelBorder();
        UIManager.put("ToggleButton.select",UIManager.getDefaults());
                       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 20;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_profile = new JToggleButton("Profile");
        toggleButton_profile.setBackground(new Color(174,217,224).darker());
        toggleButton_profile.setForeground(Color.WHITE);        
        toggleButton_profile.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_profile.setSelected(true);
        toggleButton_profile.setBorder(b);        
        add(toggleButton_profile,gbc);
        toggleButton_profile.addActionListener(this);
        toggleButton_profile.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_sport_registration = new JToggleButton("Sport Registration");
        toggleButton_sport_registration.setBackground(new Color(174,217,224));
        toggleButton_sport_registration.setForeground(new Color(94,100,114));  
        toggleButton_sport_registration.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_sport_registration.setBorder(b);
        add(toggleButton_sport_registration,gbc);
        toggleButton_sport_registration.addActionListener(this);
        toggleButton_sport_registration.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 45;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_schedule = new JToggleButton("Registered Sports Schedule");
        toggleButton_schedule.setBackground(new Color(174,217,224));
        toggleButton_schedule.setForeground(new Color(94,100,114)); 
        toggleButton_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_schedule.setBorder(b);
        add(toggleButton_schedule,gbc);
        toggleButton_schedule.addActionListener(this);
        toggleButton_schedule.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator1 = new JSeparator();
        separator1.setBackground(new Color(250,243,221));
        add(separator1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_coaches = new JToggleButton("Coaches");
        toggleButton_coaches.setBackground(new Color(174,217,224));
        toggleButton_coaches.setForeground(new Color(94,100,114)); 
        toggleButton_coaches.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_coaches.setBorder(b);
        add(toggleButton_coaches,gbc);
        toggleButton_coaches.addActionListener(this);
        toggleButton_coaches.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_statistic = new JToggleButton("Statistic");
        toggleButton_statistic.setBackground(new Color(174,217,224));
        toggleButton_statistic.setForeground(new Color(94,100,114)); 
        toggleButton_statistic.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_statistic.setBorder(b);
        add(toggleButton_statistic,gbc);
        toggleButton_statistic.addActionListener(this);
        toggleButton_statistic.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_account_settings = new JToggleButton("Account Settings");
        toggleButton_account_settings.setBackground(new Color(174,217,224));
        toggleButton_account_settings.setForeground(new Color(94,100,114)); 
        toggleButton_account_settings.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_account_settings.setBorder(b);
        add(toggleButton_account_settings,gbc);
        toggleButton_account_settings.addActionListener(this);
        toggleButton_account_settings.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator2 = new JSeparator();
        separator2.setBackground(new Color(250,243,221));
        add(separator2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_home = new JButton("Return Home Page");
        button_home.setBackground(new Color(184,242,230));
        button_home.setForeground(new Color(94,100,114)); 
        button_home.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_home.setBorder(b);
        add(button_home,gbc);
        button_home.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_logout = new JButton("Logout");
        button_logout.setBackground(new Color(184,242,230));
        button_logout.setForeground(new Color(94,100,114)); 
        button_logout.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_logout.setBorder(b);
        add(button_logout,gbc);
        button_logout.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_exit = new JButton("Exit");
        button_exit.setBackground(new Color(255,166,158));
        button_exit.setForeground(new Color(94,100,114)); 
        button_exit.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_exit.setBorder(b);
        add(button_exit,gbc);
        button_exit.addActionListener(this);
        
        bg = new ButtonGroup();
        bg.add(toggleButton_profile);
        bg.add(toggleButton_sport_registration);
        bg.add(toggleButton_schedule);
        bg.add(toggleButton_coaches);
        bg.add(toggleButton_statistic);
        bg.add(toggleButton_account_settings);       
                
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.weightx = 1;
        gbc.gridheight = 11;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_cards = new JPanel();
        panel_cards.setLayout(cl); 
        add(panel_cards,gbc);
        
        ////////////////////////////////////////////////////////////////////////
        //Profile Panel                                                       //
        ////////////////////////////////////////////////////////////////////////
        
        ImageIcon i = new ImageIcon("images\\student_profile_panel_background.png");
        labelPanel_profile = new JLabel(i);
        labelPanel_profile.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_profile, "profile");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0,0,5,0);
        label_username = new JLabel();
        label_username.setHorizontalAlignment(SwingConstants.CENTER);
        label_username.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_username.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_username,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0,0,0,0);
        label_id = new JLabel("ID:");  //+OODJ.login_user.getID()
        label_id.setHorizontalAlignment(SwingConstants.CENTER);
        label_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_id.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.55;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberL = new JLabel("IC/Passport Number: ");  ////+OODJ.login_user.getIC()
        label_ic_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ic_numberL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ic_numberL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_ic_numberL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberV = new JLabel("000000-00-0000");  ////+OODJ.login_user.getIC()
        label_ic_numberV.setHorizontalAlignment(SwingConstants.LEFT);
        label_ic_numberV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ic_numberV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_ic_numberV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateL = new JLabel("Birth Date: ");  ////+OODJ.login_user.getIC()
        label_birth_dateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_birth_dateL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_birth_dateL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_birth_dateL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateV = new JLabel("00-00-0000");  ////+OODJ.login_user.getIC()
        label_birth_dateV.setHorizontalAlignment(SwingConstants.LEFT);
        label_birth_dateV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_birth_dateV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_birth_dateV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderL = new JLabel("Gender: ");  ////+OODJ.login_user.getGender()
        label_genderL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_genderL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_genderL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_genderL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderV = new JLabel("Male");  ////+OODJ.login_user.getGender()
        label_genderV.setHorizontalAlignment(SwingConstants.LEFT);
        label_genderV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_genderV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_genderV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_emailL = new JLabel("Email Address: ");  ////+OODJ.login_user.getEmail()
        label_emailL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_emailL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_emailL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_emailL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_emailV = new JLabel("testing@gmail.com");  ////+OODJ.login_user.getEmail()
        label_emailV.setHorizontalAlignment(SwingConstants.LEFT);
        label_emailV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_emailV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_emailV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_numberL = new JLabel("Phone Number: ");  ////+OODJ.login_user.getphonenumber()
        label_phone_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_phone_numberL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_phone_numberL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_phone_numberL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_numberV = new JLabel("000-0000000");  ////+OODJ.login_user.getphonenumber()
        label_phone_numberV.setHorizontalAlignment(SwingConstants.LEFT);
        label_phone_numberV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_phone_numberV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_phone_numberV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_occupationL = new JLabel("Occupation: ");  ////+OODJ.login_user.getOccupation()
        label_occupationL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_occupationL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_occupationL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_occupationL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_occupationV = new JLabel("Superhero");  ////+OODJ.login_user.getOccupation()
        label_occupationV.setHorizontalAlignment(SwingConstants.LEFT);
        label_occupationV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_occupationV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_occupationV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_blood_typeL = new JLabel("Blood Type: ");  ////+OODJ.login_user.getBloodType()
        label_blood_typeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_blood_typeL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_blood_typeL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_blood_typeL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_blood_typeV = new JLabel("A+");  ////+OODJ.login_user.getBloodType()
        label_blood_typeV.setHorizontalAlignment(SwingConstants.LEFT);
        label_blood_typeV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_blood_typeV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_blood_typeV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,0,10,0);
        button_modify = new JButton("Modify");
        button_modify.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify.setForeground(new Color(94,100,114)); 
        button_modify.setPreferredSize(new Dimension(200,50));
        labelPanel_profile.add(button_modify,gbc);
        button_modify.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        //Sport Registration Panel                                            //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\student_registration_panel_background.png");
        labelPanel_registration = new JLabel(i);
        labelPanel_registration.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_registration, "registration");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_sport_registration = new JLabel("Sport Registration");
        label_sport_registration.setHorizontalAlignment(SwingConstants.CENTER);
        label_sport_registration.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_sport_registration.setForeground(new Color(94,100,114)); 
        labelPanel_registration.add(label_sport_registration,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,40,0,40);
        panel_registration_sport = new JPanel(new GridBagLayout());
        TitledBorder border_registration = BorderFactory.createTitledBorder("Select a sport:");
        border_registration.setTitleFont(new Font("Cambria Math",Font.PLAIN,20));
        border_registration.setTitleColor(new Color(94,100,114));
        panel_registration_sport.setBorder(border_registration);
        panel_registration_sport.setOpaque(false);
        labelPanel_registration.add(panel_registration_sport,gbc);
        
        String sports[] = {"Basketball","Tennis","SP0003","SP0004","SP0005"};
        combobox_registration_sport = new JComboBox(sports);
        combobox_registration_sport.setEditable(true);
        combobox_registration_sport.setSelectedItem("Sport");
        combobox_registration_sport.setEditable(false);
        combobox_registration_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_registration_sport.setPreferredSize(new Dimension(300,40));
        panel_registration_sport.add(combobox_registration_sport);
        combobox_registration_sport.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,40,0,40);
        panel_registration_centre = new JPanel(new GridBagLayout());
        border_registration = BorderFactory.createTitledBorder("Select a sport centre:");
        border_registration.setTitleFont(new Font("Cambria Math",Font.PLAIN,20));
        border_registration.setTitleColor(new Color(94,100,114));
        panel_registration_centre.setBorder(border_registration);
        panel_registration_centre.setOpaque(false);
        labelPanel_registration.add(panel_registration_centre,gbc);
        
        String sport_centre[] = {"Petaling Branch","Kuala Selangor Branch","Klang Branch","Sepang Branch","Hulu Langat Branch"}; 
        combobox_registration_centre = new JComboBox(sport_centre);
        combobox_registration_centre.setEditable(true);
        combobox_registration_centre.setSelectedItem("Centre");
        combobox_registration_centre.setEditable(false);
        combobox_registration_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_registration_centre.setPreferredSize(new Dimension(300,40));
        panel_registration_centre.add(combobox_registration_centre);
        combobox_registration_centre.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,40,0,40);
        panel_registration_day = new JPanel(new GridBagLayout());
        border_registration = BorderFactory.createTitledBorder("Select a day:");
        border_registration.setTitleFont(new Font("Cambria Math",Font.PLAIN,20));
        border_registration.setTitleColor(new Color(94,100,114));
        panel_registration_day.setBorder(border_registration);
        panel_registration_day.setOpaque(false);
        labelPanel_registration.add(panel_registration_day,gbc);
        
        String[] day = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        combobox_registration_day = new JComboBox(day);
        combobox_registration_day.setEditable(true);
        combobox_registration_day.setSelectedItem("Day");
        combobox_registration_day.setEditable(false);
        combobox_registration_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_registration_day.setPreferredSize(new Dimension(300,40));
        panel_registration_day.add(combobox_registration_day);
        combobox_registration_day.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,40,0,40);
        panel_registration_time = new JPanel(new GridBagLayout());
        border_registration = BorderFactory.createTitledBorder("Select a time:");
        border_registration.setTitleFont(new Font("Cambria Math",Font.PLAIN,20));
        border_registration.setTitleColor(new Color(94,100,114));
        panel_registration_time.setBorder(border_registration);
        panel_registration_time.setOpaque(false);
        labelPanel_registration.add(panel_registration_time,gbc);
        
        String[] time = {"9AM to 11AM","10AM to 12PM","11AM to 1PM","1PM to 3PM","2PM to 4PM",
                            "3PM to 5PM","4PM to 6PM","5PM to 7PM","8PM to 10PM"};
        combobox_registration_time = new JComboBox(time);
        combobox_registration_time.setEditable(true);
        combobox_registration_time.setSelectedItem("Time");
        combobox_registration_time.setEditable(false);
        combobox_registration_time.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_registration_time.setPreferredSize(new Dimension(300,40));
        panel_registration_time.add(combobox_registration_time);
        combobox_registration_time.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weighty = 0.5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_register = new JButton("Register");
        button_register.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_register.setForeground(new Color(94,100,114)); 
        button_register.setPreferredSize(new Dimension(200,50));
        labelPanel_registration.add(button_register,gbc);
        button_register.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        //Registered Sports Schedule                                          //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_schedule = new JLabel();
        labelPanel_schedule.setLayout(new GridBagLayout());
        labelPanel_schedule.setBackground(new Color(250,243,221));
        labelPanel_schedule.setOpaque(true);
        panel_cards.add(labelPanel_schedule, "schedule");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_registered_schedule = new JLabel("Registered Schedule");
        label_registered_schedule.setHorizontalAlignment(SwingConstants.CENTER);
        label_registered_schedule.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_registered_schedule.setForeground(new Color(94,100,114)); 
        labelPanel_schedule.add(label_registered_schedule,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,15);
        button_view_schedule = new JButton("View");
        button_view_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_schedule.setForeground(new Color(94,100,114)); 
        button_view_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_schedule.add(button_view_schedule,gbc);
        button_view_schedule.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,15);
        textField_search_schedule = new JTextField();
        textField_search_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_schedule.setForeground(new Color(151,151,151)); 
        textField_search_schedule.setText("Search by entering keyword");
        textField_search_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_schedule.add(textField_search_schedule,gbc);
        textField_search_schedule.addFocusListener(this);
        textField_search_schedule.getDocument().addDocumentListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String schedule_column[] = {"ID","Centre Name","Sports","Day","Time","Coach"};
        String schedule_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","1","2","3"}};
        table_schedule = new JTable(new DefaultTableModel(schedule_data,schedule_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_schedule.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_schedule.setForeground(new Color(94,100,114));
        table_schedule.setRowHeight(23);
        table_schedule.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_schedule.setAutoCreateRowSorter(true);
        table_schedule.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_schedule.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_schedule.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(4).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(5).setPreferredWidth(150);
        table_schedule.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_schedule.getTableHeader().setForeground(new Color(94,100,114));
        table_schedule.getTableHeader().setReorderingAllowed(false);
        rowSorter_schedule = new TableRowSorter<>(table_schedule.getModel());
        table_schedule.setRowSorter(rowSorter_schedule);
        
        JScrollPane sp_schedule = new JScrollPane(table_schedule);
        sp_schedule.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_schedule.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_schedule.add(sp_schedule,gbc);
        //table_coaches.getSelectionModel().addListSelectionListener(this);
        table_schedule.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Coaches Panel                                                       //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\student_coach_panel_background.png");
        labelPanel_coaches = new JLabel(i);
        labelPanel_coaches.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_coaches, "coaches");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_coaches = new JLabel("Coaches");
        label_coaches.setHorizontalAlignment(SwingConstants.CENTER);
        label_coaches.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_coaches.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coaches,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_coach_name = new JLabel("Coach: ");
        label_coach_name.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_name.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_name,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,0,5,0);
        label_coach_nameV = new JLabel("coach name");
        label_coach_nameV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_nameV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_nameV.setForeground(new Color(94,100,114));
        label_coach_nameV.setMaximumSize(new Dimension(100,300));
        labelPanel_coaches.add(label_coach_nameV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_sport = new JLabel("Sport in-charge: ");
        label_coach_sport.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_sport.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_sport,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_sportV = new JLabel("basketball");
        label_coach_sportV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_sportV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_sportV.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_sportV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_center = new JLabel("Sport Centre: ");
        label_coach_center.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_center.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_center.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_center,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_centerV = new JLabel("Subang Branch");
        label_coach_centerV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_centerV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_centerV.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_centerV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_phone = new JLabel("Phone Number: ");
        label_coach_phone.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_phone.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_phone.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_phone,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_phoneV = new JLabel("000-0000000");
        label_coach_phoneV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_phoneV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_phoneV.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_phoneV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_email = new JLabel("Email Address: ");
        label_coach_email.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_email.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_email,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_emailV = new JLabel("xxxx@hotmail.com");
        label_coach_emailV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_emailV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_emailV.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_emailV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.55;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_rating = new JLabel("Rating: ");
        label_coach_rating.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coach_rating.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_rating.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_rating,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_coach_ratingV = new JLabel("5/5");
        label_coach_ratingV.setHorizontalAlignment(SwingConstants.LEFT);
        label_coach_ratingV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_coach_ratingV.setForeground(new Color(94,100,114)); 
        labelPanel_coaches.add(label_coach_ratingV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        button_rate = new JButton("Rate this Coach");
        button_rate.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_rate.setForeground(new Color(94,100,114)); 
        button_rate.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(button_rate,gbc);
        button_rate.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,15);
        textField_search_coach = new JTextField();
        textField_search_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_coach.setForeground(new Color(151,151,151)); 
        textField_search_coach.setText("Search by entering keyword");
//        textField_search_coach.setForeground(new Color(94,100,114)); 
        textField_search_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(textField_search_coach,gbc);
        textField_search_coach.addFocusListener(this);
        textField_search_coach.getDocument().addDocumentListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String column[] = {"ID","Name","Sports","Centre","Phone No.","Email","Rating"};
        String data[][]={ {"101","Select A coach","670000","a","1","2","3"}};
        table_coaches = new JTable(new DefaultTableModel(data,column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_coaches.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_coaches.setForeground(new Color(94,100,114));
        table_coaches.setRowHeight(23);
        table_coaches.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_coaches.setAutoCreateRowSorter(true);
        table_coaches.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_coaches.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(4).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(5).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(6).setPreferredWidth(100);
        table_coaches.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_coaches.getTableHeader().setForeground(new Color(94,100,114));
        table_coaches.getTableHeader().setReorderingAllowed(false);
        rowSorter_coaches = new TableRowSorter<>(table_coaches.getModel());
        table_coaches.setRowSorter(rowSorter_coaches);
        
        JScrollPane sp_coaches = new JScrollPane(table_coaches);
        sp_coaches.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_coaches.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_coaches.add(sp_coaches,gbc);
        table_coaches.getSelectionModel().addListSelectionListener(this);
        table_coaches.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Statistic Panel                                                     //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\student_statistic_panel_background.png");
        labelPanel_statistic = new JLabel(i);
        labelPanel_statistic.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_statistic, "statistic");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic = new JLabel("Statistic");
        label_statistic.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_statistic.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        i = new ImageIcon("images\\Sport_Icon.png");
        label_statistic_sportsI = new JLabel(i);
        label_statistic_sportsI.setOpaque(false);
        labelPanel_statistic.add(label_statistic_sportsI,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_statistic_sportsV = new JLabel("0");
        label_statistic_sportsV.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_sportsV.setFont(new Font("Cambria Math",Font.BOLD,50));
        label_statistic_sportsV.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_sportsV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,15,0);
        label_statistic_sportsL = new JLabel("<html><div style='text-align: center;'>Total Number of Sports<br>We Have</div></html>");
        label_statistic_sportsL.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_sportsL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_sportsL.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_sportsL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        i = new ImageIcon("images\\Student_Icon.png");
        label_statistic_studentsI = new JLabel(i);
        label_statistic_studentsI.setOpaque(false);
        labelPanel_statistic.add(label_statistic_studentsI,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_statistic_studentsV = new JLabel("0");
        label_statistic_studentsV.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_studentsV.setFont(new Font("Cambria Math",Font.BOLD,50));
        label_statistic_studentsV.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_studentsV,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,15,0);
        label_statistic_studentsL = new JLabel("<html><div style='text-align: center;'>Total Number of Courses<br>We Have</div></html>");
        label_statistic_studentsL.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_studentsL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_studentsL.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_studentsL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        i = new ImageIcon("images\\Course_Icon.png");
        label_statistic_coursesI = new JLabel(i);
        label_statistic_coursesI.setOpaque(false);
        labelPanel_statistic.add(label_statistic_coursesI,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weighty = 0.6;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_statistic_coursesV = new JLabel("0");
        label_statistic_coursesV.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_coursesV.setFont(new Font("Cambria Math",Font.BOLD,50));
        label_statistic_coursesV.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_coursesV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weighty = 0.1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,15,0);
        label_statistic_coursesL = new JLabel("<html><div style='text-align: center;'>Total Number of Courses<br>You Registered</div></html>");
        label_statistic_coursesL.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic_coursesL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_coursesL.setForeground(new Color(94,100,114)); 
        labelPanel_statistic.add(label_statistic_coursesL,gbc);
        
        ////////////////////////////////////////////////////////////////////////
        //Account Settings Panel                                              //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\student_settings_panel_background.png");
        labelPanel_settings = new JLabel(i);
        labelPanel_settings.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_settings, "settings");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_account_settings = new JLabel("Account Settings");
        label_account_settings.setHorizontalAlignment(SwingConstants.CENTER);
        label_account_settings.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_account_settings.setForeground(new Color(94,100,114)); 
        labelPanel_settings.add(label_account_settings,gbc);
        
        //theme panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,40,0,40);
        panel_settings_theme = new JPanel(new GridBagLayout());
        TitledBorder border_settings = BorderFactory.createTitledBorder("Theme:");
        border_settings.setTitleFont(new Font("Cambria Math",Font.PLAIN,25));
        border_settings.setTitleColor(new Color(94,100,114));
        panel_settings_theme.setBorder(border_settings);
        panel_settings_theme.setOpaque(false);
        labelPanel_settings.add(panel_settings_theme,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        String theme[] = {"Light Theme","Dark Theme"};
        combobox_settings_theme = new JComboBox(theme);
        combobox_settings_theme.setSelectedItem("Light Theme");
        combobox_settings_theme.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_settings_theme.setPreferredSize(new Dimension(300,40));
        panel_settings_theme.add(combobox_settings_theme, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        button_settings_save_theme = new JButton("Save Changes");
        button_settings_save_theme.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_settings_save_theme.setForeground(new Color(94,100,114)); 
        button_settings_save_theme.setPreferredSize(new Dimension(200,40));
        panel_settings_theme.add(button_settings_save_theme,gbc);
        button_settings_save_theme.addActionListener(this);
        
        //password panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20,40,30,40);
        panel_settings_password = new JPanel(new CardLayout());
        border_settings = BorderFactory.createTitledBorder("Change Password:");
        border_settings.setTitleFont(new Font("Cambria Math",Font.PLAIN,25));
        border_settings.setTitleColor(new Color(94,100,114));
        panel_settings_password.setBorder(border_settings);
        panel_settings_password.setOpaque(false);
        labelPanel_settings.add(panel_settings_password,gbc);
        
        //page1
        panel_settings_password_pg1 = new JPanel(new GridBagLayout());
        panel_settings_password_pg1.setOpaque(false);
        panel_settings_password.add(panel_settings_password_pg1,"page1");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        label_settings_password_description = new JLabel();
        label_settings_password_description.setText("<html>Make sure you change your password regularly<br>to improve security. Passwords containing birthday or IC numbers are not encouraged.</html>");
        label_settings_password_description.setHorizontalAlignment(SwingConstants.LEFT);
        label_settings_password_description.setFont(new Font("Cambria Math",Font.ITALIC,25));
        label_settings_password_description.setForeground(new Color(94,100,114)); 
        panel_settings_password_pg1.add(label_settings_password_description,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        button_settings_password_change = new JButton("Change Password");
        button_settings_password_change.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_settings_password_change.setForeground(new Color(94,100,114)); 
        button_settings_password_change.setMinimumSize(new Dimension(200,40));
        panel_settings_password_pg1.add(button_settings_password_change,gbc);
        button_settings_password_change.addActionListener(this);
        
        //page2
        panel_settings_password_pg2 = new JPanel(new GridBagLayout());
        panel_settings_password_pg2.setOpaque(false);
        panel_settings_password.add(panel_settings_password_pg2,"page2");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20,40,0,40);
        label_settings_current_password = new JLabel();
        label_settings_current_password.setText("Current Password: ");
        label_settings_current_password.setHorizontalAlignment(SwingConstants.LEFT);
        label_settings_current_password.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_settings_current_password.setForeground(new Color(94,100,114)); 
        panel_settings_password_pg2.add(label_settings_current_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        textField_settings_current_password = new JTextField();
        textField_settings_current_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_settings_current_password.setPreferredSize(new Dimension(650,25));
        panel_settings_password_pg2.add(textField_settings_current_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        label_settings_new_password = new JLabel();
        label_settings_new_password.setText("New Password: ");
        label_settings_new_password.setHorizontalAlignment(SwingConstants.LEFT);
        label_settings_new_password.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_settings_new_password.setForeground(new Color(94,100,114)); 
        panel_settings_password_pg2.add(label_settings_new_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        textField_settings_new_password = new JTextField();
        textField_settings_new_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_settings_new_password.setPreferredSize(new Dimension(650,25));
        panel_settings_password_pg2.add(textField_settings_new_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        label_settings_confirm_password = new JLabel();
        label_settings_confirm_password.setText("Confirm New Password: ");
        label_settings_confirm_password.setHorizontalAlignment(SwingConstants.LEFT);
        label_settings_confirm_password.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_settings_confirm_password.setForeground(new Color(94,100,114)); 
        panel_settings_password_pg2.add(label_settings_confirm_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        textField_settings_confirm_password = new JTextField();
        textField_settings_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_settings_confirm_password.setPreferredSize(new Dimension(650,25));
        panel_settings_password_pg2.add(textField_settings_confirm_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,40,0,40);
        button_settings_password_save = new JButton("Save Password");
        button_settings_password_save.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_settings_password_save.setForeground(new Color(94,100,114)); 
        button_settings_password_save.setMinimumSize(new Dimension(200,40));
        panel_settings_password_pg2.add(button_settings_password_save,gbc);
        button_settings_password_save.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        
        //setVisible(true);
        
    }
    
    //method to change the them to light theme
    public void lightTheme(){
        ImageIcon i = new ImageIcon("images\\student_profile_panel_background.png");
        labelPanel_profile.setIcon(i);
        i = new ImageIcon("images\\student_registration_panel_background.png");
        labelPanel_registration.setIcon(i);
        labelPanel_schedule.setBackground(new Color(250,243,221));
        i = new ImageIcon("images\\student_coach_panel_background.png");
        labelPanel_coaches.setIcon(i);
        i = new ImageIcon("images\\student_statistic_panel_background.png");
        labelPanel_statistic.setIcon(i);
        i = new ImageIcon("images\\student_settings_panel_background.png");
        labelPanel_settings.setIcon(i);
        OODJ_Assignment.studentViewSchedule.getPanelMain().setBackground(new Color(250,243,221));
    }
    
    //method to change the them to dark theme
    public void darkTheme(){
        ImageIcon i = new ImageIcon("images\\student_profile_panel_background_dark.png");
        labelPanel_profile.setIcon(i);
        i = new ImageIcon("images\\student_registration_panel_background_dark.png");
        labelPanel_registration.setIcon(i);
        labelPanel_schedule.setBackground(new Color(250,243,221).darker());
        i = new ImageIcon("images\\student_coach_panel_background_dark.png");
        labelPanel_coaches.setIcon(i);
        i = new ImageIcon("images\\student_statistic_panel_background_dark.png");
        labelPanel_statistic.setIcon(i);
        i = new ImageIcon("images\\student_settings_panel_background_dark.png");
        labelPanel_settings.setIcon(i);
        OODJ_Assignment.studentViewSchedule.getPanelMain().setBackground(new Color(250,243,221).darker());
    }
    
    //method to check whether the time slot selected by the student crash with another time slot
    //use getCode() from Time enum
    public boolean timeValidity(int selectedTimeCode, String selectedCoach, String selectedDay){
        boolean flag = true;
        ArrayList<RegisteredSport> registeredSportArrayList = new ArrayList<RegisteredSport>();
        for (int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
            for (int y=0; y<OODJ_Assignment.allRegisteredSport.get(x).getStudent().size();y++){
                if (OODJ_Assignment.acc_login.getEmail().equals(OODJ_Assignment.allRegisteredSport.get(x).getStudent().get(y).getEmail())){
                    registeredSportArrayList.add(OODJ_Assignment.allRegisteredSport.get(x));
                }
            }
        }
        if (registeredSportArrayList.size()!=0 ) {
            for (RegisteredSport registeredSport : registeredSportArrayList) {
                if (selectedCoach.equals(registeredSport.getSchedule().get(0).getCoach()) && selectedDay.equals(registeredSport.getSchedule().get(0).getDay().toString())) {
                    if (selectedTimeCode == 2 || selectedTimeCode == 5 || selectedTimeCode == 6 || selectedTimeCode == 7) {
                        if (registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode || registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode - 1 ||
                                registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode + 1) {
                            flag = false;
                            break;
                        }
                    } else if (selectedTimeCode == 1 || selectedTimeCode == 4) {
                        if (registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode || registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode + 1) {
                            flag = false;
                            break;
                        }
                    } else if (selectedTimeCode == 3 || selectedTimeCode == 8) {
                        if (registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode || registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode - 1) {
                            flag = false;
                            break;
                        }
                    } else if (selectedTimeCode == 9) {
                        if (registeredSport.getSchedule().get(0).getTime().getCode() == selectedTimeCode) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
        }else {
            return true;
        }
        return flag;
    }
    
    //change the password panel back to page1 when the user opens settings page
    public void openSettingPage(){
        bg.setSelected(toggleButton_account_settings.getModel(), true);
        CardLayout layout = (CardLayout) panel_settings_password.getLayout();
        layout.show(panel_settings_password, "page1");
        cl.show(panel_cards, "settings");
        return;
    }
    
    //method to update text file
    public void saveStudentTxt(){
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
            JOptionPane.showMessageDialog(null, "Updated!");
            OODJ_Assignment.studentPage.UpdateAfterModify();

        } catch (FileNotFoundException fileNotFoundException) {
            //fileNotFoundException.printStackTrace();
        }
    }
    
    //method to update label text after the user modify own information
    public void UpdateAfterModify(){
        Student std =(Student) OODJ_Assignment.acc_login;
        label_username.setText(std.getName());
        label_id.setText("ID: "+std.getID());
        label_ic_numberV.setText(std.getIC());
        label_birth_dateV.setText(std.getDOB());
        label_genderV.setText(std.getGender());
        label_emailV.setText(std.getEmail());
        label_phone_numberV.setText(std.getPhone_number());
        label_occupationV.setText(std.getOccupation());
        label_blood_typeV.setText(std.getBlood_type());
    }
    
    //auto generate new id for registered sport
    //count the number of registered sport+1
    public String createRegisteredSportId(){
        int id_count =OODJ_Assignment.allRegisteredSport.size()+1;
        String id = new String();
        if (String.valueOf(id_count).length()==1){
            id= "RS"+"000"+id_count;
        }else if (String.valueOf(id_count).length()==2){
            id="RS"+"00"+id_count;
        }else if (String.valueOf(id_count).length()==3){
            id="RS"+"0"+id_count;
        }else if (String.valueOf(id_count).length()==4){
            id="RS"+id_count;
        }
        return id;
    }

    //update registered sport schedule table to display latest data
    public void update_registeredSportSchedule_table(){
        DefaultTableModel dm = (DefaultTableModel) table_schedule.getModel();
        dm.setRowCount(0);
        for(int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
            for (int y=0; y<OODJ_Assignment.allRegisteredSport.get(x).getStudent().size();y++){
                if (OODJ_Assignment.acc_login.getEmail().equals(OODJ_Assignment.allRegisteredSport.get(x).getStudent().get(y).getEmail())){
                    String id = OODJ_Assignment.allRegisteredSport.get(x).getId();
                    String centre = OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getCentre_name();
                    String sports = OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getSport().get(0).getSport_name();
                    String day = OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getDay().toString();
                    String time = OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getTime().toString().replace('$',' ');
                    String coach = OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getCoach();

                    Object[] rs_d={id, centre, sports, day, time, coach};
                    dm.addRow(rs_d);
                }
            }
        }

    }

    //method to check whether a schedule is selected in schedule table
    public boolean selectedTableScheduleIndex(){
        boolean flag = true;
        if (table_schedule.getSelectedRow()!=-1){
            // OODJ_Assignment.adminManageCentre.getCentreIndex= table_centre.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }

    //update the coach table to display latest data
    public void update_coach_table(){
        DefaultTableModel dm = (DefaultTableModel) table_coaches.getModel();
        dm.setRowCount(0);
        for (int i=0; i<OODJ_Assignment.allCoach.size();i++){
            String id = OODJ_Assignment.allCoach.get(i).getID();
            String name = OODJ_Assignment.allCoach.get(i).getName();
            String sports = OODJ_Assignment.allCoach.get(i).getSport();
            String center = OODJ_Assignment.allCoach.get(i).getSports_Center();
            String phone_number = OODJ_Assignment.allCoach.get(i).getPhone_number();
            String email = OODJ_Assignment.allCoach.get(i).getEmail();
            String rating = String.valueOf(OODJ_Assignment.allCoach.get(i).getRating());

            Object[] coach_d = {id, name, sports, center, phone_number, email, rating};

            dm.addRow(coach_d);
        }
    }

    //method to check whether a coach is selected in coach table
    public boolean selectedTableCoachIndex(){
        boolean flag = true;
        if (table_coaches.getSelectedRow()!=-1){
            // OODJ_Assignment.adminManageCentre.getCentreIndex= table_centre.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_home){
            
            this.setVisible(false);
            OODJ_Assignment.homePage.setVisible(true);
            
        } else if (e.getSource() == button_logout){
            
            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout? You can login again later.","Logout",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                this.setVisible(false);
                OODJ_Assignment.acc_login = null;
                OODJ_Assignment.homePage.setVisible(true);
            }    
                
        } else if (e.getSource() == button_exit){
            
            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            
        } else if (e.getSource() == toggleButton_profile){
            
            cl.show(panel_cards, "profile");
            
        } else if (e.getSource() == toggleButton_sport_registration){
            
            cl.show(panel_cards, "registration");
            
        } else if (e.getSource() == toggleButton_schedule){
            
            cl.show(panel_cards, "schedule");
            
        } else if (e.getSource() == toggleButton_coaches){
            
            cl.show(panel_cards, "coaches");
            
        } else if (e.getSource() == toggleButton_statistic){
            
            cl.show(panel_cards, "statistic");
            
        } else if (e.getSource() == toggleButton_account_settings){
            
            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
            layout.show(panel_settings_password, "page1");
            cl.show(panel_cards, "settings");
            
        } else if (e.getSource() == button_modify){
            
            OODJ_Assignment.modifyStudentInfo.setVisible(true);
            
        } else if (e.getSource() == button_rate){
            
            //if a coach is selected, open rateCoach page
            if (selectedTableCoachIndex()) {
                OODJ_Assignment.rateCoach.table_coach_id = table_coaches.getValueAt(table_coaches.getSelectedRow(), 0).toString();
                OODJ_Assignment.rateCoach.setVisible(true);
            }
            
        } else if (e.getSource() == button_view_schedule){
            
            //if a schedule is selected, open studentViewSchedule page
            if (selectedTableScheduleIndex()) {
                String id = table_schedule.getValueAt(table_schedule.getSelectedRow(), 0).toString();
                for (int i=0; i<OODJ_Assignment.allRegisteredSport.size(); i++) {
                    if (OODJ_Assignment.allRegisteredSport.get(i).getId().equals(id)){
                        OODJ_Assignment.studentViewSchedule.getTableScheduleIndex=i;
                        break;
                    }
                }

                OODJ_Assignment.studentViewSchedule.viewClicked();
                OODJ_Assignment.studentViewSchedule.setVisible(true);

            }
            
        } else if (e.getSource() == button_settings_password_change){
            
            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
            layout.next(panel_settings_password);
            
        } else if (e.getSource() == button_settings_save_theme){
            
            //change the theme and update text file
            switch(combobox_settings_theme.getSelectedItem().toString()){
                case "Light Theme":
                    lightTheme();
                    OODJ_Assignment.acc_login.setTheme("light");
                    saveStudentTxt();
                    break;
                case "Dark Theme":
                    darkTheme();
                    OODJ_Assignment.acc_login.setTheme("dark");
                    saveStudentTxt();
                    break;
            }
            
        } else if (e.getSource()==button_register){
            
            //if all of the information is selected
            //get the schedule that match the time and day selected by user
            //check if the user has any other class which time is crash to the schedule
            //if no schedule is crash, register successfully and  display in registered sport schedule
            if (!combobox_registration_centre.getSelectedItem().equals("Select Centre") && !combobox_registration_sport.getSelectedItem().equals("Select Sport") && !combobox_registration_day.getSelectedItem().equals("Select Day") && !combobox_registration_time.getSelectedItem().equals("Select Time")){
                if (!combobox_registration_day.getSelectedItem().equals("Not available") && !combobox_registration_time.getSelectedItem().equals("Not available") && !combobox_registration_centre.getSelectedItem().equals("Not available")) {
                    ArrayList<Schedule> schedule = new ArrayList<Schedule>();
                    for (int i=0; i<OODJ_Assignment.allSchedule.size();i++){
                        if (combobox_registration_centre.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getCentre_name())&& combobox_registration_sport.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getSport().get(0).getSport_name())&&
                        combobox_registration_day.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getDay()) && OODJ_Assignment.allSchedule.get(i).getTime().toString().equals(combobox_registration_time.getSelectedItem().toString().replace(' ','$'))){
                            schedule.add(OODJ_Assignment.allSchedule.get(i));
                        }
                    }
                    ArrayList<Student> student = new ArrayList<Student>();
                    for (int a=0; a<OODJ_Assignment.allStudent.size();a++){
                       if(OODJ_Assignment.acc_login.getEmail().equals(OODJ_Assignment.allStudent.get(a).getEmail())){
                           student.add(OODJ_Assignment.allStudent.get(a));
                       }
                    }
                    RegisteredSport rs = new RegisteredSport(createRegisteredSportId(), student, schedule);

                    boolean flag_check_registered =true;
                    for (int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
                        for (int y=0; y<OODJ_Assignment.allRegisteredSport.get(x).getStudent().size();y++){
                            if (rs.getStudent().get(0).getEmail().equals(OODJ_Assignment.allRegisteredSport.get(x).getStudent().get(y).getEmail())&& rs.getSchedule().get(0).getId().equals(OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getId())){
                                flag_check_registered=false;

                            } else if (!timeValidity(rs.getSchedule().get(0).getTime().getCode(), rs.getSchedule().get(0).getCoach(), rs.getSchedule().get(0).getDay().toString())){
                                JOptionPane.showMessageDialog(null, "You already have other class at this time.");
                                return;
                            }
                        }
                    }

                    if (flag_check_registered){
                        boolean flag_unregistered_record= true;
                        int found_index=0;
                        for (int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
                            for (int y=0; y<OODJ_Assignment.allSchedule.size();y++){
                                if (OODJ_Assignment.allSchedule.get(y).getSport().get(0).getSport_name().equals(combobox_registration_sport.getSelectedItem()) && OODJ_Assignment.allSchedule.get(y).getCentre_name().equals(combobox_registration_centre.getSelectedItem()) &&
                                OODJ_Assignment.allSchedule.get(y).getTime().toString().equals(combobox_registration_time.getSelectedItem().toString().replace(' ','$')) && OODJ_Assignment.allSchedule.get(y).getDay().equals(combobox_registration_day.getSelectedItem())){
                                    if (OODJ_Assignment.allSchedule.get(y).getId().equals(OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getId())){
                                        flag_unregistered_record=false;
                                        found_index= x;
                                        break;
                                    }
                                }
                            }
                        }
                        if (flag_unregistered_record){
                            OODJ_Assignment.allRegisteredSport.add(rs);         //first person to register for the schedule.

                            try {
                                PrintWriter p = new PrintWriter("registered_sport.txt");
                                for (int a=0; a<OODJ_Assignment.allRegisteredSport.size();a++){
                                    List<String> students= new ArrayList<String>();
                                    for (int b=0; b<OODJ_Assignment.allRegisteredSport.get(a).getStudent().size();b++){
                                        students.add(OODJ_Assignment.allRegisteredSport.get(a).getStudent().get(b).getEmail());
                                    }
                                    String stds= String.join(">>", students);

                                    RegisteredSport rss = OODJ_Assignment.allRegisteredSport.get(a);
                                    p.println(rss.getId());
                                    p.println(stds);
                                    p.println(rss.getSchedule().get(0).getId());
                                    p.println();

                                }
                                p.close();
                                JOptionPane.showMessageDialog(null, "you have registered for the sport.");
                                update_registeredSportSchedule_table();

                            } catch (FileNotFoundException fileNotFoundException) {
                                //fileNotFoundException.printStackTrace();
                            }

                        }else{
                            //
                            //existing record for registered sports.
                            //
                            Student std = (Student) OODJ_Assignment.acc_login;
                            OODJ_Assignment.allRegisteredSport.get(found_index).getStudent().add(std);

                            try {
                                PrintWriter p = new PrintWriter("registered_sport.txt");

                                for (int a = 0; a < OODJ_Assignment.allRegisteredSport.size(); a++) {
                                    List<String> students = new ArrayList<String>();
                                    for (int b = 0; b < OODJ_Assignment.allRegisteredSport.get(a).getStudent().size(); b++) {
                                        students.add(OODJ_Assignment.allRegisteredSport.get(a).getStudent().get(b).getEmail());
                                    }
                                    String stds = String.join(">>", students);

                                    RegisteredSport rss = OODJ_Assignment.allRegisteredSport.get(a);
                                    p.println(rss.getId());
                                    p.println(stds);
                                    p.println(rss.getSchedule().get(0).getId());
                                    p.println();

                                }
                                p.close();
                                JOptionPane.showMessageDialog(null, "you have registered for the sport.");
                                update_registeredSportSchedule_table();

                            } catch (FileNotFoundException fileNotFoundException) {
                                //fileNotFoundException.printStackTrace();
                            }
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "You are already registered in this slot.   -"+ rs.getSchedule().get(0).getDay()+", "+rs.getSchedule().get(0).getTime().toString().replace('$', ' ')+" at "+rs.getSchedule().get(0).getCentre_name());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This sport's schedule is currently not available, sorry for any inconvenience.");
                }               
            }else {
                JOptionPane.showMessageDialog(null, "Please select the required boxes above.");
            }
        }
        else if (e.getSource()==button_settings_password_save){
            
            //if all information is filled and valid, change password and update text file
            if (!textField_settings_current_password.getText().isEmpty() && !textField_settings_new_password.getText().isEmpty()&& !textField_settings_confirm_password.getText().isEmpty()){
                if (textField_settings_current_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){
                    if (textField_settings_new_password.getText().length() >= 6){
                        if (textField_settings_new_password.getText().equals(textField_settings_confirm_password.getText())){
                            if (!textField_settings_new_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){

                                for (int i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
                                    Student std = OODJ_Assignment.allStudent.get(i);
                                    if (OODJ_Assignment.acc_login.getEmail().equals(std.getEmail())) {
                                            std.setPassword(textField_settings_new_password.getText());

                                        try {
                                            PrintWriter p = new PrintWriter("student.txt");
                                            for (i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
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
                                            JOptionPane.showMessageDialog(null, "Updated!");
                                            OODJ_Assignment.studentPage.UpdateAfterModify();
                                            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
                                            layout.show(panel_settings_password, "page1");
                                            textField_settings_current_password.setText("");
                                            textField_settings_new_password.setText("");
                                            textField_settings_confirm_password.setText("");

                                        } catch (FileNotFoundException fileNotFoundException) {
                                            //fileNotFoundException.printStackTrace();
                                        }

                                    }
                                }

                            }else {
                                JOptionPane.showMessageDialog(null, "New password cannot be the same as the current password.");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "New password is not the same as confirm password.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "New password must have at least 6 digits.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Current password is incorrect.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please fill in the blanks.");
            }

        }
    }
    
    //when the user click any toggle button, loop all toggle button
    //if the toggle button is selected > darker color, is not selected > brighter color
    public void itemStateChanged(ItemEvent e){
        for(Component c : getContentPane().getComponents()) {
            if (c.getClass() == JToggleButton.class){
                JToggleButton temp = (JToggleButton) c;
                if (temp.isSelected()){
                    temp.setBackground(new Color(174,217,224).darker());
                    temp.setForeground(Color.WHITE);
                } else {
                    temp.setForeground(new Color(94,100,114));
                    temp.setBackground(new Color(174,217,224));
                }
            }
        }
        if (e.getSource()==combobox_registration_sport){
            
            //add item to centre combobox after user select a sport
            if (combobox_registration_sport.getItemCount()!=0){
                combobox_registration_centre.removeAllItems();
                for (int x=0; x<OODJ_Assignment.allSportsCentre.size();x++){
                    for (int y=0; y<OODJ_Assignment.allSportsCentre.get(x).getSport().size();y++){
                        if (combobox_registration_sport.getSelectedItem().equals(OODJ_Assignment.allSportsCentre.get(x).getSport().get(y).getSport_name())){

                            combobox_registration_centre.addItem(OODJ_Assignment.allSportsCentre.get(x).getCenter_name());
                        }
                    }
                }
                if (combobox_registration_centre.getItemCount()==0){
                    combobox_registration_centre.setEditable(true);
                    combobox_registration_centre.setSelectedItem("Not available");
                    combobox_registration_centre.setEditable(false);
                }
            }
            
        } else if (e.getSource()==combobox_registration_centre){
            
            //add item to day combobox after user selects sport and centre
            if (combobox_registration_centre.getItemCount()!=0){
                combobox_registration_day.removeAllItems();
                ArrayList<Day> day= new ArrayList();

                for (int i=0; i<OODJ_Assignment.allSchedule.size();i++){
                    if (combobox_registration_centre.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getCentre_name())&&  //checks the schedule's centre name and sport name
                            combobox_registration_sport.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getSport().get(0).getSport_name())){
                        day.add(OODJ_Assignment.allSchedule.get(i).getDay());
                    }
                }

                //
                //The following code referes to (Oracle, 2021).
                //
                Set<Day> set = new HashSet<>(day);                      //duplicates days in schedules, set to Set to remove duplicates
                day.clear();
                day.addAll(set);
                day.stream().distinct().collect(Collectors.toList());
                Collections.sort(day);

                for (int i=0; i<day.size();i++){
                    combobox_registration_day.addItem(day.get(i));
                }
                if (day.size()==0){
                    combobox_registration_day.setEditable(true);
                    combobox_registration_day.setSelectedItem("Not available");
                    combobox_registration_day.setEditable(false);
                    combobox_registration_time.setEditable(true);
                    combobox_registration_time.setSelectedItem("Not available");
                    combobox_registration_time.setEditable(false);
                }
            }
            
        } else if (e.getSource()==combobox_registration_day){
            
            //add item to time combobox after user select a day
            if (combobox_registration_day.getItemCount()!=0){
                combobox_registration_time.removeAllItems();

                for (int i=0;i<OODJ_Assignment.allSchedule.size();i++){
                    if (combobox_registration_centre.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getCentre_name()) && combobox_registration_sport.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getSport().get(0).getSport_name()) &&
                    combobox_registration_day.getSelectedItem().equals(OODJ_Assignment.allSchedule.get(i).getDay())){

                        combobox_registration_time.addItem(OODJ_Assignment.allSchedule.get(i).getTime().toString().replace('$', ' '));

                    }
                }
            }

        }
    }
    
    //change the label text when the frame is shown
    public void componentShown(ComponentEvent e){
        //
        //main page for student
        //
        Student std = (Student) OODJ_Assignment.acc_login;
        label_username.setText(std.getName());
        label_id.setText("ID: "+std.getID());
        label_ic_numberV.setText(std.getIC());
        label_birth_dateV.setText(std.getDOB());
        label_genderV.setText(std.getGender());
        label_emailV.setText(std.getEmail());
        label_phone_numberV.setText(std.getPhone_number());
        label_occupationV.setText(std.getOccupation());
        label_blood_typeV.setText(std.getBlood_type());

        //
        //student sport registration
        //
        combobox_registration_sport.removeAllItems();
        combobox_registration_sport.setEditable(true);
        combobox_registration_sport.setSelectedItem("Select a sport");
        combobox_registration_sport.setEditable(false);
        for (int i=0;i<OODJ_Assignment.allSport.size();i++){
            combobox_registration_sport.addItem(OODJ_Assignment.allSport.get(i).getSport_name());
        }

        combobox_registration_centre.setEditable(true);
        combobox_registration_centre.setSelectedItem("Select Centre");
        combobox_registration_centre.setEditable(false);

        combobox_registration_day.setEditable(true);
        combobox_registration_day.setSelectedItem("Select Day");
        combobox_registration_day.setEditable(false);

        combobox_registration_time.setEditable(true);
        combobox_registration_time.setSelectedItem("Select Time");
        combobox_registration_time.setEditable(false);

        //
        //update registered sports schedule table
        //
        update_registeredSportSchedule_table();

        //
        //update coach table
        //
        update_coach_table();
        
        //
        //coach display
        //
        label_coach_centerV.setText("");
        label_coach_emailV.setText("");
        label_coach_phoneV.setText("");
        label_coach_centerV.setText("");
        label_coach_ratingV.setText("");
        label_coach_sportV.setText("");

        //
        //statistic page
        //
        label_statistic_studentsV.setText(String.valueOf(OODJ_Assignment.allSchedule.size()));
        label_statistic_sportsV.setText(String.valueOf(OODJ_Assignment.allSport.size()));
        int count =0;
        for (int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
            for (int y=0; y<OODJ_Assignment.allRegisteredSport.get(x).getStudent().size();y++){
                if (OODJ_Assignment.acc_login.getEmail().equals(OODJ_Assignment.allRegisteredSport.get(x).getStudent().get(y).getEmail())){
                    count=count+1;
                }
            }
        }
        label_statistic_coursesV.setText(String.valueOf(count));

        //
        //Theme combobox
        //
        combobox_settings_theme.setEditable(true);
        if (OODJ_Assignment.acc_login.getTheme().equals("light")){
            combobox_settings_theme.setSelectedIndex(0);
        }else {
            combobox_settings_theme.setSelectedIndex(1);
        }
        combobox_settings_theme.setEditable(false);
    }
        
    //reset the frame when it is hidden
    public void componentHidden(ComponentEvent e){
        cl.show(panel_cards, "profile");
        toggleButton_profile.setSelected(true);
        toggleButton_profile.setBackground(new Color(174,217,224).darker());
        toggleButton_profile.setForeground(Color.WHITE);
        OODJ_Assignment.homePage.setVisible(true);
        
        textField_settings_current_password.setText("");
        textField_settings_new_password.setText("");
        textField_settings_confirm_password.setText("");
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    }    
    
    //change the text of labels when the user select different row in a table
    public void valueChanged(ListSelectionEvent e){
        if(table_coaches.getSelectedRow() != -1){
            label_coach_nameV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 1).toString());
            label_coach_sportV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 2).toString());
            label_coach_centerV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 3).toString());
            label_coach_phoneV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 4).toString());
            label_coach_emailV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 5).toString());
            label_coach_ratingV.setText(table_coaches.getValueAt(table_coaches.getSelectedRow(), 6).toString() + "/5");
        }
    }
    
    //remove the text when the user wants to type something
    public void focusGained(FocusEvent e){
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals("Search by entering keyword")){
            textField.setForeground(new Color(94,100,114)); 
            textField.setText("");
        }
    }
    
    //add the text if the user is not typing anything
    public void focusLost(FocusEvent e){
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals("")){
            textField.setForeground(new Color(151,151,151)); 
            textField.setText("Search by entering keyword");
        }
    }
    
    //filter the table whenever user type any keyword into textfield
    public void changedUpdate(DocumentEvent e) {
        String keyword;
        if(e.getDocument() == textField_search_coach.getDocument())
        {
            
            keyword = textField_search_coach.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_coaches.setRowFilter(null);
            }
            
        } else if (e.getDocument() == textField_search_schedule.getDocument()){
            
            keyword = textField_search_schedule.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_schedule.setRowFilter(null);
            }
            
        }       
    }
    
    public void removeUpdate(DocumentEvent e) {
        String keyword;
        if(e.getDocument() == textField_search_coach.getDocument())
        {
            
            keyword = textField_search_coach.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_coaches.setRowFilter(null);
            }
            
        } else if (e.getDocument() == textField_search_schedule.getDocument()){
            
            keyword = textField_search_schedule.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_schedule.setRowFilter(null);
            }
            
        }
    }
    
    public void insertUpdate(DocumentEvent e) {
        String keyword;
        if(e.getDocument() == textField_search_coach.getDocument())
        {
            
            keyword = textField_search_coach.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_coaches.setRowFilter(null);
            }
            
        } else if (e.getDocument() == textField_search_schedule.getDocument()){
            
            keyword = textField_search_schedule.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
            } else {
                rowSorter_schedule.setRowFilter(null);
            }
            
        }
    }

}
