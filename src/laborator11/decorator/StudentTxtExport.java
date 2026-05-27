package laborator11.decorator;

import java.util.List;

public class StudentTxtExport implements IStudentExport {

    @Override
    public void export(List<Student> students) {

        System.out.println("Exporting students to TXT...");
    }
}