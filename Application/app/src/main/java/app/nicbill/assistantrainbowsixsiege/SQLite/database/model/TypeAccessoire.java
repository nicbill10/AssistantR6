package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class TypeAccessoire {

    public static final String TABLE_NAME = "typeAccessoire";

    private int idTypeAccesoire;
    private String nomType;

    public TypeAccessoire(int idRole, String nomRole) {
        this.idTypeAccesoire = idRole;
        this.nomType = nomRole;
    }

    public int getIdTypeAccesoire(){
        return idTypeAccesoire;
    }

    public String getNomType(){
        return nomType;
    }
    public void setNomType(String nomType){
        this.nomType = nomType;
    }
}
