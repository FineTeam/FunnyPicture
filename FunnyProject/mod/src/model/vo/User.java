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

    public User()
    {}

    public User(long id1, String login1, String pass1)
    {
        this.id = id1;
        this.login = login1;
        this.pass = pass1;

    }


    public long  getId()
    {
        return id;
    }

    public void setId(long id1)
    {
        this.id = id1;
    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login1)
    {
        this.login = login1;
    }
    public String getPass()
    {
        return pass;
    }
    public void setPass(String pass1)
    {
        this.pass = pass1;
    }


}
