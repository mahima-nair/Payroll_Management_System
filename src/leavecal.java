//18. leavecal
package LoginPages;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


public class leavecal extends JFrame {

protected static final String Static = null;
private JPanel contentPane;
private JTextField id;
private JTextField name;
static int bleavecl=0,bleavesl=0,bleavemlpl=0,bleavetl=0;
public JTextField email;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
leavecal frame = new leavecal();
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

public leavecal(String msg) {
// getComponents();
name.setText(msg);
}


int casual=15,sick=15,mlpl1=120,tl1=30;
Connection con;
PreparedStatement pst;
PreparedStatement pst1;
PreparedStatement pst2;
PreparedStatement pst3;

public void Connection()
{
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");

}
catch(Exception ee) {
ee.printStackTrace();
}
}


public void Loadleave() {
Connection();

String empmail=(First_Login_Page.editEmail.getText());
try {

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
Statement st=con.createStatement();

String sql=("select *from leave where Empemail='"+empmail+"'");
//          pst.setString(1, empmail);
         ResultSet rs2=st.executeQuery(sql);
         JOptionPane.showMessageDialog(null, empmail);
         
if(rs2.next())
{
JOptionPane.showMessageDialog(null, "Hello");

int casual=15;
JOptionPane.showMessageDialog(null, casual);
int sick=15;
int mlpl1=120;
int tl1=30;
}
else
{
JOptionPane.showMessageDialog(null, "Leave information Error");
}
}

catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

public leavecal() {
// Loadleave();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 857, 630);
contentPane = new JPanel();
contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 0)));
        setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JPanel panel1 = new JPanel();
panel1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 0)));
panel1.setBackground(new Color(128, 0, 0));
panel1.setBounds(162, 54, 430, 417);
contentPane.add(panel1);
panel1.setLayout(null);

JLabel lblNewLabel_2 = new JLabel("Emp ID");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_2.setForeground(new Color(255, 255, 0));
lblNewLabel_2.setBounds(44, 27, 90, 30);
panel1.add(lblNewLabel_2);

JLabel lblNewLabel_2_1 = new JLabel("Name");
lblNewLabel_2_1.setForeground(Color.YELLOW);
lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_2_1.setBounds(44, 97, 90, 30);
panel1.add(lblNewLabel_2_1);

JLabel lblNewLabel_2_1_1 = new JLabel("Days");
lblNewLabel_2_1_1.setForeground(Color.YELLOW);
lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_2_1_1.setBounds(44, 242, 90, 30);
panel1.add(lblNewLabel_2_1_1);

id = new JTextField();
id.setBackground(new Color(255, 255, 255));
id.setBounds(144, 28, 198, 35);
panel1.add(id);
id.setColumns(10);

name = new JTextField();
name.setColumns(10);
name.setBackground(new Color(255, 255, 255));
name.setBounds(144, 98, 198, 35);
panel1.add(name);

JSpinner spinnerdays = new JSpinner();
spinnerdays.setFont(new Font("Tahoma", Font.BOLD, 18));
spinnerdays.setBounds(165, 251, 105, 35);
panel1.add(spinnerdays);

