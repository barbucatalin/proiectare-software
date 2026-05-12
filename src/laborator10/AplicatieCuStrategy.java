package laborator10;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();

        IStudentiExport strategieConsola = new StudentiInConsola();
        exporter.startExport(strategieConsola, studenti);

        String fisierText = "studentiStrategyText.txt";
        IStudentiExport strategieFisierText = new StudentiInFisierText(fisierText);
        exporter.startExport(strategieFisierText, studenti);

        String fisierExcel = "studentiStrategyExcel.xlsx";
        IStudentiExport strategieFisierExcel = new StudentiInFisierXlsx(fisierExcel);
        exporter.startExport(strategieFisierExcel, studenti);

        Importer importer = new Importer();

        IStudentiImport citireText = new StudentiDinFisierText(fisierText);
        List<Student> studentiDinText = importer.startImport(citireText);

        System.out.println();
        System.out.println("=== Studenti cititi din fisier TXT ===");
        exporter.startExport(new StudentiInConsola(), studentiDinText);

        IStudentiImport citireExcel = new StudentiDinFisierXlsx(fisierExcel);
        List<Student> studentiDinExcel = importer.startImport(citireExcel);

        System.out.println();
        System.out.println("=== Studenti cititi din fisier XLSX ===");
        exporter.startExport(new StudentiInConsola(), studentiDinExcel);
    }
}