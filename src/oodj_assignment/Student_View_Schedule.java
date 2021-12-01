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

public class Student_View_Schedule extends JDialog implements ActionListener, ComponentListener {
    
    private JButton button_close;
    private JLabel label_idL, label_sport_codeL, label_sport_nameL, label_centre_codeL, label_centre_nameL, label_dayL, label_timeL, label_coachL,
                    label_view_id, label_view_sport_code, label_view_sport_name, label_view_centre_code, label_view_centre_name, label_view_day, label_view_time,
                    label_view_coach;
    private JPanel panel_main, panel_labels, panel_view;
    private TitledBorder border_view;
    public int getTableScheduleIndex;
    
    public Student_View_Schedule(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        addComponentListener(this);
        
        setSize(550,700);
        setLocation(875,175);
        setTitle("Schedule");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Schedule");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(250,243,221));
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
        label_idL.setForeground(new Color(94,100,114)); 
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
        label_sport_codeL.setForeground(new Color(94,100,114)); 
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
        label_sport_nameL.setForeground(new Color(94,100,114)); 
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
        label_centre_codeL.setForeground(new Color(94,100,114)); 
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
        label_centre_nameL.setForeground(new Color(94,100,114)); 
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
        label_dayL.setForeground(new Color(94,100,114)); 
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
        label_timeL.setForeground(new Color(94,100,114)); 
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
        label_coachL.setForeground(new Color(94,100,114)); 
        panel_labels.add(label_coachL,gbc);
        
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
        label_view_id.setForeground(new Color(94,100,114)); 
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
        label_view_sport_code.setForeground(new Color(94,100,114)); 
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
        label_view_sport_name.setForeground(new Color(94,100,114)); 
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
        label_view_centre_code.setForeground(new Color(94,100,114)); 
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
        label_view_centre_name.setForeground(new Color(94,100,114)); 
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
        label_view_day.setForeground(new Color(94,100,114)); 
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
        label_view_time.setForeground(new Color(94,100,114)); 
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
        label_view_coach.setForeground(new Color(94,100,114)); 
        panel_view.add(label_view_coach,gbc);
       
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
        button_close.setForeground(new Color(94,100,114)); 
        button_close.setPreferredSize(new Dimension(150,40));
        panel_main.add(button_close,gbc);
        button_close.addActionListener(this);
        
        setModal(true);
                
    }
    
    //getter of panel_main
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    public void viewClicked(){
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_close){
            
            this.setVisible(false);
            
        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    //change the text of all labels when the frame is shown
    public void componentShown(ComponentEvent e) {
        
       //
       //view
       //
       label_view_id.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getId());
       label_view_sport_code.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getSport().get(0).getId());
       label_view_sport_name.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getSport().get(0).getSport_name());
       label_view_centre_name.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getCentre_name());
       label_view_day.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getDay().toString());
       label_view_time.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getTime().toString().replace('$',' '));
       label_view_coach.setText(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getCoach());

       for (int i=0;i<OODJ_Assignment.allSportsCentre.size();i++){
           if (OODJ_Assignment.allSportsCentre.get(i).getCenter_name().equals(OODJ_Assignment.allRegisteredSport.get(getTableScheduleIndex).getSchedule().get(0).getCentre_name())){
               label_view_centre_code.setText(OODJ_Assignment.allSportsCentre.get(i).getCenter_id());
           }
       }

    }

    public void componentHidden(ComponentEvent e) {

    }
    
}
