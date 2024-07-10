import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Senalize {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("person.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Person person = new Person("John Doe", 30);
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream("person.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Person person = (Person) ois.readObject();
            System.out.println(person.getName() + ", " + person.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
