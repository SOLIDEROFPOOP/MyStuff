import java.util.Calendar;

public class Student {
    private String firstName;
    private String secondName;
    private int id;
    private Calendar birthday;

    private Double gpa;
    private String city;
    private Boolean have;

    public Student(String firstName, String secondName, int id , Calendar birthday, Double gpa, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;

        this.birthday = birthday;
        this.gpa = gpa;
        this.city = city;
    }
    public Student(){

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
