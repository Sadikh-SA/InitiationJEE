package service;

import model.Utilisateur;

import java.sql.ResultSet;

public class UserDao {
    public Utilisateur logon(String login, String password){
        Utilisateur user = null;
        try {
            String sql = "SELECT * FROM Utilisateur WHERE login= ? AND password= ?";
            DataBaseHelp db = DataBaseHelp.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1, login);
            db.getPstmt().setString(2, password);
            ResultSet rs = db.My_ExecutePrepareQuery();
            if (rs.next()){
                user = new Utilisateur(rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
