import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentClient{
	public static void main(String[] args){
    Scanner kbd;		//Read from keyboad
		String cmd;			//User's command: add, search, searchall, quit
    String strName, strDateOfBirth, strCourse;

		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> allStudents, studentsFilteredByName, studentsFilteredByCourse;

			kbd = new Scanner(System.in);
      while(true){
				System.out.println("Enter your choice : ");
				System.out.print("1-Save | 2-Update | 3-Delete | 4-FindAll | 5-FindById | 6-FindByName | 7-FindByCourse | 0-Quit  : ");
				cmd = kbd.nextLine();

        // Perform save command
        if(cmd.equals("1")){
          Student std = new Student();
          System.out.print("Enter Name : ");
          std.setName(kbd.nextLine());
          System.out.print("Enter Date of Birth : ");
          std.setDateOfBirth(kbd.nextLine());
          System.out.print("Enter Course : ");
          std.setCourse(kbd.nextLine());
          boolean bAns = remoteStudent.save(std);
          if(bAns){
            System.out.println("\t Successfully create a student");
          }else{
            System.out.println("Error while creating student");
          }
        } else if (cmd.equals("2")) {
          // update
          System.out.print("Enter Id : ");
          int stdId = Integer.parseInt(kbd.nextLine());
          // String stdId = kbd.nextLine();
          Student std = new Student();
          System.out.print("Enter Name : ");
          std.setName(kbd.nextLine());
          System.out.print("Enter Date of Birth : ");
          std.setDateOfBirth(kbd.nextLine());
          System.out.print("Enter Course : ");
          std.setCourse(kbd.nextLine());
          boolean bAns = remoteStudent.update(std, stdId);
          if(bAns){
            System.out.println("\t Successfully update the student");
          }else{
            System.out.println("Error while updating student");
          }
        } else if (cmd.equals("3")) {
          // delete
          System.out.print("Enter Id : ");
          int sid = Integer.parseInt(kbd.nextLine());
          boolean bAns = remoteStudent.delete(sid);
          if(bAns){
            System.out.println("\t Successfully delete the student");
          }else{
            System.out.println("Error while deleting student");
          }
        } else if (cmd.equals("4")) {
          // findAll
          allStudents = remoteStudent.findAll();
          System.out.println("List all " + allStudents.size() + " students:");
          for(Student student: allStudents){
            System.out.println(student.toString());
          }
        } else if (cmd.equals("5")) {
          // findById
        } else if (cmd.equals("6")) {
          // findByName
        } else if (cmd.equals("7")) {
          // findByCourse
        }
        else if(cmd.equals("0")){
					break;
				}else{
					continue;
				}
      }
      

      /*
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
      */
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static String retStr(int iRet){
		return iRet!=0?"Sucessful":"Failed";
	}
}