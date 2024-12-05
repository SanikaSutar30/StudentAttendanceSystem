//                      code for jtable which contains sr no , name , prn, present and abasent col

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AttendanceTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Attendance Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create sample data (you will replace this with data from your database)
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "John Doe", "12345"));
            students.add(new Student(2, "Jane Smith", "67890"));

            // Create the table model
            AttendanceTableModel tableModel = new AttendanceTableModel(students);

            // Create the JTable with the custom table model
            JTable table = new JTable(tableModel);
            
            // Set custom renderer and editor for the radio button columns
            table.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer());
            table.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor(new JCheckBox()));
            table.getColumnModel().getColumn(4).setCellRenderer(new RadioButtonRenderer());
            table.getColumnModel().getColumn(4).setCellEditor(new RadioButtonEditor(new JCheckBox()));

            // Create a JScrollPane to handle scrolling if the table has many entries
            JScrollPane scrollPane = new JScrollPane(table);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// Student class to represent individual student data
class Student {
    int srNo;
    String name;
    String prn;

    Student(int srNo, String name, String prn) {
        this.srNo = srNo;
        this.name = name;
        this.prn = prn;
    }
}

// Custom table model for the JTable
class AttendanceTableModel extends AbstractTableModel {
    private final List<Student> students;
    private final String[] columnNames = {"Sr No", "Name", "PRN", "Present", "Absent"};

    AttendanceTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return student.srNo;
            case 1:
                return student.name;
            case 2:
                return student.prn;
            case 3:
            case 4:
                return false; // Initialize radio buttons to false
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 3 || columnIndex == 4 ? Boolean.class : super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3 || columnIndex == 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Handle changes to the radio button state here
        // For simplicity, this example does not save the state anywhere
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}

// Custom renderer for rendering radio buttons
class RadioButtonRenderer implements TableCellRenderer {
    private final JRadioButton radioButton = new JRadioButton();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        radioButton.setSelected(value != null && (Boolean) value);
        return radioButton;
    }
}

// Custom editor for handling radio button interactions
class RadioButtonEditor extends DefaultCellEditor implements ActionListener {
    private final JRadioButton radioButton;

    public RadioButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        radioButton = new JRadioButton();
        radioButton.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        radioButton.setSelected(value != null && (Boolean) value);
        return radioButton;
    }

    @Override
    public Object getCellEditorValue() {
        return radioButton.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
    }
}
