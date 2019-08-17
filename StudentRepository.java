import java.sql.*;
import java.util.*;

public class StudentRepository{
	
	// public static int save(Student p){
	// 	int iRet = -1;
	// 	try{
	// 		Connection con = DBManager.getInstance().getConnection();
	// 		String SQL = "INSERT INTO students(name, date_of_birth, course) VALUES (?,?,?)"; 
	// 		PreparedStatement pstmt = con.prepareStatement(SQL);
	// 		pstmt.setString(1, p.getName());
	// 		pstmt.setString(2, p.getDateOfBirth());
	// 		pstmt.setString(3, p.getCourse());
			
	// 		iRet = pstmt.executeUpdate();
			
	// 		pstmt.close();
	// 		con.close();
	// 	}catch(SQLException se){
	// 		System.out.println(se);
	// 	}
		
	// 	return iRet;
	// }
	
	// public static int update(Student p){
	// 	int iRet = -1;
	// 	try{
	// 		Connection con = DBManager.getInstance().getConnection();
	// 		String SQL = "UPDATE students SET name=?, date_of_birth=?, course=? WHERE Id=?";
	// 		PreparedStatement pstmt = con.prepareStatement(SQL);
	// 		pstmt.setString(1, p.getName());
	// 		pstmt.setString(2, p.getDateOfBirth());
	// 		pstmt.setString(3, p.getCourse());
	// 		pstmt.setInt(4, p.getId());
			
	// 		iRet = pstmt.executeUpdate();
			
	// 		pstmt.close();
	// 		con.close();
	// 	}catch(SQLException se){
	// 		System.out.println(se);
	// 	}
		
	// 	return iRet;
	// }

	// public static int deleteAll(){
	// 	int iRet = -1;
	// 	try{
	// 		Connection con = DBManager.getInstance().getConnection();
	// 		String SQL = "DELETE FROM Student;";
	// 		PreparedStatement pstmt = con.prepareStatement(SQL);

	// 		iRet = pstmt.executeUpdate();
			
	// 		pstmt.close();
	// 		con.close();
	// 	}catch(SQLException se){
	// 		System.out.println(se);
	// 	}
		
	// 	return iRet;
	// }
	
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
	
	// public static ArrayList<Student> findByName(String name){
	// 	ArrayList<Student> arr = new ArrayList<Student>();
		
	// 	try{
	// 		String QRY = "SELECT * FROM Student WHERE name LIKE(?) ORDER BY id";
	// 		Connection con = DBManager.getInstance().getConnection();
	// 		PreparedStatement pstmt = con.prepareStatement(QRY);
	// 		pstmt.setString(1, "%" + name + "%");
	// 		ResultSet rs = pstmt.executeQuery();
			
	// 		while(rs.next()){
	// 			Student p = new Student();
	// 			p.setId(rs.getInt("Id"));
	// 			p.setShortName(rs.getString("ShortName"));
	// 			p.setName(rs.getString("Name"));
	// 			arr.add(p);
	// 		}
			
	// 		pstmt.close();
	// 		con.close();
			
	// 	}catch(SQLException se){
	// 		System.out.println(se);
	// 	}
	// 	return arr;
	// }
		
}