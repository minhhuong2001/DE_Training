import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}

public class Hashcode_equals {

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();

        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 30));

        // Kiểm tra xem "Charlie" có trong tập hay không
        boolean isCharlieInSet = people.contains(new Person("Charlie", 30));
        System.out.println("Charlie có trong tập? " + isCharlieInSet);

        // Thêm một "Alice" khác vào tập
        people.add(new Person("Alice", 30));

        // Kiểm tra kích thước tập
        System.out.println("Kích thước tập: " + people.size()); // In ra: 2

        // Duyệt qua các phần tử trong tập và in ra
        for (Person person : people) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }
}
