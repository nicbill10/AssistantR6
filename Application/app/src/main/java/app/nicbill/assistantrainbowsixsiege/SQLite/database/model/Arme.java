package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Arme {
    public static final String TABLE_NAME = "operateurs";

    private String idArme;
    private String nomArme;
    private String calibreBalle;
    private String magSize;
    private String maxAmmo;
    private String fireRate;
    private String mobility;
    private String cheminImageArme;
    private String idTypeArme;
    private String mainWeapon;

    public Arme(String idArme, String nomArme, String calibreBalle, String magSize, String maxAmmo, String fireRate, String mobility, String cheminImageArme, String idTypeArme, String mainWeapon) {
        this.idArme = idArme;
        this.nomArme = nomArme;
        this.calibreBalle = calibreBalle;
        this.magSize = magSize;
        this.maxAmmo = maxAmmo;
        this.fireRate = fireRate;
        this.mobility = mobility;
        this.cheminImageArme = cheminImageArme;
        this.idTypeArme = idTypeArme;
        this.mainWeapon = mainWeapon;
    }

    public String getIdArme() {
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
    public String getIdTypeArme(){
        return idTypeArme;
    }
    public void setColumnCheminimageop(String idTypeArme) {
        this.idTypeArme = idTypeArme;
    }

    public String getMainWeapon() {
        return mainWeapon;
    }
    public void setMainWeapon(String mainWeapon) {
        this.mainWeapon = mainWeapon;
    }
}
