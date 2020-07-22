package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {

    private MarathonService marathonService;

    private DataService dataService;

    @Autowired
    public ApplicationTest(MarathonService marathonService, DataService dataService) {
        this.marathonService = marathonService;
        this.dataService = dataService;
        fillDataService();
    }

    private void fillDataService() {
        dataService.addStudent("Petya");
        dataService.addStudent("Vasya");
        dataService.addStudent("Igor");

        dataService.addMentor("Yaroslav");
        dataService.addMentor("Olga");
        //dataService.addMentor(null);

        dataService.addCommunication("Petya", "Yaroslav");
        dataService.addCommunication("Vasya", "Olga");

        dataService.addSprint("Sprint01");
        dataService.addSprint("Sprint02");

        dataService.addSolution("Petya", "Sprint01", 5);
        dataService.addSolution("Vasya", "Sprint01", 10);

        dataService.addSolution("Petya", "Sprint02", 1);
        dataService.addSolution("Vasya", "Sprint02", 8);
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = new ArrayList<>();
        expected.add("Yaroslav");
        expected.add("Olga");


        List<String> actual = marathonService.getMentors();
        Assertions.assertEquals(expected, actual, "checkGetMentors()");
    }

    @Test
    public void checkGetStudents() {
        List<String> expected = new ArrayList<>();
        expected.add("Petya");
        expected.add("Vasya");
        expected.add("Igor");

        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkAllStudentsAverage() {
        List<AverageScore> expected = new ArrayList<>();
        expected.add(new AverageScore("Vasya", 9));
        expected.add(new AverageScore("Petya", 3));

        List<AverageScore> actual = marathonService.allStudentsAverage();
        Assertions.assertEquals(expected, actual, "checkAllStudentsAverage()");
    }

    @Test
    public void checkStudentAverage() {

        AverageScore expected = new AverageScore("Vasya", 9);
        AverageScore actual = marathonService.studentAverage("Vasya");
        Assertions.assertEquals(expected, actual, "checkStudentAverage()");
    }

    @Test
    public void checkMentorStudents() {

        List<String> students = new ArrayList<>();
        students.add("Vasya");
        MentorStudent expected = new MentorStudent("Olga", students);
        MentorStudent actual = marathonService.mentorStudents("Olga");
        Assertions.assertEquals(expected, actual, "checkMentorStudents()");

    }


    @Test
    public void checkStudentResult() {
        StudentScore expected = new StudentScore(
                "Vasya",
                List.of(new SprintScore("Sprint01", 10),
                        new SprintScore("Sprint02", 8)));
        StudentScore actual = marathonService.studentResult("Vasya");
        Assertions.assertEquals(expected, actual, "checkStudentResult()");
    }

    @Test
    public void checkAllStudentsResult() {
        List<StudentScore> expected = List.of(
                new StudentScore("Petya",
                        List.of(new SprintScore("Sprint01", 5),
                                new SprintScore("Sprint02", 1)))
                ,
                new StudentScore("Vasya",
                        List.of(new SprintScore("Sprint01", 10),
                                new SprintScore("Sprint02", 8)))
                ,
                new StudentScore("Igor", new ArrayList<>()));
        List<StudentScore> actual = marathonService.allStudentsResult();
        Assertions.assertEquals(expected, actual, "checkAllStudentsResult()");
    }

}