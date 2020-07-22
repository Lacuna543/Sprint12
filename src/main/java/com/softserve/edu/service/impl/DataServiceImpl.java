package com.softserve.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    //Ksu
    public void addStudent(String studentName) {
        if (students == null)
            students = new ArrayList<>();
        students.add(new Entity(studentName));


    }

    //Ksu
    public void addMentor(String mentorName) {
        if (mentors == null)
            mentors = new ArrayList<>();
        mentors.add(new Entity(mentorName));

    }

    //Kate
    public void addSprint(String sprintName) {
        // TODO for sprints
    }

    //Ksu
    public void addCommunication(String studentName, String mentorName) {
        if (communication == null)
            communication = new ArrayList<>();
        communication.add(new Communication(students.stream()
                .filter(s -> s.getName().equals(studentName))
                .findFirst()
                .get()
                .getId(),
                mentors.stream()
                        .filter(s -> s.getName().equals(mentorName))
                        .findFirst()
                        .get()
                        .getId()));
    }

    //Kate
    public void addSolution(String studentName, String sprintName, int score) {
        // TODO for solution
    }

    public List<Entity> getStudents() {
        return students;
    }

    public List<Entity> getMentors() {
        return mentors;
    }

    public List<Entity> getSprints() {
        return sprints;
    }

    public List<Communication> getCommunication() {
        return communication;
    }

    public List<Solution> getSolution() {
        return solution;
    }
}
