package json_gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

public class JsonExample2 {

    public static void main(String[] args) throws Exception {
        // Đọc file JSON
        String fileName = "data.json";
        String jsonString = readFile(fileName);

        //Parse file JSON sang object
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonString, Person.class);

        // In thông tin của person
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());
        System.out.println("Địa chỉ: " + person.getAddress());

    }

    private static String readFile(String fileName) throws Exception {
        // Đọc file JSON và trả về chuỗi JSON
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        return builder.toString();
    }
}

