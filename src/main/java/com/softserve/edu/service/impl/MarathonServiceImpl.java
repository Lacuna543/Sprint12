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
import java.util.stream.Collectors;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
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
        // TODO
        return null;
    }

    //Ksu
    public List<StudentScore> allStudentsResult() {

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
