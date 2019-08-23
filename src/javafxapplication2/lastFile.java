package javafxapplication2;

import java.io.*;
import java.util.*;
import java.lang.*;



public class lastFile{

	private String studenterfile = "StudentInformation.txt";
	private String teachererfile = "AdminInformation.txt";
        private String tmpFile;

	public lastFile(String studenterfile,String teachererfile){
		this.studenterfile = studenterfile;
		this.teachererfile = teachererfile;
	}

    public lastFile(String tmpFile) {
        this.tmpFile = tmpFile;
    }
        
    
    public void writeId(String ID){
        fileswrite fw = new fileswrite(tmpFile,false);
        fw.writeID(ID);
        
    }
    public String readID(){
                String ID="";
                filesread fr = new filesread();
		fr.openFile(tmpFile);
                ID = fr.readID();
                return ID;
    }
    
    
    
    
    
    
    
    
    
    

	public Student loginStudent(String ID,String passward){
		Student student;
		filesread fr = new filesread();
		fr.openFile(studenterfile);
		if(fr.IsStudent(ID,passward)){
			student = fr.getStudent();
		}
		else{
			student = new Student("0","0","0","0","0","0","0","0","0","0","0","0");
		}
		fr.closeFile();
		return student;
	
	}

	public Teacher loginTeacher(String ID,String passward){
		Teacher teacher;
		filesread fr = new filesread();
		fr.openFile(teachererfile);
		if(fr.IsTeacher(ID,passward)){
			teacher = fr.getTeacher();
		}
		else{
			teacher = new Teacher("0","0","0","0","0","0");
		}
		fr.closeFile();
		return teacher;
	
	
	}
	//done
	public void signUp(Teacher teacher){
		fileswrite fw = new fileswrite(teachererfile,true);
		fw.writeTeacher(teacher);
		fw.closeFile();
	
	}
	//done
	public void add(Student student){
		fileswrite fw = new fileswrite(studenterfile,true);
		fw.writeStudent(student);
		fw.closeFile();
	
	}


	// Done
	public void edit(String ID, Student student){
		String newInfo;
		newInfo = student.getID()+" "+student.getPassword()+" "+student.getFullName()+" "+
		 	 student.getFatherName()+" "+student.getMotherName()+" "+student.getYear()+" "+
		 	 student.getSemester()+" "+student.getDepartment()+" "+student.getPhoneNumber()+" "+
		 	 student.getEmail()+" "+student.getAddress()+" "+student.getResult();


		List<String> list  =  new ArrayList<String>();
		filesread fr = new filesread();
		fr.openFile(studenterfile);
		list = fr.editFile(ID,newInfo);
		fr.closeFile();
		fileswrite fw = new fileswrite(studenterfile,false);
		fw.writeFile(list);
		fw.closeFile();
	
	}
	//done
	public void delete(String ID){

		List<String> list  =  new ArrayList<String>();
		filesread fr = new filesread();
		fr.openFile(studenterfile);
		list = fr.deleteFile(ID);
		fr.closeFile();
		fileswrite fw = new fileswrite(studenterfile,false);
		fw.writeFile(list);
		fw.closeFile();
	
	}
	//done
	public void changePassward(String ID,String oldPassward,String newPasssward){

		List<String> list  =  new ArrayList<String>();
		filesread fr = new filesread();
		fr.openFile(studenterfile);
		list = fr.changePassward(ID,oldPassward,newPasssward);
		fr.closeFile();
		fileswrite fw = new fileswrite(studenterfile,false);
		fw.writeFile(list);
		fw.closeFile();
	
	}

}
