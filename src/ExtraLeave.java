// 10. Extraleave
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ExtraLeave extends JFrame {

private JPanel contentPane;
private JTextField extra;
private final JSeparator separator = new JSeparator();
private JButton btnBack;
private JButton btnSubmit;
private JLabel lblEnterEmployeeId;
private JTextField Empid;
private JButton btnClose;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ExtraLeave frame = new ExtraLeave();
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
public ExtraLeave() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 994, 706);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JLabel lblNewLabel = new JLabel("Enter Extra Leaves");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel.setBounds(80, 165, 210, 46);
contentPane.add(lblNewLabel);

extra = new JTextField();
extra.setBounds(336, 170, 378, 59);
contentPane.add(extra);
extra.setColumns(10);

JLabel lblNewLabel_1 = new JLabel("Note: Entering Extra Leaves means allocated leaves of employee are over and now if he/she take leave then salary will be deducted");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel_1.setBounds(10, 601, 970, 51);
contentPane.add(lblNewLabel_1);
separator.setBounds(0, 601, 980, 2);
contentPane.add(separator);

btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
AddEmpSalary frame=new AddEmpSalary();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
btnBack.setBounds(408, 458, 175, 38);
contentPane.add(btnBack);

btnSubmit = new JButton("Submit");
btnSubmit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(e.getSource()== btnSubmit) {

                    String leave=extra.getText();
                String id=Empid.getText();
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
System.out.println("Database Connected!!!");
String sql="update Employee_Salary set Extra_Leaves="+leave+" where Empid='"+id+"'";

PreparedStatement ps=con.prepareStatement(sql);
ps.executeUpdate(sql);

JOptionPane.showMessageDialog(null, "Data Added Successfully...");
// setVisible(true);
extra.setText("");
Empid.setText("");
// EmpAadhar.setText("");
ps.close();
con.close();

}
catch (Exception e1) {
// TODO Auto-generated catch block
System.out.print(e1);
JOptionPane.showMessageDialog(btnSubmit,e1);
extra.setText("");
Empid.setText("");
// EmpAadhar.setText("");
}
}
else {
setVisible(false);
new Homepage();
}
}
});
btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
btnSubmit.setBounds(150, 458, 175, 38);
contentPane.add(btnSubmit);

lblEnterEmployeeId = new JLabel("Enter Employee ID");
lblEnterEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 17));
lblEnterEmployeeId.setBounds(90, 267, 210, 46);
contentPane.add(lblEnterEmployeeId);

Empid = new JTextField();
Empid.setColumns(10);
Empid.setBounds(341, 267, 378, 59);
contentPane.add(Empid);

btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
btnClose.setBounds(667, 458, 175, 38);
contentPane.add(btnClose);
}
}
