package laborator3;

import laborator2.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IO {
    public static void main(String[] args) {

        String fileNameIn = "src/laborator3/studenti_in.txt";
        String fileNameOut = "src/laborator3/studenti_out_sorted.txt";

        try {

            Path pathIn = Paths.get(fileNameIn);
            List<String> rawLines = Files.readAllLines(pathIn);

            List<Student> listaStudenti = new ArrayList<>();


            for (String line : rawLines) {
                if (line.trim().isEmpty()) continue;


                String[] date = line.split(",\\s*");
                if (date.length == 4) {
                    Student s = new Student(
                            date[0].trim(),
                            date[1].trim(),
                            date[2].trim(),
                            date[3].trim()
                    );
                    listaStudenti.add(s);
                }
            }


            Collections.sort(listaStudenti);


            List<String> liniiDeSalvat = new ArrayList<>();
            System.out.println("Studenți sortați (Grupă -> Nume):");
            for (Student s : listaStudenti) {
                String studentString = s.toString();
                System.out.println(studentString);
                liniiDeSalvat.add(studentString);
            }


            Path pathOut = Paths.get(fileNameOut);
            Files.write(pathOut, liniiDeSalvat);

            System.out.println("\nSucces! Rezultatul a fost salvat în: " + fileNameOut);

        } catch (IOException e) {
            System.err.println("Eroare la procesarea fișierelor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}