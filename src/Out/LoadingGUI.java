package Out;

import Calculations.Utilities;
import Model.Student;
import Model.Subject;
import code.HTTPHANDLE;
import code.Scraper;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by shafi on 7/15/2017.
 */
public class LoadingGUI {
    private JPanel panelMain;
    private JProgressBar progressBar;
    private JLabel statusLabel;
    private String student_id, semester_from, semester_to;

    public LoadingGUI(String student_id, String from_semester_id, String to_semester_id) throws  Exception{
        JFrame frame = new JFrame("Fetching result...");
        frame.setContentPane(panelMain);
        frame.setSize(240, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.student_id = student_id;
        this.semester_from = from_semester_id;
        this.semester_to = to_semester_id;
        progressBar.setVisible(true);
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setValue(0);

        startScrapping();

    }

    public void startScrapping() throws  Exception{

        System.out.println (student_id);
        System.out.println (semester_from);
        System.out.println (semester_to);

        HTTPHANDLE htmlGrabber = new HTTPHANDLE(Utilities.RESULT_URL, student_id);

        Student student = new Student();
        ArrayList<Subject> dataList = new ArrayList<>();
        int currentCnt = 1;
        int totalSemester = Utilities.numberSemester(semester_from, semester_to);

        for (int i = Integer.parseInt(semester_from); i <= Integer.parseInt(semester_to); i++){
            System.out.println ("Semester: " + i);
            htmlGrabber.setSemester_id(String.valueOf(i));
            Scraper scraper = new Scraper(htmlGrabber.sendPost());
            if (i == Integer.parseInt(semester_from)){
                student = scraper.getStudentData();
            }
            double percentage = (double) (currentCnt * 100) / totalSemester;

            progressBar.setString(String.valueOf(percentage));
            progressBar.setValue((int) percentage);
            statusLabel.setText("Data for semester " + i + " fetched....");
            currentCnt++;
            dataList.addAll(scraper.getResult());
            if (i  % 10 == 3){
                i += 7;
            }
        }

        Student finalStudent = student;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportGUI(finalStudent, dataList);
            }
        });
    }

}
