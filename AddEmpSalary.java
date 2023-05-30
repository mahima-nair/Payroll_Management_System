// 2. AddEmpSalary
package LoginPages;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmpSalary extends JFrame implements ActionListener
{
Font f,f1;
JLabel l1,l2,l3,l8,l9,l10,l12;
JPanel p1,p2,p3;
JTextField t1,t2,t7;
Choice ch1,ch2,ch3;
JButton bt1,bt2;
private JButton btnBack;
private JTextField extratxt;

AddEmpSalary(){
super("Add Salary");
setLocation(100,100);
setSize(1084,749);
setResizable(false);

f=new Font("Arial",Font.BOLD,18);
f1=new Font("Arial",Font.BOLD,25);

l1=new JLabel("Select Employee Email");
l1.setBounds(19, 2, 453, 46);
l2=new JLabel("Name");
l2.setBounds(18, 58, 453, 46);
l3=new JLabel("Email");
l3.setBounds(19, 114, 453, 46);
l8=new JLabel("Basic Salary");
l8.setBounds(19, 394, 453, 46);
l9=new JLabel("Select Month");
l9.setBounds(18, 450, 453, 46);
l10=new JLabel("Select Year");
l10.setBounds(22, 506, 453, 46);
l12=new JLabel("Employee Salary");
//    l13=new JLabel("Extra Leaves");
//    l13.setBounds(0,562,453,46);

l12.setHorizontalAlignment(JLabel.CENTER);

ch1=new Choice();
ch1.setBounds(248, 12, 453, 26);
try
{
ConnectionClass obj=new ConnectionClass();
String q="select Empemail from HrEmployee";
ResultSet rest=obj.stm.executeQuery(q);
while(rest.next()) {
ch1.add(rest.getString("Empemail"));
}
}
catch(Exception e)
{
e.printStackTrace();
}
ch2=new Choice();
ch2.setBounds(209, 460, 453, 26);
ch2.add("January");
ch2.add("February");
ch2.add("March");
ch2.add("April");
ch2.add("May");
ch2.add("June");
ch2.add("July");
ch2.add("August");
ch2.add("September");
ch2.add("October");
ch2.add("November");
ch2.add("December");

ch3=new Choice();
ch3.setBounds(208, 516, 453, 26);
ch3.add("2015");
ch3.add("2016");
ch3.add("2017");
ch3.add("2018");
ch3.add("2019");
ch3.add("2020");
ch3.add("2021");
ch3.add("2022");
ch3.add("2023");

l1.setFont(f);
l2.setFont(f);
l3.setFont(f);
l8.setFont(f);
l9.setFont(f);
l10.setFont(f);
l12.setFont(f);
// l13.setFont(f);

ch1.setFont(f);
ch2.setFont(f);
ch3.setFont(f);

t1=new JTextField();
t1.setBounds(203, 58, 453, 46);
t2=new JTextField();
t2.setBounds(204, 115, 453, 46);
t7=new JTextField();
t7.setBounds(207, 394, 453, 46);
// t8=new JTextField();
// t8.setBounds(298,457,453,46);

t1.setFont(f);
t2.setFont(f);
t7.setFont(f);
// t8.setFont(f);

t1.setEditable(false);
t2.setEditable(false);

bt1=new JButton("Submit");
bt1.setBounds(0, 562, 453, 46);

bt2=new JButton("Close");
bt2.setBounds(463, 562, 453, 46);

bt1.setFont(f);
bt2.setFont(f);
bt1.setBackground(Color.WHITE);
bt1.setForeground(Color.BLACK);
bt2.setBackground(Color.WHITE);
bt2.setForeground(Color.BLACK);

bt1.addActionListener(this);
bt2.addActionListener(this);

p1=new JPanel();
p1.setBounds(20, 52, 950, 650);
p1.setLayout(null);
p1.add(l1);
p1.add(ch1);
p1.add(l2);
p1.add(t1);
p1.add(l3);
p1.add(t2);
p1.add(l8);
p1.add(t7);
p1.add(l9);
// p1.add(l13);
// p1.add(t8);
p1.add(ch2);
p1.add(l10);
p1.add(ch3);
p1.add(bt1);
p1.add(bt2);

p2=new JPanel();
p2.setBounds(0, 52, -10, 611);
p2.setLayout(new GridLayout(1,1,10,10));

p3=new JPanel();
p3.setBounds(0, 0, 936, 22);
p3.setLayout(new GridLayout(1,1,10,10));
p3.add(l12);
getContentPane().setLayout(null);
getContentPane().add(p1);

btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
btnBack.setBounds(779, 10, 113, 31);
p1.add(btnBack);

extratxt = new JTextField();
extratxt.setFont(new Font("Arial", Font.BOLD, 18));
extratxt.setBounds(699, 327, 208, 46);
p1.add(extratxt);
getContentPane().add(p2);
getContentPane().add(p3);

JButton btnClickHereTo = new JButton("Click here to get Extra Leaves");
btnClickHereTo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

try {
String mail=ch1.getSelectedItem();

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");

String sql="select extracl,extrasl,extramlpl,extratl from leave where Empemail='"+mail+"'";
Statement statement=con.createStatement();
ResultSet result=statement.executeQuery(sql);

while(result.next())
{
// JOptionPane.showMessageDialog(null, mail );
int cl=Integer.parseInt(result.getString("extracl"));
// JOptionPane.showMessageDialog(null, cl );
int sl=Integer.parseInt(result.getString("extrasl"));
// JOptionPane.showMessageDialog(null, sl );
int mlpl=Integer.parseInt(result.getString("extramlpl"));

// JOptionPane.showMessageDialog(null, mlpl );
int tl=Integer.parseInt(result.getString("extratl"));
// JOptionPane.showMessageDialog(null, tl );

int extra=(cl+sl+mlpl+tl);
JOptionPane.showMessageDialog(null, "extra "+extra);
String extra1=String.valueOf(extra);
extratxt.setText(extra1);

}

}
catch(Exception e1) {
e1.printStackTrace();
}
}
});
btnClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 12));
btnClickHereTo.setBounds(687, 385, 229, 60);
p1.add(btnClickHereTo);


