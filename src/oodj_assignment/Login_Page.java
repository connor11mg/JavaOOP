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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Login_Page extends JDialog implements ActionListener, MouseListener, ComponentListener {
    
    private CardLayout cl = new CardLayout();
    private JPanel panel_username, panel_password, panel_cards;
    private JLabel label_username_email, label_user, label_password, label_forget_password, label_login_as, label_sign_up;
    private JTextField textField_username;
    private JPasswordField passwordField_password;
    private JButton button_next, button_login;
    private ButtonGroup bg;
    private JRadioButton radioButton_student, radioButton_admin, radioButton_coach;
    
    private String user_type;
    
    public Login_Page(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(500,300);
        setLocation(800,350);
        setTitle("Login");
        
        //
        // The method of using cardLayout refers to ().
        //
        panel_cards = new JPanel();
        panel_cards.setLayout(cl);
        add(panel_cards);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //1st panel
        panel_username = new JPanel(new GridBagLayout());
        TitledBorder b = BorderFactory.createTitledBorder("Login");
        b.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_username.setBorder(b);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_username_email = new JLabel("Email Address:");
        label_username_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_username.add(label_username_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,20);
        textField_username = new JTextField();
        textField_username.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_username.setPreferredSize(new Dimension(260,30));
        panel_username.add(textField_username,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_login_as = new JLabel("Login as:");
        label_login_as.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_username.add(label_login_as,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0,0,0,30);
        radioButton_student = new JRadioButton("Student");
        radioButton_student.setFont(new Font("Cambria Math",Font.PLAIN,20));
        this.radioButton_student.setActionCommand("student");
        panel_username.add(radioButton_student,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0,0,0,10);
        radioButton_admin = new JRadioButton("Admin");
        radioButton_admin.setFont(new Font("Cambria Math",Font.PLAIN,20));
        this.radioButton_admin.setActionCommand("admin");
        panel_username.add(radioButton_admin,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0,10,0,0);
        radioButton_coach = new JRadioButton("Coach");
        radioButton_coach.setFont(new Font("Cambria Math",Font.PLAIN,20));
        this.radioButton_coach.setActionCommand("coach");
        panel_username.add(radioButton_coach,gbc);
        
        bg = new ButtonGroup();
        bg.add(radioButton_student);
        bg.add(radioButton_admin);
        bg.add(radioButton_coach);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10,20,0,20);
        button_next = new JButton("Next");
        button_next.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_next.setPreferredSize(new Dimension(120,40));
        panel_username.add(button_next,gbc);
        button_next.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        gbc.insets = new Insets(0,20,10,0);
        label_sign_up = new JLabel("Not a member? Sign up now.");    
        label_sign_up.setFont(new Font("Cambria Math",Font.ITALIC,15));
        label_sign_up.setForeground(Color.blue);
        panel_username.add(label_sign_up,gbc);
        label_sign_up.addMouseListener(this);
        
        //2nd panel
        panel_password = new JPanel(new GridBagLayout());
        panel_password.setBorder(b);        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,0,0);
        label_user = new JLabel("User: ");    
        label_user.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_password.add(label_user,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(5,20,5,0);
        label_password = new JLabel("Password:");
        label_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_password.add(label_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,20);
        passwordField_password = new JPasswordField();
        passwordField_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        passwordField_password.setPreferredSize(new Dimension(260,35));
        passwordField_password.setEchoChar('*');
        panel_password.add(passwordField_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0,20,10,0);
        label_forget_password = new JLabel("Forget Password? Click here.");    
        label_forget_password.setFont(new Font("Cambria Math",Font.ITALIC,15));
        label_forget_password.setForeground(Color.blue);
        panel_password.add(label_forget_password,gbc);
        label_forget_password.addMouseListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0,20,10,20);
        button_login = new JButton("Login");
        button_login.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_login.setPreferredSize(new Dimension(120,40));
        panel_password.add(button_login,gbc);
        button_login.addActionListener(this);
        
        panel_cards.add(panel_username, "username");
        panel_cards.add(panel_password, "password");
        
        //setVisible(true);
        setModal(true);
        
    }
    
    //getter of user_type
    public String UserType(){
        return user_type;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_next){
            
            //check whether the email entered exists in respective file
            //if exists, save it in acc_login object and go to next page
            OODJ_Assignment.acc_login = null;
            user_type=null;
            if (bg.getSelection()!=null){
                if (bg.getSelection().getActionCommand().equals("student")){
                    
                    for (int i=0; i<OODJ_Assignment.allStudent.size(); i++){
                        Student std = OODJ_Assignment.allStudent.get(i);
                        if (textField_username.getText().equals(std.getEmail())){
                            OODJ_Assignment.acc_login= std;
                            break;
                        }
                    }if (OODJ_Assignment.acc_login != null){
                        //CardLayout cl = (CardLayout) panel_cards.getLayout();
                        cl.next(panel_cards);
                        label_user.setText("User: "+OODJ_Assignment.acc_login.getName());
                    }else{
                        JOptionPane.showMessageDialog(null, "Email not found.");
                    }
                    
                } else if (bg.getSelection().getActionCommand().equals("admin")){
                    
                    for (int i=0; i<OODJ_Assignment.allAdmin.size();i++){
                        Admin admin = OODJ_Assignment.allAdmin.get(i);
                        if (textField_username.getText().equals(admin.getEmail())){
                            OODJ_Assignment.acc_login = admin;
                            break;
                        }
                    }if (OODJ_Assignment.acc_login != null){
                        //CardLayout cl = (CardLayout) panel_cards.getLayout();
                        cl.next(panel_cards);
                        label_user.setText("User: "+OODJ_Assignment.acc_login.getName());
                    }else{
                        JOptionPane.showMessageDialog(null, "Email not found.");
                    }
                    
                }else if (bg.getSelection().getActionCommand().equals("coach")){
                    
                    for (int i=0; i<OODJ_Assignment.allCoach.size(); i++){
                        Coach c = OODJ_Assignment.allCoach.get(i);
                        if (textField_username.getText().equals(c.getEmail())){
                            OODJ_Assignment.acc_login = c;
                            break;
                        }


                    }if (OODJ_Assignment.acc_login != null){
                        //CardLayout cl = (CardLayout) panel_cards.getLayout();
                        cl.next(panel_cards);
                        label_user.setText("User: "+OODJ_Assignment.acc_login.getName());
                    }else{
                        JOptionPane.showMessageDialog(null, "Email not found.");
                    }

                }
                user_type=bg.getSelection().getActionCommand();
            }else if(bg.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Select user type.");
            }

        } else if (e.getSource() == button_login){
            
            //if the password is correct, open student/admin/coach page and change the theme
            if (bg.getSelection().getActionCommand().equals("student")){
                if (OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))){
                    this.setVisible(false);
                    OODJ_Assignment.homePage.setVisible(false);
                    OODJ_Assignment.studentPage.setVisible(true);
                    if (OODJ_Assignment.acc_login.getTheme().equals("light")){
                        OODJ_Assignment.studentPage.lightTheme();
                    }else {
                        OODJ_Assignment.studentPage.darkTheme();
                    }

                }else if (!OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))){
                    JOptionPane.showMessageDialog(null, "Wrong Password.");
                }
            }else if (bg.getSelection().getActionCommand().equals("admin")) {
                if (OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))) {
                    this.setVisible(false);
                    OODJ_Assignment.homePage.setVisible(false);
                    OODJ_Assignment.adminPage.setVisible(true);
                    if (OODJ_Assignment.acc_login.getTheme().equals("light")){
                        OODJ_Assignment.adminPage.lightTheme();
                    }else {
                        OODJ_Assignment.adminPage.darkTheme();
                    }

                } else if (!OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Wrong Password.");
                }
            }else if (bg.getSelection().getActionCommand().equals("coach")){
                if (OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))){
                    this.setVisible(false);
                    OODJ_Assignment.homePage.setVisible(false);
                    OODJ_Assignment.coachPage.setVisible(true);
                    if (OODJ_Assignment.acc_login.getTheme().equals("light")){
                        OODJ_Assignment.coachPage.lightTheme();
                    }else {
                        OODJ_Assignment.coachPage.darkTheme();
                    }

                } else if (!OODJ_Assignment.acc_login.getPassword().equals(String.valueOf(passwordField_password.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Wrong Password.");
                }
            }
            
        }
    }
    
    public void mouseExited(MouseEvent e){
        
    }
    
    public void mouseEntered(MouseEvent e){
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void mousePressed(MouseEvent e){
        
    }
    
    //trigger event when the label is clicked
    public void mouseClicked(MouseEvent e){
        if (e.getSource() == label_forget_password){
            this.setVisible(false);
            OODJ_Assignment.forgetPassword.setVisible(true);
        } else if (e.getSource() == label_sign_up){
            this.setVisible(false);
            OODJ_Assignment.registerPage.setVisible(true);
        }
    }
    
    public void componentShown(ComponentEvent e){

    }
        
    //reset the textfield when the frame is hidden
    public void componentHidden(ComponentEvent e){
        //CardLayout cl = (CardLayout) panel_cards.getLayout();
        cl.show(panel_cards, "username");
        textField_username.setText("");
        bg.clearSelection();
        passwordField_password.setText("");
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    }
    
}
