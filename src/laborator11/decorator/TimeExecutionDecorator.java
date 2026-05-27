package laborator11.decorator;

import java.util.List;

public class TimeExecutionDecorator
        extends ExportDecorator {

    public TimeExecutionDecorator(IStudentExport exporter) {
        super(exporter);
    }

    @Override
    public void export(List<Student> students) {

        long start = System.currentTimeMillis();

        exporter.export(students);

        long end = System.currentTimeMillis();

        System.out.println(
                "Execution time: "
                        + (end - start)
                        + " ms"
        );
    }
}