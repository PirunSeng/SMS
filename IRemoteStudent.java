import java.rmi.*;
import java.util.ArrayList;

public interface IRemoteStudent extends Remote{
	public int save(Student p) throws RemoteException;
	public int update(Student p, int id) throws RemoteException;
  public int delete(int id) throws RemoteException;
	public ArrayList<Student> findAll() throws RemoteException;
	public Student findById(int id) throws RemoteException;
	public ArrayList<Student> findByName(String criteria) throws RemoteException;
	public ArrayList<Student> findByCourse(String criteria) throws RemoteException;
}