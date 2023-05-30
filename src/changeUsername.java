// 5. changeUsername
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class changeUsername extends JFrame {
      Connection con=null;
      PreparedStatement pst=null;
      ResultSet rs=null;
private JPanel contentPane;
private JTextField email;
private JTextField nuser;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
changeUsername frame = new changeUsername();
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
public changeUsername() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 947, 560);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
             setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
EmployeewindowafterLogin frame=new EmployeewindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
btnBack.setBounds(485, 395, 160, 47);
contentPane.add(btnBack);

JLabel lblNewLabel = new JLabel("Change Username");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel.setBounds(270, 5, 267, 52);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Email_ID");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setBounds(54, 84, 196, 46);
contentPane.add(lblNewLabel_1);

email = new JTextField();
email.setBounds(217, 87, 297, 46);
contentPane.add(email);
email.setColumns(10);

JButton btnSubmit = new JButton("Submit");
btnSubmit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
 try {
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
pst=con.prepareStatement("select *from Employee_Login where Empemail=?");
pst.setString(1, email.getText());
// pst.setString(2,ouser.getText());
rs=pst.executeQuery();

if(rs.next()) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
pst=con.prepareStatement("update Employee_Login set username=? where Empemail=?");
pst.setString(1, nuser.getText());
pst.setString(2, email.getText());
pst.executeUpdate();
JOptionPane.showMessageDialog(null, "Reset Successfull \n Login now");
}
       catch (SQLException ex) {
// TODO Auto-generated catch block
ex.printStackTrace();
                               }
}
else {
JOptionPane.showMessageDialog(null, "Answer not Match");
}
}
          catch (Exception e2) {
// TODO Auto-generated catch block
e2.printStackTrace();
}
}
});
btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSubmit.setBounds(86, 300, 136, 46);
contentPane.add(btnSubmit);

JButton btnCancel = new JButton("Cancel");
btnCancel.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
email.setText("");
// ouser.setText("");
nuser.setText("");
}
});
btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
btnCancel.setBounds(283, 300, 155, 46);
contentPane.add(btnCancel);

JButton btnSearch = new JButton("Search");
btnSearch.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
pst=con.prepareStatement("select username from  Employee_Login where Empemail=?");
pst.setString(1, email.getText());
rs=pst.executeQuery();
if(rs.next()) {
// ouser.setText(rs.getString("ouser"));
}
else {
JOptionPane.showMessageDialog(null,"Record not found");
}

} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (Exception e2) {
// TODO Auto-generated catch block
e2.printStackTrace();
}

}
});
btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSearch.setBounds(282, 373, 144, 46);
contentPane.add(btnSearch);

JLabel lblNewLabel_1_3_1 = new JLabel("New Username");
lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1_3_1.setBounds(49, 179, 196, 46);
contentPane.add(lblNewLabel_1_3_1);

nuser = new JTextField();
nuser.setColumns(10);
nuser.setBounds(220, 182, 297, 46);
contentPane.add(nuser);

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
btnClose.setBounds(78, 373, 144, 46);
contentPane.add(btnClose);

JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setIcon(new ImageIcon(changeUsername.class.getResource("/Images/cuser1.png")));
lblNewLabel_2.setBounds(583, -20, 243, 383);
contentPane.add(lblNewLabel_2);
}
}