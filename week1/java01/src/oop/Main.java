package oop;

public class Main {
    public static void main(String[] args) {
      StudentManagement Hstudents =new StudentManagement(); 
       Hstudents.addStudent(new Student("Hoàng Hải", 21,"IT", "SV01"));
       Hstudents.addStudent(new Student("Nguyễn An", 20,"ET", "SV02"));
       Hstudents.printListInfo();
    }
}
