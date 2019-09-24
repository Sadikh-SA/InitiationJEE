package model;

public class Utilisateur {
    private int id;
    private String login;
    private String password;
    private  String nomComplet;
    private String profil;

    public Utilisateur(){}
    public Utilisateur(String login, String password, String nomComplet, String profil){
        this.login = login;
        this.password = password;
        this.nomComplet = nomComplet;
        this.profil = profil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
