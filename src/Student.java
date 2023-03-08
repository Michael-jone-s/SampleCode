public class Student {
    // instance variables
    private String name;
    private int age;
    private String major;

    // constructor
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    // main method
    public static void main(String[] args) {
        // create a new student object
        Student student1 = new Student("Michael Jone", 22, "Data Science");

        // print out the student's information
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Major: " + student1.getMajor());
    }
}
