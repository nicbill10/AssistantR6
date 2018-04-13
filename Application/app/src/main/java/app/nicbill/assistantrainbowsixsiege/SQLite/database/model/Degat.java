package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Degat {
    public static final String TABLE_NAME = "degat";

    private int idDegat;
    private String damageStandardClose;
    private String damageStandardFar;
    private String damageSuppressedClose;
    private String damageSuppressedFar;
    private String damageExtendedClose;
    private String damageExtendedFar;
    private int idArme;

    public Degat(int idDegat, String damageStandardClose, String damageStandardFar, String damageSuppressedClose, String damageSuppressedFar, String damageExtendedClose, String damageExtendedFar, int idArme) {
        this.idDegat = idDegat;
        this.damageStandardClose = damageStandardClose;
        this.damageStandardFar = damageStandardFar;
        this.damageSuppressedClose = damageSuppressedClose;
        this.damageSuppressedFar = damageSuppressedFar;
        this.damageExtendedClose = damageExtendedClose;
        this.damageExtendedFar = damageExtendedFar;
        this.idArme = idArme;
    }

    public int getIdDegat(){
        return idDegat;
    }

    public int getIdArme(){
        return idArme;
    }
    public void setIdArme(int idArme){
        this.idArme = idArme;
    }

    public String getDamageStandardClose() {
        return damageStandardClose;
    }

    public void setDamageStandardClose(String damageStandardClose) {
        this.damageStandardClose = damageStandardClose;
    }

    public String getDamageStandardFar() {
        return damageStandardFar;
    }

    public void setDamageStandardFar(String damageStandardFar) {
        this.damageStandardFar = damageStandardFar;
    }

    public String getDamageSuppressedClose() {
        return damageSuppressedClose;
    }

    public void setDamageSuppressedClose(String damageSuppressedClose) {
        this.damageSuppressedClose = damageSuppressedClose;
    }

    public String getDamageSuppressedFar() {
        return damageSuppressedFar;
    }

    public void setDamageSuppressedFar(String damageSuppressedFar) {
        this.damageSuppressedFar = damageSuppressedFar;
    }

    public String getDamageExtendedClose() {
        return damageExtendedClose;
    }

    public void setDamageExtendedClose(String damageExtendedClose) {
        this.damageExtendedClose = damageExtendedClose;
    }

    public String getDamageExtendedFar() {
        return damageExtendedFar;
    }

    public void setDamageExtendedFar(String damageExtendedFar) {
        this.damageExtendedFar = damageExtendedFar;
    }
}
