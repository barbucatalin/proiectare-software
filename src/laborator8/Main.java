package laborator8;

import laborator2.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String inputFile = "laborator8_input.xlsx";
        String outputFile2 = "laborator8_output2.xlsx";
        String outputFile3 = "laborator8_output3.xlsx";

        citesteSiAfiseaza(inputFile);
        genereazaOutputCuMedieCalculata(inputFile, outputFile2);
        genereazaOutputCuFormula(inputFile, outputFile3);

        System.out.println("\n==============================");
        System.out.println("PARTEA CU STUDENTI");
        System.out.println("==============================");

        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("1001", "Ion", "Popescu", "A1", 9.5f));
        studenti.add(new Student("1002", "Maria", "Ionescu", "A2", 8.75f));
        studenti.add(new Student("1003", "Andrei", "Vasilescu", "A1", 10f));

        String studentsFile = "laborator8_students.xlsx";

        writeStudentsToExcel(studenti, studentsFile);

        List<Student> studentiCititi = readStudentsFromExcel(studentsFile);

        System.out.println("\nStudenti cititi din Excel:");
        for (Student student : studentiCititi) {
            System.out.println(student);
        }
    }

    public static void citesteSiAfiseaza(String fileName) {
        try (
                FileInputStream fis = new FileInputStream(fileName);
                Workbook workbook = new XSSFWorkbook(fis)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("Continut fisier Excel:");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    afiseazaCelula(cell);
                    System.out.print("\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }

    public static void genereazaOutputCuMedieCalculata(String inputFile, String outputFile) {
        try (
                FileInputStream fis = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(fis);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Rezultate");

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
                Row inputRow = inputSheet.getRow(i);
                Row outputRow = outputSheet.createRow(i);

                if (inputRow == null) continue;

                for (int j = 0; j < inputRow.getLastCellNum(); j++) {
                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);
                    copiazaCelula(inputCell, outputCell);
                }

                Cell mediaCell = outputRow.createCell(inputRow.getLastCellNum());

                if (i == 0) {
                    mediaCell.setCellValue("Media");
                } else {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();

                    double media = (nota1 + nota2 + nota3) / 3;
                    mediaCell.setCellValue(media);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fos);
            }

            System.out.println("\nFisier generat: " + outputFile);

        } catch (IOException e) {
            System.out.println("Eroare la generarea fisierului output2: " + e.getMessage());
        }
    }

    public static void genereazaOutputCuFormula(String inputFile, String outputFile) {
        try (
                FileInputStream fis = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(fis);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Rezultate");

            for (int i = 0; i <= inputSheet.getLastRowNum(); i++) {
                Row inputRow = inputSheet.getRow(i);
                Row outputRow = outputSheet.createRow(i);

                if (inputRow == null) continue;

                for (int j = 0; j < inputRow.getLastCellNum(); j++) {
                    Cell inputCell = inputRow.getCell(j);
                    Cell outputCell = outputRow.createCell(j);
                    copiazaCelula(inputCell, outputCell);
                }

                Cell mediaCell = outputRow.createCell(inputRow.getLastCellNum());

                if (i == 0) {
                    mediaCell.setCellValue("Media Formula");
                } else {
                    int excelRowNumber = i + 1;
                    mediaCell.setCellFormula("AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")");
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fos);
            }

            System.out.println("Fisier generat: " + outputFile);

        } catch (IOException e) {
            System.out.println("Eroare la generarea fisierului output3: " + e.getMessage());
        }
    }

    public static void writeStudentsToExcel(List<Student> studenti, String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Numar matricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Formatie de studiu");
            header.createCell(4).setCellValue("Nota");

            int rowIndex = 1;

            for (Student student : studenti) {
                Row row = sheet.createRow(rowIndex++);

                row.createCell(0).setCellValue(student.getNumarMatricol());
                row.createCell(1).setCellValue(student.getPrenume());
                row.createCell(2).setCellValue(student.getNume());
                row.createCell(3).setCellValue(student.getFormatieDeStudiu());
                row.createCell(4).setCellValue(student.getNota());
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }

            System.out.println("Fisier studenti generat: " + fileName);

        } catch (IOException e) {
            System.out.println("Eroare la scrierea studentilor in Excel: " + e.getMessage());
        }
    }

    public static List<Student> readStudentsFromExcel(String fileName) {
        List<Student> studenti = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                Workbook workbook = new XSSFWorkbook(fis)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                String numarMatricol = row.getCell(0).getStringCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatieDeStudiu = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                Student student = new Student(
                        numarMatricol,
                        prenume,
                        nume,
                        formatieDeStudiu,
                        nota
                );

                studenti.add(student);
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea studentilor din Excel: " + e.getMessage());
        }

        return studenti;
    }

    private static void afiseazaCelula(Cell cell) {
        if (cell == null) return;

        if (cell.getCellType() == CellType.STRING) {
            System.out.print(cell.getStringCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
            System.out.print(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            System.out.print(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.FORMULA) {
            System.out.print(cell.getCellFormula());
        }
    }

    private static void copiazaCelula(Cell inputCell, Cell outputCell) {
        if (inputCell == null) return;

        if (inputCell.getCellType() == CellType.STRING) {
            outputCell.setCellValue(inputCell.getStringCellValue());
        } else if (inputCell.getCellType() == CellType.NUMERIC) {
            outputCell.setCellValue(inputCell.getNumericCellValue());
        } else if (inputCell.getCellType() == CellType.BOOLEAN) {
            outputCell.setCellValue(inputCell.getBooleanCellValue());
        } else if (inputCell.getCellType() == CellType.FORMULA) {
            outputCell.setCellFormula(inputCell.getCellFormula());
        }
    }
}