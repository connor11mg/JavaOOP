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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin_Manage_Centre extends JDialog implements ActionListener, ComponentListener {
    
    private Box box_modify, box_view;
    private CardLayout cl = new CardLayout();
    private JButton button_close, button_save_changes;
    private JLabel label_idL, label_nameL, label_locationL, label_sports_availableL, label_view_id, label_view_name,
                    label_view_location, label_modify_id, label_modify_name;
    private JPanel panel_main, panel_cards, panel_view, panel_modify;
    private JScrollPane scrollPane_view, scrollPane_modify;
    private JTextField textField_modify_location;
    private TitledBorder border_view, border_modify;
    public int getCentreIndex;
    
    public Admin_Manage_Centre(){
        
        addComponentListener(this);                                 //needed for ComponentShown
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(700,700);
        setLocation(750,175);
        setTitle("Centre");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Centre");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_modify = BorderFactory.createTitledBorder("Modify Centre");
        border_modify.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_idL = new JLabel("ID:  ");
        label_idL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_idL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_idL.setForeground(new Color(34,34,59)); 
        panel_main.add(label_idL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_nameL = new JLabel("Name:  ");
        label_nameL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_nameL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_nameL.setForeground(new Color(34,34,59)); 
        panel_main.add(label_nameL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        label_locationL = new JLabel("Location:  ");
        label_locationL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_locationL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_locationL.setForeground(new Color(34,34,59)); 
        panel_main.add(label_locationL,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20,0,0,0);
        label_sports_availableL = new JLabel("Sports Available:  ");
        label_sports_availableL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_sports_availableL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_sports_availableL.setForeground(new Color(34,34,59)); 
        panel_main.add(label_sports_availableL,gbc);
        
        //cards panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
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
        label_view_id = new JLabel("SC0001");
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
        label_view_name = new JLabel("Petaling Branch");
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
        label_view_location = new JLabel("xxx, Jalan Petaling blabla, Petaling Jaya, Selangor.");
        label_view_location.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_location.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_location.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_location,gbc);        
        
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
        gbc.insets = new Insets(0,0,3,20);
        label_modify_id = new JLabel("SC0001");
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
        gbc.insets = new Insets(0,0,3,20);
        label_modify_name = new JLabel("Petaling Branch");
        label_modify_name.setHorizontalAlignment(SwingConstants.LEFT);
        label_modify_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_modify_name.setForeground(new Color(34,34,59)); 
        panel_modify.add(label_modify_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,20);
        textField_modify_location = new JTextField();
        textField_modify_location.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_modify_location.setPreferredSize(new Dimension(260,30));
        panel_modify.add(textField_modify_location,gbc);
        
        panel_cards.add(panel_view, "view");
        panel_cards.add(panel_modify,"modify");
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,0,0);              
        box_modify = Box.createVerticalBox();
        for(int i=0; i <10;i++){
            JCheckBox checkbox = new JCheckBox(""+i);
            checkbox.setFont(new Font("Cambria Math",Font.PLAIN,20));
            box_modify.add(checkbox);
        }
        scrollPane_modify = new JScrollPane(box_modify);
        scrollPane_modify.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane_modify.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_modify.setPreferredSize(new Dimension(450,280));
        scrollPane_modify.setVisible(false);
        panel_main.add(scrollPane_modify,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,0,0);              
        box_view = Box.createVerticalBox();
        for(int i=0; i <10;i++){
            JCheckBox checkbox = new JCheckBox(""+i);
            checkbox.setFont(new Font("Cambria Math",Font.PLAIN,20));
            checkbox.setEnabled(false);
            box_view.add(checkbox);
        }
        scrollPane_view = new JScrollPane(box_view);
        scrollPane_view.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane_view.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane_view.setPreferredSize(new Dimension(450,280));
        panel_main.add(scrollPane_view,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        button_save_changes = new JButton("Save Changes");
        button_save_changes.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_save_changes.setForeground(new Color(34,34,59)); 
        button_save_changes.setPreferredSize(new Dimension(200,50));
        button_save_changes.setVisible(false);
        panel_main.add(button_save_changes,gbc);
        button_save_changes.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        button_close = new JButton("Close");
        button_close.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_close.setForeground(new Color(34,34,59)); 
        button_close.setPreferredSize(new Dimension(200,50));
        panel_main.add(button_close,gbc);
        button_close.addActionListener(this);
        
        setModal(true);         //set other page cannot be access until this window is closed
                    
    }
    
    //panel_main getter
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    //if admin click view button in admin page
    public void viewClicked(){
        panel_main.setBorder(border_view);
        cl.show(panel_cards, "view");
        button_save_changes.setVisible(false);
        scrollPane_modify.setVisible(false);
        button_close.setVisible(true);
        scrollPane_view.setVisible(true);
    }
    
    //if admin click modify button in admin page
    public void modifyClicked(){
        panel_main.setBorder(border_modify);
        cl.show(panel_cards, "modify");
        button_close.setVisible(false);   
        scrollPane_view.setVisible(false);
        button_save_changes.setVisible(true);
        scrollPane_modify.setVisible(true);
    }
    
    //method to update the checkboxes of sports if admin click view in admin page
    public void updateViewCheckBox(){
        box_view.removeAll();

        for (int i=0; i<OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().size(); i++){
            JCheckBox checkbox = new JCheckBox(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().get(i).getSport_name());
            checkbox.setFont(new Font("Cambria Math",Font.PLAIN,20));
            checkbox.setEnabled(false);
            box_view.add(checkbox);
        }
        
    }

    //method to update the checkboxes of sports if admin click modify in admin page
    public void updateModifyCheckBox(){
        box_modify.removeAll();
        ArrayList<String> centreSport = new ArrayList<String>();
        ArrayList<String> sports = new ArrayList<String>();

        for (int i=0; i<OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().size();i++){
            centreSport.add(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().get(i).getSport_name());
        }


        for (int i=0; i<OODJ_Assignment.allSport.size();i++){
            sports.add(OODJ_Assignment.allSport.get(i).getSport_name());
        }

        sports.removeAll(centreSport);


        for (int i=0; i<sports.size(); i++){
            JCheckBox checkBox = new JCheckBox(sports.get(i));
            checkBox.setFont(new Font("Cambria Math",Font.PLAIN,20));
            checkBox.setEnabled(true);
            checkBox.setActionCommand(sports.get(i));
            box_modify.add(checkBox);
        }

        for (int i=0; i<centreSport.size(); i++){
            JCheckBox checkbox = new JCheckBox(centreSport.get(i));
            checkbox.setFont(new Font("Cambria Math",Font.PLAIN,20));
            checkbox.setEnabled(true);
            checkbox.setSelected(true);
            checkbox.setActionCommand(centreSport.get(i));
            box_modify.add(checkbox);
        }

    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_close){
            
            this.setVisible(false);                         //close the window
            box_view.removeAll();
            
        }else if (e.getSource()==button_save_changes){
            
            //loop and check which checkbox is selected and update the sports available in selected centre
            ArrayList<String> selectedSport= new ArrayList<String>();
            String s = new String();
            for (Component c: box_modify.getComponents()){
                if (c.getClass() == JCheckBox.class){
                    JCheckBox cb = (JCheckBox) c;
                    if (cb.isSelected()){
                        selectedSport.add(cb.getActionCommand());
                        }
                    }

                }
            //double confirm with the user
            for (int i=0; i<selectedSport.size();i++){
                s = s+","+selectedSport.get(i);
            }
            int confirm = JOptionPane.showConfirmDialog(null, "Change sports available to  "+s.substring(1)+"  for "+OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_name()+"?" );
            //if user confirm to change the sport, remove all sports available in selected centre,
            //then add the new sports set to the centre
            if (confirm==JOptionPane.YES_OPTION){
                OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().removeAll(OODJ_Assignment.allSport);
                for (int a=0; a<selectedSport.size();a++){
                    for (int b=0; b<OODJ_Assignment.allSport.size(); b++){
                        if (OODJ_Assignment.allSport.get(b).getSport_name().equals(selectedSport.get(a))){
                            OODJ_Assignment.allSportsCentre.get(getCentreIndex).getSport().add(OODJ_Assignment.allSport.get(b));

                        }
                    }
                }
                //update text file
                try {
                    PrintWriter p = new PrintWriter("sports_centre.txt");
                    for (int c=0; c<OODJ_Assignment.allSportsCentre.size();c++){
                        SportsCentre sc= OODJ_Assignment.allSportsCentre.get(c);
                        p.println(sc.getCenter_id());
                        p.println(sc.getCenter_name());
                        p.println(sc.getCenter_location());
                        String sportnames = new String();
                        for (int d=0; d<OODJ_Assignment.allSportsCentre.get(c).getSport().size();d++){
                            sportnames = sportnames+">>"+OODJ_Assignment.allSportsCentre.get(c).getSport().get(d).getSport_name();
                        }
                        p.println(sportnames.substring(2));
                        p.println();
                    }
                    p.close();
                    JOptionPane.showMessageDialog(null, "Updated.");
                    OODJ_Assignment.adminPage.update_centre_table();

                } catch (FileNotFoundException fileNotFoundException) {
                    //fileNotFoundException.printStackTrace();
                }
            }
            
        }       
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {
        //change the text of labels when this frame turns visible
        label_view_id.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_id());
        label_view_location.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_location());
        label_view_name.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_name());
        label_modify_id.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_id());
        label_modify_name.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_name());
        textField_modify_location.setText(OODJ_Assignment.allSportsCentre.get(getCentreIndex).getCenter_location());
    }

    public void componentHidden(ComponentEvent e) {

    }
}
