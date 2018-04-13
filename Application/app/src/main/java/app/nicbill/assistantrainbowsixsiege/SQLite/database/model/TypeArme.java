package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class TypeArme {

    public static final String TABLE_NAME = "typeArme";

    private int idTypeArme;
    private String nomType;

    public TypeArme(int idTypeArme, String nomType) {
        this.idTypeArme = idTypeArme;
        this.nomType = nomType;
    }

    public int getIdTypeArme(){
        return idTypeArme;
    }

    public String getNomType(){
        return nomType;
    }
    public void setNomType(String nomType){
        this.nomType = nomType;
    }
}
