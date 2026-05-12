package laborator10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {

    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(fileName))) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                int id = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                double medie = row.getCell(4).getNumericCellValue();

                studenti.add(new Student(id, prenume, nume, grupa, medie));
            }

            System.out.println("Studentii au fost cititi din fisierul Excel: " + fileName);

        } catch (Exception e) {
            System.out.println("Eroare la citirea din fisier Excel: " + e.getMessage());
        }

        return studenti;
    }
}