package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Arme {
    public static final String TABLE_NAME = "operateurs";

    public static final String COLUMN_IDARME = "idArme";
    public static final String COLUMN_NOMARME = "nomArme";
    public static final String COLUMN_CALIBREBALLE = "calibreBalle";
    public static final String COLUMN_NBBALLES = "nbBalles";
    public static final String COLUMN_FIRERATE = "fireRate";
    public static final String COLUMN_DAMAGEFALLOFF = "damageFalloff";
    public static final String COLUMN_CHEMINIMAGEARME = "cheminImsgeArme";
    public static final String COLUMN_IDTYPEARME = "idTypeArme";

    private int idArme;
    private String nomArme;
    private String calibreBalle;
    private int nbBalles;
    private int fireRate;
    private int damageFalloff;
    private String cheminImageArme;
    private int idTypeArme;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDARME + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMARME + " TEXT,"
                    + COLUMN_CALIBREBALLE + " TEXT,"
                    + COLUMN_NBBALLES + " INTEGER,"
                    + COLUMN_FIRERATE + " INTEGER,"
                    + COLUMN_DAMAGEFALLOFF + " INTEGER,"
                    + COLUMN_CHEMINIMAGEARME + " TEXT,"
                    + COLUMN_IDTYPEARME + " INTEGER"
                    + ")";

    public Arme(int idArme, String nomArme, String calibreBalle, int nbBalles, int fireRate, int damageFalloff, String cheminImageArme, int idTypeArme) {
        this.idArme = idArme;
        this.nomArme = nomArme;
        this.calibreBalle = calibreBalle;
        this.nbBalles = nbBalles;
        this.fireRate = fireRate;
        this.damageFalloff = damageFalloff;
        this.cheminImageArme = cheminImageArme;
        this.idTypeArme = idTypeArme;
    }

    public int getIdArme() {
        return idArme;
    }

    public String getNomArme() {
        return nomArme;
    }
    public void setNomArme(String nomArme) {
        this.nomArme = nomArme;
    }

    public String getCalibreBalle() {
        return calibreBalle;
    }
    public void setCalibreBalle(String calibreBalle){
        this.calibreBalle = calibreBalle;
    }

    public int getNbBalles(){
        return nbBalles;
    }
    public void setNbBalles(int nbBalles) {
        this.nbBalles = nbBalles;
    }

    public int getFireRate(){
        return fireRate;
    }
    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getDamageFalloff(){
        return damageFalloff;
    }
    public void setDamageFalloff(int damageFalloff) {
        this.damageFalloff = damageFalloff;
    }

    public String getCheminImageArme(){
        return cheminImageArme;
    }
    public void setColumnCheminiconeop(String cheminImageArme) {
        this.cheminImageArme = cheminImageArme;
    }

    public int getIdTypeArme(){
        return idTypeArme;
    }
    public void setColumnCheminimageop(int idTypeArme) {
        this.idTypeArme = idTypeArme;
    }

}
