public class Student {

    private String numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;


    public Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }


    @Override
    public String toString() {
        return "Student: " + nume + " " + prenume +
                " | Nr. Matricol: " + numarMatricol +
                " | Grupa: " + formatieDeStudiu;
    }
}
