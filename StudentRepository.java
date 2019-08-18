import java.sql.*;
import java.util.*;

// import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class StudentRepository{
	
	public static int save(Student p){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "INSERT INTO students(name, date_of_birth, course) VALUES (?,?,?)"; 
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDateOfBirth());
			pstmt.setString(3, p.getCourse());
			
			iRet = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return iRet;
	}
	
	public static int update(Student p, int id){
		int iRet = -1;
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "UPDATE students SET name=?, date_of_birth=?, course=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDateOfBirth());
			pstmt.setString(3, p.getCourse());
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
				Student p = new Student();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDateOfBirth(rs.getString("date_of_birth"));
				p.setCourse(rs.getString("course"));
				arr.add(p);
			}
			
			stmt.close();
			con.close();
		}catch(SQLException se){
			System.out.println(se);
		}
		return arr;
	}

  public static Student findById(int id){
    Student student = new Student();
		try{
			Connection con = DBManager.getInstance().getConnection();
			String SQL = "SELECT * FROM students WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(SQL);

			while(rs.next()){
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setDateOfBirth(rs.getString("date_of_birth"));
				student.setCourse(rs.getString("course"));
			}
		}catch(SQLException se){
			System.out.println(se);
		}
		
		return student;
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
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setDateOfBirth(rs.getString("date_of_birth"));
				student.setCourse(rs.getString("course"));
				students.add(student);
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
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setDateOfBirth(rs.getString("date_of_birth"));
				student.setCourse(rs.getString("course"));
				students.add(student);
			}
			
			pstmt.close();
			con.close();
			
		}catch(SQLException se){
			System.out.println(se);
		}
		return students;
	}
}