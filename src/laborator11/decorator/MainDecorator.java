package laborator11.decorator;

import java.util.ArrayList;
import java.util.List;

public class MainDecorator {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Andrei"));
        students.add(new Student("Maria"));
        students.add(new Student("Bianca"));

        IStudentExport consoleExport =
                new TimeExecutionDecorator(
                        new StudentConsoleExport()
                );

        consoleExport.export(students);

        System.out.println();

        IStudentExport txtExport =
                new TimeExecutionDecorator(
                        new StudentTxtExport()
                );

        txtExport.export(students);
    }
}