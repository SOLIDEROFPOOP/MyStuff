import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create instances of the Student class
        Student student1 = new Student("John", "Doe", 1, new GregorianCalendar(1999, 5, 15), 3.8, "New York");
        Student student2 = new Student("Alice", "Smith", 2, new GregorianCalendar(2001, 3, 20), 3.9, "Los angeles");
        Student student3 = new Student("Bob", "Johnson", 3, new GregorianCalendar(1998, 8, 10), 3.5, "Chicago");

        // Add the students to an ArrayList
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        // Create an instance of StudentList
        StudentList studentListObj = new StudentList(studentList);

        // Call methods from StudentList class
        System.out.println("Printing Student Names:");
        studentListObj.printNames();

        System.out.println("\nPrinting Average GPA:");
        studentListObj.printAverageGpa();

        System.out.println("\nPrinting Students from City with 'a' in the Name:");
        studentListObj.printCity();

        System.out.println("\nPrinting Students with Birthdays before 2000-01-01:");
        studentListObj.printDateNames();

        System.out.println("\nPrinting Students Sorted by GPA:");
        studentListObj.printByGpa();

        System.out.println("\nConverting Students to a HashMap:");
        HashMap<String, Double> studentMap = studentListObj.converToMap();
        for (Map.Entry<String, Double> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
