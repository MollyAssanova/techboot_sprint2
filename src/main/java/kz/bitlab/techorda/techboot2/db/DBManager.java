package kz.bitlab.techorda.techboot2.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Student> students=new ArrayList<>();
    private static Long id=5L;

    static{
        students.add(new Student(1L,"Moldir","Asanova", 96, "A"));
        students.add(new Student(2L,"Madi","Bek", 92, "B"));
        students.add(new Student(3L,"Saule","Sezim", 82, "C"));
        students.add(new Student(4L,"Usen","Asan", 20, "C"));

    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudents(Student student){
        student.setId(id);
        id++;
        students.add(student);
    }
    public static Student getStudent(int id){
        return students.stream().filter(student -> student.getId()==id).findFirst().orElse(null);
    }

}
