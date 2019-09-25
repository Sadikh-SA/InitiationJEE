package model;


import java.time.LocalDate;

public class Employe {
    private  int id;
    private String matricule;
    private  String nomComplet;
    private  String tel;
    private LocalDate ddn;
    private double salaire;
    private  Service idService =new Service();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) { this.matricule = matricule;
    }
}

