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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin_Manage_Coaches extends JDialog implements Admin_Management, ActionListener, ComponentListener, ItemListener{
    
    private ButtonGroup bg;
    private CardLayout cl = new CardLayout();
    private JButton button_close, button_save_changes, button_add;
    private JComboBox combobox_modify_centre_name, combobox_modify_sport_name, combobox_modify_joined_date, combobox_modify_joined_month, combobox_modify_joined_year,
                        combobox_modify_terminated_date, combobox_modify_terminated_month, combobox_modify_terminated_year, combobox_add_birth_date, combobox_add_birth_month,
                        combobox_add_birth_year, combobox_add_joined_date, combobox_add_joined_month, combobox_add_joined_year, combobox_add_terminated_date,
                        combobox_add_terminated_month, combobox_add_terminated_year, combobox_add_centre_name, combobox_add_sport_name;
    private JLabel label_idL, label_nameL, label_ic_numberL, label_birth_dateL, label_genderL, label_emailL,
                    label_phone_numberL, label_addressL, label_date_joinedL, label_date_terminatedL, label_hourly_rateL,
                    label_centre_codeL, label_centre_nameL, label_sport_codeL, label_sport_nameL, label_ratingL, label_view_id, label_view_name, label_view_ic_number, 
                    label_view_birth_date, label_view_gender, label_view_email, label_view_phone_number, label_view_address, label_view_date_joined, 
                    label_view_date_terminated, label_view_hourly_rate, label_view_centre_code, label_view_centre_name, label_view_sport_code, label_view_sport_name, label_view_rating,
                    label_modify_id, label_modify_name, label_modify_ic_number, label_modify_birth_date, label_modify_gender, label_dash, label_modify_centre_code, label_modify_sport_code,
                    label_modify_rating, label_add_centre_code, label_add_sport_code, label_add_rating;
    private JPanel panel_main, panel_labels, panel_cards, panel_view, panel_modify, panel_add;
    private JRadioButton radioButton_add_male, radioButton_add_female;
    private JSpinner spinner_modify_hourly_rate, spinner_add_hourly_rate;
    private JTextField textField_modify_email, textField_modify_phone_number, textField_modify_address, textField_add_id, textField_add_name, textField_add_ic_number, textField_add_email,
                        textField_add_phone_number, textField_add_address;
    private TitledBorder border_view, border_modify, border_add;
    public int getCoachTableIndex;
    
    public Admin_Manage_Coaches(){
        
        addComponentListener(this);                             //needed for ComponentShown
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(700,1000);
        setLocation(750,25);
        setTitle("Coaches");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Coach");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_modify = BorderFactory.createTitledBorder("Modify Coach");
        border_modify.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_add = BorderFactory.createTitledBorder("Add Coach");
        border_add.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        //labels panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
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
        gbc.gridy = 1;
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
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_nameL = new JLabel("Name:  ");
        label_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberL = new JLabel("IC/Passport No.:  ");
        label_ic_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ic_numberL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_ic_numberL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_ic_numberL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateL = new JLabel("Birth Date:  ");
        label_birth_dateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_birth_dateL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_birth_dateL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_birth_dateL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderL = new JLabel("Gender:  ");
        label_genderL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_genderL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_genderL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_genderL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_emailL = new JLabel("Email:  ");
        label_emailL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_emailL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_emailL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_emailL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_numberL = new JLabel("Phone No.:  ");
        label_phone_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_phone_numberL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_phone_numberL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_phone_numberL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_addressL = new JLabel("Address:  ");
        label_addressL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_addressL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_addressL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_addressL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_joinedL = new JLabel("Date Joined:  ");
        label_date_joinedL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_date_joinedL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_date_joinedL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_date_joinedL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_date_terminatedL = new JLabel("Date Terminated:  ");
        label_date_terminatedL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_date_terminatedL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_date_terminatedL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_date_terminatedL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_hourly_rateL = new JLabel("Hourly Rate:  ");
        label_hourly_rateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_hourly_rateL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_hourly_rateL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_hourly_rateL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_codeL = new JLabel("Sport Centre Code:  ");
        label_centre_codeL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_codeL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_centre_codeL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_centre_codeL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_centre_nameL = new JLabel("Sport Centre:  ");
        label_centre_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_centre_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_centre_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_centre_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
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
        gbc.gridy = 15;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_sport_nameL = new JLabel("Sport:  ");
        label_sport_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sport_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_sport_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_sport_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ratingL = new JLabel("Rating:  ");
        label_ratingL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ratingL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_ratingL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_ratingL,gbc);
        
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
        label_view_name = new JLabel("testing");
        label_view_name.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_name.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_ic_number = new JLabel("000000-00-0000");
        label_view_ic_number.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_ic_number.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_birth_date = new JLabel("00-00-0000");
        label_view_birth_date.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_birth_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_birth_date.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_birth_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_gender = new JLabel("MaleFemale");
        label_view_gender.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_gender.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_gender.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_gender,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_email = new JLabel("testing@hotmail.com");
        label_view_email.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_email.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_phone_number = new JLabel("000-0000000");
        label_view_phone_number.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_phone_number.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_address = new JLabel("100, Taman Kinrara 123, Puchong, Selangor");
        label_view_address.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_address.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_address.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_address,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_date_joined = new JLabel("00-00-0000");
        label_view_date_joined.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_date_joined.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_date_joined.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_date_joined,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_date_terminated = new JLabel("00-00-0000");
        label_view_date_terminated.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_date_terminated.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_date_terminated.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_date_terminated,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_hourly_rate = new JLabel("300/hr");
        label_view_hourly_rate.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_hourly_rate.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_hourly_rate.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_hourly_rate,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_centre_code = new JLabel("SP00001");
        label_view_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_centre_code.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
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
        gbc.gridy = 13;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_sport_code = new JLabel("SP00001");
        label_view_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_sport_code.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
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
        gbc.gridy = 15;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_view_rating = new JLabel("5/5");
        label_view_rating.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_rating.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_rating.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_rating,gbc);        
        
        //modify panel
        panel_modify = new JPanel(new GridBagLayout());
        panel_modify.setOpaque(false);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,3,20);
        label_modify_id = new JLabel("12345");
        label_modify_id.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_id.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_id.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_id,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,3,20);
        label_modify_name = new JLabel("testing");
        label_modify_name.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_name.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_modify_ic_number = new JLabel("000000-00-0000");
        label_modify_ic_number.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_ic_number.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_modify_birth_date = new JLabel("00-00-0000");
        label_modify_birth_date.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_birth_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_birth_date.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_birth_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,3,20);
        label_modify_gender = new JLabel("MaleFemale");
        label_modify_gender.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_gender.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_gender.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_gender,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_modify_email = new JTextField();
        textField_modify_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_modify_email.setPreferredSize(new Dimension(260,25));
        panel_modify.add(textField_modify_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_modify_phone_number = new JTextField();
        textField_modify_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_modify_phone_number.setPreferredSize(new Dimension(260,25));
        panel_modify.add(textField_modify_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_modify_address = new JTextField();
        textField_modify_address.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_modify_address.setPreferredSize(new Dimension(260,25));
        panel_modify.add(textField_modify_address,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String items_year[] = {"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012",
                            "2011","2010","2009","2008","2007","2006","2005","2004","2003","2002",
                            "2001","2000","1999","1998","1997","1996","1995","1994","1993","1992",
                            "1991","1990","1989","1988","1987","1986","1985","1984","1983","1982",
                            "1981","1980","1979","1978","1977","1976","1975","1974","1973","1972",
                            "1971","1970","1969","1968","1967","1966","1965","1964","1963","1962",
                            "1961","1960","1959","1958","1957","1956","1955","1954","1953","1952",
                            "1951","1950","1949","1948","1947","1946","1945","1944","1943","1942",
                            "1941","1940","1939","1938","1937","1936","1935","1934","1933","1932",
                            "1931","1930","1929","1928","1927","1926","1925","1924","1923","1922"};
        combobox_modify_joined_year = new JComboBox(items_year);
        combobox_modify_joined_year.setEditable(true);
        combobox_modify_joined_year.setSelectedItem("Year");
        combobox_modify_joined_year.setEditable(false);
        combobox_modify_joined_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_joined_year.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_joined_year,gbc);
        combobox_modify_joined_year.addItemListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_dash,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        String items_month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        combobox_modify_joined_month = new JComboBox(items_month);
        combobox_modify_joined_month.setEditable(true);
        combobox_modify_joined_month.setSelectedItem("Month");
        combobox_modify_joined_month.setEditable(false);
        combobox_modify_joined_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_joined_month.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_joined_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_dash,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);       
        String items_date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        combobox_modify_joined_date = new JComboBox(items_date);
        combobox_modify_joined_date.setEditable(true);
        combobox_modify_joined_date.setSelectedItem("Date");
        combobox_modify_joined_date.setEditable(false);
        combobox_modify_joined_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_joined_date.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_joined_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_modify_terminated_year = new JComboBox(items_year);
        combobox_modify_terminated_year.setEditable(true);
        combobox_modify_terminated_year.setSelectedItem("Year");
        combobox_modify_terminated_year.setEditable(false);
        combobox_modify_terminated_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_terminated_year.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_terminated_year,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_dash,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_modify_terminated_month = new JComboBox(items_month);
        combobox_modify_terminated_month.setEditable(true);
        combobox_modify_terminated_month.setSelectedItem("Month");
        combobox_modify_terminated_month.setEditable(false);
        combobox_modify_terminated_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_terminated_month.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_terminated_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_dash,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);       
        combobox_modify_terminated_date = new JComboBox(items_date);
        combobox_modify_terminated_date.setEditable(true);
        combobox_modify_terminated_date.setSelectedItem("Date");
        combobox_modify_terminated_date.setEditable(false);
        combobox_modify_terminated_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_terminated_date.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_terminated_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        SpinnerModel model = new SpinnerNumberModel(100,100,500,10);
        spinner_modify_hourly_rate = new JSpinner(model);
        spinner_modify_hourly_rate.setFont(new Font("Cambria Math",Font.PLAIN,20));
        spinner_modify_hourly_rate.setPreferredSize(new Dimension(260,25));
        panel_modify.add(spinner_modify_hourly_rate,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_modify_centre_code = new JLabel("SC0001");
        label_modify_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_centre_code.setForeground(new Color(34,34,59));
        panel_modify.add(label_modify_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String sport_centre[] = {"Petaling Branch","Kuala Selangor Branch","Klang Branch","Sepang Branch","Hulu Langat Branch"};        
        combobox_modify_centre_name = new JComboBox(sport_centre);
        combobox_modify_centre_name.setEnabled(false);
        combobox_modify_centre_name.setEditable(true);
        combobox_modify_centre_name.setSelectedItem("Centre Name");
        combobox_modify_centre_name.setEditable(false);
        combobox_modify_centre_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_centre_name.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_centre_name,gbc);
        combobox_modify_centre_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);        
        label_modify_sport_code = new JLabel("SP0001");
        label_modify_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_sport_code.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String sports[] = {"Basketball","Tennis","SP0003","SP0004","SP0005"};
        combobox_modify_sport_name = new JComboBox(sports);
        combobox_modify_sport_name.setEnabled(false);
        combobox_modify_sport_name.setEditable(true);
        combobox_modify_sport_name.setSelectedItem("Sport Name");
        combobox_modify_sport_name.setEditable(false);
        combobox_modify_sport_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_modify_sport_name.setPreferredSize(new Dimension(260,25));
        panel_modify.add(combobox_modify_sport_name,gbc);
        combobox_modify_sport_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_modify_rating = new JLabel("5/5");
        label_modify_rating.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_rating.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_rating.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_rating,gbc);
        
        //add panel
        panel_add = new JPanel(new GridBagLayout());
        panel_add.setOpaque(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
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
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_add_name = new JTextField();
        textField_add_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_add.add(textField_add_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_add_ic_number = new JTextField();
        textField_add_ic_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_add.add(textField_add_ic_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_birth_year = new JComboBox(items_year);
        combobox_add_birth_year.setEditable(true);
        combobox_add_birth_year.setSelectedItem("Year");
        combobox_add_birth_year.setEditable(false);
        combobox_add_birth_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_birth_year.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_birth_year,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.8;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_birth_month = new JComboBox(items_month);
        combobox_add_birth_month.setEditable(true);
        combobox_add_birth_month.setSelectedItem("Month");
        combobox_add_birth_month.setEditable(false);
        combobox_add_birth_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_birth_month.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_birth_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_birth_date = new JComboBox(items_date);
        combobox_add_birth_date.setEditable(true);
        combobox_add_birth_date.setSelectedItem("Date");
        combobox_add_birth_date.setEditable(false);
        combobox_add_birth_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_add.add(combobox_add_birth_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton_add_male = new JRadioButton();
        radioButton_add_male.setText("Male");
        radioButton_add_male.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton_add_male.setForeground(new Color(34,34,59)); 
        radioButton_add_male.setOpaque(false);
        panel_add.add(radioButton_add_male,gbc);
        this.radioButton_add_male.setActionCommand("Male");
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.8;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton_add_female = new JRadioButton();
        radioButton_add_female.setText("Female");
        radioButton_add_female.setFont(new Font("Cambria Math",Font.PLAIN,20));
        radioButton_add_female.setForeground(new Color(34,34,59)); 
        radioButton_add_female.setOpaque(false);
        panel_add.add(radioButton_add_female,gbc);
        this.radioButton_add_female.setActionCommand("Female");
        
        bg = new ButtonGroup();
        bg.add(radioButton_add_male);
        bg.add(radioButton_add_female);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_add_email = new JTextField();
        textField_add_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_add_email.setPreferredSize(new Dimension(260,25));
        panel_add.add(textField_add_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_add_phone_number = new JTextField();
        textField_add_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_add_phone_number.setPreferredSize(new Dimension(260,25));
        panel_add.add(textField_add_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_add_address = new JTextField();
        textField_add_address.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_add_address.setPreferredSize(new Dimension(260,25));
        panel_add.add(textField_add_address,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_joined_year = new JComboBox(items_year);
        combobox_add_joined_year.setEditable(true);
        combobox_add_joined_year.setSelectedItem("Year");
        combobox_add_joined_year.setEditable(false);
        combobox_add_joined_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_joined_year.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_joined_year,gbc);
        combobox_add_joined_year.addItemListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 0.8;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_joined_month = new JComboBox(items_month);
        combobox_add_joined_month.setEditable(true);
        combobox_add_joined_month.setSelectedItem("Month");
        combobox_add_joined_month.setEditable(false);
        combobox_add_joined_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_joined_month.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_joined_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);       
        combobox_add_joined_date = new JComboBox(items_date);
        combobox_add_joined_date.setEditable(true);
        combobox_add_joined_date.setSelectedItem("Date");
        combobox_add_joined_date.setEditable(false);
        combobox_add_joined_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_joined_date.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_joined_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_terminated_year = new JComboBox(items_year);
        combobox_add_terminated_year.setEditable(true);
        combobox_add_terminated_year.setSelectedItem("Year");
        combobox_add_terminated_year.setEditable(false);
        combobox_add_terminated_year.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_terminated_year.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_terminated_year,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 0.8;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        combobox_add_terminated_month = new JComboBox(items_month);
        combobox_add_terminated_month.setEditable(true);
        combobox_add_terminated_month.setSelectedItem("Month");
        combobox_add_terminated_month.setEditable(false);
        combobox_add_terminated_month.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_terminated_month.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_terminated_month,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_dash = new JLabel("-");
        label_dash.setHorizontalAlignment(SwingConstants.CENTER);
        label_dash.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_dash.setForeground(new Color(34,34,59)); 
        panel_add.add(label_dash,gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 9;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);       
        combobox_add_terminated_date = new JComboBox(items_date);
        combobox_add_terminated_date.setEditable(true);
        combobox_add_terminated_date.setSelectedItem("Date");
        combobox_add_terminated_date.setEditable(false);
        combobox_add_terminated_date.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_terminated_date.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_terminated_date,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        spinner_add_hourly_rate = new JSpinner(model);
        spinner_add_hourly_rate.setFont(new Font("Cambria Math",Font.PLAIN,20));
        spinner_add_hourly_rate.setPreferredSize(new Dimension(260,25));
        panel_add.add(spinner_add_hourly_rate,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_add_centre_code = new JLabel("SC0001");
        label_add_centre_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_add_centre_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_add_centre_code.setForeground(new Color(34,34,59));        
        panel_add.add(label_add_centre_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        combobox_add_centre_name = new JComboBox(sport_centre);
        combobox_add_centre_name.setEditable(true);
        combobox_add_centre_name.setSelectedItem("Centre Name");
        combobox_add_centre_name.setEditable(false);
        combobox_add_centre_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_centre_name.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_centre_name,gbc);
        combobox_add_centre_name.addActionListener(this);
        combobox_add_centre_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        label_add_sport_code = new JLabel("SP0001");
        label_add_sport_code.setHorizontalAlignment(SwingConstants.LEFT);
        label_add_sport_code.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_add_sport_code.setForeground(new Color(34,34,59)); 
        panel_add.add(label_add_sport_code,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(3,0,0,20);        
        combobox_add_sport_name = new JComboBox(sports);
        combobox_add_sport_name.setEditable(true);
        combobox_add_sport_name.setSelectedItem("Sport Name");
        combobox_add_sport_name.setEditable(false);
        combobox_add_sport_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_add_sport_name.setPreferredSize(new Dimension(260,25));
        panel_add.add(combobox_add_sport_name,gbc);
        combobox_add_sport_name.addItemListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(3,0,0,20);
        label_add_rating = new JLabel("0/5");
        label_add_rating.setHorizontalAlignment(SwingConstants.LEFT);
        label_add_rating.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_add_rating.setForeground(new Color(34,34,59)); 
        panel_add.add(label_add_rating,gbc);
        
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
        button_close = new JButton("Close");
        button_close.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_close.setForeground(new Color(34,34,59)); 
        button_close.setPreferredSize(new Dimension(200,50));
        panel_main.add(button_close,gbc);
        button_close.addActionListener(this);
        
        setModal(true);     //set other page cannot be access until this window is closed
                
    }
    
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    public void viewClicked(){
        panel_main.setBorder(border_view);
        cl.show(panel_cards, "view");
        button_save_changes.setVisible(false);
        button_add.setVisible(false);
        button_close.setVisible(true);
    }
    
    public void modifyClicked(){
        panel_main.setBorder(border_modify);
        cl.show(panel_cards, "modify");
        button_close.setVisible(false);        
        button_add.setVisible(false);
        button_save_changes.setVisible(true);
    }
    
    public void addClicked(){
        panel_main.setBorder(border_add);
        cl.show(panel_cards, "add");
        button_close.setVisible(false);
        button_save_changes.setVisible(false);
        button_add.setVisible(true);
    }
    
    public void create_coach_id(){
        int id_count =OODJ_Assignment.allCoach.size()+1;
        if (String.valueOf(id_count).length()==1){
            textField_add_id.setText("CH"+"000"+id_count);
        }else if (String.valueOf(id_count).length()==2){
            textField_add_id.setText("CH"+"00"+id_count);
        }else if (String.valueOf(id_count).length()==3){
            textField_add_id.setText("CH"+"0"+id_count);
        }else if (String.valueOf(id_count).length()==4){
            textField_add_id.setText("CH"+id_count);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_add){
            
            if (!textField_add_name.getText().isEmpty()&& !textField_add_ic_number.getText().isEmpty()&& !textField_add_email.getText().isEmpty()&&
                    !textField_add_phone_number.getText().isEmpty()&& !textField_add_address.getText().isEmpty()&& !combobox_add_birth_year.getSelectedItem().equals("Year")&&
                    !combobox_add_birth_month.getSelectedItem().equals("Month")&& !combobox_add_birth_date.getSelectedItem().equals("Date")&&
                    bg.getSelection().isSelected()&& !combobox_add_joined_year.getSelectedItem().equals("Year")&&
                    !combobox_add_joined_month.getSelectedItem().equals("Month")&& !combobox_add_joined_date.getSelectedItem().equals("Date")&& !combobox_add_terminated_year.getSelectedItem().equals("Year")&&
                    !combobox_add_terminated_month.getSelectedItem().equals("Month")&& !combobox_add_terminated_date.getSelectedItem().equals("Date")&& !combobox_add_centre_name.getSelectedItem().equals("Center Name")&&
                    !combobox_add_sport_name.getSelectedItem().equals("Select Sport")) {
                if (OODJ_Assignment.checkPhoneNumber(textField_add_phone_number.getText()) && OODJ_Assignment.checkAlphabetOnly(textField_add_name.getText())){
                    if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_add_birth_date.getSelectedItem().toString()), Integer.parseInt(combobox_add_birth_month.getSelectedItem().toString()), Integer.parseInt(combobox_add_birth_year.getSelectedItem().toString()))) {   //check DOB date
                        if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_add_joined_date.getSelectedItem().toString()), Integer.parseInt(combobox_add_joined_month.getSelectedItem().toString()), Integer.parseInt(combobox_add_joined_year.getSelectedItem().toString()))) {       //check date joined
                            if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_add_terminated_date.getSelectedItem().toString()), Integer.parseInt(combobox_add_terminated_month.getSelectedItem().toString()), Integer.parseInt(combobox_add_terminated_year.getSelectedItem().toString()))) {     //check date terminated
                                boolean flag_email = true;
                                for (int i = 0; i < OODJ_Assignment.allCoach.size(); i++) {
                                    Coach coach = OODJ_Assignment.allCoach.get(i);
                                    if (coach.getEmail().equals(textField_add_email.getText())) {
                                        flag_email = false;
                                        JOptionPane.showMessageDialog(null, "Email registered under coach account.");
                                        break;
                                    }
                                }
                                if (flag_email) {
                                    String DOB = combobox_add_birth_date.getSelectedItem() + "-" + combobox_add_birth_month.getSelectedItem() + "-" + combobox_add_birth_year.getSelectedItem();
                                    String date_joined = combobox_add_joined_date.getSelectedItem() + "-" + combobox_add_joined_month.getSelectedItem() + "-" + combobox_add_joined_year.getSelectedItem();
                                    String date_terminated = combobox_add_terminated_date.getSelectedItem() + "-" + combobox_add_terminated_month.getSelectedItem() + "-" + combobox_add_terminated_year.getSelectedItem();

                                    String password = "coach";
                                    String feedback = "NoFeedback";
                                    String rating = "0";
                                    String theme = "light";

                                    Coach c = new Coach(textField_add_name.getText(), DOB, password, bg.getSelection().getActionCommand(), textField_add_email.getText(), textField_add_ic_number.getText(), textField_add_phone_number.getText(),
                                            textField_add_id.getText(), theme, date_joined, date_terminated, combobox_add_centre_name.getSelectedItem().toString(), combobox_add_sport_name.getSelectedItem().toString(), feedback, textField_add_address.getText(), Float.parseFloat(spinner_add_hourly_rate.getValue().toString()), Double.parseDouble(rating));

                                    OODJ_Assignment.allCoach.add(c);

                                    try {
                                        PrintWriter p = new PrintWriter("coach.txt");
                                        for (int i = 0; i < OODJ_Assignment.allCoach.size(); i++) {
                                            Coach ch = OODJ_Assignment.allCoach.get(i);
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
                                        JOptionPane.showMessageDialog(null, "Coach Account created. Your default password is 'coach'.");
                                        this.setVisible(false);
                                        OODJ_Assignment.adminPage.update_coach_table();

                                    } catch (FileNotFoundException fileNotFoundException) {
                                        //fileNotFoundException.printStackTrace();
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid date terminated, please select again");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Invalid date joined, please select again.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid birth date, please select again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number only has digits and name only has alphabets");
                }               
            }else {
                JOptionPane.showMessageDialog(null, "Please fill up the blanks");
            }
            
        }else if (e.getSource()==button_close){
            
            this.setVisible(false);
            
        }else if (e.getSource()==button_save_changes){
            
            if (!textField_modify_email.getText().isEmpty()&& !textField_modify_phone_number.getText().isEmpty() && !textField_modify_address.getText().isEmpty()&&
            !spinner_modify_hourly_rate.getValue().toString().isEmpty()&& !combobox_modify_joined_date.getSelectedItem().equals("Date")&& !combobox_modify_joined_month.getSelectedItem().equals("Month")&&
            !combobox_modify_joined_year.getSelectedItem().equals("Year")&& !combobox_modify_terminated_date.getSelectedItem().equals("Date")&& !combobox_modify_terminated_month.getSelectedItem().equals("Month")&&
            !combobox_modify_terminated_year.getSelectedItem().equals("Year")&& !combobox_modify_centre_name.getSelectedItem().equals("Centre Name")&& !combobox_modify_sport_name.getSelectedItem().equals("Sport Name")){
                if (OODJ_Assignment.checkPhoneNumber(textField_modify_phone_number.getText())){
                    if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_modify_joined_date.getSelectedItem().toString()), Integer.parseInt(combobox_modify_joined_month.getSelectedItem().toString()), Integer.parseInt(combobox_modify_joined_year.getSelectedItem().toString()))){     //check date joined
                        if (OODJ_Assignment.checkDOB(Integer.parseInt(combobox_modify_terminated_date.getSelectedItem().toString()), Integer.parseInt(combobox_modify_terminated_month.getSelectedItem().toString()), Integer.parseInt(combobox_modify_terminated_year.getSelectedItem().toString()))){     //check date terminated
                            String date_joined = combobox_modify_joined_date.getSelectedItem()+"-"+combobox_modify_joined_month.getSelectedItem()+"-"+combobox_modify_joined_year.getSelectedItem();
                            String date_terminated = combobox_modify_terminated_date.getSelectedItem()+"-"+combobox_modify_terminated_month.getSelectedItem()+"-"+combobox_modify_terminated_year.getSelectedItem();

                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setEmail(textField_modify_email.getText());
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setPhone_number(textField_modify_phone_number.getText());
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setAddress(textField_modify_address.getText());
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setDate_joined(date_joined);
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setDate_terminated(date_terminated);
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setHourly_rate(Float.parseFloat(spinner_modify_hourly_rate.getValue().toString()));
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setSports_Center(combobox_modify_centre_name.getSelectedItem().toString());
                            OODJ_Assignment.allCoach.get(getCoachTableIndex).setSport(combobox_modify_sport_name.getSelectedItem().toString());

                            try {
                                PrintWriter p = new PrintWriter("coach.txt");
                                for (int i = 0; i < OODJ_Assignment.allCoach.size(); i++) {
                                    Coach ch = OODJ_Assignment.allCoach.get(i);
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
                                JOptionPane.showMessageDialog(null, "Coach Account Updated.");
                                OODJ_Assignment.adminPage.update_coach_table();

                            } catch (FileNotFoundException fileNotFoundException) {
                                //fileNotFoundException.printStackTrace();
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Invalid date terminated, please select again");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Invalid date joined, please select again");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number must have more than 9 numerical digits.");
                }               
            }else {
                JOptionPane.showMessageDialog(null, "Please fill up the blanks.");
            }

        }
//        else if (e.getSource()== combobox_add_centre_name) {
//            
//            //int index= combobox_add_centre_name.getSelectedIndex();
//            //label_add_centre_code.setText(OODJ_Assignment.allSportsCentre.get(index).getCenter_id());
//            if (combobox_add_centre_name.getItemCount() == OODJ_Assignment.allSportsCentre.size()) {
//                String item = combobox_add_centre_name.getSelectedItem().toString();
//                switch (item) {
//                    case "Centre-Petaling Branch":
//                        label_view_centre_code.setText("SC0001");
//                        JOptionPane.showMessageDialog(null, "iokioi");
//                        break;
//
//                    case "Centre-Kuala Selangor Branch":
//                        label_view_centre_code.setText("SC0002");
//                        break;
//
//                    case "Centre-Klang Branch":
//                        label_view_centre_code.setText("SC0003");
//                        break;
//
//                    case "Centre-Sepang Branch":
//                        label_view_centre_code.setText("SC0004");
//                        break;
//
//                    case "Centre-Hulu Langat Branch":
//                        label_view_centre_code.setText("SC0005");
//                        break;
//                }
//            }
//            
//        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {
        create_coach_id();

        if(OODJ_Assignment.allCoach.size() != 0){
            //
            //view coach
            //
            Coach c = OODJ_Assignment.allCoach.get(getCoachTableIndex);
            label_view_id.setText(c.getID());
            label_view_name.setText(c.getName());
            label_view_ic_number.setText(c.getIC());
            label_view_birth_date.setText(c.getDOB());
            label_view_gender.setText(c.getGender());
            label_view_email.setText(c.getEmail());
            label_view_phone_number.setText(c.getPhone_number());
            label_view_address.setText(c.getAddress());
            label_view_date_joined.setText(c.getDate_joined());
            label_view_date_terminated.setText(c.getDate_terminated());
            label_view_hourly_rate.setText(String.valueOf(c.getHourly_rate()));
            label_view_centre_name.setText(c.getSports_Center());
            label_view_sport_name.setText(c.getSport());
            label_view_rating.setText(String.valueOf(c.getRating()));
            for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++){
                if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(c.getSports_Center())){
                    SportsCentre SC = OODJ_Assignment.allSportsCentre.get(i);
                    label_view_centre_code.setText(SC.getCenter_id());
                    for (int ii=0; ii<OODJ_Assignment.allSportsCentre.get(i).getSport().size(); ii++){
                        if (c.getSport().equals(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getSport_name())){
                            label_view_sport_code.setText(OODJ_Assignment.allSportsCentre.get(i).getSport().get(ii).getId());
                        }
                    }
                }
            }

            //
            //modify coach
            //
            String joined = OODJ_Assignment.allCoach.get(getCoachTableIndex).getDate_joined();
            String terminated = OODJ_Assignment.allCoach.get(getCoachTableIndex).getDate_terminated();
            label_modify_id.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getID());
            label_modify_name.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getName());
            label_modify_birth_date.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getDOB());
            label_modify_ic_number.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getIC());
            textField_modify_address.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getAddress());
            textField_modify_phone_number.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getPhone_number());
            textField_modify_email.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getEmail());
            spinner_modify_hourly_rate.setValue(OODJ_Assignment.allCoach.get(getCoachTableIndex).getHourly_rate());
            label_modify_gender.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getGender());
            combobox_modify_joined_year.setSelectedItem(joined.split("-")[2]);
            combobox_modify_joined_month.setSelectedItem(joined.split("-")[1]);
            combobox_modify_joined_date.setSelectedItem(joined.split("-")[0]);
            combobox_modify_terminated_year.setSelectedItem(terminated.split("-")[2]);
            combobox_modify_terminated_month.setSelectedItem(terminated.split("-")[1]);
            combobox_modify_terminated_date.setSelectedItem(terminated.split("-")[0]);
            label_modify_rating.setText(OODJ_Assignment.allCoach.get(getCoachTableIndex).getRating()+"/5");

            //
            //modify&add coach
            //

            //combobox_add_sport_name.removeAllItems();
            combobox_add_centre_name.removeAllItems();
            combobox_modify_centre_name.removeAllItems();
            combobox_modify_centre_name.setEditable(true);
            combobox_modify_centre_name.setSelectedItem(c.getSports_Center());
            combobox_modify_centre_name.setEditable(false);
            for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++) {
                combobox_add_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(i).getCenter_name());
                combobox_modify_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(i).getCenter_name());

                if (c.getSports_Center().equals(OODJ_Assignment.allSportsCentre.get(i).getCenter_name())){
                    label_modify_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                }

            }
            //combobox_modify_sport_name.removeAllItems();
            combobox_modify_sport_name.setEditable(true);
            combobox_modify_sport_name.setSelectedItem(c.getSport());
            combobox_modify_sport_name.setEditable(false);
        }
        
        
        //
        //add coach
        //        
        combobox_add_centre_name.removeAllItems();
        for (int i=0; i<OODJ_Assignment.allSportsCentre.size(); i++) {
            combobox_add_centre_name.addItem(OODJ_Assignment.allSportsCentre.get(i).getCenter_name());
        }
        textField_add_name.setText("");
        textField_add_ic_number.setText("");
        textField_add_email.setText("");
        textField_add_phone_number.setText("");
        textField_add_address.setText("");
        combobox_add_birth_year.setEditable(true);
        combobox_add_birth_year.setSelectedItem("Year");
        combobox_add_birth_year.setEditable(false);
        combobox_add_birth_month.setEditable(true);
        combobox_add_birth_month.setSelectedItem("Month");
        combobox_add_birth_month.setEditable(false);
        combobox_add_birth_date.setEditable(true);
        combobox_add_birth_date.setSelectedItem("Date");
        combobox_add_birth_date.setEditable(false);
        combobox_add_joined_year.setEditable(true);
        combobox_add_joined_year.setSelectedItem("Year");
        combobox_add_joined_year.setEditable(false);
        combobox_add_joined_month.setEditable(true);
        combobox_add_joined_month.setSelectedItem("Month");
        combobox_add_joined_month.setEditable(false);
        combobox_add_joined_date.setEditable(true);
        combobox_add_joined_date.setSelectedItem("Date");
        combobox_add_joined_date.setEditable(false);
        combobox_add_terminated_year.setEditable(true);
        combobox_add_terminated_year.setSelectedItem("Year");
        combobox_add_terminated_year.setEditable(false);
        combobox_add_terminated_month.setEditable(true);
        combobox_add_terminated_month.setSelectedItem("Month");
        combobox_add_terminated_month.setEditable(false);
        combobox_add_terminated_date.setEditable(true);
        combobox_add_terminated_date.setSelectedItem("Date");
        combobox_add_terminated_date.setEditable(false);
        
    }

    public void componentHidden(ComponentEvent e) {

    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()== combobox_add_centre_name){
            
            if (combobox_add_centre_name.getItemCount()!=0 && combobox_add_sport_name.getItemCount()!=0) {
                combobox_add_sport_name.removeAllItems();
                for (int i = 0; i < OODJ_Assignment.allSportsCentre.size(); i++) {
                    if (combobox_add_centre_name.getSelectedItem().equals(OODJ_Assignment.allSportsCentre.get(i).getCenter_name())) {
                        label_add_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
                        for (int x = 0; x < OODJ_Assignment.allSportsCentre.get(i).getSport().size(); x++) {
                            for (int y = 0; y < OODJ_Assignment.allSport.size(); y++) {
                                if (OODJ_Assignment.allSportsCentre.get(i).getSport().get(x).getSport_name().equals(OODJ_Assignment.allSport.get(y).getSport_name())) {

                                    combobox_add_sport_name.setEditable(true);
                                    combobox_add_sport_name.addItem(OODJ_Assignment.allSport.get(y).getSport_name());
                                    combobox_add_sport_name.setSelectedItem("Select Sport");
                                    combobox_add_sport_name.setEditable(false);

                                }
                            }
                        }
                    }
                }
            }
            
        } else if (e.getSource()==combobox_add_sport_name){
            
            if (combobox_add_sport_name.getItemCount()!=0 && combobox_add_sport_name.getSelectedItem()!=null){
                for (int i=0;i<OODJ_Assignment.allSport.size();i++){
                    if (combobox_add_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(i).getSport_name())){
                        label_add_sport_code.setText(OODJ_Assignment.allSport.get(i).getId());
                    }
                }
            }
            
        } else if (e.getSource()==combobox_modify_centre_name){
            
            if (combobox_modify_centre_name.getItemCount()!=0 && combobox_modify_sport_name.getItemCount()!=0) {
                combobox_modify_sport_name.removeAllItems();
                for (int i = 0; i < OODJ_Assignment.allSportsCentre.size(); i++) {
                    if (combobox_modify_centre_name.getSelectedItem().equals(OODJ_Assignment.allSportsCentre.get(i).getCenter_name())) {
                        label_modify_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());

                        for (int x = 0; x < OODJ_Assignment.allSportsCentre.get(i).getSport().size(); x++) {
                            for (int y = 0; y < OODJ_Assignment.allSport.size(); y++) {
                                if (OODJ_Assignment.allSportsCentre.get(i).getSport().get(x).getSport_name().equals(OODJ_Assignment.allSport.get(y).getSport_name())) {

                                    combobox_modify_sport_name.setEditable(true);
                                    combobox_modify_sport_name.addItem(OODJ_Assignment.allSport.get(y).getSport_name());
                                    combobox_modify_sport_name.setSelectedItem("Select Sport");
                                    combobox_modify_sport_name.setEditable(false);

                                }
                            }
                        }
                    }
                }
            }
            
        } else if (e.getSource()==combobox_modify_sport_name){
            
            if (combobox_modify_sport_name.getItemCount()!=0 && combobox_modify_sport_name.getSelectedItem()!=null){
                for (int i=0;i<OODJ_Assignment.allSport.size();i++){
                    if (combobox_modify_sport_name.getSelectedItem().equals(OODJ_Assignment.allSport.get(i).getSport_name())){
                        label_modify_sport_code.setText(OODJ_Assignment.allSport.get(i).getId());
                    }
                }
            }

        } else if (e.getSource() == combobox_add_joined_year){
            
            if (!combobox_add_joined_year.getSelectedItem().toString().equals("Year")){
                combobox_add_terminated_year.setEditable(true);
                int year = Integer.parseInt(combobox_add_joined_year.getSelectedItem().toString());
                combobox_add_terminated_year.setSelectedItem(String.valueOf(year+1));
                combobox_add_terminated_year.setEditable(false);
            }
                       
        } else if (e.getSource() == combobox_modify_joined_year){
                        
            if (!combobox_add_joined_year.getSelectedItem().toString().equals("Year")){
                combobox_modify_terminated_year.setEditable(true);
                int year = Integer.parseInt(combobox_modify_joined_year.getSelectedItem().toString());
                combobox_modify_terminated_year.setSelectedItem(String.valueOf(year+1));
                combobox_modify_terminated_year.setEditable(false);
            }
            
        }
    }
}
