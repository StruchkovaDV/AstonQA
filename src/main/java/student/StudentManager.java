package student;

import java.util.HashSet;
import java.util.Set;

public class StudentManager {

    private Set<Student> students;

    public StudentManager(Set<Student> students) {
        this.students = students;
    }

    public void expelStudent(){
        Set<Student> expelStudents = new HashSet<>();
        for (Student stud: students){
            if(stud.getAvgGrade() < 3){
                System.out.println("Студент " + stud.getName() + " исключен. Средний бал: " + stud.getAvgGrade());
                expelStudents.add(stud);
            }
        }
        students.removeAll(expelStudents);
    }

    public void increaseCourse(){
        for (Student stud: students){
            if(stud.getAvgGrade() >= 3){
                System.out.println("Студент " + stud.getName() + " переведен на следующий курс. Средний бал: " + stud.getAvgGrade());
                stud.setCourse(stud.getCourse() + 1);
            }
        }
    }
}
