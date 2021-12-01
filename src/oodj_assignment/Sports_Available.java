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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Sports_Available extends JFrame implements ActionListener, ComponentListener, PropertyChangeListener {
    
    private JButton button_next, button_back, button_return;
    private JComboBox combobox_filter_sport, combobox_filter_day;
    private JLabel label_branch, label_filter_sport, label_filter_day;
    private JPanel panel_navigation;
    private JTable table_schedule;
    private TableRowSorter<TableModel> rowSorter_schedule;
    
    public Sports_Available(){
        
        addComponentListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(1000,700);
        setLocation(600,200);
        setTitle("Sports Available");       
        
        setLayout(new GridBagLayout());
        this.getContentPane().setBackground(new Color(255,241,190));
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        panel_navigation = new JPanel();
        panel_navigation.setLayout(new BorderLayout());
        panel_navigation.setBorder(new EmptyBorder(0,150,0,150));
        panel_navigation.setBackground(new Color(255,241,190));
        add(panel_navigation,gbc);
        
        ImageIcon i = new ImageIcon("images\\left_arrow.png");
        button_back = new JButton();
        button_back.setIcon(i);
        button_back.setBorder(BorderFactory.createEmptyBorder());
        button_back.setContentAreaFilled(false);
        panel_navigation.add(button_back,BorderLayout.LINE_START);
        button_back.addActionListener(this);
        
        label_branch = new JLabel();
        label_branch.setText("Kuala Selangor Branch");
        label_branch.setFont(new Font("Cambria Math",Font.PLAIN,40));
        label_branch.setHorizontalAlignment(SwingConstants.CENTER);
        panel_navigation.add(label_branch,BorderLayout.CENTER);
        label_branch.addPropertyChangeListener("text",this);
        
        i = new ImageIcon("images\\right_arrow.png");
        button_next = new JButton();
        button_next.setIcon(i);
        button_next.setBorder(BorderFactory.createEmptyBorder());
        button_next.setContentAreaFilled(false);
        panel_navigation.add(button_next,BorderLayout.LINE_END);
        button_next.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_filter_sport = new JLabel();
        label_filter_sport.setText("Filter by Sport: ");
        label_filter_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_filter_sport.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label_filter_sport,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,5);
        String items[] = {"All"};
        combobox_filter_sport = new JComboBox(items);
        combobox_filter_sport.setFont(new Font("Cambria Math",Font.PLAIN,20));
        //combobox_filter_sport.setPreferredSize(new Dimension(260,30));
        combobox_filter_sport.setBackground(Color.WHITE);
        add(combobox_filter_sport,gbc);
        combobox_filter_sport.addActionListener(this);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,0);
        label_filter_day = new JLabel();
        label_filter_day.setText("Filter by Day: ");
        label_filter_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        label_filter_day.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label_filter_day,gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,5,30);
        String items2[] = {"All", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        combobox_filter_day = new JComboBox(items2);
        combobox_filter_day.setFont(new Font("Cambria Math",Font.PLAIN,20));
        //combobox_filter_sport.setPreferredSize(new Dimension(260,30));
        combobox_filter_day.setBackground(Color.WHITE);
        add(combobox_filter_day,gbc);
        combobox_filter_day.addActionListener(this);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10,20,10,20);
        String schedule_column[] = {"Sports","Day","Time"};
        String schedule_data[][]={ {"xxx","Monday","xAM to yPM"}};
        table_schedule = new JTable(new DefaultTableModel(schedule_data,schedule_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_schedule.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_schedule.setForeground(new Color(34,34,59));
        table_schedule.setRowHeight(23);
        table_schedule.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_schedule.setAutoCreateRowSorter(true);
        table_schedule.getColumnModel().getColumn(0).setPreferredWidth(300);
        table_schedule.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_schedule.getColumnModel().getColumn(2).setPreferredWidth(150);
        table_schedule.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_schedule.getTableHeader().setReorderingAllowed(false);
        rowSorter_schedule = new TableRowSorter<>(table_schedule.getModel());
        table_schedule.setRowSorter(rowSorter_schedule);
        
        JScrollPane sp = new JScrollPane(table_schedule);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.getViewport().setBackground(new Color(255,251,226));
        add(sp,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0.05;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,0,0,0);
        button_return = new JButton("Return");
        button_return.setFont(new Font("Cambria Math",Font.PLAIN,20));
        button_return.setBackground(new Color(255,166,158));
        button_return.setPreferredSize(new Dimension(220,40));
        add(button_return,gbc);
        button_return.addActionListener(this);
        
    }
    

    //method used to update the table content when another branch is selected
    //get the schedule that are belongs to the selected branch from allSchedule ArrayList
    public void updateTable(){
        String branch = "";
        switch(label_branch.getText()){
                case "Petaling Branch":
                    branch = "Centre-Petaling Branch";
                    break;
                case "Kuala Selangor Branch":
                    branch = "Centre-Kuala Selangor Branch";
                    break;
                case "Klang Branch":
                    branch = "Centre-Klang Branch";
                    break;
                case "Sepang Branch":
                    branch = "Centre-Sepang Branch";
                    break;
                case "Hulu Langat Branch":
                    branch = "Centre-Hulu Langat Branch";
                    break;
        }
        DefaultTableModel dm = (DefaultTableModel) table_schedule.getModel();
        dm.setRowCount(0);
        for (int i=0; i<OODJ_Assignment.allSchedule.size(); i++){
            if(OODJ_Assignment.allSchedule.get(i).getCentre_name().equals(branch)){
                String sport = OODJ_Assignment.allSchedule.get(i).getSport().get(0).getSport_name();
                String day = OODJ_Assignment.allSchedule.get(i).getDay().toString();
                String time = OODJ_Assignment.allSchedule.get(i).getTime().toString().replace('$',' ');
                
                Object[] schedule_d = {sport, day, time};
                dm.addRow(schedule_d);
            }       
        }
    }

    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button_next) {
            
            //change the branch label and update the table
            switch(label_branch.getText()){
                case "Petaling Branch":
                    label_branch.setText("Kuala Selangor Branch");
                    break;
                case "Kuala Selangor Branch":
                    label_branch.setText("Klang Branch");
                    break;
                case "Klang Branch":
                    label_branch.setText("Sepang Branch");
                    break;
                case "Sepang Branch":
                    label_branch.setText("Hulu Langat Branch");
                    break;
                case "Hulu Langat Branch":
                    label_branch.setText("Petaling Branch");
                    break;
            }
            updateTable();
            
        } else if (e.getSource() == button_back){
            
            switch(label_branch.getText()){
                case "Petaling Branch":
                    label_branch.setText("Hulu Langat Branch");
                    break;
                case "Kuala Selangor Branch":
                    label_branch.setText("Petaling Branch");
                    break;
                case "Klang Branch":
                    label_branch.setText("Kuala Selangor Branch");
                    break;
                case "Sepang Branch":
                    label_branch.setText("Klang Branch");
                    break;
                case "Hulu Langat Branch":
                    label_branch.setText("Sepang Branch");
                    break;
            }
            updateTable();
            
        } else if (e.getSource() == button_return){
            
            setVisible(false);
            OODJ_Assignment.homePage.setVisible(true);
            
        } else if (e.getSource() == combobox_filter_sport || e.getSource() == combobox_filter_day){
            
            //if any filter is selected by the user, filter the table
            if (combobox_filter_sport.getItemCount() != 0){
                boolean flag = false;
                ArrayList<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>();
                if (!combobox_filter_sport.getSelectedItem().toString().equals("All")){
                    filters.add(RowFilter.regexFilter("(?i)"+combobox_filter_sport.getSelectedItem().toString(),0));
                    flag = true;
                } 
                if (!combobox_filter_day.getSelectedItem().toString().equals("All")){
                    filters.add(RowFilter.regexFilter("(?i)"+combobox_filter_day.getSelectedItem().toString(),1));
                    flag = true;
                }
                if (flag){
                    RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
                    rowSorter_schedule.setRowFilter(combinedFilter);
                } else {
                    rowSorter_schedule.setRowFilter(null);
                }
            }
            
        }
    }
    
    //reset the page when the frame is shown
    public void componentShown(ComponentEvent e){
        label_branch.setText("Petaling Branch");
        if (combobox_filter_sport.getItemCount() != 0){
            combobox_filter_sport.removeAllItems();
            combobox_filter_sport.addItem("All");
            for (int i=0;i<OODJ_Assignment.allSport.size();i++){
                combobox_filter_sport.addItem(OODJ_Assignment.allSport.get(i).getSport_name());
            }
        }        
        combobox_filter_sport.setSelectedItem("All");
        combobox_filter_day.setSelectedItem("All");
        updateTable();
    }
        
    public void componentHidden(ComponentEvent e){
        OODJ_Assignment.homePage.setVisible(true);
    }
    
    public void componentMoved(ComponentEvent e){
        
    }
 
    public void componentResized(ComponentEvent e){
     
    }
    
    public void propertyChange(PropertyChangeEvent e){
        
    }
    
}
