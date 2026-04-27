package laborator5;

import laborator2.Student;
import java.util.Objects;

public class StudentBursier extends Student {

    private double cuantumBursa;

    public StudentBursier(String numarMatricol, String prenume, String nume, String grupa, float medie, double cuantumBursa) {
        super(numarMatricol, prenume, nume, grupa);
        this.setNota(medie);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    public void setCuantumBursa(double cuantumBursa) {
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public String toString() {
        return super.toString() + ", cuantumBursa=" + cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}