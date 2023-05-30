// 16. HrwindowafterLogin
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HrwindowafterLogin extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
HrwindowafterLogin frame = new HrwindowafterLogin();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public HrwindowafterLogin() {
setAlwaysOnTop(true);
setBackground(new Color(68, 68, 68));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 979, 516);
contentPane = new JPanel();
contentPane.setBackground(new Color(66, 66, 66));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnNewButton = new JButton("Add Employee");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
AddEmployee frame=new AddEmployee();
frame.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
btnNewButton.setBounds(308, 33, 233, 35);
contentPane.add(btnNewButton);

JButton btnUpdateEmployeeRecord = new JButton("Update Employee Record");
btnUpdateEmployeeRecord.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
UpdateEmployee frame=new UpdateEmployee();
frame.setVisible(true);
}
});
btnUpdateEmployeeRecord.setFont(new Font("Tahoma", Font.BOLD, 13));
btnUpdateEmployeeRecord.setBounds(308, 86, 233, 35);
contentPane.add(btnUpdateEmployeeRecord);

JButton btnAddEmployeeSalary = new JButton("Add Employee Salary");
btnAddEmployeeSalary.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
AddEmpSalary frame=new AddEmpSalary();
frame.setVisible(true);
}
});
btnAddEmployeeSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
btnAddEmployeeSalary.setBounds(308, 136, 233, 35);
contentPane.add(btnAddEmployeeSalary);

JButton btnDeleteEmployeeRecord = new JButton("Delete Employee Record");
btnDeleteEmployeeRecord.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
DeleteEmployee frame=new DeleteEmployee();
frame.setVisible(true);
}
});
btnDeleteEmployeeRecord.setFont(new Font("Tahoma", Font.BOLD, 13));
btnDeleteEmployeeRecord.setBounds(308, 187, 233, 35);
contentPane.add(btnDeleteEmployeeRecord);

JButton btnSearchEmployeeRecord = new JButton("Search Employee Record");
btnSearchEmployeeRecord.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
SearchEmployee frame=new SearchEmployee();
frame.setVisible(true);
}
});
btnSearchEmployeeRecord.setFont(new Font("Tahoma", Font.BOLD, 13));
btnSearchEmployeeRecord.setBounds(308, 236, 233, 35);
contentPane.add(btnSearchEmployeeRecord);

JButton btnViewEmployeesRecords = new JButton("View Employees Records");
btnViewEmployeesRecords.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
ViewEmployees frame=new ViewEmployees();
frame.setVisible(true);
}
});
btnViewEmployeesRecords.setFont(new Font("Tahoma", Font.BOLD, 13));
btnViewEmployeesRecords.setBounds(308, 281, 233, 35);
contentPane.add(btnViewEmployeesRecords);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
Homepage frame=new Homepage();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
btnBack.setBounds(651, 10, 96, 35);
contentPane.add(btnBack);

JButton btnEmployeeAttendance = new JButton("Employee Attendance");
btnEmployeeAttendance.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
viewortakeAttendance frame=new viewortakeAttendance();
frame.setVisible(true);
}

});
btnEmployeeAttendance.setFont(new Font("Tahoma", Font.BOLD, 13));
btnEmployeeAttendance.setBounds(308, 326, 233, 35);
contentPane.add(btnEmployeeAttendance);

JButton btnViewEmployeeLeave = new JButton("View Employee Leave Data");
btnViewEmployeeLeave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
viewEmpLeaveData frame=new viewEmpLeaveData();
frame.setVisible(true);
}
});
btnViewEmployeeLeave.setFont(new Font("Tahoma", Font.BOLD, 13));
btnViewEmployeeLeave.setBounds(308, 370, 233, 35);
contentPane.add(btnViewEmployeeLeave);

JButton btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
btnClose.setBounds(651, 71, 96, 35);
contentPane.add(btnClose);

JButton btnInsertEmployeeLeave = new JButton("Insert Employee Leave");
btnInsertEmployeeLeave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
leave frame=new leave();
frame.setVisible(true);
}
});
btnInsertEmployeeLeave.setFont(new Font("Tahoma", Font.BOLD, 13));
btnInsertEmployeeLeave.setBounds(308, 420, 233, 35);
contentPane.add(btnInsertEmployeeLeave);

JButton btnLogout = new JButton("Logout");
btnLogout.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
logoutHR frame=new logoutHR();
frame.setVisible(true);

}
});
btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
btnLogout.setBounds(651, 136, 124, 45);
contentPane.add(btnLogout);
}
}
