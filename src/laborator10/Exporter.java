package laborator10;

import java.util.List;

public class Exporter {

    public void startExport(IStudentiExport strategieExport, List<Student> studenti) {
        strategieExport.doExport(studenti);
    }
}