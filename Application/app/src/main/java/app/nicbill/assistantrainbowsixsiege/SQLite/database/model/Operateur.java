package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Operateur {

    public static final String TABLE_NAME = "operateurs";

    private String idOperateur;
    private String nomOperateur;
    private String nomCode;
    private String bio;
    private String ddn;
    private String cheminIconeOp;
    private String cheminImageOp;
    private int idCapacite;
    private int idTypeOp;
    private int idRole;
    private int idCTU;

    public Operateur(String idOperateur, String nomOperateur, String nomCode, String bio, String ddn, String cheminIconeOp, String cheminImageOP,
                     int idCapacite, int idTypeOp, int idRole, int idCTU) {
        this.idOperateur = idOperateur;
        this.nomOperateur = nomOperateur;
        this.nomCode = nomCode;
        this.bio = bio;
        this.ddn = ddn;
        this.cheminIconeOp = cheminIconeOp;
        this.cheminImageOp = cheminImageOP;
        this.idCapacite = idCapacite;
        this.idTypeOp = idTypeOp;
        this.idRole = idRole;
        this.idCTU = idCTU;
    }

    public String getIdOperateur() {
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

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
