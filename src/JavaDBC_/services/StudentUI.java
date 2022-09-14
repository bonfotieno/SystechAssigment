package JavaDBC_.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import JavaDBC_.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;

interface IStudentDB {
    String createInsertQuery(Student student);
    String createUpdateQuery(Student student);
    List<Student> queryStudents() throws SQLException;
    Student queryStudent(int id) throws SQLException;
    boolean executeQuery(String query);
    boolean deleteStudent(int id);
    ResultSet executeReadQuery(String query) throws SQLException;
}

class MySQLStudentDB implements IStudentDB{
    private Connection connection;
    private ResultSet resultSet;
    Statement statement;

    public MySQLStudentDB() {
        this.openConnection();
    }

    private void openConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "*##*BBBM");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String createInsertQuery(Student student) {
        return "INSERT INTO student (idNumber, name, gender) VALUES (" + student.getIdNumber() + ", \""+ student.getName() +"\", \""+ student.getGender()+"\");";
    }

    public String createUpdateQuery(Student student) {
        return "UPDATE student SET name = \"" + student.getName() + "\", gender = \""+ student.getGender() +"\", idNumber = " + student.getIdNumber()+ " WHERE id = " +student.getId()+ ";";
    }

    @Override
    public List<Student> queryStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student;";
        resultSet = executeReadQuery(query);
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setIdNumber(resultSet.getInt("idNumber"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public Student queryStudent(int id) throws SQLException {
        String query = "SELECT * FROM student WHERE id = " + id + ";";
        resultSet = executeReadQuery(query);
        Student student = new Student();
        while (resultSet.next()) {
            student.setId(resultSet.getInt("id"));
            student.setIdNumber(resultSet.getInt("IdNUmber"));
            student.setGender(resultSet.getString("gender"));
            student.setName(resultSet.getString("name"));
        }
        return student;
    }

    @Override
    public boolean executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Executed Successfully. ");
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        String query = "DELETE FROM student WHERE id = " + id;
        return executeQuery(query);
    }

    @Override
    public ResultSet executeReadQuery(String query) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;

    }
}

public class StudentUI {
    static Scanner scanner = new Scanner(System.in);;
    static IStudentDB studentDB;
    public static void main(String[] args) throws SQLException, IOException {
        studentDB = new MySQLStudentDB();
        registerStudent();
        // displayStudent(7);
        displayStudents();
        deleteStudent(7);
        updateStudent();
    }

    public static void displayStudents() throws SQLException {
        List<Student> studentList = studentDB.queryStudents();
        for (Student student: studentList){
            System.out.println(student);
        }
    }

    public static void displayStudent(int id) throws SQLException {
        System.out.println(studentDB.queryStudent(id));
    }

    public static void deleteStudent(int id) throws SQLException {
        System.out.println(studentDB.deleteStudent(id));
    }

    public static void updateStudent() throws SQLException, IOException {
        System.out.print("Enter ID of the student to update: ");
        Student student = studentDB.queryStudent(scanner.nextInt());

        System.out.print("Enter student Name: ");
        String name = scanner.nextLine();
        if (name.trim().length() > 0)
            student.setName(name);

        System.out.print("Enter student Gender: ");
        String gender = scanner.nextLine();
        if (gender.trim().length() > 0)
            student.setGender(gender);

        System.out.print("Enter student ID Number or 0 to continue: ");
        int idNumber = scanner.nextInt();
        if (idNumber > 0)
            student.setIdNumber(idNumber);

        String query = studentDB.createUpdateQuery(student);
        studentDB.executeQuery(query);
    }

    public static void registerStudent(){
        Student student = new Student();
        System.out.println("Enter student Name: ");
        student.setName(scanner.nextLine());
        System.out.println("Enter student Gender: ");
        student.setGender(scanner.nextLine());
        System.out.println("Enter student ID Number: ");
        student.setIdNumber(scanner.nextInt());

        String query = studentDB.createInsertQuery(student);
        studentDB.executeQuery(query);
    }
}