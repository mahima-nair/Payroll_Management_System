package LoginPages;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ConnectionClass {
		

		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Project","abc");
		Connection con=null;
		Statement stm=null;
		 
		 ConnectionClass()
		 {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pbl","dbms123");
		System.out.println("connected");
		    stm=con.createStatement();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		 }
		 public static void main(String[] args) {
		new ConnectionClass();

		 }
		}




