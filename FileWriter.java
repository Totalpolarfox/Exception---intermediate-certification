
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

    public static void writeToFile(String content) throws IOException {

        String firstWord = content.split("\\s+")[0];

        File file = new File(firstWord + ".txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(file, true);
                PrintWriter pw = new PrintWriter(fos)) {
            pw.println(content);
            System.out.println("Информация добавлена в файл: " + file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
