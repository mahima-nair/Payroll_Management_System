// 4. changePassword
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

public class changePassword extends JFrame {
      Connection con=null;
      PreparedStatement pst=null;
      ResultSet rs=null;
private JPanel contentPane;
private JTextField email;
private JTextField username;
private JTextField np;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
changePassword frame = new changePassword();
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
public changePassword() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 947, 560);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
           
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
btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
btnBack.setBounds(748, 10, 163, 46);
contentPane.add(btnBack);

JLabel lblNewLabel = new JLabel("Change Password");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel.setBounds(273, 10, 309, 63);
contentPane.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Email_ID");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setBounds(79, 83, 196, 46);
contentPane.add(lblNewLabel_1);

JLabel lblNewLabel_1_3 = new JLabel("New password");
lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1_3.setBounds(79, 161, 196, 46);
contentPane.add(lblNewLabel_1_3);

email = new JTextField();
email.setBounds(232, 86, 309, 46);
contentPane.add(email);
email.setColumns(10);

JButton btnSubmit = new JButton("Submit");
btnSubmit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
 try {
 Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
pst=con.prepareStatement("select *from Employee_Login where Empemail=? and username=?");
pst.setString(1, email.getText());
// pst.setString(2, np.getText());
pst.setString(2, username.getText());
rs=pst.executeQuery();
if(rs.next()) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
pst=con.prepareStatement("update Employee_Login set Password=? where Empemail=? and username=?");
pst.setString(1, np.getText());
pst.setString(2, email.getText());
pst.setString(3, username.getText());
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
btnSubmit.setBounds(57, 316, 136, 46);
contentPane.add(btnSubmit);

JButton btnCancel = new JButton("Cancel");
btnCancel.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
email.setText("");
username.setText("");
np.setText("");
}
});
btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
btnCancel.setBounds(258, 316, 155, 46);
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
username.setText(rs.getString("username"));
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
btnSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
btnSearch.setBounds(559, 83, 155, 46);
contentPane.add(btnSearch);

username = new JTextField();
username.setColumns(10);
username.setBounds(232, 234, 309, 46);
contentPane.add(username);

JLabel lblNewLabel_1_3_1 = new JLabel("Username");
lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1_3_1.setBounds(79, 233, 196, 46);
contentPane.add(lblNewLabel_1_3_1);

np = new JTextField();
np.setColumns(10);
np.setBounds(232, 164, 309, 46);
contentPane.add(np);

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
btnClose.setBounds(57, 384, 142, 42);
contentPane.add(btnClose);

JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setIcon(new ImageIcon(changePassword.class.getResource("/Images/cuser1.png")));
lblNewLabel_2.setBounds(648, 115, 337, 333);
contentPane.add(lblNewLabel_2);
}
}