package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<StudentBursier> listaStudenti = new ArrayList<>();
        listaStudenti.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        listaStudenti.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        listaStudenti.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        listaStudenti.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        String numeFisierExcel = "laborator8_students.xls";


        exportaInExcel(numeFisierExcel, listaStudenti);

        System.out.println("\n ");


        System.out.println("Citim datele:");
        List<Student> studentiCititi = citesteDinExcel(numeFisierExcel);

        for (Student s : studentiCititi) {
            System.out.println(s);
        }
    }


    public static void exportaInExcel(String numeFisier, Collection<? extends Student> studenti) {
        try (Workbook workbook = new HSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(numeFisier)) {

            Sheet sheet = workbook.createSheet("Studenti");


            Row headerRow = sheet.createRow(0);

            String[] coloane = {"Matricol", "Prenume", "Nume", "Formatie", "Nota"};

            for (int i = 0; i < coloane.length; i++) {

                Cell cell = headerRow.createCell(i);
                cell.setCellValue(coloane[i]);

            }


            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }


            for (int i = 0; i < coloane.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(fileOut);
            System.out.println("Exportul a fost realizat cu succes în: " + numeFisier);

        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului Excel: " + e.getMessage());
        }
    }


    public static List<Student> citesteDinExcel(String numeFisier) {
        List<Student> listaRezultat = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(numeFisier);
             Workbook workbook = new HSSFWorkbook(fileIn)) {

            Sheet sheet = workbook.getSheetAt(0);


            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;


                int matricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();


                Student student = new Student(matricol, prenume, nume, formatie, nota);
                student.setNota(nota);

                listaRezultat.add(student);
            }

        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }

        return listaRezultat;
    }
}