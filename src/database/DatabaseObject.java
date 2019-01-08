package database;

import java.sql.Connection;

public interface DatabaseObject {
    Connection conn = Master.getConn();

    void create();

    void update();

    void delete();
}
