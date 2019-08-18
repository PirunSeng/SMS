import java.rmi.Naming;
import java.util.ArrayList;

public class StudentClient{
	public static void main(String[] args){
		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> allStudents, studentsFilteredByName, studentsFilteredByCourse;

			// Save, works
      // System.out.println("-----------------");
			// System.out.println("Create new student");
			// Student newStudent = new Student();
			// newStudent.setName("SONG");
			// newStudent.setDateOfBirth("2000-01-01");
			// newStudent.setCourse("Research");
			// int iRet = remoteStudent.save(newStudent);
			// System.out.println("Save " + newStudent.previewString() + " is " + retStr(iRet));

			// Update, works
			// System.out.println("-----------------");
			// System.out.println("Update student with id = 2");
      // int id = 2;
			// Student updatedStudent = new Student();
			// updatedStudent.setName("Seng Pirun");
			// updatedStudent.setDateOfBirth("1999-09-09");
			// updatedStudent.setCourse("Java");
			// System.out.println("Update to student with id = " + id + " " + updatedStudent.previewString() + " is " + retStr(remoteStudent.update(updatedStudent, id)));

      // Delete
      System.out.println("-----------------");
      System.out.println("Delete student with id = 4");
      int id = 4;
      System.out.println("Delete student is " + retStr(remoteStudent.delete(id)));

      // findAll, works
			System.out.println("-----------------");
			System.out.println("List all Students");
			allStudents = remoteStudent.findAll();
			for(Student student: allStudents){
				System.out.println(student.toString());
			}

      // findBYName, works
      // System.out.println("-----------------");
			// System.out.println("List students filtered by name: seng");
			// studentsFilteredByName = remoteStudent.findByName("seng");
			// for(Student student : studentsFilteredByName){
			// 	System.out.println(student.toString());
			// }

      // findBYCourse, works
      // System.out.println("-----------------");
			// System.out.println("List students filtered by course: CG");
			// studentsFilteredByCourse = remoteStudent.findByCourse("cg");
			// for(Student student : studentsFilteredByCourse){
			// 	System.out.println(student.toString());
			// }

      // findById, pending
      // System.out.println("-----------------");
      // System.out.println("Find student by id = 2");
      // Student student = remoteStudent.findById(2);
      // System.out.println(student.toString());
      // int studentId = remoteStudent.findById(4);
      // System.out.println("Return : " + studentId);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static String retStr(int iRet){
		return iRet!=0?"Sucessful":"Failed";
	}
}