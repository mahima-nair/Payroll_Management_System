// 28. viewEmployees
package LoginPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewEmployees extends JFrame {

private JPanel contentPane;
private JTable tblData1;
private JTable tblData;
private JScrollPane scrollPane;
private JScrollPane scrollPane_1;
private JButton btnNewButton;
private JButton btnClose;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
ViewEmployees frame = new ViewEmployees();
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
public ViewEmployees() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 783, 592);
contentPane = new JPanel();
contentPane.setBackground(new Color(106, 53, 0));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setResizable(false);
setContentPane(contentPane);
contentPane.setLayout(null);

JButton btnDisplayData = new JButton("Display");
btnDisplayData.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
                 try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
                Statement st=con.createStatement() ;
                String query="select *from HrEmployee";
                st.executeQuery(query);
                ResultSet rs=st.executeQuery(query);
                ResultSetMetaData rsmd=rs.getMetaData();
//                 JTable tblData;
DefaultTableModel model=(DefaultTableModel) tblData1.getModel();
                int cols=rsmd.getColumnCount();
                String[] colName=new String[cols];
                for(int i=0;i<cols;i++)
                colName[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(colName);
                String EmpID,EmpName,EmpMobile,EmpEmail,EmpCity,EmpState,EPF;
               
                while(rs.next()) {
                EmpID=rs.getString(1);
                EmpName=rs.getString(2);
                EmpMobile=rs.getString(3);
                EmpEmail=rs.getString(4);
                EmpCity=rs.getString(5);
                EmpState=rs.getString(6);
                EPF=rs.getString(7);
                String[] row= {EmpID,EmpName,EmpMobile,EmpEmail,EmpCity,EmpState,EPF};
                model.addRow(row);
                }
                st.close();
                con.close();
                 }
                 catch(Exception e1) {
                e1.printStackTrace();
                 }
}
});
btnDisplayData.setFont(new Font("Tahoma", Font.BOLD, 15));
btnDisplayData.setBounds(36, 183, 154, 46);
contentPane.add(btnDisplayData);

scrollPane_1 = new JScrollPane();
scrollPane_1.setBounds(214, 27, 504, 462);
contentPane.add(scrollPane_1);

tblData1 = new JTable();
scrollPane_1.setViewportView(tblData1);

scrollPane = new JScrollPane();
scrollPane.setBounds(253, 61, 465, 410);
contentPane.add(scrollPane);

tblData = new JTable();
scrollPane.setViewportView(tblData);

btnNewButton = new JButton("Back");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
HrwindowafterLogin frame=new HrwindowafterLogin();
frame.setVisible(true);
}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton.setBounds(35, 299, 138, 46);
contentPane.add(btnNewButton);

btnClose = new JButton("Close");
btnClose.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a=JOptionPane.showConfirmDialog(null, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
if(a==0) {
System.exit(0);
}
}
});
btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
btnClose.setBounds(36, 425, 154, 46);
contentPane.add(btnClose);
}

}