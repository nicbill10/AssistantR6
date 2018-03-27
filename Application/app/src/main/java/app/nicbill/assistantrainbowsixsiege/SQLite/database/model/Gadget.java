package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Gadget{

    public static final String TABLE_NAME = "gadget";

    public static final String COLUMN_IDGADGET = "idGadget";
    public static final String COLUMN_NOMGADGET = "nomGadget";
    public static final String COLUMN_QTEGADGET = "qteGadget";
    public static final String COLUMN_CHEMINIMAGEGADGET = "cheminImageGadget";

    private int idGadget;
    private String nomGadget;
    private int qteGadget;
    private String cheminImageGadget;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDGADGET + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMGADGET + " TEXT,"
                    + COLUMN_QTEGADGET + " INTEGER,"
                    + COLUMN_CHEMINIMAGEGADGET + " TEXT"
                    + ")";

    public Gadget(int idGadget, String nomGadget, int qteGadget, String cheminImageGadget) {
        this.idGadget = idGadget;
        this.nomGadget = nomGadget;
        this.qteGadget = qteGadget;
        this.cheminImageGadget = cheminImageGadget;
    }

    public int getIdGadget(){
        return idGadget;
    }

    public String getNomGadget(){
        return nomGadget;
    }
    public void setNomGadget(String nomGadget){
        this.nomGadget = nomGadget;
    }

    public int getQteGadget(){
        return qteGadget;
    }
    public void setQteGadget(int qteGadget){
        this.qteGadget = qteGadget;
    }

    public String getCheminImageGadget(){
        return cheminImageGadget;
    }
    public void setCheminImageGadget(String cheminImageGadget){
        this.cheminImageGadget = cheminImageGadget;
    }

}
