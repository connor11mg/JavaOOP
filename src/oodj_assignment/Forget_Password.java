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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Forget_Password extends JFrame implements ActionListener, ComponentListener {
    
    private CardLayout cl = new CardLayout();
    private JButton button_next, button_change_password;
    private JComboBox combobox_question;
    private JLabel label_question, label_answer, label_new_password, label_confirm_password;
    private JPanel panel_question, panel_password, panel_cards;
    private JTextField textField_answer, textField_new_password, textField_confirm_password;
            
    public Forget_Password(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(650,400);
        setLocation(775,350);
        setTitle("Forget Password");
        
        panel_cards = new JPanel();
        panel_cards.setLayout(cl);
        add(panel_cards);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //1st panel
        panel_question = new JPanel(new GridBagLayout());
        TitledBorder b = BorderFactory.createTitledBorder("Forget Password?");
        b.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_question.setBorder(b);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(20,20,5,0);
        label_question = new JLabel("Security Question:");
        label_question.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_question.add(label_question,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,20,0,20);
        String[] items = {};
        combobox_question = new JComboBox(items);
        combobox_question.setEditable(true);
        combobox_question.setSelectedItem(" Select one question");
        combobox_question.setEditable(false);
        combobox_question.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_question.setPreferredSize(new Dimension(260,35));
        panel_question.add(combobox_question,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,20,0,0);
        label_answer = new JLabel("Answer:");
        label_answer.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_question.add(label_answer,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,20,0,20);
        textField_answer = new JTextField();
        textField_answer.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_answer.setPreferredSize(new Dimension(260,35));
        panel_question.add(textField_answer,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10,20,20,20);
        button_next = new JButton("Next");
        button_next.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_next.setPreferredSize(new Dimension(170,45));
        panel_question.add(button_next,gbc);
        button_next.addActionListener(this);
        
        //2nd panel
        panel_password = new JPanel(new GridBagLayout());
        panel_password.setBorder(b);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(20,20,5,0);
        label_new_password = new JLabel("New Password:");
        label_new_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_password.add(label_new_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,20,0,20);
        textField_new_password = new JTextField();
        textField_new_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_new_password.setPreferredSize(new Dimension(480,35));
        panel_password.add(textField_new_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,20,0,0);
        label_confirm_password = new JLabel("Confirm Password:");
        label_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_password.add(label_confirm_password,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5,20,0,20);
        textField_confirm_password = new JTextField();
        textField_confirm_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_confirm_password.setPreferredSize(new Dimension(480,35));
        panel_password.add(textField_confirm_password,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10,20,20,20);
        button_change_password = new JButton("Change Password");
        button_change_password.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_change_password.setPreferredSize(new Dimension(270,45));
        panel_password.add(button_change_password,gbc);
        button_change_password.addActionListener(this);
                
        panel_cards.add(panel_question,"question");
        panel_cards.add(panel_password,"password");
        
        //setVisible(true);
        
    }
    
    //method used to update account password
    //change the password of the account if password is forgotten
    public void changePasswordMethod(){
        Student std= (Student) OODJ_Assignment.acc_login;
        std.setPassword(textField_new_password.getText());
        
        //update the text file
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
            JOptionPane.showMessageDialog(null, "Password changed!");

        } catch (FileNotFoundException fileNotFoundException) {
            //fileNotFoundException.printStackTrace();
        }
    }

    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_next){
            
            //check whether the answer of security question is correct
            Student std= (Student) OODJ_Assignment.acc_login;
            if (OODJ_Assignment.loginPage.UserType().equals("student")){
                if (std.getQuestion1().equals(combobox_question.getSelectedItem())){
                    if (textField_answer.getText().equals(std.getAnswer1())){
                        cl.next(panel_cards);
                    }else{
                        JOptionPane.showMessageDialog(null, "Wrong answer.");
                    }
                }else if (std.getQuestion2().equals(combobox_question.getSelectedItem())){
                    if (textField_answer.getText().equals(std.getAnswer2())){
                        cl.next(panel_cards);
                    }else{
                        JOptionPane.showMessageDialog(null, "Wrong answer.");
                    }
                }
            }
            
        } else if (e.getSource() == button_change_password){
            
            //if the new password is valid, update the password
            if(textField_new_password.getText().length() >= 6){
                if (textField_new_password.getText().equals(textField_confirm_password.getText())){
                    if (!OODJ_Assignment.acc_login.getPassword().equals(textField_new_password.getText())){
                        changePasswordMethod();
                        this.setVisible(false);
                    }else {
                        JOptionPane.showMessageDialog(null, "Password cannot be the same as old password.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Password is not the same as confirm password.");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Password must have at least 6 digits.");
            }
                      
        }
    }
    
    //add the qeustions chosen by the user to the combobox
    public void componentShown(ComponentEvent e){
        if (OODJ_Assignment.loginPage.UserType().equals("student")){
            Student std =(Student) OODJ_Assignment.acc_login;
            
            
            combobox_question.removeAllItems();
            combobox_question.addItem(std.getQuestion1());
            combobox_question.addItem(std.getQuestion2());
        }else{
            JOptionPane.showMessageDialog(null, "Please contact admin for help.");
            this.setVisible(false);
        }
    }
        
    //reset the combobox and textfield when the frame is hidden
    public void componentHidden(ComponentEvent e){
        cl.show(panel_cards, "question");
        combobox_question.setEditable(true);
        combobox_question.setSelectedItem(" Select one question");
        combobox_question.setEditable(false);
        textField_answer.setText("");
        OODJ_Assignment.loginPage.setVisible(true);
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
                  
    }
    
    public void componentClosed(ComponentEvent e){
        
    }
    
}
