package laborator10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("=== Lista studenti ===");

        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}