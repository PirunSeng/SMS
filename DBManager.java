import java.sql.*;

public class DBManager {
	private static DBManager _instance;
	
	private Connection _connection;

	public DBManager(){
		_connection = getSQLiteConnection();
	}
	
	public static DBManager getInstance(){
		try{
			if(_instance == null){ 
				_instance = new DBManager();
				System.out.println("DBManager.getInstance() is initialized");
			}else if(_instance.getConnection().isClosed()){
				_instance = new DBManager();
			}
			return _instance;
		}catch(SQLException se){
			System.out.println(se);
			return null;
		}
	}
	
	public Connection getConnection(){
		return _connection;
	}

	public static Connection getSQLServerConnection(){
		Connection con = null;
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String URL = "jdbc:sqlserver://localhost;databaseName=NID;user=sa;password=Imdestar;";
			con = DriverManager.getConnection(URL);
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}

	public static Connection getSQLiteConnection(){
		Connection con = null;
		try{
			String url = "jdbc:sqlite:ds_rmi.db";
			con = DriverManager.getConnection(url);
		}catch(Exception se){
			System.out.println(se);
		}
		return con;
	}
}