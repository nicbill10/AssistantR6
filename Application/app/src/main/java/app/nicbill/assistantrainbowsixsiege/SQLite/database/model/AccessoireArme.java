package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class AccessoireArme {
    public static final String TABLE_NAME = "accessoireArme";

    public static final String COLUMN_IDACCESSOIRE = "idAccessoire";
    public static final String COLUMN_IDARME = "idArme";

    private int idAccessoire;
    private int idArme;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDACCESSOIRE + " INTEGER PRIMARY KEY,"
                    + COLUMN_IDARME + " INTEGER PRIMARY KEY"
                    + ")";

    public AccessoireArme(int idGadget, int idOperateur) {
        this.idAccessoire = idGadget;
        this.idArme = idOperateur;
    }

    public int getIdAccessoire(){
        return idAccessoire;
    }

    public int getIdArme(){
        return idArme;
    }
}