ch1.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0)
{
try
{
ConnectionClass obj2=new ConnectionClass();
String mail=ch1.getSelectedItem();
String q3="select *from HrEmployee where Empemail='"+mail+"'";
ResultSet rest1=obj2.stm.executeQuery(q3);
while(rest1.next())
{
t1.setText(rest1.getString("Empname"));
t2.setText(rest1.getString("Empemail"));

}
}
catch(Exception e)
{
e.printStackTrace();
}
}
});

}


@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==bt1)
{
String Eid=ch1.getSelectedItem();

String name=t1.getText();
String email=t2.getText();
// int extraleaves=Integer.parseInt(t8.getText());
// float hra=Float.parseFloat(t3.getText());
// float da=Float.parseFloat(t4.getText());
// float mid=Float.parseFloat(t5.getText());
// float pf=Float.parseFloat(t6.getText());
float basic=Float.parseFloat(t7.getText());
String month=ch2.getSelectedItem()+" "+ch3.getSelectedItem();
       String extra11=extratxt.getText();
try
{
ConnectionClass obj1=new ConnectionClass();
String q1="insert into Employee_Salary(Empid,Empname,Empemail,basic,month_year,extra_leaves) values('"+Eid+"','"+name+"','"+email+"','"+basic+"','"+month+"','"+extra11+"')";
  int aa=obj1.stm.executeUpdate(q1);
  System.out.println(aa);
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
e1.printStackTrace();
}
}
if(e.getSource()==bt2)
{
JOptionPane.showMessageDialog(null, "Are you sure?");
setVisible(false);
}
}
public static void main(String[] args)
{
new AddEmpSalary().setVisible(true);
}
}