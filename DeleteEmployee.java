// 7. DeleteEmployee
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeleteEmployee extends JFrame {

private JPanel contentPane;
private JTextField name1;
private JButton btnBack;
private JLabel lblEmployeeId;
private JTextField id;
private JLabel lblEmployeeUsername;
private JTextField username1;
private JButton btnClose;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
DeleteEmployee frame = new DeleteEmployee();
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
public DeleteEmployee() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 886, 675);
contentPane = new JPanel();
contentPane.setBackground(new Color(255, 104, 180));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JLabel name = new JLabel("Employee Name");
name.setHorizontalAlignment(SwingConstants.CENTER);
name.setFont(new Font("Tahoma", Font.BOLD, 21));
name.setBounds(146, 242, 191, 55);
contentPane.add(name);

name1 = new JTextField();
name1.setFont(new Font("Tahoma", Font.PLAIN, 14));
name1.setBounds(399, 249, 301, 49);
contentPane.add(name1);
name1.setColumns(10);

JButton btnNewButton = new JButton("Delete");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
          System.out.println("Database Connected!!!");
          PreparedStatement pst;
          PreparedStatement pst1;
          PreparedStatement pst2;
          pst=con.prepareStatement("delete from HrEmployee where EmpName=?");
          pst1=con.prepareStatement("delete from HrEmployee where Empid=?");
          pst2=con.prepareStatement("delete from Employee_Login where username=?");
         
          pst.setString(1, name1.getText());
          pst1.setString(1, id.getText());
          pst2.setString(1, username1.getText());
         
          pst.executeUpdate();
          pst1.executeUpdate();
          pst2.executeUpdate();
         
          JOptionPane.showMessageDialog(null, "Record deleted Successfully...!!!");
         
}
catch (Exception e2) {
// TODO Auto-generated catch block
// JOptionPane.showMessageDialog(null, "Record not found...!!!");
e2.printStackTrace();
}
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(332, 458, 171, 49);
contentPane.add(btnNewButton);

btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
btnBack.setBounds(641, 22, 171, 49);
contentPane.add(btnBack);

lblEmployeeId = new JLabel("Employee ID");
lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 21));
lblEmployeeId.setBounds(128, 151, 191, 55);
contentPane.add(lblEmployeeId);

id = new JTextField();
id.setFont(new Font("Tahoma", Font.PLAIN, 14));
id.setColumns(10);
id.setBounds(399, 158, 301, 49);
contentPane.add(id);

lblEmployeeUsername = new JLabel("Employee Username");
lblEmployeeUsername.setHorizontalAlignment(SwingConstants.CENTER);
lblEmployeeUsername.setFont(new Font("Tahoma", Font.BOLD, 21));
lblEmployeeUsername.setBounds(140, 334, 247, 55);
contentPane.add(lblEmployeeUsername);

username1 = new JTextField();
username1.setFont(new Font("Tahoma", Font.PLAIN, 14));
username1.setColumns(10);
username1.setBounds(399, 341, 301, 49);
contentPane.add(username1);

btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
btnClose.setBounds(575, 458, 171, 49);
contentPane.add(btnClose);
}

}