package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Verify {

		public void first() {
			
			System.out.println("---First---");
			
			HashMap<String, Object> sub1=new HashMap<>();
			sub1.put("Tamil", 68);
			
			HashMap<String, Object> sub2=new HashMap<>();
			sub2.put("English",90);
			
			HashMap<String, Object> sub3=new HashMap<>();
			sub3.put("Maths", 85);

			
			ArrayList<HashMap<String,Object>> mark=new ArrayList<>();
			mark.add(sub1);
			mark.add(sub2);
			mark.add(sub3);
			
			LinkedHashMap<String, Object> stu=new LinkedHashMap<>();
			stu.put("Name", "Kishore");
			stu.put("Gender", "Male");
			stu.put("marks", mark);
			
		//	System.out.println(stu);
			
		//	System.out.println(stu.get("marks"));
			List<HashMap<String,Object>> stud=(List<HashMap<String, Object>>) stu.get("marks");
			System.out.println(stud);
			System.out.println("Tamil: "+stud.get(0));

			System.out.println("Tamil: "+stud.get(0).get("Tamil"));
			
			/*
			{
				 name:"",
				 gender:"",
				 marks:[
				    {tamil=70 }, {},{},{}
				  ]
				}
			*/
			
		}
		
		public void second() {
			
			System.out.println("---Second---");
			
			HashMap<String,Object> sem1=new HashMap<>();
			sem1.put("Physics","77");
			sem1.put("Biology", "87");
			sem1.put("Chemistry", "78");
			HashMap<String,Object> sem2=new HashMap<>();
			sem2.put("Physics", "78");
			sem2.put("Biology", "80");
			sem2.put("Chemistry", "68");
			HashMap<String,Object> sem3=new HashMap<>();
			sem3.put("Physics", "90");
			sem3.put("Biology", "95");
			sem3.put("Chemistry", "79");
			
			HashMap<String,Object> seme1=new HashMap<>();
			seme1.put("sem1", sem1);
			HashMap<String,Object> seme2=new HashMap<>();
			seme2.put("sem2", sem2);
			HashMap<String,Object> seme3=new HashMap<>();
			seme3.put("sem3", sem3);

			ArrayList<HashMap<String,Object>> mark= new ArrayList<>();
			mark.add(seme1);
			mark.add(seme2);
			mark.add(seme3);
			
			HashMap<String,Object> stu=new HashMap<>();
			stu.put("name", "Gokul");
			stu.put("Gender", "Male");
			stu.put("marks", mark);
			
			List<HashMap<String,Object>> stud=(List<HashMap<String, Object>>) stu.get("marks");
			HashMap<String,Object> markOfStu=(HashMap<String, Object>) stud.get(0).get("sem1"); 
			System.out.println("Physics: "+markOfStu.get("Physics")); //7
			
		}
		
		public void third() {
			
			System.out.println("---Third---");
			
			HashMap<String,Object> sem1=new HashMap<>();
			sem1.put("Physics","61");
			sem1.put("Biology", "71");
			sem1.put("Chemistry", "65");
			HashMap<String,Object> sem2=new HashMap<>();
			sem2.put("Physics", "62");
			sem2.put("Biology", "72");
			sem2.put("Chemistry", "82");
			HashMap<String,Object> sem3=new HashMap<>();
			sem3.put("Physics", "73");
			sem3.put("Biology", "83");
			sem3.put("Chemistry", "80");
			
			HashMap<String,Object> mark=new HashMap<>();
			mark.put("sem1", sem1);
			HashMap<String,Object> semB=new HashMap<>();
			mark.put("sem2", sem2);
			HashMap<String,Object> semC=new HashMap<>();
			mark.put("sem3", sem3);

		
			
			HashMap<String,Object> stu=new HashMap<>();
			stu.put("name", "Kumar");
			stu.put("Gender", "Male");
			stu.put("marks", mark);
			
			HashMap<String,Object> stud=(HashMap<String, Object>) stu.get("marks");
			HashMap<String,Object> markOfStu=(HashMap<String, Object>) stud.get("sem3"); 
			System.out.println("Physics: "+markOfStu.get("Physics")); //33
		}

		public void fourth() {

			
			System.out.println("---Fourth---");
			
			HashMap<String,Object> sem1=new HashMap<>();
			sem1.put("Physics","51");
			sem1.put("Biology", "61");
			sem1.put("Chemistry", "72");
			HashMap<String,Object> sem2=new HashMap<>();
			sem2.put("Physics", "82");
			sem2.put("Biology", "72");
			sem2.put("Chemistry", "60");
			HashMap<String,Object> sem3=new HashMap<>();
			sem3.put("Physics", "83");
			sem3.put("Biology", "73");
			sem3.put("Chemistry", "80");
			
			HashMap<String,Object> mark=new HashMap<>();
			mark.put("sem1", sem1);
			HashMap<String,Object> semB=new HashMap<>();
			mark.put("sem2", sem2);
			HashMap<String,Object> semC=new HashMap<>();
			mark.put("sem3", sem3);

		
			
			HashMap<String,Object> stu=new HashMap<>();
			stu.put("name", "Loga");
			stu.put("Gender", "Female");
			stu.put("marks", mark);
			
			HashMap<String,Object> stud=(HashMap<String, Object>) stu.get("marks");
			HashMap<String,Object> markOfStu=(HashMap<String, Object>) stud.get("sem3"); 
			System.out.println("Physics: "+markOfStu.get("Physics")); //33
		}
		
		public static void main(String[] args) {

			Verify solve=new Verify();
			solve.first();
			solve.second();
			solve.third();
			solve.fourth();
			
		//	HashMap<String,Object> stud=(HashMap<String, Object>) stu.get(marks);
		//	System.out.println(stud);
		//	List<HashMap<String,Object>> marksOfStu=(List<HashMap<String,Object>>) 
			
			//List<HashMap<String,Object>> b= (List<HashMap<String, Object>>) a.get("marks");

			//System.out.println(((HashMap<String, Object>) stu.get("marks")).get(1)); //->getting error
			
			

			//System.out.println("Raja->Tamil:"+((HashMap<String, Object>) stu.get("marks")).get(0));
		}

	}


