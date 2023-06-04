import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.collectionsproject.Student;

public class App {
    public static void main(String[] args) throws Exception {
        

        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        Student studentOne = new Student("Jason", 2001);

        List<List<String>> courses = new ArrayList<>();
        courses.add(Arrays.asList("Math", "Science", "History"));
        courses.add(Arrays.asList("English", "Science", "Art"));
        courses.add(Arrays.asList("Math", "History", "Geography"));


        Student studentTwo = new Student("Ava", 2002);


        Student lastStudent = new Student("Mike", 2003);




        studentMap.put(studentOne.getId(), studentOne);
        studentMap.put(studentTwo.getId(), studentTwo);
        studentMap.put(lastStudent.getId(), lastStudent);

        Integer i = 0;
        for (Student student: studentMap.values()) {
            ArrayList<String> studentCourses = new ArrayList<>(courses.get(i));
            student.setCourses(studentCourses);
            i++;
        }

        System.out.println("Step 5: Print student information ");
        System.out.println();
        for (Student student: studentMap.values()) {
            System.out.println(String.format("Name: %s ID: %d Courses: %s", student.getName(), student.getId(), student.getCourses()));
        }
        ArrayList<String> allCourses = new ArrayList<>();


        for (Student student: studentMap.values()) {
            allCourses.addAll(student.getCourses());
        }
        
        HashSet<String> set = new HashSet<>(allCourses);
        ArrayList<String> uniqueCourses = new ArrayList<String>(set);
        System.out.println();

        System.out.println("Step 8: Print unique courses\n");


        System.out.println("Unique Courses: " + String.join(", ", uniqueCourses));

        Map<String, List<String>> courseMap = new HashMap<String, List<String>>();

            for (Student student: studentMap.values()) {
                ArrayList<String> studentCourses = student.getCourses();
                for (String studentCourse: studentCourses){
                    List<String> students = courseMap.getOrDefault(studentCourse, new ArrayList<>());
                    students.add(student.getName());
                    courseMap.put(studentCourse, students);
                }
            }
            System.out.println();
            System.out.println("Step 10: Print students by course Students by Course\n");
            for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
                String course = entry.getKey();
                List<String> students = entry.getValue();
                System.out.println(course + ": " + students);
            }
            System.out.println("Step 11: Print students whose name starts with //the letter \"J\" \n");
            System.out.println();

            System.out.println("Students with J Names:\n");
            for (Student student: studentMap.values()) {
                char sName = student.getName().charAt(0);
                if (sName == 'j' || sName == 'J'){
                    
                    System.out.println(student.getName());
                }
            }

    }
}
