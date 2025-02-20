package com.practiceproblems.javaobjecttojsonarray;
//Import the packages
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class JavaObjectToArray {
    public static void main(String[] args) {
        //Use try catch block to handle exception
        try {
            //Create student class object
            Student student1 = new Student("Kanchan", 20, Arrays.asList("Science", "English"));
            Student student2 = new Student("Prince", 25, Arrays.asList("Maths", "Java Programming"));
            Student student3 = new Student("Viraj", 20, Arrays.asList("English", "History"));
            //List to store the Student objects
            List<Student> list = new ArrayList<>();
            list.add(student1);
            list.add(student2);
            list.add(student3);

            //Mapper object for mapping
           ObjectMapper mapper = new ObjectMapper();
           String array = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

           //Print the array
            System.out.println(array);
        }catch (Exception e){
            //Print valid message
            System.out.println(e.getMessage());
        }

    }
}

//Class student to store the student details
class Student{
    //Instance variables
    private String name;
    private int age;
    private List<String> students;

    //Constructor
    public Student(String name, int age, List<String> students) {
        this.name = name;
        this.age = age;
        this.students = students;
    }

    //Getters for details
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getStudents() {
        return students;
    }
}
