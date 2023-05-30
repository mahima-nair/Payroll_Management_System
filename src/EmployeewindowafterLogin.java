// 8. EmployeewindowafterLogin
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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmployeewindowafterLogin extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
EmployeewindowafterLogin frame = new EmployeewindowafterLogin();
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
public EmployeewindowafterLogin() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 999, 650);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 0, 153));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
Homepage frame=new Homepage();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
btnBack.setBounds(760, 21, 154, 44);
contentPane.add(btnBack);

JButton btnNewButton = new JButton("View Profile");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
ViewProfile frame=new ViewProfile();
frame.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
btnNewButton.setBounds(343, 14, 256, 57);
contentPane.add(btnNewButton);

JButton btnCheckSalary = new JButton("Check Salary");
btnCheckSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
btnCheckSalary.setBounds(343, 81, 256, 57);
contentPane.add(btnCheckSalary);

JButton btnChangePassword = new JButton("Change Password");
btnChangePassword.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
changePassword frame=new changePassword();
frame.setVisible(true);
}
});
btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 18));
btnChangePassword.setBounds(343, 215, 256, 57);
contentPane.add(btnChangePassword);

JButton btnChangeUsername = new JButton("Change Username");
btnChangeUsername.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
changeUsername frame=new changeUsername();
frame.setVisible(true);
}
});
btnChangeUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
btnChangeUsername.setBounds(343, 148, 256, 57);
contentPane.add(btnChangeUsername);

JButton btnGenerateSalarySlip = new JButton("Generate Salary Slip");
btnGenerateSalarySlip.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
gensalslip frame=new gensalslip();
frame.setVisible(true);
}
});
btnGenerateSalarySlip.setFont(new Font("Tahoma", Font.BOLD, 18));
btnGenerateSalarySlip.setBounds(343, 292, 256, 57);
contentPane.add(btnGenerateSalarySlip);

JButton btnGenerateSalarySlip_1 = new JButton("Logout");
btnGenerateSalarySlip_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
logoutEmp frame = new logoutEmp();
frame.setVisible(true);
}
});
btnGenerateSalarySlip_1.setFont(new Font("Tahoma", Font.BOLD, 18));
btnGenerateSalarySlip_1.setBounds(343, 450, 256, 57);
contentPane.add(btnGenerateSalarySlip_1);

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
btnClose.setBounds(761, 86, 148, 44);
contentPane.add(btnClose);

JButton btnApplyLeave = new JButton("Apply Leave");
btnApplyLeave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
leavecal frame = new leavecal();
frame.setVisible(true);
}
});
btnApplyLeave.setFont(new Font("Tahoma", Font.BOLD, 18));
btnApplyLeave.setBounds(343, 372, 256, 57);
contentPane.add(btnApplyLeave);
}

}