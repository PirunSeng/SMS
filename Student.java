import java.util.*;
import java.io.*;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name_;
	private String dateOfBirth_;
	private String course_;
  private int id_;
	
	public Student(){
	}
	
	public Student(int id, String name, String dateOfBirth, String course){
    id_ = id;
		name_ = name;
    dateOfBirth_ = dateOfBirth;
    course_ = course;
	}

  public int getId() { return id_; }
  public void setId(int id) { id_ = id;}
	
	public String getName() { return name_;}
	public void setName(String name) { name_ = name;}

  public String getDateOfBirth() { return dateOfBirth_;}
	public void setDateOfBirth(String dateOfBirth) { dateOfBirth_ = dateOfBirth;}

  public String getCourse() { return course_;}
	public void setCourse(String course) { course_ = course;}

	public String toString(){
		return name_ + " - " + dateOfBirth_ + " - " + course_;
	}
}