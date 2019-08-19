import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentClient{
	public static void main(String[] args){
    Scanner kbd; // Read from keyboad
		String cmd; // User's command: add, search, searchall, quit

		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> allStudents, studentsFilteredByName, studentsFilteredByCourse;

			kbd = new Scanner(System.in);
      while(true){
			  System.out.println("-----------------");
				System.out.println("Enter your choice : ");
				System.out.print("1-Save | 2-Update | 3-Delete | 4-FindAll | 5-FindById | 6-FindByName | 7-FindByCourse | 0-Quit  : ");
				cmd = kbd.nextLine();

        if(cmd.equals("1")){
          // save
          Student std = new Student();
          System.out.print("Enter Name : ");
          std.setName(kbd.nextLine());
          System.out.print("Enter Date of Birth : ");
          std.setDateOfBirth(kbd.nextLine());
          System.out.print("Enter Course : ");
          std.setCourse(kbd.nextLine());
          boolean bAns = remoteStudent.save(std);
          if(bAns){
            System.out.println("Successfully create student!");
            System.out.println(std.previewString());
          }else{
            System.out.println("Error while creating student!");
          }

        } else if (cmd.equals("2")) {
          // update
          Student std = new Student();
          System.out.print("Enter Id : ");
          String stdId;
          while(true){
            stdId = kbd.nextLine();
            if (stdId.trim().isEmpty()) {
              System.out.println("Please try again!");
              System.out.print("Enter Id : ");
            } else {
              break;
            }
          }
          int sid = Integer.parseInt(stdId);
          std = remoteStudent.findById(sid);
          if(studentExist(std)) {
            std.setId(sid);
            System.out.print("Enter Name : ");
            std.setName(kbd.nextLine());
            System.out.print("Enter Date of Birth : ");
            std.setDateOfBirth(kbd.nextLine());
            System.out.print("Enter Course : ");
            std.setCourse(kbd.nextLine());
            boolean bAns = remoteStudent.update(std);
            if(bAns){
              System.out.println("Successfully update the student!");
              System.out.println(std.toString());
            }else{
              System.out.println("Error while updating student!");
            }
          } else {
            System.out.println("Not found!");
          }

        } else if (cmd.equals("3")) {
          // delete
          System.out.print("Enter Id : ");
          int sid = Integer.parseInt(kbd.nextLine());
          Student std = remoteStudent.findById(sid);
          if(studentExist(std)) {
            boolean bAns = remoteStudent.delete(sid);
            if(bAns){
              System.out.println("Successfully deleted the student!");
            }else{
              System.out.println("Error while deleting student!");
            }
          } else {
            System.out.println("Not found!");
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
          System.out.print("Enter Id : ");
          int stdId       = Integer.parseInt(kbd.nextLine());
          Student student = remoteStudent.findById(stdId);
          if(studentExist(student)) {
            System.out.println(student.toString());
          } else {
            System.out.println("Not found!");
          }

        } else if (cmd.equals("6")) {
          // findByName
          System.out.print("Enter Name : ");
          String nameCriteria    = kbd.nextLine();
          System.out.println("List students filtered by name: " + nameCriteria);
          studentsFilteredByName = remoteStudent.findByName(nameCriteria);
          for(Student student : studentsFilteredByName){
            if (student.getId() == 0){
              System.out.println("Not found!");
            } else {
              System.out.println(student.toString());
            }
          }

        } else if (cmd.equals("7")) {
          // findByCourse
          System.out.print("Enter Course : ");
          String courseCriteria    = kbd.nextLine();
          System.out.println("List students filtered by course: " + courseCriteria);
          studentsFilteredByCourse = remoteStudent.findByCourse(courseCriteria);
          for(Student student : studentsFilteredByCourse){
            System.out.println(student.toString());
          }

        } else if(cmd.equals("0")){
					break;

				} else{
					continue;
				}
      }
		}catch(Exception e){
			System.out.println(e);
		}
	}

  private static boolean studentExist(Student student) {
    return student.getId() != 0;
  }
}
