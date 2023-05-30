// 1. AddEmployee
package LoginPages;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddEmployee extends JFrame {

protected static Object eid;
private JPanel contentPane;
private JTextField Empid;
private JTextField Empname;
private JTextField Empmobile;
public JTextField Empemail;
private JTextField Empcity;
private JTextField Empstate;
public JTextField username1;
public JPasswordField Password1;
// private JTextField EmpAadhar;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
AddEmployee frame=new AddEmployee();
frame.setVisible(true);
}
catch(Exception e){
e.printStackTrace();
}

}
});
}
//      public void randomnumbers()
//      {
//      Random ran=new Random();
//      int n=ran.nextInt(1000000)+1;
//      String val=String.valueOf(n);
//      pfno.setText(val);
//      }
/**
* Create the frame.
*/
public AddEmployee() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 830, 640);
contentPane = new JPanel();
contentPane.setBackground(new Color(12, 180, 150));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
              setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel eid = new JLabel("Employee ID");
eid.setFont(new Font("Tahoma", Font.BOLD, 16));
eid.setBounds(83, 60, 163, 25);
contentPane.add(eid);

JLabel ename = new JLabel("Employee Name");
ename.setFont(new Font("Tahoma", Font.BOLD, 16));
ename.setBounds(83, 111, 163, 25);
contentPane.add(ename);

JLabel emob = new JLabel("Employee Mobile No.");
emob.setFont(new Font("Tahoma", Font.BOLD, 16));
emob.setBounds(83, 164, 180, 25);
contentPane.add(emob);

JLabel email = new JLabel("Employee Email");
email.setFont(new Font("Tahoma", Font.BOLD, 16));
email.setBounds(83, 221, 163, 25);
contentPane.add(email);

JLabel ecity = new JLabel("Employee City");
ecity.setFont(new Font("Tahoma", Font.BOLD, 16));
ecity.setBounds(83, 274, 163, 25);
contentPane.add(ecity);

JLabel estate = new JLabel("Employee State");
estate.setFont(new Font("Tahoma", Font.BOLD, 16));
estate.setBounds(83, 328, 163, 25);
contentPane.add(estate);


Empid = new JTextField();
Empid.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empid.setBounds(273, 59, 347, 32);
contentPane.add(Empid);
Empid.setColumns(10);

Empname = new JTextField();
Empname.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empname.setColumns(10);
Empname.setBounds(273, 110, 347, 32);
contentPane.add(Empname);

Empmobile =
new JTextField();
Empmobile.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empmobile.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased(KeyEvent e) {
String mobile=Empmobile.getText();
if(mobile.matches("^[0-9]*$") && mobile.length()==10) {
Empmobile.setBackground(Color.green);
}
else {
Empmobile.setBackground(new Color(255,102,102));
}
}
});
Empmobile.setColumns(10);
Empmobile.setBounds(273, 163, 347, 32);
contentPane.add(Empmobile);

Empemail = new JTextField();
Empemail.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empemail.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

}
});
Empemail.setColumns(10);
Empemail.setBounds(273, 220, 347, 32);
contentPane.add(Empemail);

Empcity = new JTextField();
Empcity.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empcity.setColumns(10);
Empcity.setBounds(273, 273, 347, 32);
contentPane.add(Empcity);

Empstate = new JTextField();
Empstate.setFont(new Font("Tahoma", Font.PLAIN, 13));
Empstate.setColumns(10);
Empstate.setBounds(273, 327, 347, 32);
contentPane.add(Empstate);



JButton btnClear = new JButton("Clear");
btnClear.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Empid.setText("");
Empname.setText("");
Empmobile.setText("");
Empemail.setText("");
Empcity.setText("");
Empstate.setText("");
// Empsalary.setText("");
username1.setText("");
Password1.setText("");
// pfno.setText("");
// EmpAadhar.setText("");
}
});
btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
btnClear.setBounds(205, 520, 124, 43);
contentPane.add(btnClear);

JLabel addlabel = new JLabel("");
JButton btnAdd = new JButton("Add");

btnAdd.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

