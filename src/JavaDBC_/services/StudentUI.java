package JavaDBC_.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import JavaDBC_.model.Student;

public class StudentUI {
    static Scanner scanner = new Scanner(System.in);
    static ISQLdb<Student> MySqlDB = new MySQLdb<>();
    static Student student;
    public static void main(String[] args) throws SQLException, IOException {
        List<String> columns = List.of("id","IdNumber","gender","name");
        student = new Student(columns,"student");
        registerStudent();
        // displayStudent(7);
        displayStudents();
//        deleteStudent(7);
//        updateStudent();
    }

    public static void displayStudents() throws SQLException {
        System.out.println("\nAll Student Details");
        List<Student> studentList = MySqlDB.getList(student);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void displayStudent(int id) throws SQLException {
        System.out.println(MySqlDB.get(student, id));
    }

    public static void deleteStudent(int id) throws SQLException {
        System.out.println(MySqlDB.delete(student, id));
    }

    public static void updateStudent() throws SQLException, IOException {
        System.out.print("Enter ID of the student to update: ");
        MySqlDB.get(student,scanner.nextInt());

        System.out.print("Enter student Name: ");
        String name = scanner.nextLine();
        if (name.length() > 0)
            student.setName(name);
        System.out.print("Enter student Gender: ");
        String gender = scanner.nextLine();
        if (gender.length() > 0)
            student.setGender(gender);
        System.out.print("Enter student ID Number or 0 to continue: ");
        int idNumber = scanner.nextInt();
        if (idNumber > 0)
            student.setIdNumber(idNumber);
        String query = MySqlDB.createUpdateQuery(student);
        MySqlDB.executeQuery(query);
    }

    public static void registerStudent() {
        System.out.println("Enter student Name: ");
        student.setName(scanner.nextLine());
        System.out.println("Enter student Gender: ");
        student.setGender(scanner.nextLine());
        System.out.println("Enter student ID Number: ");
        student.setIdNumber(scanner.nextInt());

        String query = MySqlDB.createInsertQuery(student);
        MySqlDB.executeQuery(query);
    }
}