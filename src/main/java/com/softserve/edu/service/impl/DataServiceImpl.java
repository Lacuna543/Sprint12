package com.softserve.edu.service.impl;

/*Методи, що треба реалізувати для DataServiceImpl:
	додавання нового студента до списку по імені
	додавання нового ментора до списку по імені
	додавання нового спрінта до списку по імені
	додавання комунікації по іменах ментора та студента (створити об'єкт Communication та додати до списку)
	додавання рішення по іменах студента та спрінта + бал (створ. об'єкт Solution та додати до списку)
	Інше за необхідності (треба буде до інтерфейсу DataService пододавати сигнатури методів).
*/

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

    public void addStudent(String studentName) {
        if (students == null)
            students = new ArrayList<>();
        students.add(new Entity(studentName));
    }

    public void addMentor(String mentorName) {
        if (mentors == null)
            mentors = new ArrayList<>();
        mentors.add(new Entity(mentorName));
    }

    public void addSprint(String sprintName) {
        if (sprints == null)
            sprints = new ArrayList<>();
        sprints.add(new Entity(sprintName));
    }

    /*students.stream()
                    .filter(s -> s.getName().equals(studentName))
                    .findFirst()
                    .get()*/
    public void addCommunication(String studentName, String mentorName) {
        if (communication == null) communication = new ArrayList<>();
            communication.add(new Communication(getEntityByName(students, studentName).getId(),
                getEntityByName(mentors, mentorName).getId()));
    }

    public void addSolution(String studentName, String sprintName, int score) {
        if (solution == null)
            solution = new ArrayList<>();
        int studentId = getEntityByName(students, studentName).getId();
        int sprintId = getEntityByName(sprints, sprintName).getId();
        solution.add(new Solution(studentId, sprintId, score));
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


    public static Entity getEntityByName(List<Entity> entities, String entityName) {
        /*Getting correct Entity from given list by its name (lists students, mentors, sprints)*/
        return entities.stream()
                .filter(s -> s.getName().equals(entityName))
                .findFirst()
                .orElse(null);
    }

    public static Entity getEntityById(List<Entity> entities, int entityId) {
        return entities.stream()
                .filter(s -> s.getId() == entityId)
                .findFirst()
                .orElse(null);
    }
}
