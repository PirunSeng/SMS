import java.rmi.Naming;
import java.util.ArrayList;

public class StudentClient{
	public static void main(String[] args){
		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> allStudents, studentsFilteredByName, studentsFilteredByCourse;
			//Clear records
			// System.out.println("Number of Students deleted = " + remoteStudent.deleteAll());

			//Save Student
      System.out.println("-----------------");
			System.out.println("Create new student");
			Student newStudent = new Student();
			newStudent.setName("SONG");
			newStudent.setDateOfBirth("2000-01-01");
			newStudent.setCourse("Research");

			int iRet = remoteStudent.save(newStudent);
			System.out.println("Save " + newStudent.previewString() + " is " + retStr(iRet));
			
			// System.out.println("-----------------");
			// System.out.println("Find by name composed of Kam");

			//Update Kampong Chhnang to Kampong Speu
			// System.out.println("-----------------");
			// System.out.println("Update KaKampong Chhnang to Kampong Speu");
			// kch.setShortName("KAM");
			// kch.setName("Kampong Speu");
			// System.out.println("Update to " + kch.toString() + " is " + retStr(remoteStudent.update(kch)));

      // findAll
			System.out.println("-----------------");
			System.out.println("List all Students");
			allStudents = remoteStudent.findAll();
			for(Student student: allStudents){
				System.out.println(student.toString());
			}

      // findBYName
      System.out.println("-----------------");
			System.out.println("List students filtered by name: seng");
			studentsFilteredByName = remoteStudent.findByName("seng");
			for(Student student : studentsFilteredByName){
				System.out.println(student.toString());
			}

      // findBYCourse
      System.out.println("-----------------");
			System.out.println("List students filtered by course: CG");
			studentsFilteredByCourse = remoteStudent.findByCourse("cg");
			for(Student student : studentsFilteredByCourse){
				System.out.println(student.toString());
			}

      // findById
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