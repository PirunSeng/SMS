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

  // public int save(Student std){
  public boolean save(Student std){
		return StudentRepository.save(std);
	}
	
	// public int update(Student std, int stdId){
	public boolean update(Student std, int stdId){
		return StudentRepository.update(std, stdId);
	}
	
	public ArrayList<Student> findAll(){
		return StudentRepository.findAll();
	}

  public Student findById(int id){
		return StudentRepository.findById(id);
	}

  // public int delete(int id){
  public boolean delete(int id){
		return StudentRepository.delete(id);
	}
	
	public ArrayList<Student> findByName(String criteria){
		return StudentRepository.findByName(criteria);
	}

  public ArrayList<Student> findByCourse(String criteria){
		return StudentRepository.findByCourse(criteria);
	}
	
	public static void main(String[] args){
		try{
			LocateRegistry.createRegistry(1099);
			StudentServer ss = new StudentServer();
			Naming.rebind("StudentServer", ss);
			System.out.println("StudentServer is created!!!");
		}catch(Exception e){
			System.out.println(e);
		}

	}
}