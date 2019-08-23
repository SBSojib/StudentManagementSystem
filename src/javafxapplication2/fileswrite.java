package javafxapplication2;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.System;


public class fileswrite{


	 
	
	FileWriter fw ;
	PrintWriter pw;


	//private  Formatter x;

	public fileswrite(String filername,boolean save){
		try{
			fw = new FileWriter(filername,save);
			pw = new PrintWriter(fw);
		}
		catch(Exception e){

		}
	}

	
	public void writeStudent(Student student){
		pw.printf("%s %s %s %s %s %s %s %s %s %s %s %s\n",student.getID(),student.getPassword(),
			student.getFullName(), student.getFatherName(),student.getMotherName(),
			student.getYear(), student.getSemester(),student.getDepartment(),
			student.getPhoneNumber(),student.getEmail(),
			student.getAddress(),student.getResult());
	}




	public void writeTeacher(Teacher teacher){

		pw.printf("%s %s %s %s %s %s\n",teacher.getID(),teacher.getPassword(),
			teacher.getFullName(),teacher.getDepartment(),
			teacher.getPhoneNumber(),teacher.getEmail());

	}

	
	public void writeFile(List<String> list){
		
		for(int i =0;i < list.size();i++){
			pw.println(list.get(i));
		}
	}


        public void writeID(String ID){
            pw.println(ID);
        }
	
	public void closeFile(){
		pw.close();
	}
}
