package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application2 {



        public static void main(String[] args) {


            System.out.println("  ");

            List<Student> studentiCuNote = Arrays.asList(
                    new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                    new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                    new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                    new Student(1029, "Bianca", "Popescu", "TI131/1", 10f),
                    new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                    new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                    new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                    new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                    new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
            );

            //a
            System.out.println("Studenții cu nota 10:");

            studentiCuNote.stream().filter(s -> s.getNota() == 10.0f).forEach(System.out::println);

            //b
            System.out.println("Studenții cu nota sub 5:");
            studentiCuNote.stream().filter(s -> s.getNota() < 5.0f).forEach(System.out::println);



            //c
            List<Student> studentiModificati = studentiCuNote.stream()
                    .map(s -> s.getNota() < 4.0f ?
                            new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4.0f) : s)
                    .collect(Collectors.toList());
            System.out.println("Lista cu notele sub 4 transformate în 4:");
            studentiModificati.forEach(System.out::println);



            //d
            float sumaNotelor = studentiCuNote.stream()
                    .map(Student::getNota)
                    .reduce(0.0f, Float::sum);

            Object sumaNotNotes = null;
            System.out.println(String.format("Suma tuturor notelor: %.2f", sumaNotNotes));



            //e
            float media = sumaNotelor / studentiCuNote.size();
            System.out.println(String.format("Media notelor este: %.2f", media));

    }

}
