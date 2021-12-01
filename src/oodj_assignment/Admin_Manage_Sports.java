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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Admin_Manage_Sports extends JDialog implements Admin_Management, ActionListener, ComponentListener{
   
    private CardLayout cl = new CardLayout();
    private JButton button_close, button_save_changes, button_add;
    private JLabel label_idL, label_nameL, label_priceL, label_view_id, label_view_name, label_view_price, label_modify_id, label_modify_name;
    private JPanel panel_main, panel_labels, panel_cards, panel_view, panel_modify, panel_add;
    private JSpinner spinner_modify_price, spinner_add_price;
    private JTextField textField_add_id, textField_add_name;
    private TitledBorder border_view, border_modify, border_add;
    public int getSportIndex;
    
    public Admin_Manage_Sports(){
        
        addComponentListener(this);                             //needed for ComponentShown
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(600,400);
        setLocation(800,325);
        setTitle("Sports");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        border_view = BorderFactory.createTitledBorder("View Sport");
        border_view.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_modify = BorderFactory.createTitledBorder("Modify Sport");
        border_modify.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        border_add = BorderFactory.createTitledBorder("Add Sport");
        border_add.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border_view);
        panel_main.setLayout(new GridBagLayout());
        panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        //labels panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
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
        label_idL = new JLabel("Sport ID:  ");
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
        label_nameL = new JLabel("Sport Name:  ");
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
        label_priceL = new JLabel("Price/month(4 classes):  ");
        label_priceL.setHorizontalAlignment(SwingConstants.RIGHT);
        label_priceL.setFont(new Font("Cambria Math",Font.BOLD,20));
        label_priceL.setForeground(new Color(34,34,59)); 
        panel_labels.add(label_priceL,gbc);
        
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
        label_view_name = new JLabel("basketball");
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
        label_view_price = new JLabel("150");
        label_view_price.setHorizontalAlignment(SwingConstants.LEFT);
        label_view_price.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_view_price.setForeground(new Color(34,34,59)); 
        panel_view.add(label_view_price,gbc);       
        
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
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,0,20);
        SpinnerModel model = new SpinnerNumberModel(50,50,500,10);
        spinner_modify_price = new JSpinner(model);
        spinner_modify_price.setFont(new Font("Cambria Math",Font.PLAIN,20));
        spinner_modify_price.setPreferredSize(new Dimension(200,30));
        panel_modify.add(spinner_modify_price,gbc);
        
        //add panel
        panel_add = new JPanel(new GridBagLayout());
        panel_add.setOpaque(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
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
        textField_add_name = new JTextField();
        textField_add_name.setFont(new Font("Cambria Math",Font.PLAIN,20));
        panel_add.add(textField_add_name,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,0,20);
        spinner_add_price = new JSpinner(model);
        spinner_add_price.setFont(new Font("Cambria Math",Font.PLAIN,20)); 
        spinner_add_price.setPreferredSize(new Dimension(200,30));
        panel_add.add(spinner_add_price,gbc);
        
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
        gbc.insets = new Insets(0,0,5,0);
        button_save_changes = new JButton("Save Changes");
        button_save_changes.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_save_changes.setForeground(new Color(34,34,59)); 
        button_save_changes.setPreferredSize(new Dimension(150,50));
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
        gbc.insets = new Insets(0,0,5,0);
        button_add = new JButton("Add");
        button_add.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_add.setForeground(new Color(34,34,59)); 
        button_add.setPreferredSize(new Dimension(150,50));
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
        gbc.insets = new Insets(0,0,5,0);
        button_close = new JButton("Close");
        button_close.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_close.setForeground(new Color(34,34,59)); 
        button_close.setPreferredSize(new Dimension(150,50));
        panel_main.add(button_close,gbc);
        button_close.addActionListener(this);
        
        setModal(true);             //set other page cannot be access until this window is closed
        
    }
    
    //getter of panel_main
    public JPanel getPanelMain(){
        return panel_main;
    }
    
    //if the view button is clicked in admin page
    public void viewClicked(){
        panel_main.setBorder(border_view);
        cl.show(panel_cards, "view");
        button_save_changes.setVisible(false);
        button_add.setVisible(false);
        button_close.setVisible(true);
    }
    
    //if the modify button is clicked in admin page
    public void modifyClicked(){
        panel_main.setBorder(border_modify);
        cl.show(panel_cards, "modify");
        button_close.setVisible(false);        
        button_add.setVisible(false);
        button_save_changes.setVisible(true);
    }
    
    //if the add button is clicked in admin page
    public void addClicked(){
        panel_main.setBorder(border_add);
        cl.show(panel_cards, "add");
        button_close.setVisible(false);
        button_save_changes.setVisible(false);
        button_add.setVisible(true);
    }
    
    //method to generate new sport id
    //get the number of sports+1
    public void createSportID(){
        int id_count = OODJ_Assignment.allSport.size()+1;
        String id = null;
        if (String.valueOf(id_count).length()==1){
            id= "SP"+"000"+id_count;
        }else if (String.valueOf(id_count).length()==2){
            id="SP"+"00"+id_count;
        }else if (String.valueOf(id_count).length()==3){
            id="SP"+"0"+id_count;
        }else if (String.valueOf(id_count).length()==4){
            id="SP"+id_count;
        }
        textField_add_id.setText(id);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button_close){
            
            this.setVisible(false);     //close the window
            
        }else if (e.getSource()== button_save_changes){
            
            //double confirm whether user want to change the price
            int confirm = JOptionPane.showConfirmDialog(this, "Change "+label_modify_name.getText()+" to RM"+String.valueOf(spinner_modify_price.getValue())+"?", "Sport- Change of Price", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                OODJ_Assignment.allSport.get(getSportIndex).setPrice(Double.parseDouble(spinner_modify_price.getValue().toString()));
                try {
                    //update text file
                    PrintWriter p = new PrintWriter("sport.txt");
                    for (int i=0; i<OODJ_Assignment.allSport.size(); i++){
                        Sport s = OODJ_Assignment.allSport.get(i);
                        p.println(s.getId());
                        p.println(s.getSport_name());
                        p.println(s.getPrice());
                        p.println();
                    }
                    p.close();
                    JOptionPane.showMessageDialog(null, "Updated.");
                    OODJ_Assignment.adminPage.update_sport_table();
                } catch (FileNotFoundException fileNotFoundException) {
                    //fileNotFoundException.printStackTrace();
                }
            }
            
        }else if (e.getSource()==button_add){
            
            //if everything is filled
            if (!textField_add_id.getText().isEmpty()&& !textField_add_name.getText().isEmpty()){
                String sport_name = textField_add_name.getText().substring(0,1).toUpperCase(Locale.ROOT)+textField_add_name.getText().substring(1);      //capitalise first letter and check if it is existing
                boolean flag = true;
                for (int i=0; i<OODJ_Assignment.allSport.size(); i++){
                    if (OODJ_Assignment.allSport.get(i).getSport_name().equals(sport_name)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    //add the sport to allSport ArrayList
                    Sport sport = new Sport(textField_add_id.getText(), sport_name, Double.parseDouble(spinner_add_price.getValue().toString()));
                    OODJ_Assignment.allSport.add(sport);
                    try {
                        //update text file
                        PrintWriter p = new PrintWriter("sport.text");
                        for (int i=0; i<OODJ_Assignment.allSport.size(); i++){
                            Sport s = OODJ_Assignment.allSport.get(i);

                            p.println(s.getId());
                            p.println(s.getSport_name());
                            p.println(s.getPrice());
                            p.println();
                        }
                        p.close();
                        JOptionPane.showMessageDialog(null, sport_name+" has been created.");
                        OODJ_Assignment.adminPage.update_sport_table();

                    } catch (FileNotFoundException fileNotFoundException) {
                        //fileNotFoundException.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "This sport "+"'"+sport_name+"'"+" is current existing in the system.");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Please fill up the blanks.");
            }
            
        }
    }
    
    public void componentResized(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {
        //update the text of all label and reset text filed when the frame is set to visible
        if (OODJ_Assignment.allSport.size() != 0){
            label_view_id.setText(OODJ_Assignment.allSport.get(getSportIndex).getId());
            label_view_name.setText(OODJ_Assignment.allSport.get(getSportIndex).getSport_name());
            label_view_price.setText(String.valueOf(OODJ_Assignment.allSport.get(getSportIndex).getPrice()));
            label_modify_id.setText(OODJ_Assignment.allSport.get(getSportIndex).getId());
            label_modify_name.setText(OODJ_Assignment.allSport.get(getSportIndex).getSport_name());
            spinner_modify_price.setValue(OODJ_Assignment.allSport.get(getSportIndex).getPrice());
        }        
        textField_add_name.setText("");
        //spinner_add_price.setValue(50);

        createSportID();
    }

    public void componentHidden(ComponentEvent e) {

    }
    
}
