package com.softserve.edu.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;


public class SprintScore { //Ksu
    private String sprintName;
    private int score;
    // TODO


    public SprintScore(String sprintName, int score) {
        this.sprintName = sprintName;
        this.score = score;
    }

    public String getSprintName() {
        return sprintName;
    }

    public int getScore() {
        return score;
    }
}
