package laborator2;

import java.util.*;

public class Liste {
    public static void main(String[] args) {


        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < 5; i++) x.add(rand.nextInt(11));
        for (int i = 0; i < 7; i++) y.add(rand.nextInt(11));

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("x initial: " + x);
        System.out.println("y initial: " + y);


        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) xPlusY: " + xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) zSet (comune): " + zSet);


        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) xMinusY: " + xMinusY);


        for (Integer val : xPlusY) {
            if (val <= p) {
                xPlusYLimitedByP.add(val);
            }
        }
        System.out.println("d) xPlusYLimitedByP (val <= " + p + "): " + xPlusYLimitedByP);

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(new Student("112", "Maria", "Popa", "TI21/1"));
        listaStudenti.add(new Student("115", "Ion", "Ionescu", "TI21/2"));

        System.out.println("Afisare studenti");
        for (Student s : listaStudenti) {
            System.out.println(s);
        }

        Set<Student> setStudentiCautare = new HashSet<>(listaStudenti);


        Student s1 = new Student("120", "Alis", "Popa", "TI21/2");

        Student s2 = new Student("112", "Maria", "Popa", "TI21/1");

        System.out.println("Student Alis Popa prezent: " + existaStudent(setStudentiCautare, s1));
        System.out.println("Student Maria Popa prezent: " + existaStudent(setStudentiCautare, s2));
    }

    public static boolean existaStudent(Set<Student> colectie, Student s) {
        return colectie.contains(s);
    }
}