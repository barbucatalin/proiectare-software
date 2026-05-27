package laborator11.decorator;

import java.util.List;

public abstract class ExportDecorator
        implements IStudentExport {

    protected IStudentExport exporter;

    public ExportDecorator(IStudentExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public void export(List<Student> students) {
        exporter.export(students);
    }
}