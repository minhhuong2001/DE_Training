package json_gson;

import com.google.gson.Gson;

public class JsonExample3 {

    public static void main(String[] args) {
        // Tạo object Person
        Person person2 = new Person();
        person2.setName("Lin");
        person2.setAge(26);
        person2.setName("TP.HCM, VietNam");

        // Chuyển đổi object Person thành JSON
        Gson gson2 = new Gson();
        String jsonString2 = gson2.toJson(person2);
        System.out.println("JSON: " + jsonString2);

    }
}

