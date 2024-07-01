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

    public static void readTextFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);

        BufferedReader br = new BufferedReader(fr);
        String line;

        // Đọc từng dòng trong file
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        // Đóng file
        br.close();
        fr.close();
    }

    public static void main(String[] args) throws IOException {

        String content = "Write write write.";
        writeTextFile("text_data.txt", content);

        readTextFile("text_data.txt");
    }
}
