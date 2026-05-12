package laborator10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {

    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Grupa");
            header.createCell(4).setCellValue("Medie");

            int rowIndex = 1;

            for (Student student : studenti) {
                Row row = sheet.createRow(rowIndex++);

                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getPrenume());
                row.createCell(2).setCellValue(student.getNume());
                row.createCell(3).setCellValue(student.getGrupa());
                row.createCell(4).setCellValue(student.getMedie());
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            }

            System.out.println("Studentii au fost exportati in fisierul Excel: " + fileName);

        } catch (Exception e) {
            System.out.println("Eroare la exportul in fisier Excel: " + e.getMessage());
        }
    }
}