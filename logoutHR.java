// 20. logoutHR
package LoginPages;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

class logoutHR extends JFrame implements ActionListener
{
JLabel msg=new JLabel ("Welcome HR");
Container c;
static JButton btn;
logoutHR()
{

c=this.getContentPane();
c.setLayout(null);
Font fo=new Font("Ariel",Font.BOLD,20);
msg.setFont(fo);
btn=new JButton("Logout");
btn.setFont(fo);
btn.setBackground(Color.green);
msg.setBounds(175,100,250,30);
btn.setBounds(175,200,250,30);
btn.addActionListener(this);
setVisible(false);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(300,100,700,600);
setTitle("Welcome form");
setResizable(false);
c.add(btn);
c.add(msg);

}
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==btn)
{
int a=JOptionPane.showConfirmDialog(c, "Are you sure?");
if(a==JOptionPane.YES_OPTION)
{
dispose();
setVisible(false);
HRlogin frame=new HRlogin();
frame.setVisible(true);

}
else
{
dispose();
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);

}
}
}
public static void main(String[] args)
{
new logoutHR().setVisible(true);
}

}
