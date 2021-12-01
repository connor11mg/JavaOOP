package oodj_assignment;

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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin_Manage_Admin extends JDialog implements ActionListener, ComponentListener {
            
    private JButton button_close;
    private JLabel label_idL, label_nameL, label_ic_numberL, label_birth_dateL, label_genderL, label_emailL, label_phone_numberL, 
                    label_view_id, label_view_name, label_view_ic_number, label_view_birth_date, label_view_gender, label_view_email, label_view_phone_number;
    private JPanel panel_main, panel_labels, panel_view;
    private TitledBorder border_view;
    public int getAdminIndex;
    
    public Admin_Manage_Admin(){
        
        addComponentListener(this);                             //Needed for ComponentShown
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(600,600);
        setLocation(850,175);
        setTitle("Admin");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Admin");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        //labels panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
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
        label_nameL = new JLabel("Name:  ");
        label_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_nameL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
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
        gbc.gridy = 3;
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
        gbc.gridy = 4;
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
        gbc.gridy = 5;
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
        gbc.gridy = 6;
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
        
        //view panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_view = new JPanel(new GridBagLayout());
        panel_view.setOpaque(false);
        panel_main.add(panel_view,gbc);
        
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
        
        setModal(true);             //set other page cannot be access until this window is closed
                
    }
    
    //panel_main getter
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_close){
            
            this.setVisible(false);     //close this window
            
        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {
        Admin viewAdmin = OODJ_Assignment.allAdmin.get(getAdminIndex);       //get index from table_admin

        label_view_birth_date.setText(viewAdmin.getDOB());                   //change all the labels according to selected admin
        label_view_email.setText(viewAdmin.getEmail());
        label_view_gender.setText(viewAdmin.getGender());
        label_view_id.setText(viewAdmin.getID());
        label_view_name.setText(viewAdmin.getName());
        label_view_phone_number.setText(viewAdmin.getPhone_number());
        label_view_ic_number.setText(viewAdmin.getIC());

    }

    public void componentHidden(ComponentEvent e) {

    }
    
}
