// 26. viewEmpLeaveData
package LoginPages;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class viewEmpLeaveData extends JFrame implements ActionListener
{
JTable t;
 JButton bt1;
 JTextField tf1;
 JPanel p1,p2,p3;
 String x[]= {"Employee ID","Name","Email","Start Date","End Date","Reason"};
 String y[][]=new String [20] [6];
 
 int i=0,j=0;
 Font f,f1;
 JLabel l2;
 private JButton btnBack;
 
 viewEmpLeaveData(){
 super("All Employee Leave Records");
 setSize(1500,400);
 setLocation(0,10);
 f=new Font("MS UI Gothic",Font.BOLD,17);
 try
 {
 ConnectionClass obj=new ConnectionClass();
 String q="select *from ApplyLeave";
 ResultSet rest=obj.stm.executeQuery(q);
 while(rest.next()) {
 y[i][j++]=rest.getString("Empid");
y[i][j++]=rest.getString("Empname");
y[i][j++]=rest.getString("Empemail");
y[i][j++]=rest.getString("Start_date");
y[i][j++]=rest.getString("End_date");
y[i][j++]=rest.getString("reason");
// y[i][j++]=rest.getString("Apply_date");
i++;
j=0;
 }
 t=new JTable(y,x); //first print 2 dimensional array then one dimensional array
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 JScrollPane js=new JScrollPane(t);
 t.setBackground(Color.WHITE);
 t.setForeground(Color.BLACK);
 t.setFont(f);
 
 f1=new Font("Lucida Fax",Font.BOLD,25);
 
 l2=new JLabel("Employee ID");
 l2.setFont(f1);
 l2.setForeground(Color.GRAY);
 tf1=new JTextField();
 tf1.setFont(f);
 
 bt1=new JButton("Search Employee");
 bt1.setFont(f);
 
 bt1.setBackground(Color.BLACK);
 bt1.setForeground(Color.WHITE);
 bt1.addActionListener(this);
 
 p1=new JPanel();
 p1.setLayout(new GridLayout(1,1,10,10));
 
 p2=new JPanel();
 p2.setLayout(new GridLayout(1,3,10,10));
 p2.add(l2);
 p2.add(tf1);
 p2.add(bt1);
 
 p3=new JPanel();
 p3.setLayout(new GridLayout(2,1,10,10));
 p3.add(p1);
 
 btnBack = new JButton("Back");
 btnBack.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
  setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
  }
 });
 btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
 p1.add(btnBack);
 p3.add(p2);
 
 getContentPane().add(p3,"South");
 getContentPane().add(js);
 }
 
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
String eid=tf1.getText();
if(e.getSource()==bt1) {
new viewEmpLeaveDataSingle(eid).setVisible(true);
}
}
public static void main(String[] args)
{
new viewEmpLeaveData().setVisible(true);
}

}