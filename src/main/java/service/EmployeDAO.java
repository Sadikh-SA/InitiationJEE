package service;

import model.Employe;
import model.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAO {
    public List<Service> findService(){
        List<Service> services = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Service";
            DataBaseHelp db = DataBaseHelp.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            while (rs.next()){
                Service s = new Service();
                s.setId(rs.getInt(1));
                s.setLibelle(rs.getString(2));
                services.add(s);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return services;
    }

    public void addEmploye(Employe employe) throws Exception{
        try {
            String sql = "INSERT INTO Employe VALUES (null,?,?,?,?,?,?)";
            DataBaseHelp db = DataBaseHelp.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1, employe.getMatricule());
            db.getPstmt().setString(2, employe.getNomComplet());
            db.getPstmt().setString(3, employe.getTel());
            db.getPstmt().setString(4, employe.getDdn().toString());
            db.getPstmt().setDouble(5, employe.getSalaire());
            db.getPstmt().setInt(6,employe.getIdService().getId());
            db.My_ExecutePrepareUpdate();

        } catch (Exception e){
            throw e;
        }
    }
}
