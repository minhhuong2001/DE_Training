import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileHandler {

    public static void writeBinaryFile(String fileName, byte[] data) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data);
        }
    }

    public static byte[] readBinaryFile(String fileName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            int fileSize = inputStream.available();
            byte[] data = new byte[fileSize];
            inputStream.read(data);
            return data;
        }
    }

    public static void main(String[] args) throws IOException {
        // Example usage: Write a byte array to a binary file
        byte[] data = { 0x6F, 0x25, 0x1C, 0x3F }; // Sample byte array
        writeBinaryFile("binary_data.dat", data);

        // Read the binary file back into a byte array
        byte[] readData = readBinaryFile("binary_data.dat");

        // Print the read bytes (may not be human-readable)
        System.out.println("Read bytes:");
        for (byte b : readData) {
            System.out.print(b + " ");
        }
    }
}
