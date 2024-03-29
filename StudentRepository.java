import java.sql.*;
import java.util.*;

// import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class StudentRepository{
	
	public static int save(Student std){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "INSERT INTO students(name, date_of_birth, course) VALUES (?,?,?)"; 
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, std.getName());
			pstmt.setString(2, std.getDateOfBirth());
			pstmt.setString(3, std.getCourse());
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}
	
	public static int update(Student std, int id){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "UPDATE students SET name=?, date_of_birth=?, course=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, std.getName());
			pstmt.setString(2, std.getDateOfBirth());
			pstmt.setString(3, std.getCourse());
			pstmt.setInt(4, id);
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}

	public static int delete(int id){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "DELETE FROM students WHERE id=?;";
			PreparedStatement pstmt = con.prepareStatement(SQL);
      pstmt.setInt(1, id);
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
			String QRY = "SELECT * FROM students ORDER BY id";
			Connection con = DBManager.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QRY);

			while(rs.next()){
				Student std = new Student();
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setDateOfBirth(rs.getString("date_of_birth"));
				std.setCourse(rs.getString("course"));
				arr.add(std);
			}
			
			stmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		return arr;
	}

  public static Student findById(int id){
    Student std = new Student();
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "SELECT * FROM students WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setDateOfBirth(rs.getString("date_of_birth"));
				std.setCourse(rs.getString("course"));
			}
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return std;
	}
	
	public static ArrayList<Student> findByName(String name){
		ArrayList<Student> students = new ArrayList<Student>();
		
		try{
			String QRY = "SELECT * FROM students WHERE name LIKE(?) ORDER BY id";
			Connection con = DBManager.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement(QRY);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Student std = new Student();
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setDateOfBirth(rs.getString("date_of_birth"));
				std.setCourse(rs.getString("course"));
				students.add(std);
			}
			
			pstmt.close();
			con.close();
			
		}catch(SQLException se){
			System.out.println(se);
		}
		return students;
	}

  public static ArrayList<Student> findByCourse(String course){
		ArrayList<Student> students = new ArrayList<Student>();
		
		try{
			String QRY = "SELECT * FROM students WHERE course LIKE(?) ORDER BY id";
			Connection con = DBManager.getInstance().getConnection();
			PreparedStatement pstmt = con.prepareStatement(QRY);
			pstmt.setString(1, "%" + course + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Student std = new Student();
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setDateOfBirth(rs.getString("date_of_birth"));
				std.setCourse(rs.getString("course"));
				students.add(std);
			}
			
			pstmt.close();
			con.close();
			
		}catch(SQLException se){
			System.out.println(se);
		}
		return students;
	}
}