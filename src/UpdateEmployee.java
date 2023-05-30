//23. UpdateEmployee
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class UpdateEmployee extends JFrame {

private JPanel contentPane;
private JTextField id1;
private JTextField name1;
private JTextField mobile1;
private JTextField email1;
private JTextField city1;
private JTextField state1;
private JTextField salary1;
private JTextField username1;
private JPasswordField Password1;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
UpdateEmployee frame = new UpdateEmployee();
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
public UpdateEmployee() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 966, 606);
contentPane = new JPanel();
contentPane.setBackground(new Color(255, 152, 102));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
             setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel id = new JLabel("Employee ID");
id.setFont(new Font("Tahoma", Font.BOLD, 16));
id.setBounds(105, 23, 167, 30);
contentPane.add(id);

JLabel name = new JLabel("Employee Name");
name.setFont(new Font("Tahoma", Font.BOLD, 16));
name.setBounds(105, 72, 167, 30);
contentPane.add(name);

JLabel mobile = new JLabel("Mobile No.");
mobile.setFont(new Font("Tahoma", Font.BOLD, 16));
mobile.setBounds(105, 121, 167, 30);
contentPane.add(mobile);

JLabel email = new JLabel("Email_ID");
email.setFont(new Font("Tahoma", Font.BOLD, 16));
email.setBounds(105, 173, 167, 30);
contentPane.add(email);

JLabel city = new JLabel("City");
city.setFont(new Font("Tahoma", Font.BOLD, 16));
city.setBounds(105, 223, 167, 30);
contentPane.add(city);

JLabel state = new JLabel("State");
state.setFont(new Font("Tahoma", Font.BOLD, 16));
state.setBounds(105, 267, 167, 30);
contentPane.add(state);

JLabel Salary = new JLabel("Salary");
Salary.setFont(new Font("Tahoma", Font.BOLD, 16));
Salary.setBounds(105, 316, 167, 30);
contentPane.add(Salary);

JButton btnUpdate = new JButton("Update");
btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
          PreparedStatement pst;
          PreparedStatement pst1;
          pst=con.prepareStatement("update HrEmployee set Empname=?,Empmobile=?,Empemail=?,Empcity=?,Empstate=?,Empsalary=? where Empid=?");
          pst1=con.prepareStatement("update Employee_Login set username=?,Password=?");
          pst.setString(1, name1.getText());
          pst.setString(2, mobile1.getText());
          pst.setString(3, email1.getText());
          pst.setString(4, city1.getText());
          pst.setString(5, state1.getText());
          pst.setString(6, salary1.getText());
          pst.setString(7, id1.getText());
          pst1.setString(1, username1.getText());
          pst1.setString(2, Password1.getText());
          pst.executeUpdate();
          pst1.executeUpdate();
          JOptionPane.showMessageDialog(null, "Record Updated Successfully...!!!");
         
}
catch(Exception e1) {
e1.printStackTrace();
}
}
});
btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
btnUpdate.setBounds(131, 476, 146, 38);
contentPane.add(btnUpdate);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
btnBack.setBounds(353, 477, 146, 38);
contentPane.add(btnBack);

id1 = new JTextField();
id1.setFont(new Font("Tahoma", Font.PLAIN, 14));
id1.setBounds(299, 19, 340, 30);
contentPane.add(id1);
id1.setColumns(10);

name1 = new JTextField();
name1.setFont(new Font("Tahoma", Font.PLAIN, 13));
name1.setColumns(10);
name1.setBounds(299, 74, 340, 30);
contentPane.add(name1);

mobile1 = new JTextField();
mobile1.setFont(new Font("Tahoma", Font.PLAIN, 13));
mobile1.setColumns(10);
mobile1.setBounds(299, 121, 340, 30);
contentPane.add(mobile1);

email1 = new JTextField();
email1.setFont(new Font("Tahoma", Font.PLAIN, 13));
email1.setColumns(10);
email1.setBounds(299, 172, 340, 30);
contentPane.add(email1);

city1 = new JTextField();
city1.setFont(new Font("Tahoma", Font.PLAIN, 13));
city1.setColumns(10);
city1.setBounds(299, 219, 340, 30);
contentPane.add(city1);

state1 = new JTextField();
state1.setFont(new Font("Tahoma", Font.PLAIN, 13));
state1.setColumns(10);
state1.setBounds(299, 264, 340, 30);
contentPane.add(state1);

salary1 = new JTextField();
salary1.setFont(new Font("Tahoma", Font.PLAIN, 13));
salary1.setColumns(10);
salary1.setBounds(299, 313, 340, 30);
contentPane.add(salary1);

JLabel lblUsername = new JLabel("username");
lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
lblUsername.setBounds(105, 365, 167, 30);
contentPane.add(lblUsername);

JLabel lblPassword = new JLabel("Password");
lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
lblPassword.setBounds(105, 410, 167, 30);
contentPane.add(lblPassword);

username1 = new JTextField();
username1.setFont(new Font("Tahoma", Font.PLAIN, 13));
username1.setColumns(10);
username1.setBounds(300, 362, 340, 30);
contentPane.add(username1);

Password1 = new JPasswordField();
Password1.setFont(new Font("Tahoma", Font.PLAIN, 13));
Password1.setBounds(299, 413, 340, 30);
contentPane.add(Password1);

JButton btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
btnClose.setBounds(558, 476, 146, 38);
contentPane.add(btnClose);
}
}