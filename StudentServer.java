import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.rmi.*;
import java.util.ArrayList;

public class StudentServer extends UnicastRemoteObject
					implements IRemoteStudent{
	
	private static final long serialVersionUID = 1L;

  public StudentServer() throws RemoteException {
		super();
	}
	
	// public int save(Student p){
	// 	return StudentRepository.save(p);
	// }
	
	// public int update(Student p){
	// 	return StudentRepository.update(p);
	// } 
	
	public ArrayList<Student> findAll(){
		return StudentRepository.findAll();
	}

  // public Student findById(int id){
	// 	return StudentRepository.findById(id);
	// }

  // public int delete(int id){
	// 	return StudentRepository.findById(id);
	// }
	
	// public ArrayList<Student> findByName(String criteria){
	// 	return StudentRepository.findByName(criteria);
	// }

  // public ArrayList<Student> findByCourse(String criteria){
	// 	return StudentRepository.findByCourse(criteria);
	// }
	
	public static void main(String[] args){
		try{
			LocateRegistry.createRegistry(1099);
			StudentServer ps = new StudentServer();
			Naming.rebind("StudentServer", ps);
			System.out.println("StudentServer is created!!!");
		}catch(Exception e){
			System.out.println(e);
		}

	}
}