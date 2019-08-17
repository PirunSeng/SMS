import java.rmi.Naming;
import java.util.ArrayList;

public class StudentClient{
	public static void main(String[] args){
		try{
			IRemoteStudent remoteStudent = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			ArrayList<Student> arrStudents;
			//Clear records
			// System.out.println("Number of Students deleted = " + remoteStudent.deleteAll());

			//Save Student
			// Student prov = new Student();
			// prov.setName("Phalla Chab");
			// prov.setDateOfBirth("1995-01-01");
			// prov.setCourse("Net");

			// int iRet = remoteStudent.save(prov);
			// System.out.println("Save " + prov.toString() + " is " + retStr(iRet));
			
			// Student bat = new Student("PIRUN", "JAVA");
			// System.out.println("Save " + bat.toString() + " is " + retStr(remoteStudent.save(bat)));
			
			// System.out.println("-----------------");
			// System.out.println("Find by name composed of Kam");

      // findBYName
			// ArrayList<Student> arrStudents = remoteStudent.findByName("Kam");
			// for(Student p : arrStudents){
			// 	System.out.println(p.toString());
			// }

			//Update Kampong Chhnang to Kampong Speu
			// System.out.println("-----------------");
			// System.out.println("Update KaKampong Chhnang to Kampong Speu");
			// kch.setShortName("KAM");
			// kch.setName("Kampong Speu");
			// System.out.println("Update to " + kch.toString() + " is " + retStr(remoteStudent.update(kch)));

			System.out.println("-----------------");
			System.out.println("List all Students");
			arrStudents = remoteStudent.findAll();
			for(Student student: arrStudents){
				System.out.println(student.toString());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static String retStr(int iRet){
		return iRet!=0?"Sucessful":"Failed";
	}
}