package model.vo;

/**
 * Created by IntelliJ IDEA.
 * model.vo.User: loool
 * Date: 20.12.11
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private long id;
    private String login;
    private String pass;

    public User(long id, String login, String pass)
    {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public long  getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login)
    {
        this.login = login;
    }
    public String getPass ()
    {
        return pass;
    }
    public void  setPass(String pass)
    {
        this.pass = pass;
    }
}
