// 27. viewEmployeeLeaveDataSingle
package LoginPages;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class viewEmpLeaveDataSingle extends JFrame implements ActionListener
{
JTable t;
String x[]= {"Employee ID","Name","Email","Start Date","End Date","Reason","Apply Date"};
String y[][]=new String [20] [7];
int i=0,j=0;
Font f,f1;
int count=0;

   viewEmpLeaveDataSingle(String eid)
   {
  super("Particular Employee Leave records");
 f=new Font("MS UI Gothic", Font.BOLD,17);
 
 try
 {
 ConnectionClass obj=new ConnectionClass();
String q=("select *from ApplyLeave where Empid='"+eid+"'");
ResultSet rest=obj.stm.executeQuery(q);
while(rest.next())
{
count++;
y[i][j++]=rest.getString("Empid");
y[i][j++]=rest.getString("Empname");
y[i][j++]=rest.getString("Empemail");
y[i][j++]=rest.getString("Start_date");
y[i][j++]=rest.getString("End_date");
y[i][j++]=rest.getString("reason");
y[i][j++]=rest.getString("Apply_date");
i++;
j=0;
}

if(count==0)
{
JOptionPane.showMessageDialog(null, "No record Found.");
exit(0);
}
else
{
t=new JTable(y,x);
JScrollPane js=new JScrollPane(t);
t.setBackground(Color.WHITE);
t.setForeground(Color.BLACK);
t.setFont(f);
setSize(1480,400);
setLocation(0,10);
add(js);
}
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
   }

private void exit(int k) {
// TODO Auto-generated method stub

}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub


}
}