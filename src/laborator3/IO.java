package laborator3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public static void main(String[] args) {

        String fileNameIn = "src/laborator3/in.txt";
        String fileNameOut = "src/laborator3/out.txt";

        try {
            Path pathIn = Paths.get(fileNameIn);

            List<String> lines = Files.readAllLines(pathIn);
            List<String> processedLines = new ArrayList<>();



            for (String line : lines) {

                String modifiedLine = line + "\n";


                modifiedLine = modifiedLine.replace(".", ".\n");


                System.out.print(modifiedLine);


                processedLines.add(modifiedLine);
            }


            Path pathOut = Paths.get(fileNameOut);
            Files.write(pathOut, processedLines);


            System.out.println("Rezultatul a fost salvat în: " + fileNameOut);

        } catch (IOException e) {
            System.err.println("Eroare la procesarea fișierelor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}