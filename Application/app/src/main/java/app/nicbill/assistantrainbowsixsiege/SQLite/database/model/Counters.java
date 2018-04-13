package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Counters {

    public static final String TABLE_NAME = "counters";

    private int idOpCountering;
    private int idOpCountered;

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
