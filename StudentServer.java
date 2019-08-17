import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.rmi.*;
import java.util.ArrayList;

public class StudentServer extends UnicastRemoteObject
					implements IRemoteStudent{
	
	public StudentServer() throws RemoteException{
		super();
	}
	
	public int save(Student p){
		return StudentRepository.save(p);
	}
	
	public int update(Student p){
		return StudentRepository.update(p);
	} 
	
	public ArrayList<Student> findAll(){
		return StudentRepository.findAll();
	}
	
	public ArrayList<Student> findByName(String criteria){
		return StudentRepository.findByName(criteria);
	}

	public int deleteAll(){
		return StudentRepository.deleteAll();
	}
	
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