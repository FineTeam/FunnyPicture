package ru.ksu.mvc.model.dao;

import ru.ksu.mvc.model.vo.Note;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Alexander Shlyannikov
 *         13.12.2009 20:46:32
 */
public interface NoteDAO {
    public List<Note> getAllNotes() throws SQLException;

    public Note getNoteById(long id) throws SQLException;

    public void createNote(Note note) throws SQLException;

    public void deleteNote(long id) throws SQLException;
}
