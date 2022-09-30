package com.example.exemplefragments;

public class Dia {
    private String dia;

    public Dia() {
    }
    public Dia(String dia) {
        this.dia=dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Dies{" +
                "dia='" + dia + '\'' +
                '}';
    }

}
