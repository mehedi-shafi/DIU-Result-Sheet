package Out;

import Calculations.Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shafi on 7/14/2017.
 */
public class MainUI {
    //private variables for the Program.
    private String ID;
    private int fromYear, toYear, fromSemester, toSemester;


    private String[] semesters = new String[] {"Spring", "Summer", "Fall"};
    private JPanel mainPanel;
    private JTextField idText;
    private JButton goButton;
    private JLabel idLabel;
    private JComboBox fromYearDrop;
    private JComboBox fromSemDrop;
    private JComboBox toYearDrop;
    private JComboBox toSemDrop;

    public MainUI() {
        JFrame frame = new JFrame("Result");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setVisible(true);

        DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> semModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> yearModel1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> semModel1 = new DefaultComboBoxModel<>();

        fromSemDrop.setModel(semModel);
        fromYearDrop.setModel(yearModel);
        toSemDrop.setModel(semModel1);
        toYearDrop.setModel(yearModel1);

        for (int i = 2000; i < 2050; i++){
            yearModel.addElement(String.valueOf(i));
            yearModel1.addElement(String.valueOf(i));
        }
        for (int i = 0; i < 3; i++){
            semModel.addElement(semesters[i]);
            semModel1.addElement(semesters[i]);
        }

        fromSemDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fromSemester =  fromSemDrop.getSelectedIndex() + 1;
            }
        });

        fromYearDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fromYear = fromYearDrop.getSelectedIndex() + 2000;
            }
        });

        toYearDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toYear = toYearDrop.getSelectedIndex() + 2000;
            }
        });

        toSemDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toSemester = toSemDrop.getSelectedIndex() + 1;
            }
        });

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fromSemester =  fromSemDrop.getSelectedIndex() + 1;
                fromYear = fromYearDrop.getSelectedIndex() + 2000;
                toYear = toYearDrop.getSelectedIndex() + 2000;
                toSemester = toSemDrop.getSelectedIndex() + 1;

                String from_semester_id = Utilities.semester_id_generation(fromYear, fromSemester);
                String to_semester_id = Utilities.semester_id_generation(toYear, toSemester);
                ID = idText.getText().toString();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new LoadingGUI(ID, from_semester_id, to_semester_id);

                        }catch (Exception E){
                            E.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void main (String [] args){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainUI();
                }
            });
    }

}
