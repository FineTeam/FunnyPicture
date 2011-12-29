package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: loool
 * Date: 29.12.11
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:funnypic.db");
        Statement stat = conn.createStatement();
    }
}
