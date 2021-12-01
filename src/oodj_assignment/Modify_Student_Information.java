package oodj_assignment;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Modify_Student_Information extends JDialog implements ActionListener, ComponentListener {
    
    private JButton button_save_changes;
    private JComboBox combobox_blood_type;
    private JLabel label_nameL, label_nameV, label_ic_numberL, label_ic_numberV, label_birth_dateL, label_birth_dateV, label_genderL, label_genderV,
            label_email, label_phone_number, label_occupation, label_blood_type;
    private JPanel panel_main;
    private JTextField textField_email, textField_phone_number, textField_occupation;
    
    public Modify_Student_Information(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(600,750);
        setLocation(800,175);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Modify Information");
               
        panel_main = new JPanel(new GridBagLayout());
        TitledBorder b = BorderFactory.createTitledBorder("Modify Information");
        b.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(b);      
        add(panel_main);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_nameL = new JLabel("Name: ");
        label_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_nameL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_nameL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_nameV = new JLabel("Name");
        label_nameV.setHorizontalAlignment(SwingConstants.LEFT);
        label_nameV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_nameV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberL = new JLabel("IC/Passport No.: ");
        label_ic_numberL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_ic_numberL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_ic_numberL,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_ic_numberV = new JLabel("000000-00-0000");
        label_ic_numberV.setHorizontalAlignment(SwingConstants.LEFT);
        label_ic_numberV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_ic_numberV,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateL = new JLabel("Birth Date: ");
        label_birth_dateL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_birth_dateL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_birth_dateL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_birth_dateV = new JLabel("00-00-0000");
        label_birth_dateV.setHorizontalAlignment(SwingConstants.LEFT);
        label_birth_dateV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_birth_dateV,gbc);  
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderL = new JLabel("Gender: ");
        label_genderL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_genderL.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_genderL,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_genderV = new JLabel("Male");
        label_genderV.setHorizontalAlignment(SwingConstants.LEFT);
        label_genderV.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_genderV,gbc); 
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_email = new JLabel("Email: ");
        label_email.setHorizontalAlignment(SwingConstants.RIGHT);
        label_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_email,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_email = new JTextField();
        textField_email.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_email.setPreferredSize(new Dimension(260,30));
        panel_main.add(textField_email,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_phone_number = new JLabel("Phone No.: ");
        label_phone_number.setHorizontalAlignment(SwingConstants.RIGHT);
        label_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_phone_number,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_phone_number = new JTextField();
        textField_phone_number.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_phone_number.setPreferredSize(new Dimension(260,30));
        panel_main.add(textField_phone_number,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_occupation = new JLabel("Occupation: ");
        label_occupation.setHorizontalAlignment(SwingConstants.RIGHT);
        label_occupation.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_occupation,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_occupation = new JTextField();
        textField_occupation.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_occupation.setPreferredSize(new Dimension(260,30));
        panel_main.add(textField_occupation,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_blood_type = new JLabel("Blood Type: ");
        label_blood_type.setHorizontalAlignment(SwingConstants.RIGHT);
        label_blood_type.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(label_blood_type,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        String items[] = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
        combobox_blood_type = new JComboBox(items);
        combobox_blood_type.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_blood_type.setPreferredSize(new Dimension(260,30));
        panel_main.add(combobox_blood_type,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,0,0,20);
        button_save_changes = new JButton("Save Changes");
        button_save_changes.setFont(new Font("Cambria Math",Font.PLAIN,20)); 
        button_save_changes.setPreferredSize(new Dimension(200,50));
        panel_main.add(button_save_changes,gbc);
        button_save_changes.addActionListener(this);
        
        setModal(true);
        //setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_save_changes) {
            
            //check whether all the information is filled and valid
            if (!textField_email.getText().isEmpty() && !textField_occupation.getText().isEmpty() && !textField_phone_number.getText().isEmpty()) {
                if (OODJ_Assignment.checkPhoneNumber(textField_phone_number.getText()) && OODJ_Assignment.checkAlphabetOnly(textField_occupation.getText())){
                    for (int i = 0; i < OODJ_Assignment.allStudent.size(); i++) {
                        Student std = OODJ_Assignment.allStudent.get(i);
                        if (OODJ_Assignment.acc_login.getEmail().equals(std.getEmail())) {
                            std.setEmail(textField_email.getText());
                            std.setPhone_number(textField_phone_number.getText());
                            std.setOccupation(textField_occupation.getText());
                            std.setBlood_type(combobox_blood_type.getSelectedItem().toString());

                            //update text file
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

                            } catch (FileNotFoundException fileNotFoundException) {
                                //fileNotFoundException.printStackTrace();
                            }

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html>Invalid Input! Please ensure your phone number has<br>more than 9 numerical digits and occupation does<br>not include numbers.</html>");
                }              
            }else {
                JOptionPane.showMessageDialog(null,"Please fill up the blanks.");
            }
            
        }
    }
    
    //change the label text when the frame is shown
    public void componentShown(ComponentEvent e){
        Student std =(Student) OODJ_Assignment.acc_login;
        label_nameV.setText(std.getName());
        label_ic_numberV.setText(std.getIC());
        label_birth_dateV.setText(std.getDOB());
        label_genderV.setText(std.getGender());
        textField_email.setText(std.getEmail());
        textField_phone_number.setText(std.getPhone_number());
        textField_occupation.setText(std.getOccupation());
        combobox_blood_type.setSelectedItem(std.getBlood_type());
    }

    public void componentHidden(ComponentEvent e){

    }

    public void componentMoved(ComponentEvent e){

    }

    public void componentResized(ComponentEvent e){

    }
    
}
