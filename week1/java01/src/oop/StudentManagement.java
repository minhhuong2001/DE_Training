package oop;
import java.util.ArrayList;
import java.util.List;

class StudentManagement implements StudentDao {
    private StudentDao studentDao;
    private List<Student> students;

    // Constructor
    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    // Thêm sinh viên vào danh sách
    public void addStudent(Student Student) {
        students.add(Student);
    }

    // Xóa sinh viên theo mã
    public void removeStudent(String StudentCode) {
        students.removeIf(Student -> Student.getStudentCode().equals(StudentCode));
    }
    public void printListInfo() {
        for (Student Student : students) {
            Student.printInfo();
        }
    }
}