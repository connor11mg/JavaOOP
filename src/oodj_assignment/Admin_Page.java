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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Admin_Page extends JFrame implements ActionListener, ComponentListener, ItemListener, FocusListener, DocumentListener, Theme_Setting {
    
    private ButtonGroup bg;
    private CardLayout cl = new CardLayout();
    private JButton button_home, button_logout, button_exit, button_modify, button_view_coach, button_modify_coach, button_add_coach, 
                    button_view_sport, button_modify_sport, button_add_sport, button_view_schedule, button_modify_schedule, button_add_schedule,
                    button_view_student, button_view_admin, button_view_centre, button_modify_centre, button_acc_create, button_settings_save_theme, button_settings_password_change,
                    button_settings_password_save;
    private ButtonGroup bg_acc_gender;
    private JComboBox combobox_acc_date, combobox_acc_month, combobox_acc_year, combobox_settings_theme, combobox_search_admin, combobox_search_coach, combobox_search_sport,
                        combobox_search_schedule, combobox_search_student, combobox_search_centre;
    private JLabel label_username, label_id, label_ic_numberL, label_ic_numberV, label_birth_dateL, label_birth_dateV, label_genderL, 
                    label_genderV, label_emailL, label_emailV, label_phone_numberL, label_phone_numberV, label_coaches, label_sports, label_sport_schedule,
                    label_registered_students, label_sport_centre, label_add_admin_acc, label_acc_id, label_acc_name, label_acc_ic_number, 
                    label_acc_birth_date, label_acc_gender, label_acc_email, label_acc_phone_number, label_acc_password, label_acc_confirm_password,
                    label_acc_dash1, label_acc_dash2, label_admin, label_account_settings, label_settings_password_description, label_settings_current_password, label_settings_new_password,
                    label_settings_confirm_password, label_statistic, label_statistic_adminL, label_statistic_coachesL, label_statistic_sportsL, label_statistic_scheduleL, label_statistic_studentsL,
                    label_statistic_adminV, label_statistic_coachesV, label_statistic_sportsV, label_statistic_scheduleV, label_statistic_studentsV, label_statistic_popular_sport1, label_statistic_popular_sport2,
                    label_statistic_popular_sport3;
    private JLabel labelPanel_profile, labelPanel_coaches, labelPanel_sports, labelPanel_sport_schedule, labelPanel_registered_students, 
                    labelPanel_sport_centre, labelPanel_statistic, labelPanel_add_admin_acc, labelPanel_account_settings, labelPanel_admin;
    private JPanel panel_cards, panel_acc_labels, panel_acc_inputs, panel_settings_theme, panel_settings_password, panel_settings_password_pg1, panel_settings_password_pg2, panel_search_centre,
                    panel_statistic_label, panel_statistic_value, panel_statistic_popular;
    private JPasswordField passwordField_acc_password, passwordField_acc_confirm_password;
    private JRadioButton radioButton_acc_male, radioButton_acc_female;
    private JSeparator separator1, separator2;
    private JTable table_coaches, table_sports, table_schedule, table_students, table_centre, table_admin;
    private JTextField textField_search_coach, textField_search_sport, textField_search_schedule, textField_search_student, textField_search_centre,
                        textField_acc_id, textField_acc_name, textField_acc_ic_number, textField_acc_email, textField_acc_phone_number, textField_search_admin, textField_settings_current_password,
                        textField_settings_new_password, textField_settings_confirm_password;
    private JToggleButton toggleButton_profile, toggleButton_coaches, toggleButton_sports, toggleButton_sport_schedule, 
                            toggleButton_registered_students, toggleButton_sport_centre, toggleButton_statistic, toggleButton_add_admin_acc, 
                            toggleButton_account_settings, toggleButton_admin;
    private TableRowSorter<TableModel> rowSorter_coaches, rowSorter_sports, rowSorter_schedule, rowSorter_students, rowSorter_centre, rowSorter_admin;
    
    public Admin_Page(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        addComponentListener(this);                             //needed for ComponentShown
        
        setSize(1000,800);
        setLocation(600,150);
        setTitle("Admin Page");
        setLayout(new GridBagLayout());
        this.setBackground(new Color(242,233,228));
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        Border b = BorderFactory.createRaisedBevelBorder();
        UIManager.put("ToggleButton.select", UIManager.getDefaults());
                       
        //toggle buttons for each different panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_profile = new JToggleButton("Profile");
        toggleButton_profile.setBackground(new Color(154,140,152).darker());
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
        toggleButton_admin = new JToggleButton("Admin");
        toggleButton_admin.setBackground(new Color(154,140,152));
        toggleButton_admin.setForeground(new Color(34,34,59));  
        toggleButton_admin.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_admin.setBorder(b);
        add(toggleButton_admin,gbc);
        toggleButton_admin.addActionListener(this);
        toggleButton_admin.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_coaches = new JToggleButton("Coaches");
        toggleButton_coaches.setBackground(new Color(154,140,152));
        toggleButton_coaches.setForeground(new Color(34,34,59));  
        toggleButton_coaches.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_coaches.setBorder(b);
        add(toggleButton_coaches,gbc);
        toggleButton_coaches.addActionListener(this);
        toggleButton_coaches.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_sports = new JToggleButton("Sports");
        toggleButton_sports.setBackground(new Color(154,140,152));
        toggleButton_sports.setForeground(new Color(34,34,59)); 
        toggleButton_sports.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_sports.setBorder(b);
        add(toggleButton_sports,gbc);
        toggleButton_sports.addActionListener(this);
        toggleButton_sports.addItemListener(this);        
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_sport_schedule = new JToggleButton("Sport Schedule");
        toggleButton_sport_schedule.setBackground(new Color(154,140,152));
        toggleButton_sport_schedule.setForeground(new Color(34,34,59)); 
        toggleButton_sport_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_sport_schedule.setBorder(b);
        add(toggleButton_sport_schedule,gbc);
        toggleButton_sport_schedule.addActionListener(this);
        toggleButton_sport_schedule.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 80;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_registered_students = new JToggleButton("Registered Students");
        toggleButton_registered_students.setBackground(new Color(154,140,152));
        toggleButton_registered_students.setForeground(new Color(34,34,59)); 
        toggleButton_registered_students.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_registered_students.setBorder(b);
        add(toggleButton_registered_students,gbc);
        toggleButton_registered_students.addActionListener(this);
        toggleButton_registered_students.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.ipadx = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_sport_centre = new JToggleButton("Sport Centre");
        toggleButton_sport_centre.setBackground(new Color(154,140,152));
        toggleButton_sport_centre.setForeground(new Color(34,34,59)); 
        toggleButton_sport_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_sport_centre.setBorder(b);
        add(toggleButton_sport_centre,gbc);
        toggleButton_sport_centre.addActionListener(this);
        toggleButton_sport_centre.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator1 = new JSeparator();
        separator1.setBackground(new Color(242,233,228));
        add(separator1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_statistic = new JToggleButton("Statistic");
        toggleButton_statistic.setBackground(new Color(154,140,152));
        toggleButton_statistic.setForeground(new Color(34,34,59)); 
        toggleButton_statistic.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_statistic.setBorder(b);
        add(toggleButton_statistic,gbc);
        toggleButton_statistic.addActionListener(this);
        toggleButton_statistic.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_add_admin_acc = new JToggleButton("Add Admin Account");
        toggleButton_add_admin_acc.setBackground(new Color(154,140,152));
        toggleButton_add_admin_acc.setForeground(new Color(34,34,59)); 
        toggleButton_add_admin_acc.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_add_admin_acc.setBorder(b);
        add(toggleButton_add_admin_acc,gbc);
        toggleButton_add_admin_acc.addActionListener(this);
        toggleButton_add_admin_acc.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_account_settings = new JToggleButton("Account Settings");
        toggleButton_account_settings.setBackground(new Color(154,140,152));
        toggleButton_account_settings.setForeground(new Color(34,34,59)); 
        toggleButton_account_settings.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_account_settings.setBorder(b);
        add(toggleButton_account_settings,gbc);
        toggleButton_account_settings.addActionListener(this);
        toggleButton_account_settings.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator2 = new JSeparator();
        separator2.setBackground(new Color(242,233,228));
        add(separator2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_home = new JButton("Return Home Page");
        button_home.setBackground(new Color(201,173,167));
        button_home.setForeground(new Color(34,34,59)); 
        button_home.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_home.setBorder(b);
        add(button_home,gbc);
        button_home.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_logout = new JButton("Logout");
        button_logout.setBackground(new Color(201,173,167));
        button_logout.setForeground(new Color(34,34,59)); 
        button_logout.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_logout.setBorder(b);
        add(button_logout,gbc);
        button_logout.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_exit = new JButton("Exit");
        button_exit.setBackground(new Color(255,166,158));
        button_exit.setForeground(new Color(34,34,59)); 
        button_exit.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_exit.setBorder(b);
        add(button_exit,gbc);
        button_exit.addActionListener(this);
        
        //add all the toggle button into a button group so only one can be selected at a time
        bg = new ButtonGroup();
        bg.add(toggleButton_profile);
        bg.add(toggleButton_admin);
        bg.add(toggleButton_coaches);
        bg.add(toggleButton_sports);
        bg.add(toggleButton_sport_schedule);
        bg.add(toggleButton_registered_students);
        bg.add(toggleButton_sport_centre);
        bg.add(toggleButton_statistic);
        bg.add(toggleButton_add_admin_acc);
        bg.add(toggleButton_account_settings);       
                
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.weightx = 1;
        gbc.gridheight = 15;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_cards = new JPanel();
        panel_cards.setLayout(cl); 
        add(panel_cards,gbc);
        
        ////////////////////////////////////////////////////////////////////////
        //Profile Panel                                                       //
        ////////////////////////////////////////////////////////////////////////
        
        ImageIcon i = new ImageIcon("images\\admin_profile_panel_background.png");
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
        label_username.setForeground(new Color(34,34,59)); 
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
        label_id.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.55;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberL = new JLabel("IC/Passport Number: "); 
        label_ic_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ic_numberL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ic_numberL.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_ic_numberL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberV = new JLabel("000000-00-0000"); 
        label_ic_numberV.setHorizontalAlignment(SwingConstants.LEFT);
        label_ic_numberV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ic_numberV.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_ic_numberV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateL = new JLabel("Birth Date: "); 
        label_birth_dateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_birth_dateL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_birth_dateL.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_birth_dateL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateV = new JLabel("00-00-0000"); 
        label_birth_dateV.setHorizontalAlignment(SwingConstants.LEFT);
        label_birth_dateV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_birth_dateV.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_birth_dateV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderL = new JLabel("Gender: "); 
        label_genderL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_genderL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_genderL.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_genderL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderV = new JLabel("Male");  
        label_genderV.setHorizontalAlignment(SwingConstants.LEFT);
        label_genderV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_genderV.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_genderV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_emailL = new JLabel("Email Address: "); 
        label_emailL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_emailL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_emailL.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_emailL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_emailV = new JLabel("testing@gmail.com"); 
        label_emailV.setHorizontalAlignment(SwingConstants.LEFT);
        label_emailV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_emailV.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_emailV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_numberL = new JLabel("Phone Number: "); 
        label_phone_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_phone_numberL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_phone_numberL.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_phone_numberL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_numberV = new JLabel("000-0000000"); 
        label_phone_numberV.setHorizontalAlignment(SwingConstants.LEFT);
        label_phone_numberV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_phone_numberV.setForeground(new Color(34,34,59)); 
        labelPanel_profile.add(label_phone_numberV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,0,10,0);
        button_modify = new JButton("Modify");
        button_modify.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify.setForeground(new Color(34,34,59)); 
        button_modify.setPreferredSize(new Dimension(200,50));
        labelPanel_profile.add(button_modify,gbc);
        button_modify.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        //Admin Panel                                                         //
        ////////////////////////////////////////////////////////////////////////

        labelPanel_admin = new JLabel();
        labelPanel_admin.setLayout(new GridBagLayout());
        labelPanel_admin.setBackground(new Color(242,233,228));
        labelPanel_admin.setOpaque(true);
        panel_cards.add(labelPanel_admin, "admin");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_admin = new JLabel("Admin");
        label_admin.setHorizontalAlignment(SwingConstants.CENTER);
        label_admin.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_admin.setForeground(new Color(34,34,59)); 
        labelPanel_admin.add(label_admin,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,15);
        button_view_admin = new JButton("View");
        button_view_admin.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_admin.setForeground(new Color(34,34,59)); 
        button_view_admin.setPreferredSize(new Dimension(650,300));
        labelPanel_admin.add(button_view_admin,gbc);
        button_view_admin.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_admin = new JTextField();
        textField_search_admin.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_admin.setForeground(new Color(151,151,151)); 
        textField_search_admin.setText("Search by entering keyword");
        textField_search_admin.setPreferredSize(new Dimension(650,300));
        labelPanel_admin.add(textField_search_admin,gbc);
        textField_search_admin.addFocusListener(this);
        textField_search_admin.getDocument().addDocumentListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_admin = {"Search All","Search by ID","Search by Name","Search by Phone No."};
        combobox_search_admin = new JComboBox(search_admin);
        combobox_search_admin.setSelectedItem("Search All");
        combobox_search_admin.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_admin.setForeground(new Color(34,34,59)); 
        combobox_search_admin.setPreferredSize(new Dimension(650,300));
        labelPanel_admin.add(combobox_search_admin,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String admin_column[] = {"ID","Name", "Phone No.","Email", "IC"};
        String admin_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","a", "0"}};
        table_admin = new JTable(new DefaultTableModel(admin_data,admin_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };   
        table_admin.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_admin.setForeground(new Color(34,34,59));
        table_admin.setRowHeight(23);
        table_admin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_admin.setAutoCreateRowSorter(true);
        table_admin.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_admin.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_admin.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_admin.getColumnModel().getColumn(3).setPreferredWidth(220);
        table_admin.getColumnModel().getColumn(4).setPreferredWidth(200);
        table_admin.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_admin.getTableHeader().setForeground(new Color(34,34,59));
        table_admin.getTableHeader().setReorderingAllowed(false);
        rowSorter_admin = new TableRowSorter<>(table_admin.getModel());
        table_admin.setRowSorter(rowSorter_admin);
        
        JScrollPane sp_admin = new JScrollPane(table_admin);
        sp_admin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_admin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_admin.add(sp_admin,gbc);
        table_admin.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Coaches Panel                                                       //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_coaches = new JLabel();
        labelPanel_coaches.setLayout(new GridBagLayout());
        labelPanel_coaches.setBackground(new Color(242,233,228));
        labelPanel_coaches.setOpaque(true);
        panel_cards.add(labelPanel_coaches, "coaches");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_coaches = new JLabel("Coaches");
        label_coaches.setHorizontalAlignment(SwingConstants.CENTER);
        label_coaches.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_coaches.setForeground(new Color(34,34,59)); 
        labelPanel_coaches.add(label_coaches,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,5);
        button_view_coach = new JButton("View");
        button_view_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_coach.setForeground(new Color(34,34,59)); 
        button_view_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(button_view_coach,gbc);
        button_view_coach.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,5);
        button_modify_coach = new JButton("Modify");
        button_modify_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify_coach.setForeground(new Color(34,34,59)); 
        button_modify_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(button_modify_coach,gbc);
        button_modify_coach.addActionListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,15);
        button_add_coach = new JButton("Add");
        button_add_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_add_coach.setForeground(new Color(34,34,59)); 
        button_add_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(button_add_coach,gbc);
        button_add_coach.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_coach = new JTextField();
        textField_search_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_coach.setForeground(new Color(151,151,151)); 
        textField_search_coach.setText("Search by entering keyword");
        textField_search_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(textField_search_coach,gbc);
        textField_search_coach.addFocusListener(this);
        textField_search_coach.getDocument().addDocumentListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_coach = {"Search All","Search by ID","Search by Name","Search by Sport","Search by Centre","Search by Phone No."};
        combobox_search_coach = new JComboBox(search_coach);
        combobox_search_coach.setSelectedItem("Search All");
        combobox_search_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_coach.setForeground(new Color(34,34,59)); 
        combobox_search_coach.setPreferredSize(new Dimension(650,300));
        labelPanel_coaches.add(combobox_search_coach,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        //id, name, sports, center, phone_number, email, ic, hourly_rate, date_joined, date_terminated, rating
        String coach_column[] = {"ID","Name","Sports","Centre","Phone No.","Email","IC", "Hourly Rate", "Date Joined", "Date Terminated","Rating"};
        String coach_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","a","1","2","3", "8", "9", "10"}};
        table_coaches = new JTable(new DefaultTableModel(coach_data,coach_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_coaches.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_coaches.setForeground(new Color(34,34,59));
        table_coaches.setRowHeight(23);
        table_coaches.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_coaches.setAutoCreateRowSorter(true);
        table_coaches.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_coaches.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(4).setPreferredWidth(130);
        table_coaches.getColumnModel().getColumn(5).setPreferredWidth(220);
        table_coaches.getColumnModel().getColumn(6).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(7).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(8).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(9).setPreferredWidth(150);
        table_coaches.getColumnModel().getColumn(10).setPreferredWidth(150);
        table_coaches.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_coaches.getTableHeader().setForeground(new Color(34,34,59));
        table_coaches.getTableHeader().setReorderingAllowed(false);
        rowSorter_coaches = new TableRowSorter<>(table_coaches.getModel());
        table_coaches.setRowSorter(rowSorter_coaches);
        
        JScrollPane sp_coaches = new JScrollPane(table_coaches);
        sp_coaches.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_coaches.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_coaches.add(sp_coaches,gbc);
        //table_coaches.getSelectionModel().addListSelectionListener(this);
        table_coaches.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Sports Schedule                                                     //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_sports = new JLabel();
        labelPanel_sports.setLayout(new GridBagLayout());
        labelPanel_sports.setBackground(new Color(242,233,228));
        labelPanel_sports.setOpaque(true);
        panel_cards.add(labelPanel_sports, "sports");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_sports = new JLabel("Sports");
        label_sports.setHorizontalAlignment(SwingConstants.CENTER);
        label_sports.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_sports.setForeground(new Color(34,34,59)); 
        labelPanel_sports.add(label_sports,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,5);
        button_view_sport = new JButton("View");
        button_view_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_sport.setForeground(new Color(34,34,59)); 
        button_view_sport.setPreferredSize(new Dimension(650,300));
        labelPanel_sports.add(button_view_sport,gbc);
        button_view_sport.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,5);
        button_modify_sport = new JButton("Modify");
        button_modify_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify_sport.setForeground(new Color(34,34,59)); 
        button_modify_sport.setPreferredSize(new Dimension(650,300));
        labelPanel_sports.add(button_modify_sport,gbc);
        button_modify_sport.addActionListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,15);
        button_add_sport = new JButton("Add");
        button_add_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_add_sport.setForeground(new Color(34,34,59)); 
        button_add_sport.setPreferredSize(new Dimension(650,300));
        labelPanel_sports.add(button_add_sport,gbc);
        button_add_sport.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_sport = new JTextField();
        textField_search_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_sport.setForeground(new Color(151,151,151)); 
        textField_search_sport.setText("Search by entering keyword");
        textField_search_sport.setPreferredSize(new Dimension(650,300));
        labelPanel_sports.add(textField_search_sport,gbc);
        textField_search_sport.addFocusListener(this);
        textField_search_sport.getDocument().addDocumentListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_sport = {"Search All","Search by ID","Search by Sport"};
        combobox_search_sport = new JComboBox(search_sport);
        combobox_search_sport.setSelectedItem("Search All");
        combobox_search_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_sport.setForeground(new Color(34,34,59)); 
        combobox_search_sport.setPreferredSize(new Dimension(650,300));
        labelPanel_sports.add(combobox_search_sport,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String sport_column[] = {"ID","Sport", "Price"};
        String sport_data[][]={ {"101","Amita","670000"}};
        table_sports = new JTable(new DefaultTableModel(sport_data,sport_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_sports.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_sports.setForeground(new Color(34,34,59));
        table_sports.setRowHeight(23);
        table_sports.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_sports.setAutoCreateRowSorter(true);
        table_sports.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_sports.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_sports.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_sports.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_sports.getTableHeader().setForeground(new Color(34,34,59));
        table_sports.getTableHeader().setReorderingAllowed(false);
        rowSorter_sports = new TableRowSorter<>(table_sports.getModel());
        table_sports.setRowSorter(rowSorter_sports);
        
        JScrollPane sp_sports = new JScrollPane(table_sports);
        sp_sports.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_sports.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_sports.add(sp_sports,gbc);
        table_sports.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Sport Schedule Panel                                                //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_sport_schedule = new JLabel();
        labelPanel_sport_schedule.setLayout(new GridBagLayout());
        labelPanel_sport_schedule.setBackground(new Color(242,233,228));
        labelPanel_sport_schedule.setOpaque(true);
        panel_cards.add(labelPanel_sport_schedule, "schedule");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_sport_schedule = new JLabel("Sport Schedule");
        label_sport_schedule.setHorizontalAlignment(SwingConstants.CENTER);
        label_sport_schedule.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_sport_schedule.setForeground(new Color(34,34,59)); 
        labelPanel_sport_schedule.add(label_sport_schedule,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,5);
        button_view_schedule = new JButton("View");
        button_view_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_schedule.setForeground(new Color(34,34,59)); 
        button_view_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_schedule.add(button_view_schedule,gbc);
        button_view_schedule.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,5);
        button_modify_schedule = new JButton("Modify");
        button_modify_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify_schedule.setForeground(new Color(34,34,59)); 
        button_modify_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_schedule.add(button_modify_schedule,gbc);
        button_modify_schedule.addActionListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,15);
        button_add_schedule = new JButton("Add");
        button_add_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_add_schedule.setForeground(new Color(34,34,59)); 
        button_add_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_schedule.add(button_add_schedule,gbc);
        button_add_schedule.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_schedule = new JTextField();
        textField_search_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_schedule.setForeground(new Color(151,151,151)); 
        textField_search_schedule.setText("Search by entering keyword");
        textField_search_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_schedule.add(textField_search_schedule,gbc);
        textField_search_schedule.addFocusListener(this);
        textField_search_schedule.getDocument().addDocumentListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_schedule = {"Search All","Search by ID","Search by Centre","Search by Sport","Search by Day"};
        combobox_search_schedule = new JComboBox(search_schedule);
        combobox_search_schedule.setSelectedItem("Search All");
        combobox_search_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_schedule.setForeground(new Color(34,34,59)); 
        combobox_search_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_schedule.add(combobox_search_schedule,gbc);
        
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
        table_schedule.setForeground(new Color(34,34,59));
        table_schedule.setRowHeight(23);
        table_schedule.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_schedule.setAutoCreateRowSorter(true);
        table_schedule.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_schedule.getColumnModel().getColumn(1).setPreferredWidth(190);
        table_schedule.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(4).setPreferredWidth(150);
        table_schedule.getColumnModel().getColumn(5).setPreferredWidth(100);
        table_schedule.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_schedule.getTableHeader().setForeground(new Color(34,34,59));
        table_schedule.getTableHeader().setReorderingAllowed(false);
        rowSorter_schedule = new TableRowSorter<>(table_schedule.getModel());
        table_schedule.setRowSorter(rowSorter_schedule);
        
        JScrollPane sp_schedule = new JScrollPane(table_schedule);
        sp_schedule.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_schedule.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_sport_schedule.add(sp_schedule,gbc);
        table_schedule.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Registered Students Panel                                           //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_registered_students = new JLabel();
        labelPanel_registered_students.setLayout(new GridBagLayout());
        labelPanel_registered_students.setBackground(new Color(242,233,228));
        labelPanel_registered_students.setOpaque(true);
        panel_cards.add(labelPanel_registered_students, "students");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_registered_students = new JLabel("Registered Students");
        label_registered_students.setHorizontalAlignment(SwingConstants.CENTER);
        label_registered_students.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_registered_students.setForeground(new Color(34,34,59)); 
        labelPanel_registered_students.add(label_registered_students,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,15);
        button_view_student = new JButton("View");
        button_view_student.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_student.setForeground(new Color(34,34,59)); 
        button_view_student.setPreferredSize(new Dimension(650,300));
        labelPanel_registered_students.add(button_view_student,gbc);
        button_view_student.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_student = new JTextField();
        textField_search_student.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_student.setForeground(new Color(151,151,151)); 
        textField_search_student.setText("Search by entering keyword");
        textField_search_student.setPreferredSize(new Dimension(650,300));
        labelPanel_registered_students.add(textField_search_student,gbc);
        textField_search_student.addFocusListener(this);
        textField_search_student.getDocument().addDocumentListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_student = {"Search All","Search by ID","Search by Name","Search by Phone No."};
        combobox_search_student = new JComboBox(search_student);
        combobox_search_student.setSelectedItem("Search All");
        combobox_search_student.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_student.setForeground(new Color(34,34,59)); 
        combobox_search_student.setPreferredSize(new Dimension(650,300));
        labelPanel_registered_students.add(combobox_search_student,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String students_column[] = {"ID","Name","Phone No.","Email"};
        String students_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","a"}};
        table_students = new JTable(new DefaultTableModel(students_data,students_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_students.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_students.setForeground(new Color(34,34,59));
        table_students.setRowHeight(23);
        table_students.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_students.setAutoCreateRowSorter(true);
        table_students.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_students.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_students.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_students.getColumnModel().getColumn(3).setPreferredWidth(230);
        table_students.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_students.getTableHeader().setForeground(new Color(34,34,59));
        table_students.getTableHeader().setReorderingAllowed(false);
        rowSorter_students = new TableRowSorter<>(table_students.getModel());
        table_students.setRowSorter(rowSorter_students);
        
        JScrollPane sp_students = new JScrollPane(table_students);
        sp_students.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_students.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_registered_students.add(sp_students,gbc);
        //table_coaches.getSelectionModel().addListSelectionListener(this);
        table_students.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Sport Centre Panel                                                  //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_sport_centre = new JLabel();
        labelPanel_sport_centre.setLayout(new GridBagLayout());
        labelPanel_sport_centre.setBackground(new Color(242,233,228));
        labelPanel_sport_centre.setOpaque(true);
        panel_cards.add(labelPanel_sport_centre, "centre");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_sport_centre = new JLabel("Sport Centre");
        label_sport_centre.setHorizontalAlignment(SwingConstants.CENTER);
        label_sport_centre.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_sport_centre.setForeground(new Color(34,34,59)); 
        labelPanel_sport_centre.add(label_sport_centre,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,5);
        button_view_centre = new JButton("View");
        button_view_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_centre.setForeground(new Color(34,34,59)); 
        button_view_centre.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_centre.add(button_view_centre,gbc);
        button_view_centre.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,5,15,15);
        button_modify_centre = new JButton("Modify");
        button_modify_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify_centre.setForeground(new Color(34,34,59)); 
        button_modify_centre.setPreferredSize(new Dimension(650,300));
        labelPanel_sport_centre.add(button_modify_centre,gbc);
        button_modify_centre.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,15);
        panel_search_centre = new JPanel(new GridBagLayout());
        labelPanel_sport_centre.add(panel_search_centre,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_search_centre = new JTextField();
        textField_search_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_centre.setForeground(new Color(151,151,151)); 
        textField_search_centre.setText("Search by entering keyword");
        textField_search_centre.setPreferredSize(new Dimension(650,300));
        panel_search_centre.add(textField_search_centre,gbc);
        textField_search_centre.addFocusListener(this);
        textField_search_centre.getDocument().addDocumentListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String[] search_centre = {"Search All","Search by ID","Search by Centre","Search by Sport"};
        combobox_search_centre = new JComboBox(search_centre);
        combobox_search_centre.setSelectedItem("Search All");
        combobox_search_centre.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_centre.setForeground(new Color(34,34,59)); 
        combobox_search_centre.setPreferredSize(new Dimension(650,300));
        panel_search_centre.add(combobox_search_centre,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String centre_column[] = {"ID","Centre Name","Location", "Sports"};
        String centre_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","4"}};
        table_centre = new JTable(new DefaultTableModel(centre_data,centre_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_centre.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_centre.setForeground(new Color(34,34,59));
        table_centre.setRowHeight(23);
        table_centre.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_centre.setAutoCreateRowSorter(true);
        table_centre.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_centre.getColumnModel().getColumn(1).setPreferredWidth(260);
        table_centre.getColumnModel().getColumn(2).setPreferredWidth(130);
        table_centre.getColumnModel().getColumn(3).setPreferredWidth(240);
        table_centre.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_centre.getTableHeader().setForeground(new Color(34,34,59));
        table_centre.getTableHeader().setReorderingAllowed(false);
        rowSorter_centre = new TableRowSorter<>(table_centre.getModel());
        table_centre.setRowSorter(rowSorter_centre);
        
        JScrollPane sp_centre = new JScrollPane(table_centre);
        sp_centre.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_centre.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_sport_centre.add(sp_centre,gbc);
        //table_coaches.getSelectionModel().addListSelectionListener(this);
        table_centre.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Statistic Panel                                                     //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\admin_statistic_panel_background.png");
        labelPanel_statistic = new JLabel(i);
        labelPanel_statistic.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_statistic, "statistic");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic = new JLabel("Statistic");
        label_statistic.setHorizontalAlignment(SwingConstants.CENTER);
        label_statistic.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_statistic.setForeground(new Color(34,34,59)); 
        labelPanel_statistic.add(label_statistic,gbc);
        
        //label panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,10);
        panel_statistic_label = new JPanel(new GridBagLayout());
        panel_statistic_label.setOpaque(false);
        labelPanel_statistic.add(panel_statistic_label,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_adminL = new JLabel("Total Number of Admin:   ");
        label_statistic_adminL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_statistic_adminL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_statistic_adminL.setForeground(new Color(34,34,59)); 
        panel_statistic_label.add(label_statistic_adminL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_coachesL = new JLabel("Total Number of Coaches:   ");
        label_statistic_coachesL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_statistic_coachesL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_statistic_coachesL.setForeground(new Color(34,34,59)); 
        panel_statistic_label.add(label_statistic_coachesL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_sportsL = new JLabel("Total Number of Sports Available:   ");
        label_statistic_sportsL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_statistic_sportsL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_statistic_sportsL.setForeground(new Color(34,34,59)); 
        panel_statistic_label.add(label_statistic_sportsL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_scheduleL = new JLabel("Total Number of Courses Available:   ");
        label_statistic_scheduleL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_statistic_scheduleL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_statistic_scheduleL.setForeground(new Color(34,34,59)); 
        panel_statistic_label.add(label_statistic_scheduleL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_studentsL = new JLabel("Total Number of Registered Students:   ");
        label_statistic_studentsL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_statistic_studentsL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_statistic_studentsL.setForeground(new Color(34,34,59)); 
        panel_statistic_label.add(label_statistic_studentsL,gbc);
        
        //value panel
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,10);
        panel_statistic_value = new JPanel(new GridBagLayout());
        panel_statistic_value.setOpaque(false);
        labelPanel_statistic.add(panel_statistic_value,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_adminV = new JLabel("0");
        label_statistic_adminV.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_adminV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_adminV.setForeground(new Color(34,34,59)); 
        panel_statistic_value.add(label_statistic_adminV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_coachesV = new JLabel("0");
        label_statistic_coachesV.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_coachesV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_coachesV.setForeground(new Color(34,34,59)); 
        panel_statistic_value.add(label_statistic_coachesV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_sportsV = new JLabel("0");
        label_statistic_sportsV.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_sportsV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_sportsV.setForeground(new Color(34,34,59)); 
        panel_statistic_value.add(label_statistic_sportsV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_scheduleV = new JLabel("0");
        label_statistic_scheduleV.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_scheduleV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_scheduleV.setForeground(new Color(34,34,59)); 
        panel_statistic_value.add(label_statistic_scheduleV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_statistic_studentsV = new JLabel("0");
        label_statistic_studentsV.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_studentsV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_studentsV.setForeground(new Color(34,34,59)); 
        panel_statistic_value.add(label_statistic_studentsV,gbc);
        
        //popular panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,60,20,60);
        panel_statistic_popular = new JPanel(new GridBagLayout());
        TitledBorder border_popular = BorderFactory.createTitledBorder("Most Popular Sports:");
        border_popular.setTitleFont(new Font("Cambria Math",Font.BOLD,25));
        border_popular.setTitleColor(new Color(34,34,59));
        panel_statistic_popular.setBorder(border_popular);
        panel_statistic_popular.setOpaque(false);
        labelPanel_statistic.add(panel_statistic_popular,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,30,0,0);
        label_statistic_popular_sport1 = new JLabel("1. Basketball");
        label_statistic_popular_sport1.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_popular_sport1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_popular_sport1.setForeground(new Color(34,34,59)); 
        panel_statistic_popular.add(label_statistic_popular_sport1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,30,0,0);
        label_statistic_popular_sport2 = new JLabel("2. Swimming");
        label_statistic_popular_sport2.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_popular_sport2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_popular_sport2.setForeground(new Color(34,34,59)); 
        panel_statistic_popular.add(label_statistic_popular_sport2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,30,0,0);
        label_statistic_popular_sport3 = new JLabel("3. Table Tennis");
        label_statistic_popular_sport3.setHorizontalAlignment(SwingConstants.LEFT);
        label_statistic_popular_sport3.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_statistic_popular_sport3.setForeground(new Color(34,34,59)); 
        panel_statistic_popular.add(label_statistic_popular_sport3,gbc);
        
        ////////////////////////////////////////////////////////////////////////
        //Add Admin Account Panel                                             //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\admin_acc_panel_background.png");
        labelPanel_add_admin_acc = new JLabel(i);
        labelPanel_add_admin_acc.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_add_admin_acc, "account");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_add_admin_acc = new JLabel("Add Admin Account");
        label_add_admin_acc.setHorizontalAlignment(SwingConstants.CENTER);
        label_add_admin_acc.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_add_admin_acc.setForeground(new Color(34,34,59)); 
        labelPanel_add_admin_acc.add(label_add_admin_acc,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_acc_labels = new JPanel();
        panel_acc_labels.setLayout(new GridBagLayout());
        panel_acc_labels.setOpaque(false);
        labelPanel_add_admin_acc.add(panel_acc_labels,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_id = new JLabel("ID: ");
        label_acc_id.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_id.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_name = new JLabel("Name: ");
        label_acc_name.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_name.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_ic_number = new JLabel("IC/Passport No.: ");
        label_acc_ic_number.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_ic_number.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_birth_date = new JLabel("Birth Date: ");
        label_acc_birth_date.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_birth_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_birth_date.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_birth_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_gender = new JLabel("Gender: ");
        label_acc_gender.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_gender.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_gender.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_gender,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_email = new JLabel("Email: ");
        label_acc_email.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_email.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_phone_number = new JLabel("Phone No.: ");
        label_acc_phone_number.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_phone_number.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_password = new JLabel("Password: ");
        label_acc_password.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_password.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_confirm_password = new JLabel("Confirm Password: ");
        label_acc_confirm_password.setHorizontalAlignment(SwingConstants.RIGHT);
        label_acc_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_confirm_password.setForeground(new Color(34,34,59)); 
        panel_acc_labels.add(label_acc_confirm_password,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,30);
        panel_acc_inputs = new JPanel();
        panel_acc_inputs.setOpaque(false);
        panel_acc_inputs.setLayout(new GridBagLayout());
        labelPanel_add_admin_acc.add(panel_acc_inputs,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_acc_id = new JTextField();
        textField_acc_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_acc_id.setEnabled(false);
        textField_acc_id.setForeground(new Color(34,34,59)); 
        textField_acc_id.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(textField_acc_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_acc_name = new JTextField();
        textField_acc_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_acc_name.setForeground(new Color(34,34,59)); 
        textField_acc_name.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(textField_acc_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_acc_ic_number = new JTextField();
        textField_acc_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_acc_ic_number.setForeground(new Color(34,34,59)); 
        textField_acc_ic_number.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(textField_acc_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String items_year[] = {"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012",
                            "2011","2010","2009","2008","2007","2006","2005","2004","2003","2002",
                            "2001","2000","1999","1998","1997","1996","1995","1994","1993","1992",
                            "1991","1990","1989","1988","1987","1986","1985","1984","1983","1982",
                            "1981","1980","1979","1978","1977","1976","1975","1974","1973","1972",
                            "1971","1970","1969","1968","1967","1966","1965","1964","1963","1962",
                            "1961","1960","1959","1958","1957","1956","1955","1954","1953","1952",
                            "1951","1950","1949","1948","1947","1946","1945","1944","1943","1942",
                            "1941","1940","1939","1938","1937","1936","1935","1934","1933","1932",
                            "1931","1930","1929","1928","1927","1926","1925","1924","1923","1922"};
        combobox_acc_year = new JComboBox(items_year);
        combobox_acc_year.setEditable(true);
        combobox_acc_year.setSelectedItem("Year");
        combobox_acc_year.setEditable(false);
        combobox_acc_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_acc_year.setForeground(new Color(34,34,59)); 
        combobox_acc_year.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(combobox_acc_year,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_dash1 = new JLabel("-");
        label_acc_dash1.setHorizontalAlignment(SwingConstants.CENTER);
        label_acc_dash1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_dash1.setForeground(new Color(34,34,59)); 
        panel_acc_inputs.add(label_acc_dash1,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String items_month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        combobox_acc_month = new JComboBox(items_month);
        combobox_acc_month.setEditable(true);
        combobox_acc_month.setSelectedItem("Month");
        combobox_acc_month.setEditable(false);
        combobox_acc_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_acc_month.setForeground(new Color(34,34,59)); 
        combobox_acc_month.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(combobox_acc_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_acc_dash2 = new JLabel("-");
        label_acc_dash2.setHorizontalAlignment(SwingConstants.CENTER);
        label_acc_dash2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_acc_dash2.setForeground(new Color(34,34,59)); 
        panel_acc_inputs.add(label_acc_dash2,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String items_date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        combobox_acc_date = new JComboBox(items_date);
        combobox_acc_date.setEditable(true);
        combobox_acc_date.setSelectedItem("Date");
        combobox_acc_date.setEditable(false);
        combobox_acc_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_acc_date.setForeground(new Color(34,34,59)); 
        combobox_acc_date.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(combobox_acc_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,20,0,0);
        radioButton_acc_male = new JRadioButton();
        radioButton_acc_male.setText("Male");
        radioButton_acc_male.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton_acc_male.setForeground(new Color(34,34,59)); 
        radioButton_acc_male.setOpaque(false);
        panel_acc_inputs.add(radioButton_acc_male,gbc);
        this.radioButton_acc_male.setActionCommand("Male");
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton_acc_female = new JRadioButton();
        radioButton_acc_female.setText("Female");
        radioButton_acc_female.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton_acc_female.setForeground(new Color(34,34,59)); 
        radioButton_acc_female.setOpaque(false);
        panel_acc_inputs.add(radioButton_acc_female,gbc);
        this.radioButton_acc_female.setActionCommand("Female");
        
        bg_acc_gender = new ButtonGroup();
        bg_acc_gender.add(radioButton_acc_male);
        bg_acc_gender.add(radioButton_acc_female);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_acc_email = new JTextField();
        textField_acc_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_acc_email.setForeground(new Color(34,34,59)); 
        textField_acc_email.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(textField_acc_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        textField_acc_phone_number = new JTextField();
        textField_acc_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_acc_phone_number.setForeground(new Color(34,34,59)); 
        textField_acc_phone_number.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(textField_acc_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        passwordField_acc_password = new JPasswordField();
        passwordField_acc_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        passwordField_acc_password.setForeground(new Color(34,34,59)); 
        passwordField_acc_password.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(passwordField_acc_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.6;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        passwordField_acc_confirm_password = new JPasswordField();
        passwordField_acc_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        passwordField_acc_confirm_password.setForeground(new Color(34,34,59)); 
        passwordField_acc_confirm_password.setPreferredSize(new Dimension(20,35));
        panel_acc_inputs.add(passwordField_acc_confirm_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.15;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,10,0);
        button_acc_create = new JButton("Create Account");
        button_acc_create.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_acc_create.setForeground(new Color(34,34,59)); 
        button_acc_create.setPreferredSize(new Dimension(250,50));
        labelPanel_add_admin_acc.add(button_acc_create,gbc);
        button_acc_create.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        //Account Settings Panel                                              //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\admin_settings_panel_background.png");
        labelPanel_account_settings = new JLabel(i);
        labelPanel_account_settings.setLayout(new GridBagLayout());
        panel_cards.add(labelPanel_account_settings, "settings");
        
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
        label_account_settings.setForeground(new Color(34,34,59)); 
        labelPanel_account_settings.add(label_account_settings,gbc);
        
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
        border_settings.setTitleColor(new Color(34,34,59));
        panel_settings_theme.setBorder(border_settings);
        panel_settings_theme.setOpaque(false);
        labelPanel_account_settings.add(panel_settings_theme,gbc);
        
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
        button_settings_save_theme.setForeground(new Color(34,34,59)); 
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
        border_settings.setTitleColor(new Color(34,34,59));
        panel_settings_password.setBorder(border_settings);
        panel_settings_password.setOpaque(false);
        labelPanel_account_settings.add(panel_settings_password,gbc);
        
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
        label_settings_password_description.setForeground(new Color(34,34,59)); 
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
        button_settings_password_change.setForeground(new Color(34,34,59)); 
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
        label_settings_current_password.setForeground(new Color(34,34,59)); 
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
        label_settings_new_password.setForeground(new Color(34,34,59)); 
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
        label_settings_confirm_password.setForeground(new Color(34,34,59)); 
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
        button_settings_password_save.setForeground(new Color(34,34,59)); 
        button_settings_password_save.setMinimumSize(new Dimension(200,40));
        panel_settings_password_pg2.add(button_settings_password_save,gbc);
        button_settings_password_save.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        
        //setVisible(true);
        
    }
    
    //change the theme if the user choose light theme
    public void lightTheme(){
        ImageIcon i = new ImageIcon("images\\admin_profile_panel_background.png");
        labelPanel_profile.setIcon(i);
        labelPanel_admin.setBackground(new Color(242,233,228));
        labelPanel_coaches.setBackground(new Color(242,233,228));
        labelPanel_sports.setBackground(new Color(242,233,228));
        labelPanel_sport_schedule.setBackground(new Color(242,233,228));
        labelPanel_registered_students.setBackground(new Color(242,233,228));
        labelPanel_sport_centre.setBackground(new Color(242,233,228));
        i = new ImageIcon("images\\admin_statistic_panel_background.png");
        labelPanel_statistic.setIcon(i);
        i = new ImageIcon("images\\admin_acc_panel_background.png");
        labelPanel_add_admin_acc.setIcon(i);
        i = new ImageIcon("images\\admin_settings_panel_background.png");
        labelPanel_account_settings.setIcon(i);
        OODJ_Assignment.adminManageAdmin.getPanelMain().setBackground(new Color(242,233,228));
        OODJ_Assignment.adminManageCentre.getPanelMain().setBackground(new Color(242,233,228));
        OODJ_Assignment.adminManageCoaches.getPanelMain().setBackground(new Color(242,233,228));
        OODJ_Assignment.adminManageSchedule.getPanelMain().setBackground(new Color(242,233,228));
        OODJ_Assignment.adminManageSports.getPanelMain().setBackground(new Color(242,233,228));
        OODJ_Assignment.adminManageStudents.getPanelMain().setBackground(new Color(242,233,228));
    }
    
    //change the theme if the user choose dark theme
    public void darkTheme(){
        ImageIcon i = new ImageIcon("images\\admin_profile_panel_background_dark.png");
        labelPanel_profile.setIcon(i);
        labelPanel_admin.setBackground(new Color(155,106,73));
        labelPanel_coaches.setBackground(new Color(155,106,73));
        labelPanel_sports.setBackground(new Color(155,106,73));
        labelPanel_sport_schedule.setBackground(new Color(155,106,73));
        labelPanel_registered_students.setBackground(new Color(155,106,73));
        labelPanel_sport_centre.setBackground(new Color(155,106,73));
        i = new ImageIcon("images\\admin_statistic_panel_background_dark.png");
        labelPanel_statistic.setIcon(i);
        i = new ImageIcon("images\\admin_acc_panel_background_dark.png");
        labelPanel_add_admin_acc.setIcon(i);
        i = new ImageIcon("images\\admin_settings_panel_background_dark.png");
        labelPanel_account_settings.setIcon(i);
        OODJ_Assignment.adminManageAdmin.getPanelMain().setBackground(new Color(155,106,73));
        OODJ_Assignment.adminManageCentre.getPanelMain().setBackground(new Color(155,106,73));
        OODJ_Assignment.adminManageCoaches.getPanelMain().setBackground(new Color(155,106,73));
        OODJ_Assignment.adminManageSchedule.getPanelMain().setBackground(new Color(155,106,73));
        OODJ_Assignment.adminManageSports.getPanelMain().setBackground(new Color(155,106,73));
        OODJ_Assignment.adminManageStudents.getPanelMain().setBackground(new Color(155,106,73));
    }
    
    //method called when the user open setting page
    //flip the settings password panel to page 1
    public void openSettingPage(){
        bg.setSelected(toggleButton_account_settings.getModel(), true);
        CardLayout layout = (CardLayout) panel_settings_password.getLayout();
        layout.show(panel_settings_password, "page1");       
        cl.show(panel_cards, "settings");
        return;
    }
    
    //method to update the admin table to display the latest data
    public void update_admin_table(){
        DefaultTableModel dm = (DefaultTableModel) table_admin.getModel();
        dm.setRowCount(0);
        for (int ii=0; ii<OODJ_Assignment.allAdmin.size(); ii++) {
            String id = OODJ_Assignment.allAdmin.get(ii).getID();
            String name = OODJ_Assignment.allAdmin.get(ii).getName();
            String phone_number = OODJ_Assignment.allAdmin.get(ii).getPhone_number();
            String email = OODJ_Assignment.allAdmin.get(ii).getEmail();
            String ic = OODJ_Assignment.allAdmin.get(ii).getIC();
            Object[] admin_d = {id, name, phone_number, email, ic};

            dm.addRow(admin_d);
        }
    }

    //method to update the coach table to display the latest data
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
            String ic = OODJ_Assignment.allCoach.get(i).getIC();
            String date_joined = OODJ_Assignment.allCoach.get(i).getDate_joined();
            String date_terminated = OODJ_Assignment.allCoach.get(i).getDate_terminated();
            String hourly_rate = String.valueOf(OODJ_Assignment.allCoach.get(i).getHourly_rate());
            Object[] coach_d = {id, name, sports, center, phone_number, email, ic, hourly_rate, date_joined, date_terminated, rating};

            dm.addRow(coach_d);
        }
    }

    //method to update the sport table to display the latest data
    public void update_sport_table(){
        DefaultTableModel dm = (DefaultTableModel) table_sports.getModel();
        dm.setRowCount(0);
        for (int i=0;i<OODJ_Assignment.allSport.size(); i++){
            String id = OODJ_Assignment.allSport.get(i).getId();
            String name = OODJ_Assignment.allSport.get(i).getSport_name();
            String price = String.valueOf(OODJ_Assignment.allSport.get(i).getPrice());
            Object[] sport_d = {id, name, price};

            dm.addRow(sport_d);
        }
    }
    
    //method to update the centre table to display the latest data
    public void update_centre_table(){
        DefaultTableModel dm = (DefaultTableModel) table_centre.getModel();
        dm.setRowCount(0);
        for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++){
            String id = OODJ_Assignment.allSportsCentre.get(i).getCenter_id();
            String name = OODJ_Assignment.allSportsCentre.get(i).getCenter_name();
            String location = OODJ_Assignment.allSportsCentre.get(i).getCenter_location();
            //String[] sport_name = new String[OODJ_Assignment.allSportsCentre.get(i).getSport().size()];
            String sport_name=null;
            for (int s=0; s<OODJ_Assignment.allSportsCentre.get(i).getSport().size(); s++){
                //sport_name[s]= OODJ_Assignment.allSportsCentre.get(i).getSport().get(s).getSport_name();
                sport_name= sport_name+","+OODJ_Assignment.allSportsCentre.get(i).getSport().get(s).getSport_name();
            }
            Object[] centre_d = {id, name, location, sport_name.substring(5)};

            dm.addRow(centre_d);
        }      
    }

    //method to update the schedule table to display the latest data
    public void update_schedule_table(){
        DefaultTableModel dm = (DefaultTableModel) table_schedule.getModel();
        dm.setRowCount(0);
        for (int i=0; i<OODJ_Assignment.allSchedule.size(); i++){
            String id = OODJ_Assignment.allSchedule.get(i).getId();
            String centre_name = OODJ_Assignment.allSchedule.get(i).getCentre_name();
            //String date = OODJ_Assignment.allSchedule.get(i).getDate();
            String day = OODJ_Assignment.allSchedule.get(i).getDay().toString();
            String time = OODJ_Assignment.allSchedule.get(i).getTime().toString();
            String coach = OODJ_Assignment.allSchedule.get(i).getCoach();
            String timing = time.replace('$',' ');
            String sport_name=null;
            for (int s=0; s<OODJ_Assignment.allSchedule.get(i).getSport().size(); s++){
                //sport_name[s]= OODJ_Assignment.allSportsCentre.get(i).getSport().get(s).getSport_name();
                sport_name= sport_name+","+OODJ_Assignment.allSchedule.get(i).getSport().get(s).getSport_name();
            }
            Object[] schedule_d = {id,centre_name, sport_name.substring(5), day, timing, coach};

            dm.addRow(schedule_d);
        }
    }
    
    //method to update the students table to display the latest data
    public void update_registeredStudent_table(){
        DefaultTableModel dm = (DefaultTableModel) table_students.getModel();
        dm.setRowCount(0);
        for (int i=0; i<OODJ_Assignment.allStudent.size(); i++){
            String id = OODJ_Assignment.allStudent.get(i).getID();
            String name = OODJ_Assignment.allStudent.get(i).getName();
            String email = OODJ_Assignment.allStudent.get(i).getEmail();
            String phone_number = OODJ_Assignment.allStudent.get(i).getPhone_number();
            Object[] student_d = {id, name, phone_number, email};
            dm.addRow(student_d);
        }
    }
    
    //
    // The following code referes to (Oracle, 2021).
    //
    //method to find out the top 3 sports registered by students
    public void registeredSport_ranking(){

        ArrayList<String> sports = new ArrayList<String>();
        for (int x=0; x<OODJ_Assignment.allRegisteredSport.size();x++){
            for (int y=0; y<OODJ_Assignment.allRegisteredSport.get(x).getStudent().size();y++){
                sports.add(OODJ_Assignment.allRegisteredSport.get(x).getSchedule().get(0).getSport().get(0).getSport_name());
            }
        }
        int length = sports.size();
        String s;
        HashMap<String , Integer> sportsFrequency = new HashMap<String , Integer>();
        for (int i=0; i<length; i++){
            s=sports.get(i);
            if (sportsFrequency.containsKey(s)){
                sportsFrequency.put(s, sportsFrequency.get(s)+1);
            }else {
                sportsFrequency.put(s,1);
            }

        }

        Map.Entry<String, Integer> maxEntry1 = null;

        for (Map.Entry<String, Integer> entry : sportsFrequency.entrySet())
        {
            if (maxEntry1 == null || entry.getValue().compareTo(maxEntry1.getValue()) > 0)
            {
                maxEntry1 = entry;
            }
        }
        //if the top 1 sport is obtained, display it, otherwise display "not available"
        if (maxEntry1 != null){
            label_statistic_popular_sport1.setText("1. "+maxEntry1.getKey());
            sportsFrequency.remove(maxEntry1.getKey());
        } else {
            label_statistic_popular_sport1.setText("1. Not Available");
        }       

        
        Map.Entry<String, Integer> maxEntry2 = null;

        for (Map.Entry<String, Integer> entry : sportsFrequency.entrySet())
        {
            if (maxEntry2 == null || entry.getValue().compareTo(maxEntry2.getValue()) > 0)
            {
                maxEntry2 = entry;
            }
        }
        //if the top 2 sport is obtained, display it, otherwise display "not available"
        if (maxEntry2 != null){
            label_statistic_popular_sport2.setText("2. "+maxEntry2.getKey());
            sportsFrequency.remove(maxEntry2.getKey());
        } else {
            label_statistic_popular_sport2.setText("2. Not Available");
        }        

        
        Map.Entry<String, Integer> maxEntry3 = null;

        for (Map.Entry<String, Integer> entry : sportsFrequency.entrySet())
        {
            if (maxEntry3 == null || entry.getValue().compareTo(maxEntry3.getValue()) > 0)
            {
                maxEntry3 = entry;
            }
        }
        //if the top 3 sport is obtained, display it, otherwise display "not available"
        if (maxEntry3 != null){
            label_statistic_popular_sport3.setText("3. "+maxEntry3.getKey());
        } else {
            label_statistic_popular_sport3.setText("3. Not Available");
        }       

    }

    //method to check whether a coach is selected in the coach table
    public boolean getCoachTableIndex(){
        boolean flag = true;
        if (table_coaches.getSelectedRow()!=-1){
            //OODJ_Assignment.adminManageCoaches.getCoachTableIndex = table_coaches.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }

    //method to check whether a sport is selected in the sport table
    public boolean getSportTableIndex(){
        boolean flag = true;
        if (table_sports.getSelectedRow()!=-1){
           // OODJ_Assignment.adminManageSports.getSportIndex= table_sports.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }

    //method to check whether a centre is selected in the centre table
    public boolean getCentreTableIndex(){
        boolean flag = true;
        if (table_centre.getSelectedRow()!=-1){
           // OODJ_Assignment.adminManageCentre.getCentreIndex= table_centre.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }

    //method to check whether a schedule is selected in the schedule table
    public boolean getScheduleTableIndex(){
        boolean flag = true;
        if (table_schedule.getSelectedRow()!=-1){
            // OODJ_Assignment.adminManageCentre.getCentreIndex= table_centre.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }
    
    //method to check whether a student is selected in the student table
    public boolean getRegisteredStudentTableIndex(){
        boolean flag = true;
        if (table_students.getSelectedRow()!=-1){
            // OODJ_Assignment.adminManageCentre.getCentreIndex= table_centre.getSelectedRow();
        }else {
            JOptionPane.showMessageDialog(null, "Please select ONE specific row");
            flag = false;
        }
        return flag;
    }
    
    //method used to filter the tables according to the keyword entered by user
    public void filterTable(DocumentEvent e){
        String keyword;
        //check the source of the document event to find out which table to filter
        if(e.getDocument() == textField_search_coach.getDocument()){
            
            //filter different columns based on user's selection
            keyword = textField_search_coach.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search_coach.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));  
                        break;
                    case "Search by ID":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));  
                        break;
                    case "Search by Name":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));  
                        break;
                    case "Search by Sport":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,2));  
                        break;
                    case "Search by Centre":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,3));  
                        break;
                    case "Search by Phone No.":
                        rowSorter_coaches.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,4));  
                        break;
                }                            
            } else {
                rowSorter_coaches.setRowFilter(null);
            }
            
        } else if ((e.getDocument() == textField_search_sport.getDocument())){
            
            //filter different columns based on user's selection
            keyword = textField_search_sport.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search_sport.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_sports.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
                        break;
                    case "Search by ID":
                        rowSorter_sports.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));
                        break;
                    case "Search by Sport":
                        rowSorter_sports.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));
                        break;
                }          
            } else {
                rowSorter_sports.setRowFilter(null);
            }
            
        } else if ((e.getDocument() == textField_search_schedule.getDocument())){
            
            //filter different columns based on user's selection
            keyword = textField_search_schedule.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search_schedule.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
                        break;
                    case "Search by ID":
                        rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));
                        break;
                    case "Search by Centre":
                        rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));
                        break;
                    case "Search by Sport":
                        rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,2));
                        break;
                    case "Search by Day":
                        rowSorter_schedule.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,3));
                        break;
                }                
            } else {
                rowSorter_schedule.setRowFilter(null);
            }
            
        } else if ((e.getDocument() == textField_search_student.getDocument())){
            
            //filter different columns based on user's selection
            keyword = textField_search_student.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search_student.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
                        break;
                    case "Search by ID":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));
                        break;
                    case "Search by Name":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));
                        break;
                    case "Search by Phone No.":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,2));
                        break;
                }               
            } else {
                rowSorter_students.setRowFilter(null);
            }
            
        } else if ((e.getDocument() == textField_search_centre.getDocument())){
            
            //filter different columns based on user's selection
            keyword = textField_search_centre.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search_centre.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_centre.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
                        break;
                    case "Search by ID":
                        rowSorter_centre.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));
                        break;
                    case "Search by Centre":
                        rowSorter_centre.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));
                        break;
                    case "Search by Sport":
                        rowSorter_centre.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,3));
                        break;
                }        
            } else {
                rowSorter_centre.setRowFilter(null);
            }
            
        } else if ((e.getDocument() == textField_search_admin.getDocument())){
            
            //filter different columns based on user's selection
            keyword = textField_search_admin.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){                
                switch (combobox_search_admin.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_admin.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));
                        break;
                    case "Search by ID":
                        rowSorter_admin.setRowFilter(RowFilter.regexFilter("(?i)"+keyword, 0));
                        break;
                    case "Search by Name":
                        rowSorter_admin.setRowFilter(RowFilter.regexFilter("(?i)"+keyword, 1));
                        break;
                    case "Search by Phone No.":
                        rowSorter_admin.setRowFilter(RowFilter.regexFilter("(?i)"+keyword, 2));
                        break;
                }
            } else {
                rowSorter_admin.setRowFilter(null);
            }
            
        }
    }
    
    //method to update the text of labels after user modify own information
    public void UpdateAfterModify(){
        label_username.setText(OODJ_Assignment.acc_login.getName());
        label_birth_dateV.setText(OODJ_Assignment.acc_login.getDOB());
        label_emailV.setText(OODJ_Assignment.acc_login.getEmail());
        label_genderV.setText(OODJ_Assignment.acc_login.getGender());
        label_ic_numberV.setText(OODJ_Assignment.acc_login.getIC());
        label_phone_numberV.setText(OODJ_Assignment.acc_login.getPhone_number());
        label_id.setText("ID: "+OODJ_Assignment.acc_login.getID());
    }

    //method to generate new admin id
    //count the number of admins+1
    //reset all the textfield and combobox after an admin acc is created
    public void create_admin_id(){
        int id_count =OODJ_Assignment.allAdmin.size()+1;
        if (String.valueOf(id_count).length()==1){
            textField_acc_id.setText("AD"+"000"+id_count);
        }else if (String.valueOf(id_count).length()==2){
            textField_acc_id.setText("AD"+"00"+id_count);
        }else if (String.valueOf(id_count).length()==3){
            textField_acc_id.setText("AD"+"0"+id_count);
        }else if (String.valueOf(id_count).length()==4){
            textField_acc_id.setText("AD"+id_count);
        }
        textField_acc_name.setText("");
        textField_acc_ic_number.setText("");
        textField_acc_email.setText("");
        textField_acc_phone_number.setText("");
        passwordField_acc_password.setText("");
        passwordField_acc_confirm_password.setText("");
        combobox_acc_year.setEditable(true);
        combobox_acc_year.setSelectedItem("Year");
        combobox_acc_year.setEditable(false);
        combobox_acc_month.setEditable(true);
        combobox_acc_month.setSelectedItem("Month");
        combobox_acc_month.setEditable(false);
        combobox_acc_date.setEditable(true);
        combobox_acc_date.setSelectedItem("Date");
        combobox_acc_date.setEditable(false);
    }
    
    //method to update admin text file
    public void saveAdminTxt(){
        try{
            PrintWriter p = new PrintWriter("admin.txt");
            for (int i=0; i<OODJ_Assignment.allAdmin.size();i++){
                Admin a = OODJ_Assignment.allAdmin.get(i);
                p.println(a.getID());
                p.println(a.getName());
                p.println(a.getDOB());
                p.println(a.getGender());
                p.println(a.getEmail());
                p.println(a.getIC());
                p.println(a.getPhone_number());
                p.println(a.getPassword());
                p.println(a.getTheme());
                p.println();
            }
            p.close();
            JOptionPane.showMessageDialog(null, "Updated!");
            OODJ_Assignment.adminPage.UpdateAfterModify();
        } catch (FileNotFoundException fileNotFoundException) {
            //fileNotFoundException.printStackTrace();
        }
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
            
        } else if (e.getSource() == toggleButton_admin){
            
            cl.show(panel_cards, "admin");
            
        } else if (e.getSource() == toggleButton_coaches){
            
            cl.show(panel_cards, "coaches");
            
        } else if (e.getSource() == toggleButton_sports){
            
            cl.show(panel_cards, "sports");
            
        } else if (e.getSource() == toggleButton_sport_schedule){
            
            cl.show(panel_cards, "schedule");
            
        } else if (e.getSource() == toggleButton_registered_students){
            
            cl.show(panel_cards, "students");
            
        } else if (e.getSource() == toggleButton_sport_centre){
            
            cl.show(panel_cards, "centre");
            
        } else if (e.getSource() == toggleButton_statistic){
            
            cl.show(panel_cards, "statistic");
            
        } else if (e.getSource() == toggleButton_add_admin_acc){
            
            cl.show(panel_cards, "account");
            
        } else if (e.getSource() == toggleButton_account_settings){
            
            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
            layout.show(panel_settings_password, "page1");
            cl.show(panel_cards, "settings");
            
        } else if (e.getSource() == button_modify){
            
            OODJ_Assignment.modifyAdminInfo.setVisible(true);
            
        } else if (e.getSource() == button_view_coach){
            
            //if a coach is selected, open the adminManageCoaches page
            if (getCoachTableIndex()){
                String id = table_coaches.getValueAt(table_coaches.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allCoach.size();i++){
                    if (OODJ_Assignment.allCoach.get(i).getID().equals(id)){
                        OODJ_Assignment.adminManageCoaches.getCoachTableIndex=i;
                    }
                }
                OODJ_Assignment.adminManageCoaches.viewClicked();
                OODJ_Assignment.adminManageCoaches.setVisible(true);
            }
            
        } else if (e.getSource() == button_modify_coach){
            
            //if a coach is selected, open the adminManageCoaches page
            if(getCoachTableIndex()){
               String id = table_coaches.getValueAt(table_coaches.getSelectedRow(), 0).toString();
               for (int i=0;i<OODJ_Assignment.allCoach.size();i++){
                   if (OODJ_Assignment.allCoach.get(i).getID().equals(id)){
                       OODJ_Assignment.adminManageCoaches.getCoachTableIndex=i;
                   }
               }
               OODJ_Assignment.adminManageCoaches.modifyClicked();
               OODJ_Assignment.adminManageCoaches.setVisible(true);
           }
            
        } else if (e.getSource() == button_add_coach){
            
            //open the adminManageCoaches page
            OODJ_Assignment.adminManageCoaches.addClicked();
            OODJ_Assignment.adminManageCoaches.setVisible(true);
            
        } else if (e.getSource() == button_view_sport){
            
            //if a sport is selected, open the adminManageSports page
            if (getSportTableIndex()) {
                String id = table_sports.getValueAt(table_sports.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSport.size();i++){
                    if (OODJ_Assignment.allSport.get(i).getId().equals(id)){
                        OODJ_Assignment.adminManageSports.getSportIndex=i;
                    }
                }
                OODJ_Assignment.adminManageSports.viewClicked();
                OODJ_Assignment.adminManageSports.setVisible(true);
            }
            
        } else if (e.getSource() == button_modify_sport){
            
            //if a sport is selected, open the adminManageSports page
            if (getSportTableIndex()) {
                String id = table_sports.getValueAt(table_sports.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSport.size();i++){
                    if (OODJ_Assignment.allSport.get(i).getId().equals(id)){
                        OODJ_Assignment.adminManageSports.getSportIndex=i;
                    }
                }
                OODJ_Assignment.adminManageSports.modifyClicked();
                OODJ_Assignment.adminManageSports.setVisible(true);
            }
            
        } else if (e.getSource() == button_add_sport){
            
            //open the adminManageSports page
            OODJ_Assignment.adminManageSports.addClicked();
            OODJ_Assignment.adminManageSports.setVisible(true);
            
        } else if (e.getSource() == button_view_schedule){
            
            //if a schedule is selected, open the adminManageSchedule page
            if (getScheduleTableIndex()) {
                String id = table_schedule.getValueAt(table_schedule.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSchedule.size();i++) {
                    if (OODJ_Assignment.allSchedule.get(i).getId().equals(id)) {
                        OODJ_Assignment.adminManageSchedule.getScheduleIndex=i;
                        OODJ_Assignment.adminManageSchedule.viewClicked();
                        OODJ_Assignment.adminManageSchedule.setVisible(true);
                    }
                }
            }
            
        } else if (e.getSource() == button_modify_schedule){
            
            //if a schedule is selected, open the adminManageSchedule page
            if (getScheduleTableIndex()) {
                String id = table_schedule.getValueAt(table_schedule.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSchedule.size();i++) {
                    if (OODJ_Assignment.allSchedule.get(i).getId().equals(id)) {
                        OODJ_Assignment.adminManageSchedule.getScheduleIndex=i;
                        OODJ_Assignment.adminManageSchedule.modifyClicked();
                        OODJ_Assignment.adminManageSchedule.setVisible(true);
                    }
                }
            }
            
        } else if (e.getSource() == button_add_schedule){
            
            //open the adminManageSchedule page
            OODJ_Assignment.adminManageSchedule.addClicked();
            OODJ_Assignment.adminManageSchedule.setVisible(true);
            
        } else if (e.getSource() == button_view_student){
            
            //if a student is selected, open the adminManageStudents page
            if (getRegisteredStudentTableIndex()) {
                String id= table_students.getValueAt(table_students.getSelectedRow(), 0).toString();
                for (int i=0; i<OODJ_Assignment.allStudent.size(); i++){
                    if (OODJ_Assignment.allStudent.get(i).getID().equals(id)){
                        OODJ_Assignment.adminManageStudents.getRegisteredStudentIndex = i;
                    }

                }
                OODJ_Assignment.adminManageStudents.setVisible(true);
            }
            
        } else if (e.getSource() == button_view_centre){
            
            //if a centre is selected, open the adminManageCentre page
            if (getCentreTableIndex()) {
                String id = table_centre.getValueAt(table_centre.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSportsCentre.size();i++){
                    if (OODJ_Assignment.allSportsCentre.get(i).getCenter_id().equals(id)){
                        OODJ_Assignment.adminManageCentre.getCentreIndex=i;
                        OODJ_Assignment.adminManageCentre.updateViewCheckBox();
                    }
                }

                OODJ_Assignment.adminManageCentre.viewClicked();
                OODJ_Assignment.adminManageCentre.setVisible(true);
            }
            
        } else if (e.getSource() == button_modify_centre){
            
            //if a centre is selected, open the adminManageCentre page
            if (getCentreTableIndex()) {
                String id = table_centre.getValueAt(table_centre.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSportsCentre.size();i++){
                    if (OODJ_Assignment.allSportsCentre.get(i).getCenter_id().equals(id)){
                        OODJ_Assignment.adminManageCentre.getCentreIndex=i;
                    }
                }
                OODJ_Assignment.adminManageCentre.updateModifyCheckBox();
                OODJ_Assignment.adminManageCentre.modifyClicked();
                OODJ_Assignment.adminManageCentre.setVisible(true);                
            }
            
        } else if (e.getSource() == button_view_admin){
            
            //if an admin is selected, open the adminManageAdmin page
            if (table_admin.getSelectedRow()!=-1) {
                String id = table_admin.getValueAt(table_admin.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allAdmin.size();i++){
                    if (OODJ_Assignment.allAdmin.get(i).getID().equals(id)){
                        OODJ_Assignment.adminManageAdmin.getAdminIndex =i;
                    }
                }

                OODJ_Assignment.adminManageAdmin.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "Please select ONE specific row.");
            }
            
        } else if (e.getSource() == button_acc_create){
            
            //if all the information is filled and valid
            if (!textField_acc_id.getText().isEmpty()&& !textField_acc_name.getText().isEmpty()&& !textField_acc_ic_number.getText().isEmpty()&&
            !combobox_acc_date.getSelectedItem().equals("Date")&& !combobox_acc_month.getSelectedItem().equals("Month")&& !combobox_acc_year.getSelectedItem().equals("Year")&& bg_acc_gender.getSelection().isSelected()&&
            !textField_acc_email.getText().isEmpty()&& !textField_acc_phone_number.getText().isEmpty()&& !String.valueOf(passwordField_acc_password.getPassword()).isEmpty()&& !String.valueOf(passwordField_acc_confirm_password.getPassword()).isEmpty()){

                if (OODJ_Assignment.checkPhoneNumber(textField_acc_phone_number.getText()) && OODJ_Assignment.checkAlphabetOnly(textField_acc_name.getText())){
                    if (passwordField_acc_password.getPassword().length >= 6){
                        if (String.valueOf(passwordField_acc_password.getPassword()).equals(String.valueOf(passwordField_acc_confirm_password.getPassword()))) {
                            if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_acc_date.getSelectedItem().toString()), Integer.parseInt(combobox_acc_month.getSelectedItem().toString()), Integer.parseInt(combobox_acc_year.getSelectedItem().toString()))) {
                                //check whether the acc existed
                                boolean flag_email = true;
                                for (int i = 0; i < OODJ_Assignment.allAdmin.size(); i++) {
                                    Admin admin = OODJ_Assignment.allAdmin.get(i);

                                    if (textField_acc_email.getText().equals(admin.getEmail())) {
                                        flag_email = false;
                                        JOptionPane.showMessageDialog(null, "Email is taken");
                                        break;
                                    }
                                }
                                if (flag_email) {
                                    
                                    //add the new admin to allAdmin ArrayList
                                    String theme = "light";
                                    String DOB = combobox_acc_date.getSelectedItem().toString() + "-" + combobox_acc_month.getSelectedItem().toString() + "-" + combobox_acc_year.getSelectedItem().toString();
                                    Admin a = new Admin(textField_acc_name.getText(), DOB, String.valueOf(passwordField_acc_password.getPassword()), bg_acc_gender.getSelection().getActionCommand(), textField_acc_email.getText(),
                                            textField_acc_ic_number.getText(), textField_acc_phone_number.getText(), textField_acc_id.getText(), theme);
                                    OODJ_Assignment.allAdmin.add(a);

                                    //update text file
                                    try {
                                        PrintWriter p = new PrintWriter("admin.txt");
                                        for (int i = 0; i < OODJ_Assignment.allAdmin.size(); i++) {
                                            Admin ad = OODJ_Assignment.allAdmin.get(i);
                                            p.println(ad.getID());
                                            p.println(ad.getName());
                                            p.println(ad.getDOB());
                                            p.println(ad.getGender());
                                            p.println(ad.getEmail());
                                            p.println(ad.getIC());
                                            p.println(ad.getPhone_number());
                                            p.println(ad.getPassword());
                                            p.println(ad.getTheme());
                                            p.println();
                                        }

                                        p.close();
                                        JOptionPane.showMessageDialog(null, "Admin Account created.");
                                        create_admin_id();

                                    } catch (FileNotFoundException fileNotFoundException) {
                                        //fileNotFoundException.printStackTrace();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid date, please select again.");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Password is not the same as confirm password.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Password must have at least 6 digits.");
                    }                    
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number must has at least 9 numerical digits and name only has alphabets");
                }                
            }else{
                JOptionPane.showMessageDialog(null, "Fill the up the blanks.");
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
                    saveAdminTxt();
                    break;
                case "Dark Theme":
                    darkTheme();
                    OODJ_Assignment.acc_login.setTheme("dark");
                    saveAdminTxt();
                    break;
            }
            
        } else if (e.getSource()==button_settings_password_save){
            
            //if all the information is filled and valid
            if (!textField_settings_current_password.getText().isEmpty() && !textField_settings_new_password.getText().isEmpty()&& !textField_settings_confirm_password.getText().isEmpty()){
                if (textField_settings_current_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){
                    if (textField_settings_new_password.getText().length() >= 6){
                        if (textField_settings_new_password.getText().equals(textField_settings_confirm_password.getText())){
                            if (!textField_settings_new_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){
                                for (int i = 0; i < OODJ_Assignment.allAdmin.size(); i++) {
                                    Admin adm = OODJ_Assignment.allAdmin.get(i);
                                    if (OODJ_Assignment.acc_login.getEmail().equals(adm.getEmail())) {
                                        adm.setPassword(textField_settings_new_password.getText());
                                        //update text file after changing the passowrd in allAdmin ArrayList
                                        try{
                                            PrintWriter p = new PrintWriter("admin.txt");
                                            for (i=0; i<OODJ_Assignment.allAdmin.size();i++){
                                                Admin a = OODJ_Assignment.allAdmin.get(i);
                                                p.println(a.getID());
                                                p.println(a.getName());
                                                p.println(a.getDOB());
                                                p.println(a.getGender());
                                                p.println(a.getEmail());
                                                p.println(a.getIC());
                                                p.println(a.getPhone_number());
                                                p.println(a.getPassword());
                                                p.println(a.getTheme());
                                                p.println();
                                            }
                                            p.close();
                                            JOptionPane.showMessageDialog(null, "Updated!");
                                            OODJ_Assignment.adminPage.UpdateAfterModify();
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
    
    //change the text of all labels when the frame is shown
    public void componentShown(ComponentEvent e){
        label_username.setText(OODJ_Assignment.acc_login.getName());
        label_birth_dateV.setText(OODJ_Assignment.acc_login.getDOB());
        label_emailV.setText(OODJ_Assignment.acc_login.getEmail());
        label_genderV.setText(OODJ_Assignment.acc_login.getGender());
        label_ic_numberV.setText(OODJ_Assignment.acc_login.getIC());
        label_phone_numberV.setText(OODJ_Assignment.acc_login.getPhone_number());
        label_id.setText("ID: "+OODJ_Assignment.acc_login.getID());

        bg_acc_gender.setSelected(radioButton_acc_male.getModel(), true);

        create_admin_id();
        update_admin_table();
        update_coach_table();
        update_sport_table();
        update_centre_table();
        update_schedule_table();
        update_registeredStudent_table();

        //
        //statistic page
        //
        label_statistic_adminV.setText(String.valueOf(OODJ_Assignment.allAdmin.size()));
        label_statistic_coachesV.setText(String.valueOf(OODJ_Assignment.allCoach.size()));
        label_statistic_sportsV.setText(String.valueOf(OODJ_Assignment.allSport.size()));
        label_statistic_scheduleV.setText(String.valueOf(OODJ_Assignment.allSchedule.size()));
        label_statistic_studentsV.setText(String.valueOf(OODJ_Assignment.allStudent.size()));
        
        registeredSport_ranking();

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
    
    //reset the text field and combobox when this frame is hidden
    public void componentHidden(ComponentEvent e){
        cl.show(panel_cards, "profile");
        toggleButton_profile.setSelected(true);
        toggleButton_profile.setForeground(Color.WHITE);
        toggleButton_profile.setBackground(new Color(154,140,152).darker());
        
        textField_acc_email.setText("");
        textField_acc_name.setText("");
        textField_acc_phone_number.setText("");
        passwordField_acc_password.setText("");
        passwordField_acc_confirm_password.setText("");
        textField_acc_ic_number.setText("");
        combobox_acc_year.setSelectedIndex(0);
        combobox_acc_month.setSelectedIndex(0);
        combobox_acc_date.setSelectedIndex(0);
        
        OODJ_Assignment.homePage.setVisible(true);
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    } 
    
    //change the color of toggle button when one of them is clicked
    //loop all toggle button, if selected > darker color, if not selected > brighter color
    public void itemStateChanged(ItemEvent e){
        for(Component c : getContentPane().getComponents()) {
            if (c.getClass() == JToggleButton.class){
                JToggleButton temp = (JToggleButton) c;
                if (temp.isSelected()){
                    temp.setForeground(Color.WHITE);
                    temp.setBackground(new Color(154,140,152).darker());
                } else {
                    temp.setForeground(new Color(34,34,59));
                    temp.setBackground(new Color(154,140,152));
                }
            }
        }
    }
    
    //remove the text in the text field when user trys to type something
    public void focusGained(FocusEvent e){
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals("Search by entering keyword")){
            textField.setForeground(new Color(34,34,59)); 
            textField.setText("");
        }
    }
    
    //display the text if user is not going to enter anything
    public void focusLost(FocusEvent e){
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().equals("")){
            textField.setForeground(new Color(151,151,151)); 
            textField.setText("Search by entering keyword");
        }
    }
    
    //filter the table whenever ser type anything into search text field
    public void changedUpdate(DocumentEvent e) {
        filterTable(e);       
    }
    
    public void removeUpdate(DocumentEvent e) {
        filterTable(e);
    }
    
    public void insertUpdate(DocumentEvent e) {
        filterTable(e);
    }
    
}
