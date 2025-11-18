package gpa.model;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private static CourseManager instance;
    private List<Course> courses = new ArrayList<>();
    private double requiredCredits = 15;  // set your desired total credits

    public static CourseManager getInstance() {
        if (instance == null)
            instance = new CourseManager();
        return instance;
    }

    public void add(Course c) {
        courses.add(c);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getTotalCredits() {
        return courses.stream().mapToDouble(Course::getCredit).sum();
    }

    public boolean reachedRequiredCredits() {
        return getTotalCredits() >= requiredCredits;
    }

    public double calculateGPA() {
        double t = 0;
        double c = 0;

        for (Course course : courses) {
            t += course.getCredit() * course.getGradePoint();
            c += course.getCredit();
        }
        return t / c;
    }
}
