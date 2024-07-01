import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileHandler {

    public static void writeBinaryFile(String fileName, byte[] data) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data);
        }
    }

    public static void readBinaryFile(String fileName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            int fileSize = inputStream.available();
            byte[] data = new byte[fileSize];
            inputStream.read(data);
            for (byte b : data) {
                System.out.print(b + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        byte[] data = { 0x2F, 0x25, 0x1C, 0x3F }; 
        writeBinaryFile("binary_data.dat", data);

        readBinaryFile("binary_data.dat");

    }
}
