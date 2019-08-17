import java.sql.*;
import java.util.*;

public class StudentRepository{
	
	public static int save(Student p){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "INSERT INTO Student(Id, ShortName, Name) Values(?,?,?)"; 
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2,p.getShortName());
			pstmt.setString(3,p.getName());
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}
	
	public static int update(Student p){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "UPDATE Student SET ShortName=?, Name=? WHERE Id=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, p.getShortName());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3,p.getId());
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}

	public static int deleteAll(){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "DELETE FROM Student;";
			PreparedStatement pstmt = con.prepareStatement(SQL);

			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}
	
	public static ArrayList<Student> findAll(){
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try{
			String QRY = "SELECT * FROM Student ORDER BY Id";
			Connection con = DBManager.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QRY);

			while(rs.next()){
				Student p = new Student();
				p.setId(rs.getInt("Id"));
				p.setShortName(rs.getString("ShortName"));
				p.setName(rs.getString("Name"));
				arr.add(p);
			}
			
			stmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		return arr;
	}
	
	public static ArrayList<Student> findByName(String name){
		ArrayList<Student> arr = new ArrayList<Student>();
		
		try{
			String QRY = "SELECT * FROM Student WHERE name LIKE(?) ORDER BY id";
			Connection con = DBManager.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement(QRY);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Student p = new Student();
				p.setId(rs.getInt("Id"));
				p.setShortName(rs.getString("ShortName"));
				p.setName(rs.getString("Name"));
				arr.add(p);
			}
			
			pstmt.close();
			con.close();
			
		}catch(SQLException se){
			System.out.println(se);
		}
		return arr;
	}
		
}