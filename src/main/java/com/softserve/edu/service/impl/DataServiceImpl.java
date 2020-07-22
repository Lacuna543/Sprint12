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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("DataService")
public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;


    public DataServiceImpl() {
        students = new ArrayList<>();
        mentors = new ArrayList<>();
        sprints = new ArrayList<>();
        communication = new ArrayList<>();
        solution = new ArrayList<>();
    }


    public void addStudent(String studentName) {
        // TODO for students - Ksu
    }

    public void addMentor(String mentorName) {
        // TODO for mentors - Ksu
    }

    public void addSprint(String sprintName) {
        sprints.add(new Entity(sprintName));
    }

    public void addCommunication(String studentName, String mentorName) {
        // TODO for communication - Ksu
    }

    public void addSolution(String studentName, String sprintName, int score) {
        int studentId = getEntityByName(students, studentName).getId();
        int sprintId = getEntityByName(sprints, sprintName).getId();
        solution.add(new Solution(studentId, sprintId, score));
    }


    public Entity getEntityByName(List<Entity> entities, String entityName) {
        /*Getting correct Entity from given list by its name (lists students, mentors, sprints)
        * Methods where it should be used:
        *   addCommunication
        *   addSolution*/
        return entities.stream()
                .filter(s -> s.getName().equals(entityName))
                .findFirst()
                .orElse(null);
    }

    // TODO: getters by Ksu
}
