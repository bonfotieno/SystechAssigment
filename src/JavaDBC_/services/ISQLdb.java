package JavaDBC_.services;

import JavaDBC_.model.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ISQLdb<T extends Entity> {
    String createInsertQuery(T t);
    String createUpdateQuery(T t);
    List<T> getList(T t) throws SQLException;
    T get(T t, int id) throws SQLException;
    boolean executeQuery(String query);
    boolean delete(int id);
    ResultSet executeReadQuery(String query) throws SQLException;
}
