package com.softserve.edu.service.impl;

/*Основний сервіс:
	Отримання списків всіх студентів, менторів
	Отримання результату 1 студента або всіх студентів (клас StudentScore)
	Середній результат для 1 студента або всіх студентів (AverageScore)
	Студенти ментора
	Інші методи (додавання сигнетур до інтерфейсу MarathonService
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@Service
public class MarathonServiceImpl implements MarathonService {

    private DataService dataService;

    @Autowired
    public MarathonServiceImpl(DataService dataService) {
        this.dataService = dataService;
    }

    //Kate
    public List<String> getStudents() {
        return dataService.getStudents().stream().map(Entity::getName).collect(Collectors.toList());
    }

    //Kate
    public List<String> getMentors() {
        return dataService.getMentors().stream().map(Entity::getName).collect(Collectors.toList());
    }

    //Kate
    public StudentScore studentResult(String studentName) {
        int studentId = dataService.getStudents().stream()
                .filter(student -> student.getName().equals(studentName))
                .findFirst()
                .map(Entity::getId)
                .orElse(0);
        Map<Integer, Integer> sprintsResults = dataService.getSolution().stream()
                .filter(solution -> solution.getIdStudent() == studentId)
                .collect(Collectors.toMap(Solution::getIdSprint, Solution::getScore));

        List<SprintScore> sprintScores = new ArrayList<>();

        for (Integer sprintId : sprintsResults.keySet()) {
            String sprintName = dataService.getSprints().stream()
                    .filter(sprint -> sprint.getId() == sprintId)
                    .findFirst()
                    .map(Entity::getName).orElse(null);
            sprintScores.add(new SprintScore(sprintName, sprintsResults.get(sprintId)));
        }

        return new StudentScore(studentName, sprintScores);
    }

    //Ksu
    public List<StudentScore> allStudentsResult() {
        // TODO
        return null;
    }

    //Ksu
    public AverageScore studentAverage(String studentName) {
        // TODO
        return null;
    }

    //Kate
    public List<AverageScore> allStudentsAverage() {
        // TODO
        return null;
    }

    //Ksu
    public MentorStudent mentorStudents(String mentorName) {
        // TODO
        return null;
    }
}
