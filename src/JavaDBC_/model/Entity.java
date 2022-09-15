package JavaDBC_.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected List<String> columns;
    protected String tableName;
    protected List<String> targetColumns;
    public List<String> getTargetColumns() {
        return targetColumns;
    }
    public abstract void setTargetColumns(List<String> targetColumns);
    public List<String> getColumns() {
        return columns;
    }
    public String getTableName() {
        return tableName;
    }
    public Entity(List<String> columns, String tableName) {
        this.columns = columns;
        this.tableName = tableName;
        this.targetColumns = new ArrayList<>();
    }
    public Entity(){};
}
