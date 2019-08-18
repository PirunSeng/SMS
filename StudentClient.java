import java.rmi.Naming;
import java.util.ArrayList;

public class StudentClient{
	public static void main(String[] args){
		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> allStudents, studentsFilteredByName, studentsFilteredByCourse;

			// Save, works
      System.out.println("-----------------");
			System.out.println("Create new student");
			Student newStd = new Student();
			newStd.setName("John Doe");
			newStd.setDateOfBirth("2000-01-01");
			newStd.setCourse("NET");
			int iRet = remoteStudent.save(newStd);
			System.out.println("Save " + newStd.previewString() + " is " + retStr(iRet));

			// Update, works
			System.out.println("-----------------");
			System.out.println("Update student with id = 1");
      int id = 1;
			Student updatedStd = new Student();
			updatedStd.setName("NICO");
			updatedStd.setDateOfBirth("1888-08-08");
			updatedStd.setCourse("DS");
			System.out.println("Update to student with id = " + id + " " + updatedStd.previewString() + " is " + retStr(remoteStudent.update(updatedStd, id)));

      // Delete, works
      System.out.println("-----------------");
      System.out.println("Delete student with id = 3");
      int sid = 3;
      System.out.println("Delete student is " + retStr(remoteStudent.delete(sid)));

      // findAll, works
			System.out.println("-----------------");
			System.out.println("List all Students");
			allStudents = remoteStudent.findAll();
			for(Student student: allStudents){
				System.out.println(student.toString());
			}

      // findBYName, works
      System.out.println("-----------------");
      String nameCriteria = "john";
			System.out.println("List students filtered by name: " + nameCriteria);
			studentsFilteredByName = remoteStudent.findByName(nameCriteria);
			for(Student student : studentsFilteredByName){
				System.out.println(student.toString());
			}

      // findBYCourse, works
      System.out.println("-----------------");
      String courseCriteria = "NET";
			System.out.println("List students filtered by course: " + courseCriteria);
			studentsFilteredByCourse = remoteStudent.findByCourse(courseCriteria);
			for(Student student : studentsFilteredByCourse){
				System.out.println(student.toString());
			}

      // findById, works
      System.out.println("-----------------");
      int stdId = 1;
      System.out.println("Find student by id = " + stdId);
      Student student = remoteStudent.findById(stdId);
      System.out.println(student.toString());
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static String retStr(int iRet){
		return iRet!=0?"Sucessful":"Failed";
	}
}