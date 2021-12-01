package oodj_assignment;

import java.awt.BorderLayout;
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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Rate_Coach extends JDialog implements ActionListener, ComponentListener{
    
    private ButtonGroup bg;
    private JButton button_submit;
    private JLabel label_rating, label_feedback, label_note, label_very_dissatisfied, label_very_satisfied;
    private JPanel panel_main, panel_satisfaction;
    private JRadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    private JTextArea textArea_feedback;
    public String table_coach_id;
    
    public Rate_Coach(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        addComponentListener(this);
        
        setSize(500,450);
        setLocation(850,325);
        setTitle("Rate Coach");
               
        panel_main = new JPanel(new GridBagLayout());
        TitledBorder b = BorderFactory.createTitledBorder("Rate Coach");
        b.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(b);      
        add(panel_main);
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(10,15,0,0);
        label_rating = new JLabel("Rating: ");
        label_rating.setHorizontalAlignment(SwingConstants.LEFT);
        label_rating.setFont(new Font("Cambria Math",Font.PLAIN,20)); 
        panel_main.add(label_rating,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0,0,0,0);
        panel_satisfaction = new JPanel();
        panel_satisfaction.setBorder(new EmptyBorder(0,20,0,40));
        panel_satisfaction.setLayout(new BorderLayout());
        panel_main.add(panel_satisfaction,gbc);
        
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.weightx = 1;
//        gbc.weighty = 0.3;
//        gbc.gridwidth = 3;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.anchor = GridBagConstraints.SOUTH;
//        gbc.insets = new Insets(0,15,0,0);
        label_very_dissatisfied = new JLabel("Very Dissatisfied");
        label_very_dissatisfied.setHorizontalAlignment(SwingConstants.LEFT);
        label_very_dissatisfied.setFont(new Font("Cambria Math",Font.PLAIN,16)); 
        panel_satisfaction.add(label_very_dissatisfied,BorderLayout.LINE_START);
        
//        gbc.gridx = 3;
//        gbc.gridy = 1;
//        gbc.weightx = 1;
//        gbc.weighty = 0.3;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.anchor = GridBagConstraints.SOUTH;
//        gbc.insets = new Insets(0,0,0,50);
        label_very_satisfied = new JLabel("Very Satisfied");
        label_very_satisfied.setHorizontalAlignment(SwingConstants.RIGHT);
        label_very_satisfied.setFont(new Font("Cambria Math",Font.PLAIN,16)); 
        panel_satisfaction.add(label_very_satisfied,BorderLayout.LINE_END);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,20,0,0);
        radioButton1= new JRadioButton("1");
        radioButton1.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(radioButton1,gbc);
        radioButton1.setActionCommand("1");
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton2= new JRadioButton("2");
        radioButton2.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(radioButton2,gbc);
        radioButton2.setActionCommand("2");
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton3= new JRadioButton("3");
        radioButton3.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(radioButton3,gbc);
        radioButton3.setActionCommand("3");
        
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton4= new JRadioButton("4");
        radioButton4.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(radioButton4,gbc);
        radioButton4.setActionCommand("4");
        
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        radioButton5= new JRadioButton("5");
        radioButton5.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_main.add(radioButton5,gbc);
        radioButton5.setActionCommand("5");
        
        bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton4);
        bg.add(radioButton5);        
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0,15,0,0);
        label_feedback = new JLabel("Feedback: ");
        label_feedback.setHorizontalAlignment(SwingConstants.LEFT);
        label_feedback.setFont(new Font("Cambria Math",Font.PLAIN,20)); 
        panel_main.add(label_feedback,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,15);
        textArea_feedback = new JTextArea(4,10);
        textArea_feedback.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textArea_feedback.setLineWrap(true);
        textArea_feedback.setWrapStyleWord(false);
        JScrollPane sp = new JScrollPane(textArea_feedback);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel_main.add(sp,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1;
        gbc.weighty = 0.3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,15,0,15);
        label_note = new JLabel("*Your rating is anonymous.");
        label_note.setForeground(Color.RED);
        label_note.setHorizontalAlignment(SwingConstants.LEFT);
        label_note.setFont(new Font("Cambria Math",Font.PLAIN,16)); 
        panel_main.add(label_note,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,0,0,15);
        button_submit = new JButton("Submit");
        button_submit.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_submit.setPreferredSize(new Dimension(150,40));
        panel_main.add(button_submit,gbc);
        button_submit.addActionListener(this);
        
        setModal(true);
        //setVisible(true);
        
    }
    
    //auto generate a rating id
    //count the number of rating+1
    public String createRateCoachId(){
        int id_count =OODJ_Assignment.allRateCoach.size()+1;
        String id = new String();
        if (String.valueOf(id_count).length()==1){
            id= "RC"+"000"+id_count;
        }else if (String.valueOf(id_count).length()==2){
            id="RC"+"00"+id_count;
        }else if (String.valueOf(id_count).length()==3){
            id="RC"+"0"+id_count;
        }else if (String.valueOf(id_count).length()==4){
            id="RC"+id_count;
        }
        return id;
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_submit){

            //if one of the 5 radio button is selected, save the data into allRateCoach ArrayList and update text file
            if (bg.getSelection()!=null){
                if (textArea_feedback.getText().length()>=3){
                    RateCoach rc = new RateCoach(createRateCoachId(), table_coach_id, textArea_feedback.getText(), Integer.parseInt(bg.getSelection().getActionCommand()));
                    OODJ_Assignment.allRateCoach.add(rc);

                    try {
                        PrintWriter p = new PrintWriter("rate_coach.txt");
                        for (int i=0; i<OODJ_Assignment.allRateCoach.size(); i++){
                            RateCoach rateC = OODJ_Assignment.allRateCoach.get(i);
                            p.println(rateC.getId());
                            p.println(rateC.getCoach_id());
                            p.println(rateC.getFeedback());
                            p.println(rateC.getRating());
                            p.println();
                        }
                        p.close();
                        JOptionPane.showMessageDialog(null, "Rating has been submitted.");
                        OODJ_Assignment.coach_rating(table_coach_id);
                        OODJ_Assignment.studentPage.update_coach_table();
                        this.setVisible(false);

                    } catch (FileNotFoundException fileNotFoundException) {
                        //fileNotFoundException.printStackTrace();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Please type appropriately in the feedback in the provided blanks.  (3characters min.)");
                }

            }else if (bg.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Please select rating");
            }

        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    //reset the text area when the frame is shown or hidden
    public void componentShown(ComponentEvent e) {
        textArea_feedback.setText("");
    }

    public void componentHidden(ComponentEvent e) {
        textArea_feedback.setText("");
    }
}
