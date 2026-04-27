package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends Student {

    private double cuantumBursa;


    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.setNota((float) nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentBursier)) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {

        return super.toString() + String.format(" Bursa: %-10.2f", cuantumBursa);
    }


}
