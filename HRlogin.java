// 14. HRlogin
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
import javax.swing.ImageIcon;

public class HRlogin extends JFrame {

private JPanel contentPane;
private JTextField editUsername;
private JPasswordField editPassword;
private final JSeparator separator = new JSeparator();

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
HRlogin frame = new HRlogin();
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
public HRlogin() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 895, 517);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("HR Login Page");
lblNewLabel.setForeground(new Color(0, 0, 0));
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(0, 0, 1057, 44);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Username");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setBounds(40, 111, 166, 33);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Password");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setBounds(55, 182, 138, 33);
contentPane.add(lblNewLabel_2);

editUsername = new JTextField();
editUsername.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

}
});
editUsername.setBounds(223, 111, 351, 33);
contentPane.add(editUsername);
editUsername.setColumns(10);

editPassword = new JPasswordField();
editPassword.setBounds(222, 184, 351, 33);
contentPane.add(editPassword);

JButton btnLogin = new JButton("Login");
btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String username=editUsername.getText();
String Password=editPassword.getText();
if(editUsername.getText().trim().isEmpty() && editPassword.getText().trim().isEmpty()) {
                  JOptionPane.showMessageDialog(null, "ALL fields are mandatory");
              }
else if(editUsername.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(null, "Username field is mandatory");
}
else if(editPassword.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(null, "Password field is mandatory");
}
else {

try {
//Class.forName("con.oracle.jdbc.driver.OracleDriver");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
                   String sql=("select *from Hr_Login where username='"+username+"' and password='"+Password+"'");
                   Statement smt=con.createStatement();
                   ResultSet rs1=smt.executeQuery(sql);
                   if(rs1.next()) {
//                   setVisible(false);
//                   System.out.println("Hello");
                  //if username and password is true then go to Homepage
                 JOptionPane.showMessageDialog(null,"Login Successfully....!!!");
                 setVisible(false);
                 HrwindowafterLogin frame=new HrwindowafterLogin();
                 frame.setVisible(true);
                   }
                   else {
                  JOptionPane.showMessageDialog(null, "Invalid Username and Password...!");
                       setVisible(true);
                   }
                   
}
catch(Exception e1) {
System.out.println(e1);
}
}
}
});
btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
btnLogin.setBounds(118, 296, 152, 33);
contentPane.add(btnLogin);

JButton btnReset = new JButton("Reset");
btnReset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
editUsername.setText("");
editPassword.setText("");

}
});
btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
btnReset.setBounds(312, 296, 145, 33);
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
btnNewButton.setBounds(312, 352, 195, 33);
contentPane.add(btnNewButton);

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
btnClose.setBounds(118, 352, 145, 33);
contentPane.add(btnClose);

JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\priya\\eclipse-workspace\\Hello _World\\JDBC_Connect\\src\\Images\\hrlogin.jpg"));
lblNewLabel_3.setBounds(536, -20, 415, 438);
contentPane.add(lblNewLabel_3);
}
}