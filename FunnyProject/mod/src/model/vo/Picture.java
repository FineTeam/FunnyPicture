package model.vo;

/**
 * Created by IntelliJ IDEA.
 * model.vo.User: loool
 * Date: 20.12.11
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class Picture {
   private long id;
    private  String name;
    private  String namemini;
    public Picture(long id, String login, String pass)
    {
        this.id = id;
        this.name = login;
        this.namemini= pass;
    }

    public long  getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getNamemini ()
    {
        return namemini;
    }
    public void  setNamemini(String namemini)
    {
        this.namemini = namemini;
    }
}
