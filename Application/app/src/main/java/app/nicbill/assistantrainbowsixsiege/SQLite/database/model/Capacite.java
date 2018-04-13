package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Capacite {

    public static final String TABLE_NAME = "capacite";

    private int idCap;
    private String nomCap;
    private String descCap;
    private String cheminImageCap;
    private int idOperateur;

    public Capacite(int idCap, String nomCap, String descCap, String cheminImageCap, int idOperateur) {
        this.idCap = idCap;
        this.nomCap = nomCap;
        this.descCap = descCap;
        this.cheminImageCap = cheminImageCap;
        this.idOperateur = idOperateur;
    }

    public int getIdCap(){
        return idCap;
    }

    public String getNomCap(){
        return nomCap;
    }
    public void setNomCap(String nomCap){
        this.nomCap = nomCap;
    }

    public String getDescCap(){
        return descCap;
    }
    public void setDescCap(String descCap){
        this.descCap = descCap;
    }

    public String getCheminImageCap(){
        return cheminImageCap;
    }
    public void setCheminImageCap(String cheminImageCap){
        this.cheminImageCap = cheminImageCap;
    }

    public int getIdOperateur(){
        return idOperateur;
    }
    public void setIdOperateur(int idOperateur){
        this.idOperateur = idOperateur;
    }
}
