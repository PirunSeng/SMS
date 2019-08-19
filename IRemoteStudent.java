import java.rmi.*;
import java.util.ArrayList;

public interface IRemoteStudent extends Remote{
	public boolean save(Student s) throws RemoteException;
	public boolean update(Student s) throws RemoteException;
  public boolean delete(int id) throws RemoteException;
	public Student findById(int id) throws RemoteException;
	public ArrayList<Student> findAll() throws RemoteException;
	public ArrayList<Student> findByName(String criteria) throws RemoteException;
	public ArrayList<Student> findByCourse(String criteria) throws RemoteException;
}