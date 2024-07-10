package json_gson;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class JsonExample1 {

    public static void main(String[] args) {
        String jsonString = "{\"name\": \"Han\", \"age\": 24, \"address\": \"Hanoi, Vietnam\"}";

        // Parse JSON sang object Person
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonString, Person.class);

        // In thông tin của person
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());
        System.out.println("Địa chỉ: " + person.getAddress());



        // Ghi vào file
        try (FileWriter file = new FileWriter("data.json")) {
            file.write(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

