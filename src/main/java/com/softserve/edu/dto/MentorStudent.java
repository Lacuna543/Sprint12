package com.softserve.edu.dto;
import java.util.List;

public class MentorStudent { //Ksu
    private String mentorName;
    private List<String> studentNames;

    public MentorStudent(String mentorName, List<String> studentNames) {
        this.mentorName = mentorName;
        this.studentNames = studentNames;
    }

    public String getMentorName() {
        return mentorName;
    }


    public List<String> getStudentNames() {
        return studentNames;
    }

}
