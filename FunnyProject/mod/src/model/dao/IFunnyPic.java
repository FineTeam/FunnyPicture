package model.dao;

import model.vo.Comment;
import model.vo.User;

import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * model.vo.User: loool
 * Date: 20.12.11
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
public interface IFunnyPic {
    public User registration(String login, String pass) throws ClassNotFoundException, SQLException;
    public User authorisation(String login, String pass) throws ClassNotFoundException, SQLException;
    public void addComent(long picid, String comm, long userid) throws ClassNotFoundException, SQLException;
    public  void addPic(Byte picture, long userid);
    public  void showMiniPic() throws ClassNotFoundException, SQLException;
    public  void  showPic(long picid) throws ClassNotFoundException, SQLException;
    public void  showComm(long picid) throws ClassNotFoundException, SQLException;

}
