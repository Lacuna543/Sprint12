package com.softserve.edu.dto;

import java.util.Objects;

public class AverageScore { //Kate
    private String studentName;
    private double avgScore;

    public AverageScore(String studentName, double avgScore) {
        this.studentName = studentName;
        this.avgScore = avgScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AverageScore that = (AverageScore) o;
        return Double.compare(that.avgScore, avgScore) == 0 &&
                Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, avgScore);
    }

}
