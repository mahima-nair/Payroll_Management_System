// 3. ApplyLeave
package LoginPages;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class ApplyLeave extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton bt1,bt2;
JPanel p1,p2,p3;
JTextField tf1,tf2,tf3,tf4;
Font f,f1;
Choice ch1,ch2;
private JButton btnBack;
private JLabel lblimage;

ApplyLeave()
{
super("Apply Employee Leave");
setLocation(500,50);
setSize(943,653);
// setResizable(false);

f=new Font("Arial",Font.BOLD,25);
f1=new Font("Arial",Font.BOLD,16);

l1=new JLabel("Apply Employee Leave");
l2=new JLabel("select Employee ID");
l3=new JLabel("Name");
l4=new JLabel("Email");
l5=new JLabel("Start Date");
l6=new JLabel("End Date");
l7=new JLabel("Leave Type");

tf1=new JTextField();
tf2=new JTextField();
tf3=new JTextField();
tf4=new JTextField();

bt1=new JButton("Submit");
bt2=new JButton("Close");

bt1.addActionListener(this);
bt2.addActionListener(this);

bt1.setForeground(Color.WHITE);
bt2.setForeground(Color.WHITE);

bt1.setBackground(Color.BLACK);
bt2.setBackground(Color.BLACK);

ch1=new Choice();
try
{
ConnectionClass obj=new ConnectionClass();
String q="select Empid from HrEmployee";
ResultSet rest=obj.stm.executeQuery(q);
while(rest.next())
{
ch1.add(rest.getString("Empid"));
}
}
catch(Exception e)
{
e.printStackTrace();
}

ch2=new Choice();
ch2.add("Sick Leave");
ch2.add("Casual Leave");
ch2.add("Maternity/Paternity Leave");
ch2.add("Travel Leave");
ch2.add("Earned Leave");

l1.setHorizontalAlignment(JLabel.CENTER);

l1.setFont(f);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
l7.setFont(f1);
ch1.setFont(f1);
ch2.setFont(f1);

tf1.setFont(f1);
tf2.setFont(f1);
tf3.setFont(f1);
tf4.setFont(f1);

bt1.setFont(f1);
bt2.setFont(f1);

tf1.setEditable(false);
tf2.setEditable(false);

p1=new JPanel();
p1.setLayout(new GridLayout(2,2,18,15));
p1.add(l1);

p2=new JPanel();
p2.setLayout(new GridLayout(8,7,15,15));

p2.add(l2);
p2.add(ch1);
p2.add(l3);
p2.add(tf1);
p2.add(l4);
p2.add(tf2);
p2.add(l5);
p2.add(tf3);
p2.add(l6);
p2.add(tf4);
p2.add(l7);
p2.add(ch2);
p2.add(bt1);
p2.add(bt2);

p3=new JPanel();
p3.setLayout(new GridLayout(5,5,10,10));

// ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\priya\\eclipse-workspace\\Hello _World\\JDBC_Connect\\src\\Images\\insertleave1.jpeg"));
// Image img1=img.getImage().getScaledInstance(250, 400, Image.SCALE_SMOOTH);
// ImageIcon ic1=new ImageIcon(img1);
// l8=new JLabel(null);
// p3.add(l8);

getContentPane().setLayout(new BorderLayout(10,10));
getContentPane().add(p1,"North");
// getContentPane().add(p3,"Center");
getContentPane().add(p2,"West");

btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
EmployeewindowafterLogin frame=new  EmployeewindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
p1.add(btnBack);

lblimage = new JLabel("");
lblimage.setBackground(new Color(240, 240, 240));
lblimage.setIcon(new ImageIcon(ApplyLeave.class.getResource("/Images/IN.jpg")));
getContentPane().add(lblimage, BorderLayout.CENTER);

ch1.addMouseListener(new MouseAdapter()
{
@Override
public void mouseClicked(MouseEvent arg0)
{
try
{
ConnectionClass obj2=new ConnectionClass();
String eid=ch1.getSelectedItem();
System.out.println("Connected");
   String q2="select *from HrEmployee where Empid='"+eid+"'";
   System.out.println(eid);
   ResultSet rest1=obj2.stm.executeQuery(q2);
   
   while(rest1.next()) {
    tf1.setText(rest1.getString("Empname"));
    tf2.setText(rest1.getString("Empemail"));
   }
}
catch(Exception e1)
{
e1.printStackTrace();
}
}

});
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==bt1)
{
            String eid=ch1.getSelectedItem();
String name=tf1.getText();
String email=tf2.getText();
String startdt=tf3.getText().toString();
String enddt=tf4.getText().toString();
String reason=ch2.getSelectedItem();
String apply_dt=new java.util.Date().toString();
       if(tf3.getText().trim().isEmpty() && tf4.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all the fields");
       }
       else if(tf3.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill start date fields");
       }
       else if(tf4.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill end date fields");
       }
try
{
ConnectionClass obj1=new ConnectionClass();
String ql=("insert into ApplyLeave(Empid,Empname,Empemail,start_date,end_date,reason) values('"+eid+"','"+name+"','"+email+"','"+startdt+"','"+enddt+"','"+reason+"')");
// JOptionPane.showMessageDialog(null, "Your data Successfully Inserted");
  int aa=obj1.stm.executeUpdate(ql);
//   System.out.println(aa);
  if(aa==1)
  {
  JOptionPane.showMessageDialog(null, "Your data Successfully Inserted");
  this.setVisible(true);
  }
  else
  {
  JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
  this.setVisible(false);
  this.setVisible(true);
  }
}
catch(Exception e1)
{
// JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
e1.printStackTrace();
}
}
if(e.getSource()==bt2)
{
JOptionPane.showMessageDialog(null, "Are you sure?");
setVisible(false);
}
}

public static void main(String[] args) {
new ApplyLeave().setVisible(true);
}

}
