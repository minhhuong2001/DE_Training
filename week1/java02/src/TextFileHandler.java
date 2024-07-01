import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileHandler {

    public static void writeTextFile(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }

    public static String readTextFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim();
    }

    public static void main(String[] args) throws IOException {

        String content = "Write write write.";
        writeTextFile("text_data.txt", content);

        String readContent = readTextFile("text_data.txt");
        
        System.out.println("Read content:");
        System.out.println(readContent);
    }
}
