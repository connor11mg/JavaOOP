package oodj_assignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class View_Registered_Students extends JDialog implements ActionListener, FocusListener, DocumentListener{
    
    private JComboBox combobox_search;
    private JPanel panel_main;
    private JTable table_students;
    private JTextField textField_search;
    private TableRowSorter<TableModel> rowSorter_students;
    public int getScheduleIndex;
    
    public View_Registered_Students(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setSize(800,700);
        setLocation(750,175);
        setTitle("Student List");
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        //main panel
        panel_main = new JPanel(new GridBagLayout());
        TitledBorder border = BorderFactory.createTitledBorder("Registered Student List");
        border.setTitleFont(new Font("Felix Titling",Font.PLAIN,30));
        panel_main.setBorder(border);
        panel_main.setLayout(new GridBagLayout());
        //panel_main.setBackground(new Color(242,233,228));
        add(panel_main);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,15,0,0);
        textField_search = new JTextField();
        textField_search.setFont(new Font("Cambria Math",Font.PLAIN,20));
        textField_search.setForeground(new Color(151,151,151)); 
        textField_search.setText("Search by entering keyword");
        textField_search.setPreferredSize(new Dimension(650,300));
        panel_main.add(textField_search,gbc);
        textField_search.addFocusListener(this);
        textField_search.getDocument().addDocumentListener(this);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 0.03;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,0,0,15);
        String[] search_selection = {"Search All","Search by ID","Search by Name","Search by Phone No."};
        combobox_search = new JComboBox(search_selection);
        combobox_search.setSelectedItem("Search All");
        combobox_search.setFont(new Font("Cambria Math",Font.PLAIN,20));
        combobox_search.setForeground(new Color(34,34,59)); 
        combobox_search.setPreferredSize(new Dimension(650,300));
        panel_main.add(combobox_search,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,15,15,15);
        String students_column[] = {"ID","Name","Phone No.","Email"};
        String students_data[][]={ {"101","Amitaaaaaaaaaaaaaaa","670000","a"}};
        table_students = new JTable(new DefaultTableModel(students_data,students_column)){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        table_students.setFont(new Font("Cambria Math",Font.PLAIN,18));
        table_students.setForeground(new Color(34,34,59));
        table_students.setRowHeight(23);
        table_students.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_students.setAutoCreateRowSorter(true);
        table_students.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_students.getColumnModel().getColumn(1).setPreferredWidth(150);
        table_students.getColumnModel().getColumn(2).setPreferredWidth(150);
        table_students.getColumnModel().getColumn(3).setPreferredWidth(250);
        table_students.getTableHeader().setFont(new Font("Cambria Math",Font.PLAIN,20));
        table_students.getTableHeader().setForeground(new Color(34,34,59));
        table_students.getTableHeader().setReorderingAllowed(false);
        rowSorter_students = new TableRowSorter<>(table_students.getModel());
        table_students.setRowSorter(rowSorter_students);
        
        JScrollPane sp_students = new JScrollPane(table_students);
        sp_students.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp_students.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_main.add(sp_students,gbc);
        table_students.setRowSelectionInterval(0, 0);
        
        setModal(true);
    }
    
    //method to update the table so that it will display the latest data
    public void update_registered_table() {
        DefaultTableModel dm = (DefaultTableModel) table_students.getModel();
        dm.setRowCount(0);

        for (int i = 0; i < OODJ_Assignment.allRegisteredSport.size(); i++) {
            for (int x = 0; x < OODJ_Assignment.allRegisteredSport.get(i).getStudent().size(); x++) {
                if (OODJ_Assignment.allSchedule.get(getScheduleIndex).getId().equals(OODJ_Assignment.allRegisteredSport.get(i).getSchedule().get(0).getId())) {
                    String name = OODJ_Assignment.allRegisteredSport.get(i).getStudent().get(x).getName();
                    String email = OODJ_Assignment.allRegisteredSport.get(i).getStudent().get(x).getEmail();
                    String id = OODJ_Assignment.allRegisteredSport.get(i).getStudent().get(x).getID();
                    String phone_number = OODJ_Assignment.allRegisteredSport.get(i).getStudent().get(x).getPhone_number();

                    Object[] registered_d = {id, name, phone_number, email};
                    dm.addRow(registered_d);

                }
            }
        }
    }
    
    //method to filter the table based on the keyword entered by user
    //filter only the selected column if user select a column in combobox
    public void filterTable(DocumentEvent e){
        if(e.getDocument() == textField_search.getDocument()){
            
            String keyword = textField_search.getText().trim();
            if(!(keyword.equals("") || keyword.equals("Search by entering keyword"))){
                switch (combobox_search.getSelectedItem().toString()){
                    case "Search All":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword));  
                        break;
                    case "Search by ID":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,0));  
                        break;
                    case "Search by Name":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,1));  
                        break;
                    case "Search by Phone No.":
                        rowSorter_students.setRowFilter(RowFilter.regexFilter("(?i)"+keyword,2));  
                        break;
                }                            
            } else {
                rowSorter_students.setRowFilter(null);
            }
            
        } 
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    //remove the text when user wants to type something
    public void focusGained(FocusEvent e){
        if (textField_search.getText().equals("Search by entering keyword")){
            textField_search.setForeground(new Color(34,34,59)); 
            textField_search.setText("");
        }
    }
    
    //add the text if the user is not typing anything
    public void focusLost(FocusEvent e){
        if (textField_search.getText().equals("")){
            textField_search.setForeground(new Color(151,151,151)); 
            textField_search.setText("Search by entering keyword");
        }
    }
    
    //filter the table whenever user type anything into the textfield
    public void changedUpdate(DocumentEvent e) {
        filterTable(e);   
    }
    
    public void removeUpdate(DocumentEvent e) {
        filterTable(e);
    }
    
    public void insertUpdate(DocumentEvent e) {
        filterTable(e);
    }
}
