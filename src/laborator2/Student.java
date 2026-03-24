package laborator2;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private float nota;

    public Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = 0.0f;
    }


    public String getNumarMatricol() {
        return numarMatricol;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }


    @Override
    public int compareTo(Student altStudent) {
        int rezultatFormatie = this.formatieDeStudiu.compareTo(altStudent.formatieDeStudiu);
        if (rezultatFormatie == 0) {
            return this.nume.compareTo(altStudent.nume);
        }
        return rezultatFormatie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        return Objects.equals(numarMatricol, student.numarMatricol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numarMatricol);
    }

    @Override
    public String toString() {

        return numarMatricol + ", " + prenume + ", " + nume + ", " + formatieDeStudiu + ", Nota: " + nota;
    }
}