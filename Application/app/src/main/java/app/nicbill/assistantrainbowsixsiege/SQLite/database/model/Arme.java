package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Arme {
    public static final String TABLE_NAME = "operateurs";

    private int idArme;
    private String nomArme;
    private String calibreBalle;
    private String magSize;
    private String maxAmmo;
    private String fireRate;
    private String mobility;
    private String cheminImageArme;
    private int idTypeArme;

    public Arme(int idArme, String nomArme, String calibreBalle, String magSize, String maxAmmo, String fireRate, String mobility, String cheminImageArme, int idTypeArme) {
        this.idArme = idArme;
        this.nomArme = nomArme;
        this.calibreBalle = calibreBalle;
        this.magSize = magSize;
        this.maxAmmo = maxAmmo;
        this.fireRate = fireRate;
        this.mobility = mobility;
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

    public String getMagSize(){
        return magSize;
    }
    public void setMagSize(String magSize) {
        this.magSize = magSize;
    }

    public String getMaxAmmo(){
        return maxAmmo;
    }
    public void setMaxAmmo(String maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public String getFireRate(){
        return fireRate;
    }
    public void setFireRate(String fireRate) {
        this.fireRate = fireRate;
    }

    public String getMobility(){
        return mobility;
    }
    public void setMobility(String mobility) {
        this.mobility = mobility;
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
