package student;

import java.util.Map;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> subjectGrades;

    public Student(String name, String group, int course, Map<String, Integer> subjectGrades) {
        this.name = name;
        this.group = group;
        if (course < 1) throw new IllegalArgumentException("Курс должен быть >= 1");
        this.course = course;
        this.subjectGrades = subjectGrades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade(){
        if (subjectGrades.isEmpty()) return 0.0;
        double sum = 0;
        for (Integer grade: subjectGrades.values()){
            sum += grade;
        }
        return sum/subjectGrades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student s)) return false;
        return name.equals(s.name) && group.equals(s.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
