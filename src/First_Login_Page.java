// 11. First_Login_Page
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;

public class First_Login_Page extends JFrame {

private JPanel contentPane;
private JTextField editUsername;
private JPasswordField editPassword;
private final JSeparator separator = new JSeparator();
public static JTextField editEmail;
public static JTextField editid;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
First_Login_Page frame = new First_Login_Page();
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

public First_Login_Page() {
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 978, 513);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Employee Login Page");
lblNewLabel.setForeground(new Color(0, 0, 0));
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(0, 0, 1057, 44);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Username");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setBounds(31, 77, 166, 33);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Password");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setBounds(45, 135, 138, 33);
contentPane.add(lblNewLabel_2);

editUsername = new JTextField();
editUsername.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

}
});
editUsername.setBounds(207, 79, 386, 33);
contentPane.add(editUsername);
editUsername.setColumns(10);

editPassword = new JPasswordField();
editPassword.setBounds(207, 137, 386, 33);
contentPane.add(editPassword);

JButton btnLogin = new JButton("Login");
btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String username=editUsername.getText();
String Password=editPassword.getText();
String email=editEmail.getText();

if(editUsername.getText().trim().isEmpty() && editPassword.getText().trim().isEmpty() && editEmail.getText().trim().isEmpty() ) {
                  JOptionPane.showMessageDialog(null, "ALL fields are mandatory");
              }
else if(editUsername.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(null, "Username field is mandatory");
}
else if(editPassword.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(null, "Password field is mandatory");
}
else if(editEmail.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(null, "Email field is mandatory");
}
else {
try {
//Class.forName("con.oracle.jdbc.driver.OracleDriver");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
                   String sql=("select *from Employee_Login where username='"+username+"' and Password='"+Password+"' and Empemail='"+email+"'");
                   
                  Statement smt=con.createStatement();
                   ResultSet rs1=smt.executeQuery(sql);
                   
                   if(rs1.next()) {
                  //if username and password is true then go to Homepage
                 JOptionPane.showMessageDialog(null,"Login Successfully....!!!");
//                  String email1=editEmail.getText();
                 
                 
                 setVisible(false);
                 EmployeewindowafterLogin frame=new EmployeewindowafterLogin();
                 frame.setVisible(true);
                 
   
                 String msg=editEmail.getText();
                 new ViewProfile(msg).setVisible(true);
                 setVisible(false);
                 
                 ViewProfile fr2=new ViewProfile();
                 fr2.setVisible(true);
                 
//                  ViewProfile frmtwo=new ViewProfile();
//                  frmtwo.email.setText(editEmail.getText());
//                  frmtwo.setVisible(true);
                   }
                   else {
                  JOptionPane.showMessageDialog(null, "Invalid Username and Password...!");
                       setVisible(true);
                   }
                   con.close();
}
catch(Exception e1) {
System.out.println(e1);
}
}
}
});
btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
btnLogin.setBounds(15, 361, 152, 33);
contentPane.add(btnLogin);

JButton btnReset = new JButton("Reset");
btnReset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
editUsername.setText("");
editPassword.setText("");
editEmail.setText("");
}
});
btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
btnReset.setBounds(177, 361, 145, 33);
contentPane.add(btnReset);
separator.setBounds(0, 48, 1068, 2);
contentPane.add(separator);

JButton btnNewButton = new JButton("Back to Homepage");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
Homepage frame=new Homepage();
frame.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton.setBounds(654, 65, 195, 33);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("Forgot Password?");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
changePassword frame=new changePassword();
frame.setVisible(true);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
btnNewButton_1.setBounds(433, 374, 189, 33);
contentPane.add(btnNewButton_1);

JLabel lblNewLabel_2_1 = new JLabel("Email ID");
lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_2_1.setBounds(45, 198, 138, 33);
contentPane.add(lblNewLabel_2_1);

JButton btnNewButton_1_1 = new JButton("Forgot Username?");
btnNewButton_1_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
changeUsername frame=new changeUsername();
frame.setVisible(true);
}
});
btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
btnNewButton_1_1.setBounds(433, 315, 189, 33);
contentPane.add(btnNewButton_1_1);

JButton btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
btnClose.setBounds(119, 404, 152, 33);
contentPane.add(btnClose);

editEmail = new JTextField();
editEmail.setColumns(10);
editEmail.setBounds(207, 200, 386, 33);
contentPane.add(editEmail);

JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\priya\\eclipse-workspace\\Hello _World\\JDBC_Connect\\src\\Images\\hrlogin.jpg"));
lblNewLabel_3.setBounds(599, 58, 343, 349);
contentPane.add(lblNewLabel_3);

editid = new JTextField();
editid.setColumns(10);
editid.setBounds(207, 254, 386, 33);
contentPane.add(editid);

JLabel lblNewLabel_2_1_1 = new JLabel("Employee ID");
lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_2_1_1.setBounds(45, 254, 138, 33);
contentPane.add(lblNewLabel_2_1_1);
}
}