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
    private long userid;
    public Picture(long id1, String name1, String namemini1, long userid1)
    {
        this.id = id1;
        this.name = name1;
        this.namemini= namemini1;
        this.userid = userid1;
    }

    public long  getId()
    {
        return id;
    }

    public void setId(long id1)
    {
        this.id = id1;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name1)
    {
        this.name = name1;
    }
    public String getNamemini ()
    {
        return namemini;
    }
    public void  setNamemini(String namemini1)
    {
        this.namemini = namemini1;
    }

    public long  getUserid()
    {
        return userid;
    }

    public void setUserid(long userid1)
    {
        this.userid = userid1;
    }
}
