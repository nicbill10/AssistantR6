package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Operateur {

    public static final String TABLE_NAME = "operateurs";

    public static final String COLUMN_IDOPERATEUR = "idOperateur";
    public static final String COLUMN_NOMOPERATEUR = "nomOperateur";
    public static final String COLUMN_NOMCODE = "nomCode";
    public static final String COLUMN_ORIGINE = "origine";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_DDN = "ddn";
    public static final String COLUMN_CHEMINICONEOP = "cheminIconeOp";
    public static final String COLUMN_CHEMINIMAGEOP = "cheminImageOp";
    public static final String COLUMN_IDCAPACITE = "idCapacite";
    public static final String COLUMN_IDTYPEOP = "idTypeOp";
    public static final String COLUMN_IDROLE = "idRole";
    public static final String COLUMN_IDCTU = "idCTU";

    private int idOperateur;
    private String nomOperateur;
    private String nomCode;
    private String origine;
    private String desc;
    private String ddn;
    private String cheminIconeOp;
    private String cheminImageOp;
    private int idCapacite;
    private int idTypeOp;
    private int idRole;
    private int idCTU;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDOPERATEUR + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMOPERATEUR + " TEXT,"
                    + COLUMN_NOMCODE + " TEXT,"
                    + COLUMN_ORIGINE + " TEXT,"
                    + COLUMN_DESC + " TEXT,"
                    + COLUMN_DDN + " TEXT,"
                    + COLUMN_CHEMINICONEOP + " TEXT,"
                    + COLUMN_CHEMINIMAGEOP + " TEXT,"
                    + COLUMN_IDCAPACITE + " INTEGER,"
                    + COLUMN_IDTYPEOP + " INTEGER,"
                    + COLUMN_IDROLE + " INTEGER,"
                    + COLUMN_IDCTU + " INTEGER"
                    + ")";

    public Operateur(int idOperateur, String nomOperateur, String nomCode, String origine, String desc, String ddn, String cheminIconeOp, String cheminImageOP,
                     int idCapacite, int idTypeOp, int idRole, int idCTU) {
        this.idOperateur = idOperateur;
        this.nomOperateur = nomOperateur;
        this.nomCode = nomCode;
        this.origine = origine;
        this.desc = desc;
        this.ddn = ddn;
        this.cheminIconeOp = cheminIconeOp;
        this.cheminImageOp = cheminImageOP;
        this.idCapacite = idCapacite;
        this.idTypeOp = idTypeOp;
        this.idRole = idRole;
        this.idCTU = idCTU;
    }

    public int getIdOperateur() {
        return idOperateur;
    }

    public String getNomOperateur() {
        return nomOperateur;
    }
    public void setNomOperateur(String nomOperateur) {
        this.nomOperateur = nomOperateur;
    }

    public String getNomCode() {
        return nomCode;
    }
    public void setNomCode(String nomCode){
        this.nomCode = nomCode;
    }

    public String getOrigine(){
        return origine;
    }
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDdn(){
        return ddn;
    }
    public void setDdn(String ddn) {
        this.ddn = ddn;
    }

    public String getCheminIconeOp(){
        return cheminIconeOp;
    }
    public void setColumnCheminiconeop(String cheminIconeOP) {
        this.cheminIconeOp = cheminIconeOP;
    }

    public String getCheminImageOp(){
        return cheminImageOp;
    }
    public void setColumnCheminimageop(String cheminImageOP) {
        this.cheminImageOp = cheminImageOP;
    }

    public int getIdCapacite(){
        return idCapacite;
    }
    public void setIdCapacite(int idCapacite) {
        this.idCapacite = idCapacite;
    }

    public int getIdTypeOp(){
        return idTypeOp;
    }
    public void setIdTypeOp(int idTypeOp) {
        this.idTypeOp = idTypeOp;
    }

    public int getIdRole(){
        return idRole;
    }
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdCTU(){
        return idCTU;
    }
    public void setIdCTU(int idCTU) {
        this.idCTU = idCTU;
    }
}
