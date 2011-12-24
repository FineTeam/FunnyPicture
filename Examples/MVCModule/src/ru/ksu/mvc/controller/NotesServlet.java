package ru.ksu.mvc.controller;

import ru.ksu.mvc.model.dao.NoteDAO;
import ru.ksu.mvc.model.dao.impl.DBNoteDAO;
import ru.ksu.mvc.model.vo.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Alexander Shlyannikov
 *         13.12.2009 21:08:42
 */
public class NotesServlet extends HttpServlet {

    private NoteDAO noteDAO;

    @Override
    public void init() throws ServletException {
        String driver = getInitParameter("driver");
        String url = getInitParameter("url");
        String user = getInitParameter("user");
        String pass = getInitParameter("pass");
        try {
            noteDAO = new DBNoteDAO(driver, url, user, pass);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage(), e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter(Constants.PARAM_ACTION);
            if (action == null) {
                action = Constants.ACTION_ALL;
            }
            if (action.equals(Constants.ACTION_ALL)) {
                List<Note> notes = noteDAO.getAllNotes();
                request.setAttribute(Constants.ATTRIBUTE_NOTES, notes);
                include(request, response, Constants.JSP_NOTES);
            } else if (action.equals(Constants.ACTION_NOTE)) {
                String idStr = request.getParameter(Constants.PARAM_ID);
                long id = Long.parseLong(idStr);
                Note note = noteDAO.getNoteById(id);
                request.setAttribute(Constants.ATTRIBUTE_NOTE, note);
                include(request, response, Constants.JSP_NOTE);
            }
        } catch (RuntimeException e) {
// User hacking our urls
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Bad request");
            include(request, response, Constants.JSP_ERROR);
        } catch (SQLException e) {
// Database unavailable
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Database connection error");
            include(request, response, Constants.JSP_ERROR);
        } catch (Exception e) {
// Unknown f***up
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, e.getMessage());
            include(request, response, Constants.JSP_ERROR);
        }
    }

    private void include(HttpServletRequest request, HttpServletResponse response, String jspPath) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(jspPath);
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter(Constants.PARAM_ACTION);
            if (action.equals(Constants.ACTION_CREATE)) {
                String title = request.getParameter(Constants.PARAM_TITLE);
                String text = request.getParameter(Constants.PARAM_TEXT);
                Note note = new Note(title, text);
                noteDAO.createNote(note);
                request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Note created");
                include(request, response, Constants.JSP_SUCCESS);
            } else if (action.equals(Constants.ACTION_DELETE)) {
                String idStr = request.getParameter(Constants.PARAM_ID);
                long id = Long.parseLong(idStr);
                noteDAO.deleteNote(id);
                request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Note deleted");
                include(request, response, Constants.JSP_SUCCESS);
            }
        } catch (RuntimeException e) {
// User hacking our urls
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Bad request");
            include(request, response, Constants.JSP_ERROR);
        } catch (SQLException e) {
// Database unavailable
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, "Database connection error");
            include(request, response, Constants.JSP_ERROR);
        } catch (Exception e) {
// Unknown f***up
            request.setAttribute(Constants.ATTRIBUTE_MESSAGE, e.getMessage());
            include(request, response, Constants.JSP_ERROR);
        }
    }
}
