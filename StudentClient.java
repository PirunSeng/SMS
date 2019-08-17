import java.rmi.Naming;
import java.util.ArrayList;

public class StudentClient{
	public static void main(String[] args){
		try{
			IRemoteStudent rp = (IRemoteStudent)Naming.lookup("rmi://127.0.0.1/StudentServer");
			
			//Clear records
			System.out.println("Number of Students deleted = " + rp.deleteAll());

			//Save Student
			Student prov = new Student();
			prov.setId(6);
			prov.setShortName("KPT");
			prov.setName("Kampong Thom");

			int iRet = rp.save(prov);
			System.out.println("Save " +prov.toString() + " is " + retStr(iRet));
			
			Student bat = new Student(1, "BAT", "Battambang");
			System.out.println("Save " + bat.toString() + " is " + retStr(rp.save(bat)));
			
			//KCH
			Student kch = new Student(4, "KCH", "Kampong Chhnang");
			System.out.println("Save " + kch.toString() + " is " + retStr(rp.save(kch)));
			
			System.out.println("-----------------");
			System.out.println("Find by name composed of Kam");
			ArrayList<Student> arrProv = rp.findByName("Kam");
			for(Student p : arrProv){
				System.out.println(p.toString());
			}

			//Update Kampong Chhnang to Kampong Speu
			System.out.println("-----------------");
			System.out.println("Update KaKampong Chhnang to Kampong Speu");
			kch.setShortName("KAM");
			kch.setName("Kampong Speu");
			System.out.println("Update to " + kch.toString() + " is " + retStr(rp.update(kch)));

			System.out.println("-----------------");
			System.out.println("List all Students");
			arrProv = rp.findAll();
			for(Student p: arrProv){
				System.out.println(p.toString());
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private static String retStr(int iRet){
		return iRet!=0?"Sucessful":"Failed";
	}
}