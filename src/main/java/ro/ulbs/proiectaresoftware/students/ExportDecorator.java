package ro.ulbs.proiectaresoftware.students;

import java.util.List;


public class ExportDecorator implements ExportStrategy {

    private ExportStrategy exportStrategyDecorat;


    public ExportDecorator(ExportStrategy exportStrategyDecorat) {
        this.exportStrategyDecorat = exportStrategyDecorat;
    }

    @Override

    public void exporta(String sursa, List<Student> studenti) {
        long timpStart = System.currentTimeMillis();

        exportStrategyDecorat.exporta(sursa, studenti);

        long timpFinal = System.currentTimeMillis();
        long durata = timpFinal - timpStart;

        System.out.println(" Exportul " + sursa + " a durat: " + durata + " ms.");
    }

}