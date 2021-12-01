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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Coach_Page extends JFrame implements ActionListener, ItemListener, ComponentListener, FocusListener, DocumentListener, Theme_Setting {
    
    private ButtonGroup bg;
    private CardLayout cl = new CardLayout();
    private JButton button_home, button_logout, button_exit, button_modify, button_settings_save_theme, button_settings_password_change, button_settings_password_save,
            button_view_students;
    private ButtonGroup bg_feedback;
    private JComboBox combobox_settings_theme, combobox_search_schedule;
    private JLabel label_username, label_id, label_ic_numberL, label_birth_dateL, label_genderL, label_emailL, label_phone_numberL,
            label_ic_numberV, label_birth_dateV, label_genderV, label_emailV, label_phone_numberV, label_addressL, label_addressV, label_date_joinedL,
            label_date_joinedV, label_date_terminatedL, label_date_terminatedV, label_hourly_rateL, label_hourly_rateV, label_centre_codeL, label_centre_codeV,
            label_centre_nameL, label_centre_nameV, label_sport_codeL, label_sport_codeV, label_sport_nameL, label_sport_nameV, label_ratingL, label_ratingV,
            label_account_settings, label_settings_password_description, label_settings_current_password, label_settings_new_password, label_settings_confirm_password,
            label_assigned_schedule, label_feedback, label_filter_by;
    private JLabel labelPanel_profile, labelPanel_schedule, labelPanel_feedback, labelPanel_settings;
    private JPanel panel_cards, panel_settings_theme, panel_settings_password, panel_settings_password_pg1, panel_settings_password_pg2;
    private JRadioButton radioButton_all, radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    private JSeparator separator1, separator2;
    private JTable table_schedule, table_feedback;
    private JTextField textField_search_schedule, textField_settings_current_password, textField_settings_new_password, textField_settings_confirm_password;
    private JToggleButton toggleButton_profile, toggleButton_assigned_schedule, toggleButton_feedback, toggleButton_account_settings;
    private TableRowSorter<TableModel> rowSorter_schedule, rowSorter_feedback;
    
    public Coach_Page(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        addComponentListener(this);
        
        setSize(1000,800);
        setLocation(600,150);
        setTitle("Coach Page");
        setLayout(new GridBagLayout());
        this.setBackground(new Color(189,224,254));
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //Border b = BorderFactory.createEtchedBorder();
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
        toggleButton_profile.setBackground(new Color(205,180,219).darker());
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
        toggleButton_assigned_schedule = new JToggleButton("Assigned Schedule");
        toggleButton_assigned_schedule.setBackground(new Color(205,180,219));
        toggleButton_assigned_schedule.setForeground(new Color(94,100,114));  
        toggleButton_assigned_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_assigned_schedule.setBorder(b);
        add(toggleButton_assigned_schedule,gbc);
        toggleButton_assigned_schedule.addActionListener(this);
        toggleButton_assigned_schedule.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator1 = new JSeparator();
        separator1.setBackground(new Color(205,180,219));
        add(separator1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_feedback = new JToggleButton("Feedback");
        toggleButton_feedback.setBackground(new Color(205,180,219));
        toggleButton_feedback.setForeground(new Color(94,100,114)); 
        toggleButton_feedback.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_feedback.setBorder(b);
        add(toggleButton_feedback,gbc);
        toggleButton_feedback.addActionListener(this);
        toggleButton_feedback.addItemListener(this);       
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        toggleButton_account_settings = new JToggleButton("Account Settings");
        toggleButton_account_settings.setBackground(new Color(205,180,219));
        toggleButton_account_settings.setForeground(new Color(94,100,114)); 
        toggleButton_account_settings.setFont(new Font("Cambria Math",Font.PLAIN,20));
        toggleButton_account_settings.setBorder(b);
        add(toggleButton_account_settings,gbc);
        toggleButton_account_settings.addActionListener(this);
        toggleButton_account_settings.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        separator2 = new JSeparator();
        separator2.setBackground(new Color(205,180,219));
        add(separator2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 120;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_home = new JButton("Return Home Page");
        button_home.setBackground(new Color(255, 200, 221));
        button_home.setForeground(new Color(94,100,114)); 
        button_home.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_home.setBorder(b);
        add(button_home,gbc);
        button_home.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_logout = new JButton("Logout");
        button_logout.setBackground(new Color(255, 200, 221));
        button_logout.setForeground(new Color(94,100,114)); 
        button_logout.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_logout.setBorder(b);
        add(button_logout,gbc);
        button_logout.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
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
        bg.add(toggleButton_assigned_schedule);
        bg.add(toggleButton_feedback);
        bg.add(toggleButton_account_settings);       
                
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.weightx = 1;
        gbc.gridheight = 9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_cards = new JPanel();
        panel_cards.setLayout(cl); 
        add(panel_cards,gbc);
        
        ////////////////////////////////////////////////////////////////////////
        //Profile Panel                                                       //
        ////////////////////////////////////////////////////////////////////////
        
        ImageIcon i = new ImageIcon("images\\coach_profile_panel_background.png");
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
        label_username = new JLabel("testing");
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
        label_ic_numberL = new JLabel("IC/Passport Number: ");
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
        label_ic_numberV = new JLabel("000000-00-0000");
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
        label_birth_dateL = new JLabel("Birth Date: ");
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
        label_birth_dateV = new JLabel("00-00-0000");
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
        label_genderL = new JLabel("Gender: ");
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
        label_genderV = new JLabel("Male");
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
        label_emailL = new JLabel("Email Address: ");
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
        label_emailV = new JLabel("testing@gmail.com");
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
        label_phone_numberL = new JLabel("Phone Number: ");
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
        label_phone_numberV = new JLabel("000-0000000");
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
        label_addressL = new JLabel("Address: ");
        label_addressL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_addressL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_addressL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_addressL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_addressV = new JLabel("xxx, Taman Kinrara 123, Puchong, Selangor");
        label_addressV.setHorizontalAlignment(SwingConstants.LEFT);
        label_addressV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_addressV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_addressV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_joinedL = new JLabel("Date Joined: ");
        label_date_joinedL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_date_joinedL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_date_joinedL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_date_joinedL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_joinedV = new JLabel("00-00-0000");
        label_date_joinedV.setHorizontalAlignment(SwingConstants.LEFT);
        label_date_joinedV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_date_joinedV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_date_joinedV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_terminatedL = new JLabel("Date Terminated: ");
        label_date_terminatedL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_date_terminatedL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_date_terminatedL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_date_terminatedL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_terminatedV = new JLabel("00-00-0000");
        label_date_terminatedV.setHorizontalAlignment(SwingConstants.LEFT);
        label_date_terminatedV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_date_terminatedV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_date_terminatedV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_hourly_rateL = new JLabel("Hourly Rate: ");
        label_hourly_rateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_hourly_rateL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_hourly_rateL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_hourly_rateL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_hourly_rateV = new JLabel("RM 100/hr");
        label_hourly_rateV.setHorizontalAlignment(SwingConstants.LEFT);
        label_hourly_rateV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_hourly_rateV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_hourly_rateV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_codeL = new JLabel("Sport Centre Code: ");
        label_centre_codeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_codeL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_centre_codeL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_centre_codeL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_codeV = new JLabel("SC0001");
        label_centre_codeV.setHorizontalAlignment(SwingConstants.LEFT);
        label_centre_codeV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_centre_codeV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_centre_codeV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_nameL = new JLabel("Sport Centre: ");
        label_centre_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_nameL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_centre_nameL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_centre_nameL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_nameV = new JLabel("Petaling Branch");
        label_centre_nameV.setHorizontalAlignment(SwingConstants.LEFT);
        label_centre_nameV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_centre_nameV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_centre_nameV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_codeL = new JLabel("Sport Code: ");
        label_sport_codeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sport_codeL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_sport_codeL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_sport_codeL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_codeV = new JLabel("SP0001");
        label_sport_codeV.setHorizontalAlignment(SwingConstants.LEFT);
        label_sport_codeV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_sport_codeV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_sport_codeV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_nameL = new JLabel("Sport: ");
        label_sport_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sport_nameL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_sport_nameL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_sport_nameL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_nameV = new JLabel("Basketball");
        label_sport_nameV.setHorizontalAlignment(SwingConstants.LEFT);
        label_sport_nameV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_sport_nameV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_sport_nameV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.weightx = 0.55;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ratingL = new JLabel("Rating: ");
        label_ratingL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ratingL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ratingL.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_ratingL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ratingV = new JLabel("4/5");
        label_ratingV.setHorizontalAlignment(SwingConstants.LEFT);
        label_ratingV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_ratingV.setForeground(new Color(94,100,114)); 
        labelPanel_profile.add(label_ratingV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,0,10,0);
        button_modify = new JButton("Modify");
        button_modify.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_modify.setForeground(new Color(94,100,114)); 
        button_modify.setPreferredSize(new Dimension(180,40));
        labelPanel_profile.add(button_modify,gbc);
        button_modify.addActionListener(this);
        
        ////////////////////////////////////////////////////////////////////////
        //Assigned Schedule Panel                                             //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_schedule = new JLabel();
        labelPanel_schedule.setLayout(new GridBagLayout());
        labelPanel_schedule.setBackground(new Color(189,224,254));
        labelPanel_schedule.setOpaque(true);
        panel_cards.add(labelPanel_schedule, "schedule");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_assigned_schedule = new JLabel("Assigned Schedule");
        label_assigned_schedule.setHorizontalAlignment(SwingConstants.CENTER);
        label_assigned_schedule.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_assigned_schedule.setForeground(new Color(94,100,114)); 
        labelPanel_schedule.add(label_assigned_schedule,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,15);
        button_view_students = new JButton("View Student List");
        button_view_students.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_students.setForeground(new Color(94,100,114)); 
        button_view_students.setPreferredSize(new Dimension(650,300));
        labelPanel_schedule.add(button_view_students,gbc);
        button_view_students.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        textField_search_schedule = new JTextField();
        textField_search_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search_schedule.setForeground(new Color(151,151,151)); 
        textField_search_schedule.setText("Search by entering keyword");
        textField_search_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_schedule.add(textField_search_schedule,gbc);
        textField_search_schedule.addFocusListener(this);
        textField_search_schedule.getDocument().addDocumentListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,15);
        String[] search_student = {"Search All","Search by ID","Search by Centre","Search by Sport","Search by Day"};
        combobox_search_schedule = new JComboBox(search_student);
        combobox_search_schedule.setSelectedItem("Search All");
        combobox_search_schedule.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search_schedule.setForeground(new Color(94,100,114)); 
        combobox_search_schedule.setPreferredSize(new Dimension(650,300));
        labelPanel_schedule.add(combobox_search_schedule,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String schedule_column[] = {"ID","Centre","Sports","Day","Time"};
        String schedule_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","a","1"}};
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
        table_schedule.getColumnModel().getColumn(1).setPreferredWidth(180);
        table_schedule.getColumnModel().getColumn(2).setPreferredWidth(150);
        table_schedule.getColumnModel().getColumn(3).setPreferredWidth(130);
        table_schedule.getColumnModel().getColumn(4).setPreferredWidth(130);
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
        //Feedback Schedule                                                  //
        ////////////////////////////////////////////////////////////////////////
        
        labelPanel_feedback = new JLabel();
        labelPanel_feedback.setLayout(new GridBagLayout());
        labelPanel_feedback.setBackground(new Color(189,224,254));
        labelPanel_feedback.setOpaque(true);
        panel_cards.add(labelPanel_feedback, "feedback");
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.05;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,0);
        label_feedback = new JLabel("Feedback");
        label_feedback.setHorizontalAlignment(SwingConstants.CENTER);
        label_feedback.setFont(new Font("Cambria Math",Font.BOLD,40));
        label_feedback.setForeground(new Color(94,100,114)); 
        labelPanel_feedback.add(label_feedback,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,15,15,15);
        label_filter_by = new JLabel("Filter by Ratings: ");
        label_filter_by.setHorizontalAlignment(SwingConstants.LEFT);
        label_filter_by.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_filter_by.setForeground(new Color(94,100,114)); 
        labelPanel_feedback.add(label_filter_by,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton_all = new JRadioButton("All");
        radioButton_all.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton_all.setForeground(new Color(94,100,114)); 
        radioButton_all.setOpaque(false);
        labelPanel_feedback.add(radioButton_all,gbc);
        radioButton_all.addActionListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton1 = new JRadioButton("1");
        radioButton1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton1.setForeground(new Color(94,100,114)); 
        radioButton1.setOpaque(false);
        labelPanel_feedback.add(radioButton1,gbc);
        radioButton1.addActionListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton2 = new JRadioButton("2");
        radioButton2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton2.setForeground(new Color(94,100,114)); 
        radioButton2.setOpaque(false);
        labelPanel_feedback.add(radioButton2,gbc);
        radioButton2.addActionListener(this);
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton3 = new JRadioButton("3");
        radioButton3.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton3.setForeground(new Color(94,100,114)); 
        radioButton3.setOpaque(false);
        labelPanel_feedback.add(radioButton3,gbc);
        radioButton3.addActionListener(this);
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton4 = new JRadioButton("4");
        radioButton4.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton4.setForeground(new Color(94,100,114)); 
        radioButton4.setOpaque(false);
        labelPanel_feedback.add(radioButton4,gbc);
        radioButton4.addActionListener(this);
        
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,0);
        radioButton5 = new JRadioButton("5");
        radioButton5.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton5.setForeground(new Color(94,100,114)); 
        radioButton5.setOpaque(false);
        labelPanel_feedback.add(radioButton5,gbc);
        radioButton5.addActionListener(this);
        
        bg_feedback = new ButtonGroup();
        bg_feedback.add(radioButton_all);
        bg_feedback.add(radioButton1);
        bg_feedback.add(radioButton2);
        bg_feedback.add(radioButton3);
        bg_feedback.add(radioButton4);
        bg_feedback.add(radioButton5);
        radioButton_all.setSelected(true);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String feedback_column[] = {"Rating","Feedback"};
        String feedback_data[][]={ {"101","feedback1"}    
                          };
        table_feedback = new JTable(new DefaultTableModel(feedback_data,feedback_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_feedback.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_feedback.setForeground(new Color(94,100,114));
        table_feedback.setRowHeight(23);
        table_feedback.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_feedback.setAutoCreateRowSorter(true);
        table_feedback.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_feedback.getColumnModel().getColumn(1).setPreferredWidth(700);
        table_feedback.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_feedback.getTableHeader().setForeground(new Color(94,100,114));
        table_feedback.getTableHeader().setReorderingAllowed(false);
        rowSorter_feedback = new TableRowSorter<>(table_feedback.getModel());
        table_feedback.setRowSorter(rowSorter_feedback);
        
        JScrollPane sp_feedback = new JScrollPane(table_feedback);
        sp_feedback.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_feedback.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelPanel_feedback.add(sp_feedback,gbc);
        //table_coaches.getSelectionModel().addListSelectionListener(this);
        table_feedback.setRowSelectionInterval(0, 0);
        
        ////////////////////////////////////////////////////////////////////////
        //Account Settings Panel                                              //
        ////////////////////////////////////////////////////////////////////////
        
        i = new ImageIcon("images\\coach_settings_panel_background.png");
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
    
    //method to change to light theme
    public void lightTheme(){
        ImageIcon i = new ImageIcon("images\\coach_profile_panel_background.png");
        labelPanel_profile.setIcon(i);
        labelPanel_schedule.setBackground(new Color(189,224,254));
        labelPanel_feedback.setBackground(new Color(189,224,254));
        i = new ImageIcon("images\\coach_settings_panel_background.png");
        labelPanel_settings.setIcon(i);
    }
    
    //method to change to dark theme
    public void darkTheme(){
        ImageIcon i = new ImageIcon("images\\coach_profile_panel_background_dark.png");
        labelPanel_profile.setIcon(i);
        labelPanel_schedule.setBackground(new Color(0,31,58));
        labelPanel_feedback.setBackground(new Color(0,31,58));
        i = new ImageIcon("images\\coach_settings_panel_background_dark.png");
        labelPanel_settings.setIcon(i);
    }
    
    //change the password panel to page1 when user open settings page
    public void openSettingPage(){
        bg.setSelected(toggleButton_account_settings.getModel(), true);
        CardLayout layout = (CardLayout) panel_settings_password.getLayout();
        layout.show(panel_settings_password, "page1");
        cl.show(panel_cards, "settings");
        return;
    }
    
    //update the label text after user modify their own information
    public void UpdateAfterModify(){
        Coach coach = (Coach) OODJ_Assignment.acc_login;
        label_username.setText(coach.getName());
        label_id.setText("ID: "+coach.getID());
        label_ic_numberV.setText(coach.getIC());
        label_birth_dateV.setText(coach.getDOB());
        label_genderV.setText(coach.getGender());
        label_emailV.setText(coach.getEmail());
        label_phone_numberV.setText(coach.getPhone_number());
        label_addressV.setText(coach.getAddress());
        label_date_joinedV.setText(coach.getDate_joined());
        label_date_terminatedV.setText(coach.getDate_terminated());
        label_hourly_rateV.setText(String.valueOf(coach.getHourly_rate()));
        label_centre_nameV.setText(coach.getSports_Center());
        label_sport_nameV.setText(coach.getSport());
        label_ratingV.setText(String.valueOf(coach.getRating()));

        for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++){
            if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(coach.getSports_Center())){
                SportsCentre SC = OODJ_Assignment.allSportsCentre.get(i);
                label_centre_codeV.setText(SC.getCenter_id());
                for (int ii=0; ii<OODJ_Assignment.allSportsCentre.get(i).getSport().size(); ii++){
                    if (coach.getSport().equals(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getSport_name())){
                        label_sport_codeV.setText(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getId());
                    }
                }
            }
        }
    }
    
    // update the schedule table to display latest data
    public void update_schedule_table(){
        DefaultTableModel dm = (DefaultTableModel) table_schedule.getModel();
        dm.setRowCount(0);

        for (int i=0; i<OODJ_Assignment.allSchedule.size(); i++){
            if (OODJ_Assignment.acc_login.getName().equals(OODJ_Assignment.allSchedule.get(i).getCoach())) {
                String id = OODJ_Assignment.allSchedule.get(i).getId();
                String centre_name = OODJ_Assignment.allSchedule.get(i).getCentre_name();
                //String date = OODJ_Assignment.allSchedule.get(i).getDate();
                String day = OODJ_Assignment.allSchedule.get(i).getDay().toString();
                String time = OODJ_Assignment.allSchedule.get(i).getTime().toString();
                String timing = time.replace('$', ' ');
                String sport_name = OODJ_Assignment.allSchedule.get(i).getSport().get(0).getSport_name();

                Object[] schedule_d = {id, centre_name, sport_name, day, timing};

                dm.addRow(schedule_d);
            }
        }
    }

    //update the feedback table to display latest data
    public void update_feedback_table(){
        DefaultTableModel dm = (DefaultTableModel) table_feedback.getModel();
        dm.setRowCount(0);

        for (int i=0; i<OODJ_Assignment.allRateCoach.size(); i++){
            if (OODJ_Assignment.acc_login.getID().equals(OODJ_Assignment.allRateCoach.get(i).getCoach_id())) {
                String rating = String.valueOf(OODJ_Assignment.allRateCoach.get(i).getRating());
                String feedback = OODJ_Assignment.allRateCoach.get(i).getFeedback();

                Object[] feedback_d = {rating, feedback};

                dm.addRow(feedback_d);
            }
        }
    }

    //method to check whether a schedule is selected in schedule table
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
    
    //filter schedule table if the argument passed is document event
    //filer the table based on keyword entered by users
    public void filterTable(DocumentEvent e){       
        if(e.getDocument() == textField_search_schedule.getDocument()){
            String keyword = textField_search_schedule.getText().trim();
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
        }
    }
    
    //filter the feedback table is an integer is passed as argument
    //filter the table according to the rating selected by user
    public void filterTable(int i){
        switch (i){
            case 0:
                rowSorter_feedback.setRowFilter(null);
                break;
            case 1:
                rowSorter_feedback.setRowFilter(RowFilter.regexFilter("(?i)"+"1",0));
                break;
            case 2:
                rowSorter_feedback.setRowFilter(RowFilter.regexFilter("(?i)"+"2",0));
                break;
            case 3:
                rowSorter_feedback.setRowFilter(RowFilter.regexFilter("(?i)"+"3",0));
                break;
            case 4:
                rowSorter_feedback.setRowFilter(RowFilter.regexFilter("(?i)"+"4",0));
                break;
            case 5:
                rowSorter_feedback.setRowFilter(RowFilter.regexFilter("(?i)"+"5",0));
                break;
        }
    }
    
    //method to update the text file
    public void saveCoachTxt(){
        try {
            PrintWriter p = new PrintWriter("coach.txt");
            for (int ii = 0; ii < OODJ_Assignment.allCoach.size(); ii++) {
                Coach ch = OODJ_Assignment.allCoach.get(ii);
                p.println(ch.getID());
                p.println(ch.getName());
                p.println(ch.getDOB());
                p.println(ch.getGender());
                p.println(ch.getEmail());
                p.println(ch.getIC());
                p.println(ch.getPhone_number());
                p.println(ch.getPassword());
                p.println(ch.getAddress());
                p.println(ch.getDate_joined());
                p.println(ch.getDate_terminated());
                p.println(ch.getSports_Center());
                p.println(ch.getSport());
                p.println(ch.getFeedback());
                p.println(ch.getHourly_rate());
                p.println(ch.getRating());
                p.println(ch.getTheme());
                p.println();
            }
            p.close();
            OODJ_Assignment.coachPage.UpdateAfterModify();
            JOptionPane.showMessageDialog(null, "Updated.");

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
            
        } else if (e.getSource() == toggleButton_assigned_schedule){
            
            cl.show(panel_cards, "schedule");
            
        } else if (e.getSource() == toggleButton_feedback){
            
            cl.show(panel_cards, "feedback");
            
        } else if (e.getSource() == toggleButton_account_settings){
            
            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
            layout.show(panel_settings_password, "page1");
            cl.show(panel_cards, "settings");
            
        } else if (e.getSource() == button_modify){
            
            OODJ_Assignment.modifyCoachInformation.setVisible(true);
            
        } else if (e.getSource() == button_settings_password_change){
            
            CardLayout layout = (CardLayout) panel_settings_password.getLayout();
            layout.next(panel_settings_password);
            
        } else if (e.getSource() == radioButton_all){
            
            filterTable(0);                     //filter feedback table whenever user select a radio button
            
        } else if (e.getSource() == radioButton1){
            
            filterTable(1);
            
        } else if (e.getSource() == radioButton2){
            
            filterTable(2);
            
        } else if (e.getSource() == radioButton3){
            
            filterTable(3);
            
        } else if (e.getSource() == radioButton4){
            
            filterTable(4);
            
        } else if (e.getSource() == radioButton5){
            
            filterTable(5);
                      
        } else if (e.getSource() == button_view_students){
            
            //if a schedule is selected, shows the viewRegisteredStudents page
            if (getScheduleTableIndex()) {
                String id = table_schedule.getValueAt(table_schedule.getSelectedRow(), 0).toString();
                for (int i=0;i<OODJ_Assignment.allSchedule.size();i++) {
                    if (OODJ_Assignment.allSchedule.get(i).getId().equals(id)) {
                        OODJ_Assignment.viewRegisteredStudents.getScheduleIndex=i;

                    }
                }
                OODJ_Assignment.viewRegisteredStudents.update_registered_table();
                OODJ_Assignment.viewRegisteredStudents.setVisible(true);
            }
            
        } else if (e.getSource() == button_settings_save_theme){
            
            //change the theme and update text file
            switch(combobox_settings_theme.getSelectedItem().toString()){
                case "Light Theme":
                    lightTheme();
                    OODJ_Assignment.acc_login.setTheme("light");
                    saveCoachTxt();
                    break;
                case "Dark Theme":
                    darkTheme();
                    OODJ_Assignment.acc_login.setTheme("dark");
                    saveCoachTxt();
                    break;
            }
            
        } else if (e.getSource()==button_settings_password_save){

            //if all the information is filled and valid
            if (!textField_settings_current_password.getText().isEmpty() && !textField_settings_new_password.getText().isEmpty()&& !textField_settings_confirm_password.getText().isEmpty()){
                if (textField_settings_current_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){
                    if (textField_settings_new_password.getText().length() >= 6){
                        if (textField_settings_new_password.getText().equals(textField_settings_confirm_password.getText())){
                            if (!textField_settings_new_password.getText().equals(OODJ_Assignment.acc_login.getPassword())){
                                for (int i=0; i<OODJ_Assignment.allCoach.size(); i++){
                                    if (OODJ_Assignment.acc_login.getID().equals(OODJ_Assignment.allCoach.get(i).getID())){
                                        Coach c = OODJ_Assignment.allCoach.get(i);

                                        c.setPassword(textField_settings_new_password.getText());
                                        
                                        //update the text file after password is changed successfully
                                        try {
                                            PrintWriter p = new PrintWriter("coach.txt");
                                            for (int ii = 0; ii < OODJ_Assignment.allCoach.size(); ii++) {
                                                Coach ch = OODJ_Assignment.allCoach.get(ii);
                                                p.println(ch.getID());
                                                p.println(ch.getName());
                                                p.println(ch.getDOB());
                                                p.println(ch.getGender());
                                                p.println(ch.getEmail());
                                                p.println(ch.getIC());
                                                p.println(ch.getPhone_number());
                                                p.println(ch.getPassword());
                                                p.println(ch.getAddress());
                                                p.println(ch.getDate_joined());
                                                p.println(ch.getDate_terminated());
                                                p.println(ch.getSports_Center());
                                                p.println(ch.getSport());
                                                p.println(ch.getFeedback());
                                                p.println(ch.getHourly_rate());
                                                p.println(ch.getRating());
                                                p.println(ch.getTheme());
                                                p.println();
                                            }
                                            p.close();
                                            OODJ_Assignment.coachPage.UpdateAfterModify();
                                            JOptionPane.showMessageDialog(null, "Updated.");
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
    
    //change the color of toggle button whenver any of them is selected
    //loop all toggle button, if is selected > darker color, if is not selected > brighter color
    public void itemStateChanged(ItemEvent e){
        for(Component c : getContentPane().getComponents()) {
            if (c.getClass() == JToggleButton.class){
                JToggleButton temp = (JToggleButton) c;
                if (temp.isSelected()){
                    temp.setBackground(new Color(205,180,219).darker());
                    temp.setForeground(Color.WHITE);
                } else {
                    temp.setForeground(new Color(94,100,114));
                    temp.setBackground(new Color(205,180,219));
                }
            }
        }
    }
    
    //update the text of all labels when the frame is shown
    public void componentShown(ComponentEvent e){
        Coach coach = (Coach) OODJ_Assignment.acc_login;
        label_username.setText(coach.getName());
        label_id.setText("ID: "+coach.getID());
        label_ic_numberV.setText(coach.getIC());
        label_birth_dateV.setText(coach.getDOB());
        label_genderV.setText(coach.getGender());
        label_emailV.setText(coach.getEmail());
        label_phone_numberV.setText(coach.getPhone_number());
        label_addressV.setText(coach.getAddress());
        label_date_joinedV.setText(coach.getDate_joined());
        label_date_terminatedV.setText(coach.getDate_terminated());
        label_hourly_rateV.setText(String.valueOf(coach.getHourly_rate()));
        label_centre_nameV.setText(coach.getSports_Center());
        label_sport_nameV.setText(coach.getSport());
        label_ratingV.setText(String.valueOf(coach.getRating()));

        for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++){
            if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(coach.getSports_Center())){
                SportsCentre SC = OODJ_Assignment.allSportsCentre.get(i);
                label_centre_codeV.setText(SC.getCenter_id());
                for (int ii=0; ii<OODJ_Assignment.allSportsCentre.get(i).getSport().size(); ii++){
                    if (coach.getSport().equals(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getSport_name())){
                        label_sport_codeV.setText(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getId());
                    }
                }
            }
        }
        
        update_schedule_table();
        update_feedback_table();

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
        
    //change the page back to profile when the frame is hidden
    public void componentHidden(ComponentEvent e){
        //CardLayout cl = (CardLayout) panel_cards.getLayout();
        cl.show(panel_cards, "profile");
        toggleButton_profile.setSelected(true);
        toggleButton_profile.setBackground(new Color(205,180,219).darker());
        toggleButton_profile.setForeground(Color.WHITE);
        OODJ_Assignment.homePage.setVisible(true);
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    }    
    
    //remove the text if the user is going to type something in text field
    public void focusGained(FocusEvent e){
        if (textField_search_schedule.getText().equals("Search by entering keyword")){
            textField_search_schedule.setForeground(new Color(94,100,114)); 
            textField_search_schedule.setText("");
        }
    }
    
    //add the text if the user is not going to type anything to the text field
    public void focusLost(FocusEvent e){
        if (textField_search_schedule.getText().equals("")){
            textField_search_schedule.setForeground(new Color(151,151,151)); 
            textField_search_schedule.setText("Search by entering keyword");
        }
    }
    
    //filter the table whenever user type something into text field
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
