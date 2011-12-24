package ru.ksu.mvc.model.dao.impl;

import ru.ksu.mvc.model.dao.NoteDAO;
import ru.ksu.mvc.model.vo.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Shlyannikov
 *         13.12.2009 20:49:00
 */
public class DBNoteDAO implements NoteDAO {
    private String driver;
    private String url;
    private String user;
    private String pass;
    private static final String TABLE_NAME = "NOTES";

    public DBNoteDAO(String driver, String url, String user, String pass) throws SQLException {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
        createTable();
    }

    @Override
    public List<Note> getAllNotes() throws SQLException {
        ArrayList<Note> result = new ArrayList<Note>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from NOTES");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                Note note = new Note(id, title, text);
                result.add(note);
            }
            return result;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Note getNoteById(long id) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            Note result = new Note();
            PreparedStatement statement = connection.prepareStatement("select * from NOTES as note where note.ID = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                result = new Note(id, title, text);
                break;
            }
            return result;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void createNote(Note note) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into NOTES (title, text) values (?,?)");
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getText());
            statement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteNote(long id) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from NOTES where NOTES.id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new SQLException(e.getMessage(), e);
        }
    }

    public void createTable() throws SQLException {
        Connection connection = getConnection();
        DatabaseMetaData meta = connection.getMetaData();   //проверяет есть ли уже эта таблица
        ResultSet mrs = meta.getTables(null, null, null, new String[]{"TABLE"});
        boolean exist = false;
        while (mrs.next()) {
            if (mrs.getString(3).equals(TABLE_NAME)) {
                exist = true;
            }
        }
        mrs.close();
        try {
            if (!exist) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("create table NOTES (id bigint GENERATED BY DEFAULT AS IDENTITY(START WITH 0) NOT NULL PRIMARY KEY, title varchar, text varchar)");
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}