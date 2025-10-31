package student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StudentMain {

    public static void main(String[] args) {

        String English = "Английский язык";
        String math = "Математика";
        String physics = "Физика";
        Set<Student> students = new HashSet<>();

        HashMap<String, Integer> grades1 = new HashMap<>();
        grades1.put(math, 2);
        grades1.put(English, 2);
        grades1.put(physics, 2);

        students.add(new Student("Иванов Иван Иванович", "1.1 Математика", 1, grades1));

        HashMap<String, Integer> grades2 = new HashMap<>();
        grades2.put(math, 3);
        grades2.put(English, 3);
        grades2.put(physics, 3);

        students.add(new Student("Петров Петр Петрович", "1.1 Математика", 2, grades2));

        HashMap<String, Integer> grades3 = new HashMap<>();
        grades3.put(math, 2);
        grades3.put(English, 3);
        grades3.put(physics, 3);

        students.add(new Student("Галкин Максим Сергеевич", "1.1 Математика", 2, grades3));

        HashMap<String, Integer> grades4 = new HashMap<>();
        grades4.put(math, 5);
        grades4.put(English, 5);
        grades4.put(physics, 5);

        students.add(new Student("Киркоров Филипп Андреевич", "1.1 Математика", 3, grades4));

        HashMap<String, Integer> grades5 = new HashMap<>();
        grades5.put(math, 4);
        grades5.put(English, 4);
        grades5.put(physics, 5);

        students.add(new Student("Билан Дмитрий Васильевич", "1.1 Математика", 3, grades5));

        StudentManager studentManager = new StudentManager(students);

        printStudents(students, 2);

        System.out.println();
        studentManager.increaseCourse();

        System.out.println();
        studentManager.expelStudent();
    }

    public static void printStudents(Set<Student> students, int course) {
        if (course < 1) throw new IllegalArgumentException("course must be >= 1");
        System.out.println("Студенты " + course + " курса:");
        for (Student stud : students) {
            if (stud.getCourse() == course) {
                System.out.println(stud.getName());
            }
        }
    }
}
