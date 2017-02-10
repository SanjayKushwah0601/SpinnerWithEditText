package sanjay.spinnerwithedittext;

import java.util.ArrayList;

/**
 * Created by Sanjay on 2/10/2017.
 */
public class CourseClass {
    private ArrayList<String> course_name;
    private String course_crn;
    
    public CourseClass(ArrayList<String> course_name, String course_crn) {
        super();
        this.setCourse_crn(course_crn);
        this.setCourse_name(course_name);
    }

    public ArrayList<String> getCourse_name() {
        return course_name;
    }

    public void setCourse_name(ArrayList<String> course_name) {
        this.course_name = course_name;
    }

    public String getCourse_crn() {
        return course_crn;
    }

    public void setCourse_crn(String course_crn) {
        this.course_crn = course_crn;
    }
}
