package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class ArmeOperateur {

    public static final String TABLE_NAME = "armeOperateur";

    public static final String COLUMN_IDARME = "idArme";
    public static final String COLUMN_IDOPERATEUR = "idOperateur";

    private int idArme;
    private int idOperateur;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDARME + " INTEGER PRIMARY KEY,"
                    + COLUMN_IDOPERATEUR + " INTEGER PRIMARY KEY"
                    + ")";

    public ArmeOperateur(int idArme, int idOperateur) {
        this.idArme = idArme;
        this.idOperateur = idOperateur;
    }

    public int getIdArme(){
        return idArme;
    }

    public int getIdOperateur(){
        return idOperateur;
    }
}
