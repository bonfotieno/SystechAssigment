package javaDBC.services;
import javaDBC.model.Student;

import java.sql.*;
import java.util.List;

interface IStudentDB {
    String createInsertQuery(Student student);
    List<Student> getStudents() throws SQLException;
    Student getStudent(int id) throws SQLException;
    boolean executeQuery(String query);
    ResultSet executeReadQuery(String query);
}

class MySQLStudentDB implements IStudentDB{
    private Connection conn;
    public MySQLStudentDB() {
    }
    private void createConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "PASS");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String createInsertQuery(Student student) {
        return null;
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        return null;
    }

    @Override
    public Student getStudent(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean executeQuery(String query) {
        return false;
    }

    @Override
    public ResultSet executeReadQuery(String query) {
        return null;
    }
}
public class StudentUI {
}