JButton btnPressHereFirst = new JButton("Press here first");
btnPressHereFirst.addActionListener(new ActionListener() {
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
// mobile.setText(rs.getString(3));
// email.setText(rs.getString(4));
// city.setText(rs.getString(5));
// state.setText(rs.getString(6));
// pfno.setText(rs.getString(7));
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
btnPressHereFirst.setBounds(80, 336, 213, 43);
panel1.add(btnPressHereFirst);
btnPressHereFirst.setFont(new Font("Tahoma", Font.BOLD, 18));

JLabel lblNewLabel_2_1_2 = new JLabel("Email");
lblNewLabel_2_1_2.setForeground(Color.YELLOW);
lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
lblNewLabel_2_1_2.setBounds(44, 166, 90, 30);
panel1.add(lblNewLabel_2_1_2);

email = new JTextField();
email.setColumns(10);
email.setBackground(Color.WHITE);
email.setBounds(144, 161, 198, 35);
panel1.add(email);

JLabel lblNewLabel_1 = new JLabel("Apply Leave");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
lblNewLabel_1.setBounds(339, 10, 223, 34);
contentPane.add(lblNewLabel_1);
//      Loadleave();
JButton btnok = new JButton("OK");
btnok.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int casual=10;
int sick=10;
int mlpl1=120;
int tl1=30;

int b;
String empmail=(First_Login_Page.editEmail.getText());

int days=Integer.parseInt(spinnerdays.getValue().toString());
String s=JOptionPane.showInputDialog(null,"Enter Type of Leave (in smallcase)");
JOptionPane.showMessageDialog(null, s);
JOptionPane.showMessageDialog(null, days);

    String s1="casual";String s2="sick";String s3="maternity";String s4="paternity";String s5="travel";
if(s.equals(s1))
{
b=casual-days;
bleavecl=b-bleavecl;

// JOptionPane.showMessageDialog(null, "bleavecl "+bleavecl);

if(days>0 && days<=10)
{
JOptionPane.showMessageDialog(null, "You have a Casual Leave "+b);
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst4;
int a=0;
pst4=con.prepareStatement("update leave set cl='"+bleavecl+"',extracl='"+a+"',extrasl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");

pst4.executeUpdate();
JOptionPane.showMessageDialog(null, "Your casual leave updated");

}
catch (SQLException e1) {
// TODO Auto-generated catch block
}
catch (ClassNotFoundException e1) {
JOptionPane.showMessageDialog(null, "Your casual leave are over");
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
else if(days>0 && days>10)
{
b=days-casual;
bleavecl=b-bleavecl;
JOptionPane.showMessageDialog(null, "Entering extra else if");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst41;
int a=0;
pst41=con.prepareStatement("update leave set extracl='"+b+"',extrasl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");

pst41.executeUpdate();
JOptionPane.showMessageDialog(null, "Your extra leave updated");

}
catch (SQLException e1) {
// TODO Auto-generated catch block
}
catch (ClassNotFoundException e1) {
JOptionPane.showMessageDialog(null, "Your casual leave are over");
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
else
{
JOptionPane.showMessageDialog(null, "Casual Error");
}

}


else if(s.equals(s2))
{
// JOptionPane.showMessageDialog(null, "sick "+sick);

b=sick-days;
bleavesl=b-bleavesl;

if(days>=0 && days<=10)
{
JOptionPane.showMessageDialog(null, "You have a sick Leave "+sick);
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst5;
int a=0;
pst5=con.prepareStatement("update leave set sl='"+bleavesl+"',extracl='"+a+"',extrasl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");
pst5.executeUpdate();
JOptionPane.showMessageDialog(null, "Your sick leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
else if(days>10)
{
b=days-sick;
JOptionPane.showMessageDialog(null,"Entering extra sick");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst51;
int a=0;
pst51=con.prepareStatement("update leave set extrasl='"+b+"',extracl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");
pst51.executeUpdate();
JOptionPane.showMessageDialog(null, "Your sick leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}

else
{
JOptionPane.showMessageDialog(null, "Sick Error");
}

}


else if(s.equals(s3) || s.equals(s4))
{
// JOptionPane.showMessageDialog(null, "mlpl "+mlpl1);
b=mlpl1-days;
bleavemlpl=b-bleavemlpl;
if(days>=0 && days>10)
{
JOptionPane.showMessageDialog(null, "You have a Maternity/Paternity Leave "+mlpl1);
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst6;
int a=0;
pst6=con.prepareStatement("update leave set mlpl='"+bleavemlpl+"',extracl='"+a+"',extrasl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");
pst6.executeUpdate();
JOptionPane.showMessageDialog(null, "Your maternity/paternity leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}


}
else if(days>10)
{
b=days-mlpl1;
JOptionPane.showMessageDialog(null,"Entering extra mlpl");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst61;
int a=0;
pst61=con.prepareStatement("update leave set extramlpl='"+b+"',extracl='"+a+"',extrasl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");
pst61.executeUpdate();
JOptionPane.showMessageDialog(null, "Your maternity/paternity leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}


}
else
{
JOptionPane.showMessageDialog(null, "mlpl Error");
}

}

else if(s.equals(s5))
{
JOptionPane.showMessageDialog(null, "Travel "+tl1);
b=tl1-days;
bleavetl=b-bleavetl;
if(days>=0 && days<=10)
{
JOptionPane.showMessageDialog(null, "You have a Travel Leave "+tl1);
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst7;
int a=0;
pst7=con.prepareStatement("update leave set tl='"+bleavetl+"',extracl='"+a+"',extrasl='"+a+"',extramlpl='"+a+"',extratl='"+a+"' where Empemail='"+empmail+"'");
pst7.executeUpdate();
JOptionPane.showMessageDialog(null, "Your Travel leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
if(days>10)
{
b=days-tl1;
JOptionPane.showMessageDialog(null,"Entering tl ");
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
PreparedStatement pst71;
int a=0;
pst71=con.prepareStatement("update leave set extratl='"+b+"',extracl='"+a+"',extrasl='"+a+"',extramlpl='"+a+"' where Empemail='"+empmail+"'");
pst71.executeUpdate();
JOptionPane.showMessageDialog(null, "Your Travel leave updated");
}
catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (ClassNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}

}
else
{
JOptionPane.showMessageDialog(null, "tl Error");

}

}
else {
JOptionPane.showMessageDialog(null, "Something Wrong");
}
}
});
btnok.setFont(new Font("Tahoma", Font.BOLD, 18));
btnok.setBounds(301, 498, 124, 43);
contentPane.add(btnok);

JButton btnCancel = new JButton("Close");
btnCancel.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
btnCancel.setBounds(457, 498, 124, 43);
contentPane.add(btnCancel);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
EmployeewindowafterLogin frame = new EmployeewindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
btnBack.setBounds(636, 498, 124, 43);
contentPane.add(btnBack);
}
}