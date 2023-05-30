// 21. SearchEmployee
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SearchEmployee extends JFrame {

private JPanel contentPane;
private JTextField id;
private JTextField name;
private JTextField mobile;
private JTextField email;
private JTextField city;
private JTextField state;
private JTextField salary;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
SearchEmployee frame = new SearchEmployee();
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
public SearchEmployee() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 839, 604);
contentPane = new JPanel();
contentPane.setBackground(new Color(193, 132, 255));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Employee ID");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel.setBounds(71, 37, 147, 27);
contentPane.add(lblNewLabel);

JLabel lblEmployeeName = new JLabel("Employee Name");
lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 17));
lblEmployeeName.setBounds(71, 91, 147, 27);
contentPane.add(lblEmployeeName);

JLabel lblNewLabel_1_1 = new JLabel("Mobile No.");
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_1.setBounds(71, 144, 147, 27);
contentPane.add(lblNewLabel_1_1);

JLabel lblNewLabel_1_2 = new JLabel("Email_ID");
lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_2.setBounds(71, 202, 147, 27);
contentPane.add(lblNewLabel_1_2);

JLabel lblNewLabel_1_3 = new JLabel("City");
lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_3.setBounds(71, 262, 147, 27);
contentPane.add(lblNewLabel_1_3);

JLabel lblNewLabel_1_4 = new JLabel("State");
lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_4.setBounds(71, 320, 147, 27);
contentPane.add(lblNewLabel_1_4);

JLabel lblNewLabel_1_5 = new JLabel("Salary");
lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_5.setBounds(71, 375, 147, 27);
contentPane.add(lblNewLabel_1_5);

id = new JTextField();
id.setFont(new Font("Tahoma", Font.PLAIN, 14));
id.setBounds(268, 29, 261, 35);
contentPane.add(id);
id.setColumns(10);

name = new JTextField();
name.setFont(new Font("Tahoma", Font.PLAIN, 14));
name.setColumns(10);
name.setBounds(268, 91, 261, 35);
contentPane.add(name);

mobile = new JTextField();
mobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
mobile.setColumns(10);
mobile.setBounds(268, 136, 261, 35);
contentPane.add(mobile);

email = new JTextField();
email.setFont(new Font("Tahoma", Font.PLAIN, 14));
email.setColumns(10);
email.setBounds(268, 194, 261, 35);
contentPane.add(email);

city = new JTextField();
city.setFont(new Font("Tahoma", Font.PLAIN, 14));
city.setColumns(10);
city.setBounds(268, 254, 261, 35);
contentPane.add(city);

state = new JTextField();
state.setFont(new Font("Tahoma", Font.PLAIN, 14));
state.setColumns(10);
state.setBounds(268, 312, 261, 35);
contentPane.add(state);

salary = new JTextField();
salary.setFont(new Font("Tahoma", Font.PLAIN, 14));
salary.setColumns(10);
salary.setBounds(268, 367, 261, 35);
contentPane.add(salary);

JButton btnNewButton = new JButton("Search");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
String s=JOptionPane.showInputDialog(null,"Enter Employee ID for Search");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
          PreparedStatement pst;ResultSet rs;
         pst=con.prepareStatement("select *from HrEmployee where Empid=?");
         pst.setString(1, s);
         rs=pst.executeQuery();
         if(rs.next()) {
         id.setText(rs.getString(1));
         name.setText(rs.getString(2));
         mobile.setText(rs.getString(3));
         email.setText(rs.getString(4));
         city.setText(rs.getString(5));
         state.setText(rs.getString(6));
         salary.setText(rs.getString(7));
         }
         else {
         JOptionPane.showMessageDialog(null,"Record not found having ID "+s);
         }
         
}
catch(Exception e1) {
e1.printStackTrace();
}
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton.setBounds(66, 472, 161, 42);
contentPane.add(btnNewButton);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
btnBack.setBounds(315, 472, 161, 42);
contentPane.add(btnBack);

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
btnClose.setBounds(593, 471, 161, 42);
contentPane.add(btnClose);
}
}
