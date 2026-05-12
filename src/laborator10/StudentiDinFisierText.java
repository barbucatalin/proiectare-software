package laborator10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {

    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String linie;

            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(";");

                int id = Integer.parseInt(valori[0]);
                String prenume = valori[1];
                String nume = valori[2];
                String grupa = valori[3];
                double medie = Double.parseDouble(valori[4]);

                studenti.add(new Student(id, prenume, nume, grupa, medie));
            }

            System.out.println("Studentii au fost cititi din fisierul text: " + fileName);

        } catch (Exception e) {
            System.out.println("Eroare la citirea din fisier text: " + e.getMessage());
        }

        return studenti;
    }
}