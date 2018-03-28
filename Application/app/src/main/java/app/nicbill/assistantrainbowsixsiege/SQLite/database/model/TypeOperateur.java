package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;


public class TypeOperateur {

    public static final String TABLE_NAME = "typeOperateur";

    public static final String COLUMN_IDTYPEOP = "idTypeOp";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_VITESSE = "vitesse";
    public static final String COLUMN_ARMURE = "armure";

    private int idTypeOp;
    private String type;
    private String vitesse;
    private String armure;



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDTYPEOP + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TYPE + " TEXT,"
                    + COLUMN_VITESSE + " TEXT,"
                    + COLUMN_ARMURE + " TEXT"
                    + ")";

    public TypeOperateur(int idTypeOp, String type, String vitesse, String armure) {
        this.idTypeOp = idTypeOp;
        this.type = type;
        this.vitesse = vitesse;
        this.armure = armure;
    }

    public int getIdTypeOp(){
        return idTypeOp;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getVitesse(){
        return vitesse;
    }
    public void setVitesse(String vitesse){
        this.vitesse = vitesse;
    }

    public String getArmure(){
        return armure;
    }
    public void setArmure(String armure){
        this.armure = armure;
    }

}
