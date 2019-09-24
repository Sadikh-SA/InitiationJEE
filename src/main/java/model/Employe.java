package model;


public class Employe {
    private  int id;
    private String matricule;
    private  String nomComplet;
    private  int tel;
    private String ddn;
    private  Service service =new Service();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNom(String nom) {
        this.nomComplet = nom;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDdn() {
        return ddn;
    }

    public void setDdn(String ddn) {
        this.ddn = ddn;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) { this.matricule = matricule;
    }
}

