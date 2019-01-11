package database;

import java.sql.Connection;

public interface DatabaseObject {
    Connection conn = Connect.getConn();

    void create();

    void update();

    void delete();
}
