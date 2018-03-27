package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;


public class TypeOperateur {

    public static final String TABLE_NAME = "typeOperateur";

    public static final String COLUMN_IDTYPEOP = "idTypeOp";
    public static final String COLUMN_NOMCAP = "nomCap";
    public static final String COLUMN_DESCCAP = "descCap";
    public static final String COLUMN_CHEMINIMAGECAP = "cheminImageCap";
    public static final String COLUMN_IDOPERATEUR = "idOperateur";

    private int idCap;
    private String nomCap;
    private String descCap;
    private String cheminImageCap;
    private int idOperateur;



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDTYPEOP + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMCAP + " TEXT,"
                    + COLUMN_DESCCAP + " TEXT,"
                    + COLUMN_CHEMINIMAGECAP + " TEXT,"
                    + COLUMN_IDOPERATEUR + " INTEGER"
                    + ")";

    public TypeOperateur(int idCap, String nomCap, String descCap, String cheminImageCap, int idOperateur) {
        this.idCap = idCap;
        this.nomCap = nomCap;
        this.descCap = descCap;
        this.cheminImageCap = cheminImageCap;
        this.idOperateur = idOperateur;
    }

    public int getIdCap(){
        return idCap;
    }

    public String getNomCap(){
        return nomCap;
    }
    public void setNomCap(String nomCap){
        this.nomCap = nomCap;
    }

    public String getDescCap(){
        return descCap;
    }
    public void setDescCap(String descCap){
        this.descCap = descCap;
    }

    public String getCheminImageCap(){
        return cheminImageCap;
    }
    public void setCheminImageCap(String cheminImageCap){
        this.cheminImageCap = cheminImageCap;
    }

    public int getIdOperateur(){
        return idOperateur;
    }
    public void setIdOperateur(int idOperateur){
        this.idOperateur = idOperateur;
    }
}
