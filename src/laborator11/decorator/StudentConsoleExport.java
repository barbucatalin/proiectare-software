package laborator11.decorator;

import java.util.List;

public class StudentConsoleExport implements IStudentExport {

    @Override
    public void export(List<Student> students) {

        for (Student s : students) {
            System.out.println("Student: " + s.getName());
        }
    }
}