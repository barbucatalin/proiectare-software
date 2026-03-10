

import laborator2.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(new Student("120", "Alis", "Popa", "TI21/2"));
        listaStudenti.add(new Student("112", "Maria", "Popa", "TI21/1"));
        listaStudenti.add(new Student("77821", "Andrei", "Popa", "Grupa 202"));


        System.out.println("--- Lista de studenti ---");
        for (Student s : listaStudenti) {
            System.out.println(s);
        }


        Student alis = new Student("120", "Alis", "Popa", "TI21/2");
        System.out.println("\nEste prezentă Alis? " + listaStudenti.contains(alis));


        Student maria = new Student("112", "Maria", "Popa", "TI21/1");
        System.out.println("Este prezentă Maria? " + listaStudenti.contains(maria));
    }
}