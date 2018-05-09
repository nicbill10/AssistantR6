package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class TypeArme {

    public static final String TABLE_NAME = "typeArme";

    private String idTypeArme;
    private String nomType;

    public TypeArme(String idTypeArme, String nomType) {
        this.idTypeArme = idTypeArme;
        this.nomType = nomType;
    }

    public String getIdTypeArme(){
        return idTypeArme;
    }

    public String getNomType(){
        return nomType;
    }
    public void setNomType(String nomType){
        this.nomType = nomType;
    }
}
