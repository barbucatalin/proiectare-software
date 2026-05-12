package laborator10;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {

    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Student student : studenti) {
                writer.println(
                        student.getId() + ";" +
                                student.getPrenume() + ";" +
                                student.getNume() + ";" +
                                student.getGrupa() + ";" +
                                student.getMedie()
                );
            }

            System.out.println("Studentii au fost exportati in fisierul text: " + fileName);

        } catch (Exception e) {
            System.out.println("Eroare la exportul in fisier text: " + e.getMessage());
        }
    }
}