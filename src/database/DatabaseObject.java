package database;

import java.sql.Connection;

public interface DatabaseObject<T> {
    Connection conn = DBMaster.getConn();

    void create();

    void update();

    void delete();
}
