package javafxapplication2;




import java.io.*;
import java.util.*;
import java.lang.*;

public class filesread {
		private Scanner x;
	
	
	
		String[] students;
		String[] teachers; 
		
		public void openFile(String filername){
				
                        try{ 
                        x = new Scanner(new File(filername));
                        }
                        catch(Exception e){
                                        System.out.println(e);
                        }
		}
		
                
                public String readID(){
                    String ID = "";
                    while(x.hasNext()){
                        ID = x.nextLine();
                    }
                    return ID;
                }
                               
		// done
		public List<String> editFile(String ID,String newinfo){
			List<String> list  =  new ArrayList<String>();
			
			int  i = 0;
				while(x.hasNext()){
					String total = x.nextLine();
					String[] spl = total.split(" "); 
					if(spl[0].equals(ID)){
							total = newinfo;
					}
				
					list.add(total);
				}
				return list;		
		}




//done
		public List<String> deleteFile(String ID){
			List<String> list  =  new ArrayList<String>();
			
			int  i = 0;
				while(x.hasNext()){
					String total = x.nextLine();
					String[] spl = total.split(" "); 
					if(!spl[0].equals(ID)){
						list.add(total);

					}
				
					
				}
				return list;		
		}








//  done
public List<String> changePassward(String ID,String oldpassward,String newpassward){
			List<String> list  =  new ArrayList<String>();
			
			int  i = 0;
				while(x.hasNext()){
					String total = x.nextLine();
					if(total.length()> 10){
						String[] spl = total.split(" "); 

						if(spl[0].equals(ID)&&spl[1].equals(oldpassward)){
							spl[1] = newpassward;
							total = spl[0]+" "+spl[1]+" "+spl[2]+" "+spl[3]+" "+spl[4]+" "+spl[5]+" "+spl[6]+" "+spl[7]+" "+spl[8]+" "+spl[9]+" "+spl[10]+" "+spl[11];
							
						}
					
						list.add(total);
					}
				}
				return list;		
		}











		public boolean IsStudent(String ID,String passward){

			while(x.hasNext()){
				String total = x.nextLine();
				String[] spl = total.split(" "); 
				if(spl[0].equals(ID) && spl[1].equals(passward)){
					students = spl;
					return true;
				}
			}

			return false;
		}



	public boolean IsTeacher(String ID,String passward){

			while(x.hasNext()){
				String total = x.nextLine();
				String[] spl = total.split(" "); 
				if(spl[0].equals(ID) && spl[1].equals(passward)){
					teachers = spl;
					return true;
				}
			}

			return false;
		}

		public Teacher getTeacher(){
			Teacher tch = new Teacher(teachers[0],teachers[1],teachers[2],teachers[3],teachers[4],teachers[5]);
			return tch;
		}

		public Student getStudent(){
			Student st = new Student(students[0],students[1],students[2],students[3],students[4],students[5],students[6],students[7],students[8],students[9],students[10],students[11]);
			return st;
		}
		







		
		public void closeFile(){
				x.close();
		}
		
		
		 
}
