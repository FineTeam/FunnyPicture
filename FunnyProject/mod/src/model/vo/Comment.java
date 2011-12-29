package model.vo;

/**
 * Created by IntelliJ IDEA.
 * model.vo.User: loool
 * Date: 20.12.11
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    private long id;
    private  String comm;
    private long userid;
    private long picid;

    public Comment()
    {}

    public Comment(long id1, String comm1,long userid1, long picid1 )
    {
        this.id = id1;
        this.comm = comm1;
        this.userid = userid1;
        this.picid = picid1;

    }

    public long  getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public String getComm()
    {
        return comm;
    }
    public void setComm(String comm)
    {
        this.comm = comm;
    }
    public long  getUserid()
    {
        return userid;
    }

    public void setUserid(long userid1)
    {
        this.userid = userid1;
    }
    public long  getPicid()
    {
        return picid;
    }

    public void setPicid(long picid1)
    {
        this.picid = picid1;
    }
}
