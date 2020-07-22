package com.softserve.edu.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprintScore that = (SprintScore) o;
        return getScore() == that.getScore() &&
                Objects.equals(getSprintName(), that.getSprintName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSprintName(), getScore());
    }
}
