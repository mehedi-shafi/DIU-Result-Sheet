package Out;

import Calculations.CGPA_calc;
import Calculations.Utilities;
import Model.Student;
import Model.Subject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by shafi on 7/15/2017.
 */
public class ReportGUI {


    private JPanel reportPanel;
    private JList courseIdList;
    private JList courseNameList;
    private JList gradePointList;
    private JList gradeList;
    private JLabel courseIdLabel;
    private JLabel courseNameLabel;
    private JLabel gradePointLabel;
    private JLabel gradeLabel;
    private JLabel totalCreditLabel;
    private JLabel totalCoursesTable;
    private JLabel CGPALabl;
    private JLabel cgLabel;
    private JLabel nameLabel;
    private JLabel IDLabel;
    private JLabel nameGetLabel;
    private JLabel idgetLabel;
    private JLabel programLabel;
    private JLabel programGetLabel;
    private JLabel batchLabel;
    private JLabel batchGetLabel;

    public ReportGUI(Student student, ArrayList<Subject> Result){

        System.out.println("Total courses: " + Result.size());
        Result = Utilities.getUnqueResult(Result);
        System.out.println("Total courses: " + Result.size());

        JFrame frame = new JFrame("Report Card.");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(720, 620);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setContentPane(reportPanel);


        nameGetLabel.setText(student.getName());
        idgetLabel.setText(student.getId());
        programGetLabel.setText(student.getProgram());
        batchGetLabel.setText(student.getBatch());

        DefaultListModel courseIdModel = new DefaultListModel();
        DefaultListModel courseNameModel = new DefaultListModel();
        DefaultListModel gradePointModel = new DefaultListModel();
        DefaultListModel gradeModel = new DefaultListModel();
        int icnt= 1;
        for (Subject temp : Result){
            courseIdModel.addElement(icnt +". " +  temp.getCourseCode()+" (" + temp.getCredit() + ")");
            courseNameModel.addElement(icnt +". " + temp.getCourseName());
            gradePointModel.addElement(icnt +". " + temp.getGradePoint());
            gradeModel.addElement(icnt +". " + temp.getGrade());
            icnt++;
        }

        courseIdList.setModel(courseIdModel);
        courseNameList.setModel(courseNameModel);
        gradePointList.setModel(gradePointModel);
        gradeList.setModel(gradeModel);

        CGPA_calc res = new CGPA_calc(Result);
        totalCreditLabel.setText("Total credit: " + res.getTotalCredit() );
        totalCoursesTable.setText("Total courses: " + res.totalNumCourseCompleted());
        cgLabel.setText(String.valueOf(res.getCgpa()));
    }

}
