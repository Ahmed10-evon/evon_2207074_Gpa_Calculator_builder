package gpa.model;

public class Course {

    private String courseName;
    private String courseCode;
    private double credit;
    private String teacher1;
    private String teacher2;
    private String grade;

    public Course(String courseName, String courseCode, double credit,
                  String teacher1, String teacher2, String grade) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credit = credit;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.grade = grade;
    }

    public double getGradePoint() {
        return switch (grade) {
            case "A+" -> 4.0;
            case "A"  -> 3.75;
            case "A-" -> 3.5;
            case "B+" -> 3.25;
            case "B"  -> 3.0;
            case "B-" -> 2.75;
            case "C+" -> 2.5;
            case "C"  -> 2.25;
            case "D"  -> 2.0;
            default   -> 0.0;
        };
    }

    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public double getCredit() { return credit; }
    public String getTeacher1() { return teacher1; }
    public String getTeacher2() { return teacher2; }
    public String getGrade() { return grade; }
}
