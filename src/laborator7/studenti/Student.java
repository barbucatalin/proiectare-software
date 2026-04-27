package laborator7.studenti;

import java.util.Objects;

public final class Student {

    private final String numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;

    public Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getNumarMatricol() {
        return numarMatricol;
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
    public String toString() {
        return numarMatricol + ", " + prenume + ", " + nume + ", " + formatieDeStudiu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(numarMatricol, student.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }
}