package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class TypeArme {

    public static final String TABLE_NAME = "typeArme";

    public static final String COLUMN_IDTYPEARME = "idTypeArme";
    public static final String COLUMN_NOMTYPE = "nomType";

    private int idTypeArme;
    private String nomType;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDTYPEARME + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMTYPE + " TEXT"
                    + ")";

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
