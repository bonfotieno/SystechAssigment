package JavaDBC_.model;

public class Student {
    private int id;
    private int IdNumber;
    private String gender;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(int idNumber) {
        IdNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "id= " + id + "\tidNumber= " + IdNumber + "\tname= " + name + "\tgender= " + gender;
    }
}