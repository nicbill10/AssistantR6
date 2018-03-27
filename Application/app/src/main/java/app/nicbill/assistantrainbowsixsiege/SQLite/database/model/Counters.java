package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Counters {

    public static final String TABLE_NAME = "counters";

    public static final String COLUMN_IDOPCOUNTERING = "idOpCountering";
    public static final String COLUMN_IDOPCOUNTERED = "idOpCountered";

    private int idOpCountering;
    private int idOpCountered;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDOPCOUNTERING + " INTEGER PRIMARY KEY,"
                    + COLUMN_IDOPCOUNTERED + " INTEGER PRIMARY KEY"
                    + ")";

    public Counters(int idOpCountering, int idOpCountered) {
        this.idOpCountering = idOpCountering;
        this.idOpCountered = idOpCountered;
    }

    public int getIdOpCountering(){
        return idOpCountering;
    }

    public int getIdOpCountered(){
        return idOpCountered;
    }

}
