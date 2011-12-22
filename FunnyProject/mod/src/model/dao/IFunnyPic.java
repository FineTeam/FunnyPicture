package model.dao;

/**
 * Created by IntelliJ IDEA.
 * model.vo.User: loool
 * Date: 20.12.11
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
public interface IFunnyPic {
    public  void  registration (String login, String pass);
    public  void  authorisation(String login, String pass);
    public  void  addComent(int userid, String comm);
    public  void addPic();
    public  void miniPic();
    public  void  showPic(int picid);

}
