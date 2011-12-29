package model.dao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import model.vo.*;

import javax.imageio.ImageIO;

/**
 * Created by IntelliJ IDEA.
 * User: loool
 * Date: 28.12.11
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
public class FunnyPic implements IFunnyPic {
    Statement stat;
    Connection conn;
    ResultSet rs;

    Picture pic;
    Comment comm;

    private void dbConnect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:funnypic.db");
        stat = conn.createStatement();
        conn.setAutoCommit(false);
    }

    private void smPicCreate() throws  IOException{
        BufferedImage originalImage = ImageIO.read(new File("c:\\pic.jpg"));
        int width = 150;
        int height = 100;
        Image image = originalImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        BufferedImage changedImage = new BufferedImage(width, height,    BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = changedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        ImageIO.write(changedImage, "jpg", new File("c:\\newpic.jpg"));
    }

    public User registration(String login, String pass) throws ClassNotFoundException, SQLException {
        User userinfo = new User();
        try {
            dbConnect();

            ResultSet rs = stat.executeQuery("select id, pass from user where login like '" + login + "' ");

            if (rs.wasNull()) {
                PreparedStatement prep = conn.prepareStatement("insert into user (login, pass) values (?, ?);");

                prep.setString(1, login);
                prep.setString(2, pass);
                prep.addBatch();

                prep.executeBatch();

                conn.commit();

                rs = stat.executeQuery("select id from user where login like '" + login + "' ");

                userinfo.setLogin(login);
                userinfo.setPass(pass);
                userinfo.setId(rs.getLong("id"));
            } else {
                //ошибка такой логин уже есть
            }
        } finally {

            rs.close();
            conn.close();

        }
        return userinfo;
    }

    public User authorisation(String login, String pass) throws ClassNotFoundException, SQLException {
        User userinfo = new User();
        try {
            dbConnect();

            rs = stat.executeQuery("select id, pass from user where login like '" + login + "' ");

            if (rs.wasNull()) {
                //ошибка  такого логина нет
            } else {
                String passwd = rs.getString("pass");
                if (passwd.equals(pass)) {
                    userinfo.setId(rs.getInt("id"));
                    userinfo.setLogin(login);
                    userinfo.setPass(pass);

                } else {
                    //ошибка  неправильный пароль
                }
            }
        } finally {

            rs.close();
            conn.close();

        }
        return userinfo;
    }

    public void addComent(long picid, String comm, long  userid) throws ClassNotFoundException, SQLException {
        try{
        dbConnect();

        PreparedStatement prep = conn.prepareStatement("insert into comments (comm, userid, picid) values (?, ?, ?);");

        prep.setString(1, comm);
        prep.setLong(2, userid);
        prep.setLong(3, picid);
        prep.addBatch();

        prep.executeBatch();

        conn.commit();
        }
        finally {

            rs.close();
            conn.close();

        }

    }

    public void addPic(Byte picture, long userid) throws ClassNotFoundException, SQLException {
        try{
          dbConnect();
        }
        finally {

            rs.close();
            conn.close();

        }
    }

    public void showMiniPic() throws ClassNotFoundException, SQLException {
        try{
            dbConnect();
        }

        finally {

            rs.close();
            conn.close();

        }
    }

    public void showPic(long picid) throws ClassNotFoundException, SQLException {
             try{

             dbConnect();
             }
             finally {

                 rs.close();
                 conn.close();

             }
    }

    public void showComm(long picid) throws ClassNotFoundException, SQLException {
         try{
             dbConnect();
         }

         finally {

             rs.close();
             conn.close();

         }
}
}
