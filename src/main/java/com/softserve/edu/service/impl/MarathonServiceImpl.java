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
import com.softserve.edu.entity.Communication;
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
        return dataService.getMentors().stream().map(Entity::getName).distinct().collect(Collectors.toList());
    }

    //Kate
    public StudentScore studentResult(String studentName) {
        int studentId = dataService.getStudents().stream()
                .filter(student -> student.getName().equals(studentName))
                .findFirst()
                .map(Entity::getId)
                .orElse(0);
        Map<Integer, Integer> sprintsResults = dataService.getSolution().stream()
                .filter(solution -> solution.getIdStudent() == studentId).distinct()
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
        List<StudentScore> listOfAllStudentsResult = new ArrayList<>();
        for (String s : getStudents()) {
            listOfAllStudentsResult.add(studentResult(s));
        }

        return listOfAllStudentsResult;
    }

    //Ksu
    public AverageScore studentAverage(String studentName) {
        List<Solution> listOfScoreStudents = new ArrayList<>();
        listOfScoreStudents = dataService.getSolution()
                .stream()
                .filter(students -> students.getIdStudent() == dataService.getStudents()
                        .stream().filter(studentsOne -> studentsOne.getName().equals(studentName)).findFirst().get().getId()).collect(Collectors.toList());
        int sum = 0;
        for (Solution score : listOfScoreStudents) {
            sum += score.getScore();
        }

        AverageScore averageScore = new AverageScore(studentName, sum / listOfScoreStudents.size());
        return averageScore;
    }

    //Kate
    public List<AverageScore> allStudentsAverage() {
        return dataService.getStudents().stream()
                .map(student -> studentAverage(student.getName()))
                .collect(Collectors.toList());
    }

    //Ksu
    public MentorStudent mentorStudents(String mentorName) {
        List<Communication> list = dataService.getCommunication().stream()
                .filter(s -> s.getIdMentor() == dataService.getMentors()
                        .stream()
                        .filter(s1 -> s1.getName().equals(mentorName))
                        .findFirst()
                        .get().getId()).collect(Collectors.toList());
        List<String> listNameStudents = new ArrayList<>();
        for (Communication communication : list) {
            listNameStudents.add(dataService.getStudents().stream()
                    .filter(s -> s.getId() == communication.getIdStudent())
                    .findFirst().get().getName());
        }
        return new MentorStudent(mentorName, listNameStudents);
    }
}
