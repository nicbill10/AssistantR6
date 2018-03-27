package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class CTU {

    public static final String TABLE_NAME = "ctu";

    public static final String COLUMN_IDCTU = "idCTU";
    public static final String COLUMN_NOMCTU = "nomCTU";
    public static final String COLUMN_ABREVCTU = "abrevCTU";
    public static final String COLUMN_LOCATIONCTU = "locationCTU";
    public static final String COLUMN_DESCCTU = "descCTU";

    private int idCTU;
    private String nomCTU;
    private String abrevCTU;
    private String locationCTU;
    private String descCTU;



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDCTU + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMCTU + " TEXT,"
                    + COLUMN_ABREVCTU + " TEXT,"
                    + COLUMN_LOCATIONCTU + " TEXT,"
                    + COLUMN_DESCCTU + " TEXT"
                    + ")";

    public CTU(int idCTU, String nomCTU, String abrevCTU, String locationCTU, String descCTU) {
        this.idCTU = idCTU;
        this.nomCTU = nomCTU;
        this.abrevCTU = abrevCTU;
        this.locationCTU = locationCTU;
        this.descCTU = descCTU;
    }

    public int getIdCTU(){
        return idCTU;
    }

    public String getNomCTU(){
        return nomCTU;
    }
    public void setNomCTU(String nomCTU){
        this.nomCTU = nomCTU;
    }

    public String getAbrevCTU(){
        return abrevCTU;
    }
    public void setAbrevCTU(String abrevCTU){
        this.abrevCTU = abrevCTU;
    }

    public String getLocationCTU(){
        return locationCTU;
    }
    public void setLocationCTU(String locationCTU){
        this.locationCTU = locationCTU;
    }

    public String getDescCTU(){
        return descCTU;
    }
    public void setDescCTU(String descCTU){
        this.descCTU = descCTU;
    }
}
