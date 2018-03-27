package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class GadgetOperateur {

    public static final String TABLE_NAME = "gadgetOperateur";

    public static final String COLUMN_IDGADGET = "idGadget";
    public static final String COLUMN_IDOPERATEUR = "idOperateur";

    private int idGadget;
    private int idOperateur;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDGADGET + " INTEGER PRIMARY KEY,"
                    + COLUMN_IDOPERATEUR + " INTEGER PRIMARY KEY"
                    + ")";

    public GadgetOperateur(int idGadget, int idOperateur) {
        this.idGadget = idGadget;
        this.idOperateur = idOperateur;
    }

    public int getIdGadget(){
        return idGadget;
    }

    public int getIdOperateur(){
        return idOperateur;
    }
}
