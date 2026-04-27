package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class GestiuneStudenti{

public static Student schimbaGrupa(Student s, String nouaGrupa) {
    return new Student(s.getNumarMatricol(),
            s.getPrenume(),
            s.getNume(),
            nouaGrupa,
            s.getNota());
}
public static void main(String[] args) {

    List<Student> listaInitiala = new ArrayList<>();
    listaInitiala.add(new Student(101, "Andrei", "Popa", "OLD_GP"));
    listaInitiala.add(new Student(102, "Maria", "Ionescu", "OLD_GP"));
    listaInitiala.add(new Student(103, "Dan", "Georgescu", "OLD_GP"));
    listaInitiala.add(new Student(104, "Ana", "Vasile", "OLD_GP"));
    listaInitiala.add(new Student(105, "Ion", "Mihalcea", "OLD_GP"));

    int n = listaInitiala.size();
    int mijloc = (n + 1) / 2;



    List<Student> grupaA = new ArrayList<>();
    List<Student> grupaB = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        Student s = listaInitiala.get(i);
        if (i < mijloc) {

            grupaA.add(schimbaGrupa(s, "ISM1"));
        } else {

            grupaB.add(schimbaGrupa(s, "ISM2"));
        }
    }

    System.out.println(" Grupa ISM1 (" + grupaA.size() + " studenti) ===");
    grupaA.forEach(System.out::println);


    System.out.println(" Grupa ISM2 (" + grupaB.size() + " studenti) ===");
    grupaB.forEach(System.out::println);
}

}
