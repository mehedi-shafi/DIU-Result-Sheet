package Model;

/**
 * Created by shafi on 7/14/2017.
 */
public class Subject {

    private String courseName;
    private String courseCode;
    private String credit;
    private String gradePoint;
    private String grade;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void getSubjectRes(){
        System.out.println(getCourseCode() + "\t\t" + getCourseName() + "\t\t" + getCredit() + "\t\t" +  getGrade() + "\t\t" + getGradePoint());
    }
}
