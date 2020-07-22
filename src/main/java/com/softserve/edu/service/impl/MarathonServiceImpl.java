package com.softserve.edu.service.impl;

/*Основний сервіс:
	Отримання списків всіх студентів, менторів
	Отримання результату 1 студента або всіх студентів (клас StudentScore)
	Середній результат для 1 студента або всіх студентів (AverageScore)
	Студенти ментора
	Інші методи (додавання сигнетур до інтерфейсу MarathonService
*/

import java.util.List;

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
        // TODO
        return null;
    }

    //Kate
    public List<String> getMentors() {
        // TODO
        return null;
    }

    //Kate
    public StudentScore studentResult(String studentName) {
        // TODO
        return null;
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
