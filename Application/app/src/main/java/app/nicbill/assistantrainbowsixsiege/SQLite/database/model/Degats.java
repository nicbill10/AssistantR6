package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Degats {
    public static final String TABLE_NAME = "degats";

    public static final String COLUMN_IDDEGAT = "idDegat";
    public static final String COLUMN_NBDEGATS = "nbDegats";
    public static final String COLUMN_ZONETOUCHE = "zoneTouche";
    public static final String COLUMN_ARMUREROOK = "armureRook";
    public static final String COLUMN_IDARME = "idArme";

    private int idDegat;
    private int nbDegat;
    private String zoneTouche;
    private int armureRook;
    private int idArme;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDDEGAT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NBDEGATS + " INT,"
                    + COLUMN_ZONETOUCHE + " TEXT,"
                    + COLUMN_ARMUREROOK + " INT,"
                    + COLUMN_IDARME + " INT"
                    + ")";

    public Degats(int idDegat, int nbDegats, String zoneTouche, int armureRook, int idArme) {
        this.idDegat = idDegat;
        this.nbDegat = nbDegats;
        this.zoneTouche = zoneTouche;
        this.armureRook = armureRook;
        this.idArme = idArme;
    }

    public int getIdDegat(){
        return idDegat;
    }

    public int getNbDegat(){
        return nbDegat;
    }
    public void setNbDegat(int nbDegat){
        this.nbDegat = nbDegat;
    }

    public String getZoneTouche(){
        return zoneTouche;
    }
    public void setZoneTouche(String zoneTouche){
        this.zoneTouche = zoneTouche;
    }

    public int getArmureRook(){
        return armureRook;
    }
    public void setArmureRook(int armureRook){
        this.armureRook = armureRook;
    }

    public int getIdArme(){
        return idArme;
    }
    public void setIdArme(int idArme){
        this.idArme = idArme;
    }
}
