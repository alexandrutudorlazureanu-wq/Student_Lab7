package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public  class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final  String formatieDeStudiu;
    private final float nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, float nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }


    public String getPrenume() {
        return prenume;
    }
    public String getNume() {
        return nume;
    }
    public float getNota() {
        return nota;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

    @Override
    public String toString() {
        return String.format("%-15d %-15s %-15s %-15s %-10.2f",
                numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }


    public void setNota(float v) {
    }
}


