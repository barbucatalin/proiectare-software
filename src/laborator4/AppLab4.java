package laborator4;

import laborator2.Student;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


class Tanar {
    private String name;
    private int age;
    private String address;

    public Tanar(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Tanar{nume='" + name + "', varsta=" + age + ", adresa='" + address + "'}";
    }
}

public class AppLab4 {

    public static void main(String[] args) {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);


        varste.put("Vlad", 19);
        varste.put("Iulia", 19);


        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj",
                "Simina", "Alba-Iulia", "Marius", "Medias", "Mihai", "Cisnadie", "Daniela", "Sibiu"
        );


        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            String adresa = adrese.getOrDefault(nume, "Necunoscuta");
            tineri.put(nume, new Tanar(nume, varste.get(nume), adresa));
        }


        System.out.println("--- Lista Tineri (4.5.1) ---");
        tineri.forEach((k, v) -> System.out.println(k + " -> " + v));



        List<Student> listaInitiala = new ArrayList<>();
        listaInitiala.add(new Student("1024", "Ioan", "Mihalcea", "ISM141/1"));
        listaInitiala.add(new Student("1025", "Andrei", "Popa", "ISM141/2"));
        listaInitiala.add(new Student("1026", "Anamaria", "Prodan", "TI131/1"));
        listaInitiala.add(new Student("1027", "Paul", "Mohanu", "TI132/1"));
        listaInitiala.add(new Student("1028", "Mihai", "Ionescu", "TI132/1"));
        listaInitiala.add(new Student("1029", "Bianca", "Popescu", "TI131/1"));


        HashMap<String, Student> mapStudenti = new HashMap<>();
        for (Student s : listaInitiala) {
            mapStudenti.put(s.getNumarMatricol(), s);
        }


        try {

            File fileNote = new File("src/laborator4/note_anon.txt");
            Scanner sc = new Scanner(fileNote);
            while (sc.hasNextLine()) {
                String[] date = sc.nextLine().split(",");
                if (date.length == 2) {
                    String matricol = date[0].trim();
                    float nota = Float.parseFloat(date[1].trim());


                    if (mapStudenti.containsKey(matricol)) {
                        mapStudenti.get(matricol).setNota(nota);
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("\n[Eroare] Fisierul note_anon.txt nu a fost gasit!");
        }


        System.out.println("\n--- Lista Studenti cu Note (4.5.2) ---");
        for (Student s : mapStudenti.values()) {
            System.out.println(s);
        }
    }
}