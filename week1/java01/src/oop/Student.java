package oop;

class Student extends Person {
    private String major;
    private String studentCode;

    public Student(String name, int age, String major, String studentCode) {
        super(name, age);
        this.major = major;
        this.studentCode = studentCode;
    }

    @Override
    public String getFullName() {
        return String.format("[Sinh viên] %s - %s", getName(), studentCode);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
    public void printInfo() {
        System.out.println("Mã SV: " + studentCode);
        System.out.println("Họ tên: " + getName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Ngành " + major);
    }
}

