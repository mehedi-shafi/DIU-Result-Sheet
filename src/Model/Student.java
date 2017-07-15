package Model;

/**
 * Created by shafi on 7/14/2017.
 */
public class Student {

    private String name;
    private String id;
    private String program;
    private String batch;
    private String enrollment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public void getStudentInfo (){
        System.out.println (getName() + "\t\t" + getId() + "\t\t" + getBatch());
    }
}
