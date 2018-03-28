package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class TypeAccessoire {

    public static final String TABLE_NAME = "typeAccessoire";

    public static final String COLUMN_IDTYPEACCESSOIRE = "idTypeAccessoire";
    public static final String COLUMN_NOMTYPE = "nomType";

    private int idTypeAccesoire;
    private String nomType;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDTYPEACCESSOIRE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMTYPE + " TEXT"
                    + ")";

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
