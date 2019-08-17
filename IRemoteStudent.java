import java.rmi.*;
import java.util.ArrayList;

public interface IRemoteStudent extends Remote{
	public int save(Student p) throws RemoteException;
	public int update(Student p) throws RemoteException;
	public ArrayList<Student> findAll() throws RemoteException;
	public ArrayList<Student> findByName(String criteria) throws RemoteException;
	public int deleteAll() throws RemoteException;
}