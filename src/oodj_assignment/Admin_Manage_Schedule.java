package oodj_assignment;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin_Manage_Schedule extends JDialog implements Admin_Management, ActionListener, ComponentListener, ItemListener {
    
    private CardLayout cl = new CardLayout();
    private JButton button_view_registered_students, button_save_changes, button_add;
    private JComboBox combobox_modify_sport_name, combobox_modify_centre_name, combobox_modify_day, combobox_modify_time, combobox_modify_coach,
                        combobox_add_sport_name, combobox_add_centre_name, combobox_add_day, combobox_add_time, combobox_add_coach;
    private JLabel label_idL, label_sport_codeL, label_sport_nameL, label_centre_codeL, label_centre_nameL, label_dayL, label_timeL, label_coachL,
                    label_view_id, label_view_sport_code, label_view_sport_name, label_view_centre_code, label_view_centre_name, label_view_day, label_view_time, label_view_coach,
                    label_modify_id, label_modify_sport_code, label_modify_centre_code, label_add_sport_code, label_add_centre_code;
    private JPanel panel_main, panel_labels, panel_cards, panel_view, panel_modify, panel_add;
    private JTextField textField_add_id;
    private TitledBorder border_view, border_modify, border_add;
    public int getScheduleIndex;
    
    public Admin_Manage_Schedule(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(600,700);
        setLocation(800,175);
        setTitle("Schedule");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Schedule");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_modify = BorderFactory.createTitledBorder("Modify Schedule");
        border_modify.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_add = BorderFactory.createTitledBorder("Add Schedule");
        border_add.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        //labels panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_labels = new JPanel();
        panel_labels.setLayout(new GridBagLayout());
        panel_labels.setOpaque(false);
        panel_main.add(panel_labels,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_idL = new JLabel("ID:  ");
        label_idL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_idL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_idL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_idL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_codeL = new JLabel("Sport Code:  ");
        label_sport_codeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sport_codeL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_sport_codeL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_sport_codeL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_nameL = new JLabel("Sport Name:  ");
        label_sport_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sport_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_sport_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_sport_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_codeL = new JLabel("Centre Code:  ");
        label_centre_codeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_codeL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_centre_codeL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_centre_codeL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_nameL = new JLabel("Centre Name:  ");
        label_centre_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_centre_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_centre_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dayL = new JLabel("Day:  ");
        label_dayL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_dayL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_dayL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_dayL,gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_timeL = new JLabel("Time:  ");
        label_timeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_timeL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_timeL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_timeL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_coachL = new JLabel("Coach:  ");
        label_coachL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_coachL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_coachL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_coachL,gbc);
        
        //cards panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_cards = new JPanel();
        panel_cards.setLayout(cl);
        panel_cards.setOpaque(false);
        panel_main.add(panel_cards,gbc);
        
        //view panel
        panel_view = new JPanel(new GridBagLayout());
        panel_view.setOpaque(false);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_id = new JLabel("12345");
        label_view_id.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_id.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_id,gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_sport_code = new JLabel("SP0001");
        label_view_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_sport_code.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_sport_name = new JLabel("Basketball");
        label_view_sport_name.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_sport_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_sport_name.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_sport_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_centre_code = new JLabel("SC0001");
        label_view_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_centre_code.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_centre_name = new JLabel("Petaling Branch");
        label_view_centre_name.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_centre_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_centre_name.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_centre_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_day = new JLabel("Monday");
        label_view_day.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_day.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_day,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_time = new JLabel("9AM to 11AM");
        label_view_time.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_time.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_time.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_time,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_coach = new JLabel("Jason Leong");
        label_view_coach.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_coach.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_coach,gbc);                
        
        //modify panel
        panel_modify = new JPanel(new GridBagLayout());
        panel_modify.setOpaque(false);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_modify_id = new JLabel("12345");
        label_modify_id.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_id.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,20);
        label_modify_sport_code = new JLabel("SP0001");
        label_modify_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_sport_code.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,3,20);
        String[] sports = {"Basketball","Tennis"};
        combobox_modify_sport_name = new JComboBox(sports);
        combobox_modify_sport_name.setEditable(true);
        combobox_modify_sport_name.setSelectedItem("Sport Name");
        combobox_modify_sport_name.setEditable(false);
        combobox_modify_sport_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_sport_name.setForeground(new Color(34,34,59)); 
        panel_modify.add(combobox_modify_sport_name,gbc);
        combobox_modify_sport_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,20);
        label_modify_centre_code = new JLabel("SC0001");
        label_modify_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_centre_code.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,20);
        String sport_centre[] = {"Petaling Branch","Kuala Selangor Branch","Klang Branch","Sepang Branch","Hulu Langat Branch"};
        combobox_modify_centre_name = new JComboBox(sport_centre);
        combobox_modify_centre_name.setEditable(true);
        combobox_modify_centre_name.setSelectedItem("Centre Name");
        combobox_modify_centre_name.setEditable(false);
        combobox_modify_centre_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_centre_name.setForeground(new Color(34,34,59)); 
        panel_modify.add(combobox_modify_centre_name,gbc);
        combobox_modify_centre_name.addItemListener(this);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String[] day = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        combobox_modify_day = new JComboBox(day);
        combobox_modify_day.setEditable(true);
        combobox_modify_day.setSelectedItem("Day");
        combobox_modify_day.setEditable(false);
        combobox_modify_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_day.setForeground(new Color(34,34,59));
        panel_modify.add(combobox_modify_day,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String[] time = {"9AM to 11AM","10AM to 12PM","11AM to 1PM","1PM to 3PM","2PM to 4PM",
                            "3PM to 5PM","4PM to 6PM","5PM to 7PM","8PM to 10PM"};
        combobox_modify_time = new JComboBox(time);
        combobox_modify_time.setEditable(true);
        combobox_modify_time.setSelectedItem("Time");
        combobox_modify_time.setEditable(false);
        combobox_modify_time.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_time.setForeground(new Color(34,34,59));
        panel_modify.add(combobox_modify_time,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String[] coach = {};
        combobox_modify_coach = new JComboBox(coach);
        combobox_modify_coach.setEditable(true);
        combobox_modify_coach.setSelectedItem("Coach");
        combobox_modify_coach.setEditable(false);
        combobox_modify_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_coach.setForeground(new Color(34,34,59));
        panel_modify.add(combobox_modify_coach,gbc);        
        
        //add panel
        panel_add = new JPanel(new GridBagLayout());
        panel_add.setOpaque(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(3,0,0,20);
        textField_add_id = new JTextField();
        textField_add_id.setEnabled(false);
        textField_add_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_add.add(textField_add_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_add_sport_code = new JLabel("SP0001");
        label_add_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_add_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_add_sport_code.setForeground(new Color(34,34,59)); 
        panel_add.add(label_add_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_sport_name = new JComboBox(sports);
        combobox_add_sport_name.setEditable(true);
        combobox_add_sport_name.setSelectedItem("Sport Name");
        combobox_add_sport_name.setEditable(false);
        combobox_add_sport_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_sport_name.setForeground(new Color(34,34,59)); 
        panel_add.add(combobox_add_sport_name,gbc);
        combobox_add_sport_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_add_centre_code = new JLabel("SC0001");
        label_add_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_add_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_add_centre_code.setForeground(new Color(34,34,59)); 
        panel_add.add(label_add_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,20);
        combobox_add_centre_name = new JComboBox(sport_centre);
        combobox_add_centre_name.setEditable(true);
        combobox_add_centre_name.setSelectedItem("Centre Name");
        combobox_add_centre_name.setEditable(false);
        combobox_add_centre_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_centre_name.setForeground(new Color(34,34,59)); 
        panel_add.add(combobox_add_centre_name,gbc);
        combobox_add_centre_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_day = new JComboBox(day);
        combobox_add_day.setEditable(true);
        combobox_add_day.setSelectedItem("Day");
        combobox_add_day.setEditable(false);
        combobox_add_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_day.setForeground(new Color(34,34,59));
        panel_add.add(combobox_add_day,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_time = new JComboBox(time);
        combobox_add_time.setEditable(true);
        combobox_add_time.setSelectedItem("Time");
        combobox_add_time.setEditable(false);
        combobox_add_time.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_time.setForeground(new Color(34,34,59));
        panel_add.add(combobox_add_time,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 0.6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_coach = new JComboBox(coach);
        combobox_add_coach.setEditable(true);
        combobox_add_coach.setSelectedItem("Coach");
        combobox_add_coach.setEditable(false);
        combobox_add_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_coach.setForeground(new Color(34,34,59));
        panel_add.add(combobox_add_coach,gbc);
        
        panel_cards.add(panel_view, "view");
        panel_cards.add(panel_modify,"modify");
        panel_cards.add(panel_add,"add");
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_save_changes = new JButton("Save Changes");
        button_save_changes.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_save_changes.setForeground(new Color(34,34,59)); 
        button_save_changes.setPreferredSize(new Dimension(200,50));
        button_save_changes.setVisible(false);
        panel_main.add(button_save_changes,gbc);
        button_save_changes.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_add = new JButton("Add");
        button_add.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_add.setForeground(new Color(34,34,59)); 
        button_add.setPreferredSize(new Dimension(200,50));
        button_add.setVisible(false);
        panel_main.add(button_add,gbc);
        button_add.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        button_view_registered_students = new JButton("View Registered Student");
        button_view_registered_students.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_view_registered_students.setForeground(new Color(34,34,59)); 
        button_view_registered_students.setPreferredSize(new Dimension(300,50));
        panel_main.add(button_view_registered_students,gbc);
        button_view_registered_students.addActionListener(this);
        
        setModal(true);             //set other page cannot be access until this window is closed
                
    }
    
    //panel_main getter
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    //method to check whether the selected time crash with another
    //eg. 9-11AM cannot be selected if the coach has a class from 10AM to 12PM
    //use .getCode() from Time Enum to get the code of each time slot 
    public boolean timeValidity(int selectedTimeCode, String selectedCoach, String selectedDay){
        boolean flag = true;
        for (Schedule schedule : OODJ_Assignment.allSchedule){
            if (selectedCoach.equals(schedule.getCoach()) && selectedDay.equals(schedule.getDay().toString())){
                if (selectedTimeCode == 2 || selectedTimeCode == 5 || selectedTimeCode == 6 || selectedTimeCode == 7){
                    if (schedule.getTime().getCode() == selectedTimeCode || schedule.getTime().getCode() == selectedTimeCode-1 || 
                            schedule.getTime().getCode() == selectedTimeCode+1){
                        flag = false;
                        break;
                    }
                } else if (selectedTimeCode == 1 || selectedTimeCode == 4){
                    if (schedule.getTime().getCode() == selectedTimeCode || schedule.getTime().getCode() == selectedTimeCode+1){
                        flag = false;
                        break;
                    }
                } else if (selectedTimeCode == 3 || selectedTimeCode == 8){
                    if (schedule.getTime().getCode() == selectedTimeCode || schedule.getTime().getCode() == selectedTimeCode-1){                        
                        flag = false;
                        break;
                    }
                } else if (selectedTimeCode == 9){
                    if (schedule.getTime().getCode() == selectedTimeCode){
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }
    
    //if the view button is clicked in admin page
    public void viewClicked(){
        panel_main.setBorder(border_view);
        cl.show(panel_cards, "view");
        button_save_changes.setVisible(false);
        button_add.setVisible(false);
        button_view_registered_students.setVisible(true);
    }
    
    //if the modify button is clicked in admin page
    public void modifyClicked(){
        panel_main.setBorder(border_modify);
        cl.show(panel_cards, "modify");
        button_view_registered_students.setVisible(false);        
        button_add.setVisible(false);
        button_save_changes.setVisible(true);
    }
    
    //if the add button is clicked in admin page
    public void addClicked(){
        panel_main.setBorder(border_add);
        cl.show(panel_cards, "add");
        button_view_registered_students.setVisible(false);
        button_save_changes.setVisible(false);
        button_add.setVisible(true);
    }
    
    //method to generate new schedule id
    //get the current number of schedule+1
    public void create_schedule_id(){
        int id_count =OODJ_Assignment.allSchedule.size()+1;
        if (String.valueOf(id_count).length()==1){
            textField_add_id.setText("SD"+"000"+id_count);
        }else if (String.valueOf(id_count).length()==2){
            textField_add_id.setText("SD"+"00"+id_count);
        }else if (String.valueOf(id_count).length()==3){
            textField_add_id.setText("SD"+"0"+id_count);
        }else if (String.valueOf(id_count).length()==4){
            textField_add_id.setText("SD"+id_count);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_add){
            
            String time = "$"+combobox_add_time.getSelectedItem().toString().replace(' ','$');
            String day = combobox_add_day.getSelectedItem().toString();
            String coach = combobox_add_coach.getSelectedItem().toString();
            //if all the info is selected and valid
            if (!combobox_add_day.getSelectedItem().equals("Day") && !combobox_add_time.getSelectedItem().equals("Time") && !combobox_add_coach.getSelectedItem().equals("Select Coach")) {
                for (int i = 0; i < OODJ_Assignment.allSport.size(); i++) {
                    if (combobox_add_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(i).getSport_name())) {
                        ArrayList<Sport> sport = new ArrayList<>();
                        sport.add(OODJ_Assignment.allSport.get(i));
                        Schedule sch = new Schedule(textField_add_id.getText(), combobox_add_centre_name.getSelectedItem().toString(), coach, Day.valueOf(day), Time.valueOf(time), sport);
                        //if the time slot is not crash with another schedule
                        //update the allSchedule arraylist
                        if (timeValidity(sch.getTime().getCode(), sch.getCoach(), sch.getDay().toString())) {
                            boolean flag_check_schedule = true;

                            for (int x = 0; x < OODJ_Assignment.allSchedule.size(); x++) {
                                if (OODJ_Assignment.allSchedule.get(x).getCoach().equals(sch.getCoach()) && OODJ_Assignment.allSchedule.get(x).getTime().getCode() == sch.getTime().getCode() &&
                                        OODJ_Assignment.allSchedule.get(x).getDay().equals(sch.getDay()) && OODJ_Assignment.allSchedule.get(x).getCentre_name().equals(sch.getCentre_name())) {
                                    if (OODJ_Assignment.allSchedule.get(x).getTime().getCode() == sch.getTime().getCode() &&
                                            OODJ_Assignment.allSchedule.get(x).getDay().equals(sch.getDay()) && OODJ_Assignment.allSchedule.get(x).getCentre_name().equals(sch.getCentre_name())) {
                                        flag_check_schedule = false;
                                        break;
                                    }

                                }
                            }
                            if (flag_check_schedule) {
                                OODJ_Assignment.allSchedule.add(sch);
                                //update text file
                                try {
                                    PrintWriter p = new PrintWriter("schedule.txt");
                                    for (int y = 0; y < OODJ_Assignment.allSchedule.size(); y++) {
                                        Schedule sc = OODJ_Assignment.allSchedule.get(y);
                                        p.println(sc.getId());
                                        p.println(sc.getSport().get(0).getSport_name());
                                        p.println(sc.getCentre_name());
                                        p.println(sc.getDay());
                                        p.println(sc.getTime());
                                        p.println(sc.getCoach());
                                        p.println();
                                    }
                                    p.close();
                                    JOptionPane.showMessageDialog(null, "Schedule " + sch.getId() + " has been created.");
                                    OODJ_Assignment.adminPage.update_schedule_table();
                                    this.setVisible(false);
                                } catch (FileNotFoundException fileNotFoundException) {
                                    //fileNotFoundException.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This time and day might be scheduled for this coach (" + combobox_add_coach.getSelectedItem() + ") at " + combobox_add_centre_name.getSelectedItem());
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "This time and day might be scheduled for this coach (" + combobox_add_coach.getSelectedItem() + ") at " + combobox_add_centre_name.getSelectedItem());
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill up all the blanks.");
            }
            
        } else if (e.getSource()==button_save_changes){
            
            String time = "$"+combobox_modify_time.getSelectedItem().toString().replace(' ','$');
            String day = combobox_modify_day.getSelectedItem().toString();
            String coach = combobox_modify_coach.getSelectedItem().toString();
            
            for(int i=0; i<OODJ_Assignment.allSport.size(); i++){
                if (combobox_modify_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(i).getSport_name())){
                    ArrayList<Sport> sport = new ArrayList<>();
                    sport.add(OODJ_Assignment.allSport.get(i));
                    Schedule sch = new Schedule(label_modify_id.getText(), combobox_modify_centre_name.getSelectedItem().toString(), coach, Day.valueOf(day), Time.valueOf(time), sport);
                    //check whether the time crash with another time slot
                    if (timeValidity(sch.getTime().getCode(), sch.getCoach(), sch.getDay().toString())){
                        boolean flag_check_schedule= true;
                        for (int x=0; x<OODJ_Assignment.allSchedule.size();x++){
                            if (OODJ_Assignment.allSchedule.get(x).getCoach().equals(sch.getCoach())&& OODJ_Assignment.allSchedule.get(x).getTime().getCode()==sch.getTime().getCode()&&
                                    OODJ_Assignment.allSchedule.get(x).getDay().equals(sch.getDay()) && OODJ_Assignment.allSchedule.get(x).getCentre_name().equals(sch.getCentre_name())){
                                if (OODJ_Assignment.allSchedule.get(x).getTime().getCode()==sch.getTime().getCode()&&
                                        OODJ_Assignment.allSchedule.get(x).getDay().equals(sch.getDay()) && OODJ_Assignment.allSchedule.get(x).getCentre_name().equals(sch.getCentre_name())) {
                                    flag_check_schedule = false;
                                    break;
                                }
                            }
                        }
                        //update the allSport ArrayList
                        if (flag_check_schedule){
                            OODJ_Assignment.allSchedule.get(getScheduleIndex).setCentre_name(sch.getCentre_name());
                            OODJ_Assignment.allSchedule.get(getScheduleIndex).setCoach(sch.getCoach());
                            OODJ_Assignment.allSchedule.get(getScheduleIndex).setDay(sch.getDay());
                            OODJ_Assignment.allSchedule.get(getScheduleIndex).setTime(Time.valueOf(sch.getTime().toString()));
                            OODJ_Assignment.allSchedule.get(getScheduleIndex).setSport(sch.getSport());
                            
                            //update the text file
                            try {
                                PrintWriter p = new PrintWriter("schedule.txt");
                                for (int y=0; y<OODJ_Assignment.allSchedule.size(); y++){
                                    Schedule sc = OODJ_Assignment.allSchedule.get(y);
                                    p.println(sc.getId());
                                    p.println(sc.getSport().get(0).getSport_name());
                                    p.println(sc.getCentre_name());
                                    p.println(sc.getDay());
                                    p.println(sc.getTime());
                                    p.println(sc.getCoach());
                                    p.println();

                                }
                                p.close();
                                JOptionPane.showMessageDialog(null, "Schedule "+sch.getId()+" has been updated.");
                                OODJ_Assignment.adminPage.update_schedule_table();
                            } catch (FileNotFoundException fileNotFoundException) {
                                //fileNotFoundException.printStackTrace();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "This time and day might be scheduled for this coach ("+combobox_add_coach.getSelectedItem()+") at "+combobox_add_centre_name.getSelectedItem());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This time and day might be scheduled for this coach (" + combobox_add_coach.getSelectedItem() + ") at " + combobox_add_centre_name.getSelectedItem());
                    }
                }
            }

        } else if (e.getSource()==button_view_registered_students){
            
            //open the frame and display all the students who registered this schedule
            OODJ_Assignment.viewRegisteredStudents.getScheduleIndex = getScheduleIndex;
            OODJ_Assignment.viewRegisteredStudents.update_registered_table();
            OODJ_Assignment.viewRegisteredStudents.setVisible(true);

        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {
        
        create_schedule_id();
        if (OODJ_Assignment.allSchedule.size() != 0){
            //
            //view function - change the text of labels
            //
            label_view_id.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getId());
            label_view_coach.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getCoach());
            label_view_centre_name.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getCentre_name());
            label_view_day.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getDay().toString());
            label_view_time.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getTime().toString().replace('$', ' '));
            for (int i=0; i<OODJ_Assignment.allSportsCentre.size();i++){
                if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(OODJ_Assignment.allSchedule.get(getScheduleIndex).getCentre_name())){
                    label_view_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                    label_modify_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                }
            }
            String sport_name= new String();
            String sport_id = new String();
            for (int i=0;i<OODJ_Assignment.allSport.size(); i++) {
                for (int s = 0; s < OODJ_Assignment.allSchedule.get(getScheduleIndex).getSport().size(); s++) {
                    if (OODJ_Assignment.allSport.get(i).getSport_name().equals(OODJ_Assignment.allSchedule.get(getScheduleIndex).getSport().get(s).getSport_name())){
                        sport_name = sport_name+","+OODJ_Assignment.allSport.get(i).getSport_name();
                        sport_id = sport_id+","+OODJ_Assignment.allSport.get(i).getId();
                    }
                }
            }
            label_view_sport_code.setText(sport_id.substring(1));
            label_view_sport_name.setText(sport_name.substring(1));

            //
            //modify function - read the data of selected schedule and change the item of combobox
            //
            label_modify_id.setText(OODJ_Assignment.allSchedule.get(getScheduleIndex).getId());
            label_modify_sport_code.setText(sport_id.substring(1));

            combobox_modify_centre_name.removeAllItems();
            for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++){
                combobox_modify_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(i).getCenter_name());

            }

            combobox_modify_sport_name.removeAllItems();
            for (int i=0; i<OODJ_Assignment.allSport.size(); i++){
                combobox_modify_sport_name.addItem(OODJ_Assignment.allSport.get(i).getSport_name());
            }

            combobox_modify_sport_name.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getSport().get(0).getSport_name());
            combobox_modify_centre_name.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getCentre_name());

            combobox_modify_day.setEditable(true);
            combobox_modify_day.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getDay().toString());
            combobox_modify_day.setEditable(false);
            //combobox_modify_time.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getTime().toString().replace('$',' '));
            combobox_modify_time.setEditable(true);
            combobox_modify_time.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getTime().toString().replace('$',' '));
            combobox_modify_time.setEditable(false);
            combobox_modify_coach.setEditable(true);
            combobox_modify_coach.setSelectedItem(OODJ_Assignment.allSchedule.get(getScheduleIndex).getCoach());
            combobox_modify_coach.setEditable(false);
        }
        

        //
        //Add function - reset all the selected item in combobox
        //
        combobox_add_sport_name.removeAllItems();
        for (int i=0; i<OODJ_Assignment.allSport.size();i++){
            combobox_add_sport_name.addItem(OODJ_Assignment.allSport.get(i).getSport_name());
        }
        combobox_add_centre_name.setEditable(true);
        combobox_add_centre_name.setSelectedItem("Select centre");
        combobox_add_centre_name.setEditable(false);
        combobox_add_day.setEditable(true);
        combobox_add_day.setSelectedItem("Day");
        combobox_add_day.setEditable(false);
        combobox_add_time.setEditable(true);
        combobox_add_time.setSelectedItem("Time");
        combobox_add_time.setEditable(false);
        combobox_add_coach.setEditable(true);
        combobox_add_coach.setSelectedItem("Coach");
        combobox_add_coach.setEditable(false);

    }

    public void componentHidden(ComponentEvent e) {

    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combobox_modify_centre_name) {

            //change the id of centre whenever the selected centre changes
            if (combobox_modify_centre_name.getSelectedItem()!=null) {
                for (int i = 0; i < OODJ_Assignment.allSportsCentre.size(); i++) {
                    if (combobox_modify_centre_name.getSelectedItem().equals(OODJ_Assignment.allSportsCentre.get(i).getCenter_name())) {
                        label_modify_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                        combobox_modify_coach.removeAllItems();
                        combobox_modify_coach.setEditable(true);
                        combobox_modify_coach.setSelectedItem("Select Coach");
                        combobox_modify_coach.setEditable(false);
                        for (int x=0; x<OODJ_Assignment.allCoach.size();x++){
                            if (combobox_modify_sport_name.getSelectedItem()!=null) {
                                if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(OODJ_Assignment.allCoach.get(x).getSports_Center()) && combobox_modify_sport_name.getSelectedItem().equals(OODJ_Assignment.allCoach.get(x).getSport())) {
                                    combobox_modify_coach.addItem(OODJ_Assignment.allCoach.get(x).getName());
                                }
                            }
                        }
                    }
                }
            }
        } else if (e.getSource() == combobox_modify_sport_name) {

            //change the id of sport whenever the selected sport changes
            if (combobox_modify_centre_name.getItemCount() != 0 && combobox_modify_sport_name.getItemCount() != 0) {
                for (int i = 0; i < OODJ_Assignment.allSport.size(); i++) {
                    if (combobox_modify_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(i).getSport_name())) {
                        label_modify_sport_code.setText(OODJ_Assignment.allSport.get(i).getId());
                        for (int a = 0; a < OODJ_Assignment.allSportsCentre.size(); a++) {
                            for (int b = 0; b < OODJ_Assignment.allSportsCentre.get(a).getSport().size(); b++) {
                                if (OODJ_Assignment.allSport.get(i).getSport_name().equals(OODJ_Assignment.allSportsCentre.get(a).getSport().get(b).getSport_name())) {
                                    // combobox_modify_centre_name.removeAllItems();
                                    // combobox_modify_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(a).getCenter_name());
                                }
                            }
                        }
                    }
                }
            }

            //add item to centre combobox after user selects a sport
            if (combobox_modify_sport_name.getItemCount() != 0) {
                for (int x = 0; x < OODJ_Assignment.allSport.size(); x++) {
                    if (combobox_modify_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(x).getSport_name())) {
                        combobox_modify_centre_name.removeAllItems();
                        combobox_modify_centre_name.setEditable(true);
                        combobox_modify_centre_name.setSelectedItem("Select centre");
                        combobox_modify_centre_name.setEditable(false);
                        for (int a = 0; a < OODJ_Assignment.allSportsCentre.size(); a++) {
                            for (int b = 0; b < OODJ_Assignment.allSportsCentre.get(a).getSport().size(); b++) {
                                if (OODJ_Assignment.allSport.get(x).getSport_name().equals(OODJ_Assignment.allSportsCentre.get(a).getSport().get(b).getSport_name())) {
                                    combobox_modify_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(a).getCenter_name());
                                }
                            }
                        }
                    }
                }
            }
        } else if (e.getSource()==combobox_add_sport_name){

            //change the id of sport when the user select a sport and add item to centre combobox
            if (combobox_add_sport_name.getItemCount()!=0){
                for (int i=0; i<OODJ_Assignment.allSport.size();i++){
                    if (OODJ_Assignment.allSport.get(i).getSport_name().equals(combobox_add_sport_name.getSelectedItem())){
                        label_add_sport_code.setText(OODJ_Assignment.allSport.get(i).getId());
                        combobox_add_centre_name.removeAllItems();
                        combobox_add_centre_name.setEditable(true);
                        combobox_add_centre_name.setSelectedItem("Select centre");
                        combobox_add_centre_name.setEditable(false);
                        for (int x=0; x<OODJ_Assignment.allSportsCentre.size();x++){
                            for (int y=0; y<OODJ_Assignment.allSportsCentre.get(x).getSport().size();y++){
                                if (OODJ_Assignment.allSport.get(i).getSport_name().equals(OODJ_Assignment.allSportsCentre.get(x).getSport().get(y).getSport_name())){
                                    combobox_add_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(x).getCenter_name());
                                }
                            }
                        }
                    }
                }
            }
        } else if (e.getSource()==combobox_add_centre_name) {

            //add item to coach combobox after the user choose a centre
            if (combobox_add_centre_name.getItemCount() != 0) {
                for (int i = 0; i < OODJ_Assignment.allSportsCentre.size(); i++) {
                    if (combobox_add_centre_name.getSelectedItem().equals(OODJ_Assignment.allSportsCentre.get(i).getCenter_name())) {
                        label_add_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                        combobox_add_coach.removeAllItems();
                        combobox_add_coach.setEditable(true);
                        combobox_add_coach.setSelectedItem("Select Coach");
                        combobox_add_coach.setEditable(false);
                        for (int x=0; x<OODJ_Assignment.allCoach.size();x++){
                            if (combobox_add_sport_name.getSelectedItem()!=null) {
                                if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(OODJ_Assignment.allCoach.get(x).getSports_Center()) && combobox_add_sport_name.getSelectedItem().equals(OODJ_Assignment.allCoach.get(x).getSport())) {
                                    combobox_add_coach.addItem(OODJ_Assignment.allCoach.get(x).getName());
                                }
                            }
                        }
                    }
                }
            }

        }
    }
    
}
