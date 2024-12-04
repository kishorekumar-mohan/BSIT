package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Pratice {

    public static void main(String[] args) {
        HashMap<String, Object> Details1 = new LinkedHashMap<>();
        Details1.put("name", "Kishore Kumar");
        Details1.put("gender", "Male");

        HashMap<String, Object> Details2 = new LinkedHashMap<>();
        Details2.put("name", "Gokul");
        Details2.put("gender", "Male");

        // Kishore's semesters
        ArrayList<HashMap<String, Object>> sem_1 = new ArrayList<>();
        HashMap<String, Object> sem1 = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sem1Subject = new ArrayList<>();
        HashMap<String, Integer> sem1Marks = new LinkedHashMap<>();
        sem1Marks.put("Tamil", 83);
        sem1Marks.put("English", 73);
        sem1Marks.put("Maths", 65);
        sem1Marks.put("Science", 89);
        sem1Marks.put("Social Science", 91);
        sem1Subject.add(sem1Marks);
        sem1.put("Semester1", sem1Subject);
        sem_1.add(sem1);

        HashMap<String, Object> sem2 = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sem2Subs = new ArrayList<>();
        HashMap<String, Integer> sem2Marks = new LinkedHashMap<>();
        sem2Marks.put("Tamil", 80);
        sem2Marks.put("English", 78);
        sem2Marks.put("Maths", 70);
        sem2Marks.put("Science", 75);
        sem2Marks.put("Social Science", 95);
        sem2Subs.add(sem2Marks);
        sem2.put("Semester2", sem2Subs);
        sem_1.add(sem2);

        Details1.put("marks", sem_1);

        // Gokul's semesters
        ArrayList<HashMap<String, Object>> sem_12 = new ArrayList<>();
        HashMap<String, Object> sem12 = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sem1Subject2 = new ArrayList<>();
        HashMap<String, Integer> sem1Marks2 = new LinkedHashMap<>();
        sem1Marks2.put("Tamil", 85);
        sem1Marks2.put("English", 75);
        sem1Marks2.put("Maths", 60);
        sem1Marks2.put("Science", 80);
        sem1Marks2.put("Social Science", 75);
        sem1Subject2.add(sem1Marks2);
        sem12.put("Semester1", sem1Subject2);
        sem_12.add(sem12);

        HashMap<String, Object> sem22 = new HashMap<>();
        ArrayList<HashMap<String, Integer>> sem2Subs2 = new ArrayList<>();
        HashMap<String, Integer> sem2Marks2 = new LinkedHashMap<>();
        sem2Marks2.put("Tamil", 69);
        sem2Marks2.put("English", 75);
        sem2Marks2.put("Maths", 76);
        sem2Marks2.put("Science", 70);
        sem2Marks2.put("Social Science", 65);
        sem2Subs2.add(sem2Marks2);
        sem22.put("Semester2", sem2Subs2);
        sem_12.add(sem22);

        Details2.put("marks", sem_12);

       
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();
        students.add(Details1);
        students.add(Details2);

        
//        HashMap<String, Object> stud = students.get(1); // Get the first student's data
//        String name = (String) stud.get("name");
//        System.out.println(name);
//        System.out.println("");
        
        HashMap<String, Object> msd = students.get(1);
        List<HashMap<String, Object>> dhoni = (List<HashMap<String, Object>>) msd.get("marks");
        HashMap<String, Object> vijay = dhoni.get(0); 
        List<HashMap<String, Integer>> thala = (List<HashMap<String, Integer>>) vijay.get("Semester1");
        HashMap<String, Integer> yellow = thala.get(0);

        System.out.println(yellow.get("Science"));
        
        
        
//        HashMap<String, Object> Students = new LinkedHashMap<>();
//		Students.put("Students", students);
//        System.out.println(Students);
    }
}
