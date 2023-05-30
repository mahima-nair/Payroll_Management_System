// 13. Homepage
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Homepage extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Homepage frame = new Homepage();
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
public Homepage() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 959, 656);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnNewButton = new JButton("HR");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HRlogin frame=new HRlogin();
frame.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton.setBounds(310, 214, 227, 47);
contentPane.add(btnNewButton);

JButton btnNewButton_1 = new JButton("Employee");
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
First_Login_Page frame=new First_Login_Page();
frame.setVisible(true);
}
});
btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
btnNewButton_1.setBounds(310, 301, 227, 47);
contentPane.add(btnNewButton_1);

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
btnClose.setBounds(336, 387, 186, 47);
contentPane.add(btnClose);

JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setBackground(Color.BLUE);
lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\priya\\eclipse-workspace\\Hello _World\\JDBC_Connect\\src\\Images\\homepage1.jpeg"));
lblNewLabel_1.setBounds(0, 0, 945, 619);
contentPane.add(lblNewLabel_1);
JLabel lblNewLabel = new JLabel("Payroll Database Management System");
lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 18));
lblNewLabel.setBounds(206, 37, 575, 72);
contentPane.add(lblNewLabel);
}
}