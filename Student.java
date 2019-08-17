import java.util.*;
import java.io.*;

public class Student implements Serializable{
	private int id_;
	private String shortName_;
	private String name_;
	
	public Student(){
	}
	
	public Student(int id, String shortName, String name){
		id_ = id;
		shortName_ = shortName;
		name_ = name;
	}
	
	public int getId(){ return id_;}
	public void setId(int id) { id_ = id;}
	
	public String getShortName() { return shortName_;}
	public void setShortName(String shortName) { shortName_ = shortName;}
	
	public String getName() { return name_;}
	public void setName(String name) { name_ = name;}

	public String toString(){
		return id_ + " - " + shortName_ + " - " + name_;
	}
}