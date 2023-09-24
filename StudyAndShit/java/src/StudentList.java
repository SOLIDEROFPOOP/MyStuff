import java.util.*;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public void printNames(){
        students.stream().forEach(student -> System.out.println(student.getFirstName()));
    }
    public void printAverageGpa(){
        double average = students.stream().mapToDouble(Student::getGpa).average().getAsDouble();
        System.out.println(average);
    }
    public void printCity(){
        students
                .stream()
                .filter(student -> student.getCity().indexOf('a') != -1)
                .forEach(student -> System.out.println(student.getFirstName()));
    }
    public void printDateNames(){
        Calendar calendar = new GregorianCalendar(2000 , 1 , 1);
        students.stream()
                .filter(student -> student.getBirthday().before(calendar))
                .forEach(student -> System.out.println(student.getFirstName()));
    }
    public void printByGpa(){
        students.stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .forEach(student -> System.out.println(student.getFirstName()));
    }
    public HashMap<String , Double> converToMap(){
        /*
        HashMap<String , Double> map = new HashMap<>();
        for (Student student : students){
            map.put(student.getFirstName() , student.getGpa());
        }
        return map;

         */
        HashMap<String , Double> map = new HashMap<>();
        students.stream().forEach(student -> map.put(student.getFirstName() , student.getGpa()));
        return map;
    }
}
