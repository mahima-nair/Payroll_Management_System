//12. gensalslip
package LoginPages;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gensalslip extends JFrame implements ActionListener
{
JButton bt1,bt2;
JLabel l1,l2,l3,l4,l5,l6;
JTextArea ta;
Choice ch1,ch2,ch3;
JPanel p1;
Font f;
private JButton btnBack;

   gensalslip()
   {
  super("Generate Pay Slip");
  setSize(741,610);
  setLocation(100,100);
  setResizable(false);
 
  f=new Font("arial",Font.BOLD,16);
 
  l1=new JLabel("          Employee Email");
  l2=new JLabel("          Month");
  l3=new JLabel("          Year");
 
  l1.setFont(new Font("Arial", Font.BOLD, 18));
  l2.setFont(new Font("Arial", Font.BOLD, 18));
  l3.setFont(new Font("Arial", Font.BOLD, 18));
 
  ch1=new Choice();
 
  try
  {
  ConnectionClass obj=new ConnectionClass();
  String q="select Empemail from HrEmployee";
  ResultSet rest=obj.stm.executeQuery(q);
  while(rest.next())
  {
  ch1.add(rest.getString("Empemail"));
  }
  }
  catch(Exception e)
  {
  e.printStackTrace();
  }
  ch2=new Choice();
 
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
  ch3.add("2015");
  ch3.add("2016");
  ch3.add("2017");
  ch3.add("2018");
  ch3.add("2019");
  ch3.add("2020");
  ch3.add("2021");
  ch3.add("2022");
  ch3.add("2023");
 
  ch1.setFont(f);
  ch2.setFont(f);
  ch3.setFont(f);
 
  bt1=new JButton("Calculate");
  bt1.setBackground(Color.BLACK);
  bt1.setForeground(Color.WHITE);
  bt1.addActionListener(this);
  bt1.setFont(f);
 
  bt2=new JButton("Close");
  bt2.setBackground(Color.BLACK);
  bt2.setForeground(Color.WHITE);
  bt2.addActionListener(this);
  bt2.setFont(f);
 
  p1=new JPanel();
  p1.setLayout(new GridLayout(4,2,10,10));
  p1.add(l1);
  p1.add(ch1);
  p1.add(l2);
  p1.add(ch2);
  p1.add(l3);
  p1.add(ch3);
  p1.add(bt1);
  p1.add(bt2);
 
  ta=new JTextArea();
  JScrollPane sp=new JScrollPane(ta);
  ta.setEditable(false);
  ta.setFont(new Font("Arial", Font.BOLD, 15));
 
  getContentPane().setLayout(new BorderLayout());
  getContentPane().add(sp,"Center");
 
  btnBack = new JButton("Print Salary Slip");
  btnBack.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
try
{
ta.print();
}
catch(Exception e2)
{
e2.printStackTrace();
Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE,null,e2);
}
  }
  });
  btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
  sp.setColumnHeaderView(btnBack);
  getContentPane().add(p1,"South");
 
   }
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==bt1)
{
JOptionPane.showMessageDialog(null, "Hello");
ta.setText("--------------------------------Pay Slip-----------------------------------------------------------------------------------------------------------");
try
{
ConnectionClass obj1=new ConnectionClass();
String mail=ch1.getSelectedItem();
// JOptionPane.showMessageDialog(null, mail);
String month_year=ch2.getSelectedItem()+" "+ch3.getSelectedItem();
String ql="select *from HrEmployee where Empemail='"+mail+"'";
ResultSet rest1=obj1.stm.executeQuery(ql);
while(rest1.next())
{
ta.append("\n\nEmployee Id: "+Integer.parseInt(rest1.getString("Empid")));
ta.append("\nEmployee Name: "+rest1.getString("Empname"));
ta.append("\n\nEmployee Email: "+rest1.getString("Empemail"));
ta.append("\n----------------------------------------------------------------------------------------\n\n");

}
ConnectionClass obj2=new ConnectionClass();
// String id=ch1.getSelectedItem();
String q2="select *from Employee_Salary where month_year='"+month_year+"' and Empemail='"+mail+"'";
ResultSet rest2=obj2.stm.executeQuery(q2);

if(rest2.next()==false)
{
// ta.append("\n---------------------------------------------------------------------------------------\n\n");
ta.append("Record Not Found of this month and year.\n");
ta.append("\n---------------------------------------------------------------------------------------\n\n");
ta.append("Please add the Salary of this month and year for this record.\n");
}
else
{
ConnectionClass obj3=new ConnectionClass();
ResultSet rest3=obj3.stm.executeQuery(q2);

while(rest3.next())
{  
ta.append("\n\nBASIC SALARY : "+Float.parseFloat(rest2.getString("basic")));
ta.append("\n\nHRA : "+(0.1*Float.parseFloat(rest2.getString("basic"))));
ta.append("\n\nDA : "+(0.1*Float.parseFloat(rest2.getString("basic"))));
ta.append("\n\nMED : "+(0.015*Float.parseFloat(rest2.getString("basic"))));
ta.append("\n\nPF : "+(0.1*Float.parseFloat(rest2.getString("basic"))));

ta.append("\n\nEXTRA LEAVES : "+rest2.getString("Extra_Leaves"));
}
ta.append("\n-----------------------------------------------------------------------------------------------\n\n");
 int perday=(int) (0.03*Float.parseFloat(rest2.getString("basic")));

System.out.println(perday);

float cleave=perday*Integer.parseInt(rest2.getString("Extra_Leaves"));

float gross_salary=(float) ((0.1*Float.parseFloat(rest2.getString("basic")))+(0.1*Float.parseFloat(rest2.getString("basic")))+(0.015*Float.parseFloat(rest2.getString("basic")))+Float.parseFloat(rest2.getString("basic")));

gross_salary=gross_salary-cleave;

double tax=(gross_salary*2.1)/100;

float totalde=(float) (tax+(0.1*Float.parseFloat(rest2.getString("basic"))));

float net=gross_salary-totalde;

ta.append("\nTotal Deductions : "+totalde);
ta.append("\nTax 2.1% of salary : "+tax);
ta.append("\nGross Salary : "+gross_salary);
ta.append("\nNet Salary : "+net);
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
new gensalslip().setVisible(true);
}

}
