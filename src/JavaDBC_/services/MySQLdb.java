package JavaDBC_.services;


import JavaDBC_.model.Entity;
import JavaDBC_.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLdb<T extends Entity> implements ISQLdb<T> {
    private Connection connection;
    private ResultSet resultSet;
    public MySQLdb() {
        this.openConnection();
    }
    private void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String createInsertQuery(T t) {
        StringBuilder stringBuilder = new StringBuilder("insert into ");
        stringBuilder.append(t.getTableName());
        stringBuilder.append("(");
        boolean isFirstColumn = true;
        for (String column : t.getColumns())
        {
            if (!isFirstColumn)
                stringBuilder.append(",");
            stringBuilder.append("`").append(column).append("`");
            isFirstColumn = false;
        }
        stringBuilder.append(") values(");
        Student s = (Student) t;
        isFirstColumn = true;
        for (String column:t.getTargetColumns()) {
            if (!isFirstColumn)
                stringBuilder.append(",");
            if (column.equalsIgnoreCase("IdNumber")) {
                stringBuilder.append(s.getIdNumber());
            }
            if (column.equalsIgnoreCase("gender")) {
                stringBuilder.append("\"").append(s.getGender()).append("\"");
            }
            if (column.equalsIgnoreCase("name")) {
                stringBuilder.append("\"").append((String) s.getName()).append("\"");
            }
            isFirstColumn = false;
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public String createUpdateQuery(T t) {
        return null; //"UPDATE student SET name = \"" + t.getName() + "\", gender = \"" + t.getGender() + "\", idNumber = " + t.getIdNumber() + " WHERE id = " + student.getId() + ";";
    }

    @Override
    public List<T> getList() throws SQLException {
        List<T> studentList = new ArrayList<>();
        String query = "SELECT * FROM student;";
        resultSet = executeReadQuery(query);
        while (resultSet.next()) {
            Student s = new Student();
            s.setId(resultSet.getInt("id"));
            s.setIdNumber(resultSet.getInt("idNumber"));
            s.setName(resultSet.getString("name"));
            s.setGender(resultSet.getString("gender"));
            studentList.add((T)s);
        }
        return studentList;
    }

    @Override
    public T get(T t, int id) throws SQLException {
        String query = "SELECT * FROM student WHERE id = " + id + ";";
        resultSet = executeReadQuery(query);
//        List<String> columns = List.of();
//        while (resultSet.next()) {
//            T.setId(resultSet.getInt("id"));
//            T.setIdNumber(resultSet.getInt("IdNUmber"));
//            t.setGender(resultSet.getString("gender"));
//            t.setName(resultSet.getString("name"));
//        }
        return t;
    }

    @Override
    public boolean executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Executed Successfully. ");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM student WHERE id = " + id;
        return executeQuery(query);
    }

    @Override
    public ResultSet executeReadQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
}
