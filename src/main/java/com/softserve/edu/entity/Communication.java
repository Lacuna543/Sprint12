package com.softserve.edu.entity;

public class Communication { //Ksu
    private int idStudent;
    private int idMentor;
    // TODO


    public Communication(int idStudent, int idMentor) {
        this.idStudent = idStudent;
        this.idMentor = idMentor;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public int getIdMentor() {
        return idMentor;
    }
}
