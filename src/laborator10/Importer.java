package laborator10;

import java.util.List;

public class Importer {

    public List<Student> startImport(IStudentiImport strategieImport) {
        return strategieImport.doImport();
    }
}