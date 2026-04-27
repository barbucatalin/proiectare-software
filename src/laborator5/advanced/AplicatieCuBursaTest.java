package laborator5.advanced;

import laborator5.StudentBursier;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AplicatieCuBursaTest {

    AplicatieCuBursa app = new AplicatieCuBursa();

    @Test
    void sortTest1() {

        // ARRANGE
        List<StudentBursier> lista = app.genereaza();

        // ACT
        List<StudentBursier> sortata = app.sorteaza(lista);

        // ASSERT
        for (int i = 0; i < sortata.size() - 1; i++) {

            StudentBursier s1 = sortata.get(i);
            StudentBursier s2 = sortata.get(i + 1);

            int cmp = Comparator
                    .comparing(StudentBursier::getFormatieDeStudiu)
                    .thenComparing(StudentBursier::getNume)
                    .thenComparing(StudentBursier::getPrenume)
                    .thenComparing(StudentBursier::getNota)
                    .thenComparing(StudentBursier::getCuantumBursa)
                    .compare(s1, s2);

            assertTrue(cmp <= 0);
        }
    }
}