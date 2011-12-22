package ru.ksu.mvc.controller;

/**
 * @author Alexander Shlyannikov
 *         13.12.2009 22:02:54
 */
public interface Constants {
    String ACTION_NOTE = "note";
    String ACTION_ALL = "all";
    String ACTION_DELETE = "delete";
    String ACTION_CREATE = "create";
    String ATTRIBUTE_MESSAGE = "message";
    String ATTRIBUTE_NOTE = "note";
    String ATTRIBUTE_NOTES = "notes";
    String PARAM_ACTION = "action";
    String PARAM_ID = "id";
    String PARAM_TITLE = "title";
    String PARAM_TEXT = "text";
    String JSP_NOTES = "/WEB-INF/jsp/notes.jsp";
    String JSP_NOTE = "/WEB-INF/jsp/note.jsp";
    String JSP_ERROR = "/WEB-INF/jsp/error.jsp";
    String JSP_SUCCESS = "/WEB-INF/jsp/success.jsp";
}
