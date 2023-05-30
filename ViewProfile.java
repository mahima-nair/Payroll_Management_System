// 30. viewProfile
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

public class ViewProfile extends JFrame {

private JPanel contentPane;
public static JTextField id;
private JTextField name;
private JTextField mobile;
public  JTextField email;
private JTextField city;
private JTextField state;
private JTextField pfno;
// private JTextField salary;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ViewProfile frame = new ViewProfile();
frame.setVisible(true);
// ViewProfile frame=new ViewProfile(String)

} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public ViewProfile(String msg) {
// getComponents();
email.setText(msg);
}

public ViewProfile() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 839, 604);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 147, 147));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Employee ID");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel.setBounds(100, 51, 147, 27);
contentPane.add(lblNewLabel);

JLabel lblEmployeeName = new JLabel("Employee Name");
lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 17));
lblEmployeeName.setBounds(101, 104, 147, 27);
contentPane.add(lblEmployeeName);

JLabel lblNewLabel_1_1 = new JLabel("Mobile No.");
lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_1.setBounds(103, 155, 147, 27);
contentPane.add(lblNewLabel_1_1);

JLabel lblNewLabel_1_2 = new JLabel("Email_ID");
lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_2.setBounds(102, 209, 147, 27);
contentPane.add(lblNewLabel_1_2);

JLabel lblNewLabel_1_3 = new JLabel("City");
lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_3.setBounds(104, 258, 147, 27);
contentPane.add(lblNewLabel_1_3);

JLabel lblNewLabel_1_4 = new JLabel("State");
lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_4.setBounds(104, 313, 147, 27);
contentPane.add(lblNewLabel_1_4);

id = new JTextField();
id.setFont(new Font("Tahoma", Font.PLAIN, 17));
id.setBounds(268, 49, 261, 35);
contentPane.add(id);
id.setColumns(10);

name = new JTextField();
name.setFont(new Font("Tahoma", Font.PLAIN, 17));
name.setColumns(10);
name.setBounds(268, 100, 261, 35);
contentPane.add(name);

mobile = new JTextField();
mobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
mobile.setColumns(10);
mobile.setBounds(268, 153, 261, 35);
contentPane.add(mobile);

email = new JTextField();
email.setFont(new Font("Tahoma", Font.PLAIN, 17));
email.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
}
});
email.setColumns(10);
email.setBounds(268, 205, 261, 35);
contentPane.add(email);

city = new JTextField();
city.setFont(new Font("Tahoma", Font.PLAIN, 17));
city.setColumns(10);
city.setBounds(268, 258, 261, 35);
contentPane.add(city);

state = new JTextField();
state.setFont(new Font("Tahoma", Font.PLAIN, 17));
state.setColumns(10);
state.setBounds(268, 309, 261, 35);
contentPane.add(state);

// salary = new JTextField();
// salary.setColumns(10);
// salary.setBounds(268, 362, 261, 35);
// contentPane.add(salary);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
EmployeewindowafterLogin frame=new EmployeewindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
btnBack.setBounds(626, 31, 147, 47);
contentPane.add(btnBack);

JButton btnDisplay = new JButton("Display");
btnDisplay.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

email.setText(First_Login_Page.editEmail.getText());

String s=JOptionPane.showInputDialog(null,"Enter Employee Email for Search");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
System.out.println("Database Connected!!!");
PreparedStatement pst;
ResultSet rs;
pst=con.prepareStatement("select *from HrEmployee where Empemail=?");
         pst.setString(1, s);
rs=pst.executeQuery();
if(rs.next()) {
id.setText(rs.getString(1));
name.setText(rs.getString(2));
mobile.setText(rs.getString(3));
// email.setText(rs.getString(4));
city.setText(rs.getString(5));
state.setText(rs.getString(6));
pfno.setText(rs.getString(7));
// salary.setText(rs.getString(7));
}
else {
JOptionPane.showMessageDialog(null, "Record not found for ID "+s);
}

}
catch(Exception e1) {
e1.printStackTrace();
}
}
});
btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 17));
btnDisplay.setBounds(234, 446, 327, 42);
contentPane.add(btnDisplay);

JButton btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 17));
btnClose.setBounds(626, 439, 156, 42);
contentPane.add(btnClose);

JLabel lblNewLabel_1_4_1 = new JLabel("EPF No.");
lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_1_4_1.setBounds(100, 366, 147, 27);
contentPane.add(lblNewLabel_1_4_1);

pfno = new JTextField();
pfno.setFont(new Font("Tahoma", Font.PLAIN, 17));
pfno.setColumns(10);
pfno.setBounds(268, 363, 261, 35);
contentPane.add(pfno);
}
}