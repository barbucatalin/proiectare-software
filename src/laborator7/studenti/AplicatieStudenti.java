package laborator7.studenti;

import java.util.HashSet;
import java.util.Set;

public class AplicatieStudenti {

    public static void main(String[] args) {

        Set<Student> studenti = new HashSet<>();

        studenti.add(new Student("1", "Andrei", "Popa", "TI 211"));
        studenti.add(new Student("2", "Ioan", "Ionescu", "TI 211"));
        studenti.add(new Student("3", "Maria", "Georgescu", "TI 211"));
        studenti.add(new Student("4", "Ana", "Pop", "TI 211"));
        studenti.add(new Student("5", "Vlad", "Marin", "TI 211"));

        System.out.println("Initial:");
        studenti.forEach(System.out::println);

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println("\nDupa impartire:");
        studenti.forEach(System.out::println);
    }


    public static Set<Student> imparteInDouaFormatii(Set<Student> studenti,
                                                     String f1,
                                                     String f2) {

        Set<Student> rezultat = new HashSet<>();

        int index = 0;
        int half = studenti.size() / 2;

        for (Student s : studenti) {

            if (index < half) {
                rezultat.add(schimbaFormatia(s, f1));
            } else {
                rezultat.add(schimbaFormatia(s, f2));
            }

            index++;
        }

        return rezultat;
    }


    public static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(
                st.getNumarMatricol(),
                st.getPrenume(),
                st.getNume(),
                nouaFormatie
        );
    }
}