package oodj_assignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Home_Page extends JFrame implements ActionListener, ComponentListener {
    
    private JButton button_user, button_setting, button_sports, button_exit;
    private JLabel label_title, background;
    private JComboBox combobox_user;
    
    public Home_Page(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(800,500);
        setLocation(700,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home Page");
        
        ImageIcon i = new ImageIcon("images\\Home_Page_Background.jpg");
        background = new JLabel();
        background.setIcon(i);
        add(background);
        
        background.setLayout(new GridBagLayout());
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,0,0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        i = new ImageIcon("images\\settings_icon.png");
        button_setting = new JButton(i);
        button_setting.setBackground(Color.LIGHT_GRAY);
        button_setting.setPreferredSize(new Dimension(60,60));
        background.add(button_setting,gbc);
        button_setting.addActionListener(this);
                      
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5,0,0,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        button_user = new JButton("(Click to Login/Register)");
        button_user.setFont(new Font("Cambria Math",Font.PLAIN,18));
        button_user.setPreferredSize(new Dimension(300,60));
        button_user.setBackground(Color.BLACK);
        button_user.setForeground(Color.WHITE);
        background.add(button_user,gbc);
        button_user.setVisible(false);
        button_user.addActionListener(this);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5,0,0,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;       
        String[] items = {" Student Page"," Logout"};
        combobox_user = new JComboBox(items);
        combobox_user.setEditable(true);
        combobox_user.setSelectedItem(" Welcome, ");
        combobox_user.setEditable(false);
        combobox_user.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_user.setPreferredSize(new Dimension(300,60));
        background.add(combobox_user,gbc);
        //combobox_user.setVisible(false);
        combobox_user.addActionListener(this);
      
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(60,0,0,0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        label_title = new JLabel("Real Champions Sport Academy");
        label_title.setFont(new Font("Segoe Print", Font.BOLD, 45));
        //label_title.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 45));
        //label_title.setFont(new Font("Felix Titling", Font.BOLD, 38));
        //label_title.setFont(new Font("Forte", Font.BOLD, 36));
        //label_title.setFont(new Font("Stencil", Font.BOLD, 36));
        label_title.setHorizontalAlignment(SwingConstants.CENTER);
        label_title.setVerticalAlignment(SwingConstants.CENTER);
        label_title.setForeground(Color.BLACK);
        background.add(label_title,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(50,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;        
        button_sports = new JButton("Sports Available");
        button_sports.setFont(new Font("Cambria Math",Font.PLAIN,22));
        button_sports.setPreferredSize(new Dimension(300,65));
        background.add(button_sports,gbc);
        button_sports.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(10,0,30,0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        button_exit = new JButton("Exit");
        button_exit.setBackground(new Color(229,56,59));
        //button_exit.setForeground(Color.BLACK);
        button_exit.setFont(new Font("Cambria Math",Font.PLAIN,22));
        button_exit.setPreferredSize(new Dimension(300,65));
        background.add(button_exit,gbc);
        button_exit.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == combobox_user) {
            
            //open respective page when it is selected
            if (combobox_user.getItemCount() == 2){
                String item = combobox_user.getSelectedItem().toString();
                switch (item){
                    case " Student Page":
                        this.setVisible(false);
                        OODJ_Assignment.studentPage.setVisible(true);
                        break;
                    case " Logout":
                        int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to logout? You can login again later.","Logout",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if (confirm == JOptionPane.YES_OPTION){
                            combobox_user.setVisible(false);
                            button_user.setVisible(true);
                            OODJ_Assignment.acc_login = null;
                        } else {
                            combobox_user.setEditable(true);
                            combobox_user.setSelectedItem(" Welcome, "+OODJ_Assignment.acc_login.getName());
                            combobox_user.setEditable(false);
                        }
                        break;
                    case " Admin Page":
                        this.setVisible(false);
                        OODJ_Assignment.adminPage.setVisible(true);
                        break;
                    case " Coach Page":
                        this.setVisible(false);
                        OODJ_Assignment.coachPage.setVisible(true);
                        break;
                }
            }
            
        } else if (e.getSource() == button_exit) {
            
            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            
        } else if (e.getSource() == button_user){
            
            OODJ_Assignment.loginPage.setVisible(true);
            
        } else if (e.getSource() == button_sports){
            
            this.setVisible(false);
            OODJ_Assignment.sportsAvailable.setVisible(true);
            
        } else if (e.getSource() == button_setting){
            
            //open settings page of student/admin/coach page based on account type
            String userType = OODJ_Assignment.loginPage.UserType();
            if (userType == null){
                JOptionPane.showMessageDialog(this, "Please login to access Account Settings.");
            } else {
                switch (userType){
                    case "student":
                        this.setVisible(false);
                        OODJ_Assignment.studentPage.setVisible(true);
                        OODJ_Assignment.studentPage.openSettingPage();
                        break;
                    case "admin":
                        this.setVisible(false);
                        OODJ_Assignment.adminPage.setVisible(true);
                        OODJ_Assignment.adminPage.openSettingPage();
                        break;
                    case "coach":
                        this.setVisible(false);
                        OODJ_Assignment.coachPage.setVisible(true);
                        OODJ_Assignment.coachPage.openSettingPage();
                        break;
                }
            }
       
        }
        
    }
    
    //add item to the combobox according to account type
    public void componentShown(ComponentEvent e){
        if (OODJ_Assignment.acc_login == null){
            combobox_user.setVisible(false);
            button_user.setVisible(true);
        } else {
            button_user.setVisible(false);
            combobox_user.setVisible(true);            
            combobox_user.removeAllItems();            
            if (OODJ_Assignment.loginPage.UserType().equals("student")){               
                combobox_user.addItem(" Student Page");
                combobox_user.addItem(" Logout");
            }else if (OODJ_Assignment.loginPage.UserType().equals("admin")){
                combobox_user.addItem(" Admin Page");
                combobox_user.addItem(" Logout");
            }else if (OODJ_Assignment.loginPage.UserType().equals("coach")){
                combobox_user.addItem(" Coach Page");
                combobox_user.addItem(" Logout");
            }
            combobox_user.setEditable(true);
            combobox_user.setSelectedItem(" Welcome, "+OODJ_Assignment.acc_login.getName());
            combobox_user.setEditable(false);
        }       
    }
        
    public void componentHidden(ComponentEvent e){

    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    
//
//The method of resizing background image refers to (Muteti, M., 2019).
//    
//auto resize the background image following the size of frame
    int oldWidth = (int)this.getSize().getWidth();
    int oldHeight = (int)this.getSize().getHeight();
    public void componentResized(ComponentEvent e){             
        if((int)this.getSize().getWidth()-oldWidth != 0 || (int)this.getSize().getHeight()-oldHeight != 0){
            ImageIcon i = new ImageIcon("images\\Home_Page_Background.jpg");
            Image img = i.getImage();
            Image imgScaled = img.getScaledInstance((int)this.getSize().getWidth(),(int)this.getSize().getHeight(),Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScaled);
            background.setIcon(scaledIcon);
            oldWidth = (int)this.getSize().getWidth();
            oldHeight = (int)this.getSize().getHeight();
        }       
    }
}
