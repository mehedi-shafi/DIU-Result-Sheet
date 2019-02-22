package Calculations;

import Model.Subject;

import java.util.ArrayList;

/**
 * Created by shafi on 7/15/2017.
 */
public class Utilities {
    public static  String RESULT_URL= "http://vus.daffodilvarsity.edu.bd/?app=result";

    public static String semester_id_generation (int year, int semester){

        String yearString = String.valueOf(year);
        String semesterString = String.valueOf(semester);
        String semester_id = String.valueOf(yearString.charAt(2));
        semester_id += yearString.charAt(3);
         semester_id  += semesterString;

        return semester_id;
    }

    public static int numberSemester (String from, String to){
        int frm = Integer.parseInt(from);
        int t = Integer.parseInt(to);
        int semCount = 0;
        for (int i = frm; i <= t; i++){
            semCount++;
            if (i % 10 == 3) i += 7;
        }
        return semCount;
    }

    public static ArrayList<Subject> getUnqueResult(ArrayList<Subject> data){
        ArrayList<Subject> returnList = new ArrayList<>();
        System.out.println("Processing raw data: ");
        for (int i = 0; i < data.size(); i++){
//            System.out.print(data.get(i).getCourseCode() + " " + Double.parseDouble(data.get(i).getGradePoint()));
            Subject temp = data.get(i);
            boolean match = false;
            for (int j = i+1; j < data.size(); j++){
                if (data.get(i).getCourseCode().compareTo(data.get(j).getCourseCode()) == 0){
                    match = true;
//                    System.out.print(" " + data.get(j).getCourseCode() + " " + Double.parseDouble(data.get(j).getGradePoint()));
                    if (Double.parseDouble(data.get(j).getGradePoint()) > Double.parseDouble(data.get(i).getGradePoint())){
                        temp = data.get(j);
                    }
                }
            }
//            System.out.println();
            if (!match) {
                returnList.add(temp);
            }
        }
        return returnList;
    }
}