if(e.getSource()== btnAdd) {
String id=Empid.getText();
String name=Empname.getText();
String mob=Empmobile.getText();
String email=Empemail.getText();
String city=Empcity.getText();
String state=Empstate.getText();
// String epf=pfno.getText();
// String sal=Empsalary.getText();
String username=username1.getText();
String Password=Password1.getText();
                    String email1=Empemail.getText();
               if(Empid.getText().trim().isEmpty() && Empname.getText().trim().isEmpty() && Empmobile.getText().trim().isEmpty() && Empemail.getText().trim().isEmpty() && Empcity.getText().trim().isEmpty() && Empstate.getText().trim().isEmpty())
               {
                          JOptionPane.showMessageDialog(null, "Please fill all the fields");
               }
               else if(Empid.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "ID field is mandatory");
               }
               else if(Empname.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Name field is mandatory");
               }
               else if(Empmobile.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Mobile field is mandatory");
               }
               else if(Empemail.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Email field is mandatory");
               }
               else if(Empcity.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "City field is mandatory");
               }
               else if(Empstate.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "State field is mandatory");
               }
               else if(username1.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Username field is mandatory");
               }
               else if(Password1.getText().trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Password field is mandatory");
               }
       else {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
System.out.println("Database Connected!!!");
String sql=("insert into HrEmployee values('"+id+"','"+name+"','"+mob+"','"+email+"','"+city+"','"+state+"',s1.nextval)");
String sql1=("insert into Employee_Login values('"+username+"','"+Password+"','"+email1+"')");

PreparedStatement ps=con.prepareStatement(sql);
PreparedStatement ps1=con.prepareStatement(sql1);
ps.executeUpdate(sql);
ps1.executeUpdate(sql1);

JOptionPane.showMessageDialog(null, "Data Added Successfully...");
setVisible(true);
Empid.setText("");
Empname.setText("");
Empmobile.setText("");
Empemail.setText("");
Empcity.setText("");
Empstate.setText("");
// pfno.setText("");
// Empsalary.setText("");
username1.setText("");
Password1.setText("");
Empemail.setText("");
// EmpAadhar.setText("");
ps.close();
con.close();

}
catch (Exception e1) {
// TODO Auto-generated catch block
System.out.print(e1);
JOptionPane.showMessageDialog(btnAdd,e1);
Empid.setText("");
Empname.setText("");
Empmobile.setText("");
Empemail.setText("");
Empcity.setText("");
Empstate.setText("");
// pfno.setText("");
// Empsalary.setText("");
username1.setText("");
Password1.setText("");
Empemail.setText("");
// EmpAadhar.setText("");
}
       }
}
else {
setVisible(false);
new Homepage();
}
}
});
btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
btnAdd.setBounds(453, 520, 124, 43);
contentPane.add(btnAdd);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
btnBack.setBounds(654, 41, 135, 32);
contentPane.add(btnBack);

JLabel lblEmployeeUsername = new JLabel("Employee Username");
lblEmployeeUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
lblEmployeeUsername.setBounds(83, 382, 180, 25);
contentPane.add(lblEmployeeUsername);

JLabel lblEmployeePassword = new JLabel("Employee Password");
lblEmployeePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
lblEmployeePassword.setBounds(83, 436, 163, 25);
contentPane.add(lblEmployeePassword);

username1 = new JTextField();
username1.setFont(new Font("Tahoma", Font.PLAIN, 13));
username1.setColumns(10);
username1.setBounds(273, 381, 347, 32);
contentPane.add(username1);

Password1 = new JPasswordField();
Password1.setFont(new Font("Tahoma", Font.PLAIN, 13));
Password1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
}
});
Password1.setBounds(273, 433, 347, 36);
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
btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
btnClose.setBounds(662, 85, 124, 32);
contentPane.add(btnClose);

JLabel elab = new JLabel("");
elab.setFont(new Font("Tahoma", Font.BOLD, 16));
elab.setForeground(new Color(128, 255, 255));
elab.setBounds(646, 214, 160, 32);
contentPane.add(elab);

// JLabel addlabel = new JLabel("");
addlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
addlabel.setForeground(new Color(255, 0, 0));
addlabel.setBounds(195, 456, 489, 28);
contentPane.add(addlabel);
// randomnumbers();
Empemail.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased(KeyEvent e) {
String PATTERN="^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
Pattern patt=Pattern.compile(PATTERN);
Matcher match=patt.matcher(Empemail.getText());
// JLabel elab;
if(!match.matches()) {
elab.setText("Incorrect Email");
}
else {
elab.setText(null);
}
}
});
}
}