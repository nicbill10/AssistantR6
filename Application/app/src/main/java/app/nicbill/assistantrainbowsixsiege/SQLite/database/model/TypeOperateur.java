package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;


public class TypeOperateur {

    public static final String TABLE_NAME = "typeOperateur";

    private int idTypeOp;
    private String type;
    private int vitesse;
    private int armure;

    public TypeOperateur(int idTypeOp, String type, int vitesse, int armure) {
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

    public int getVitesse(){
        return vitesse;
    }
    public void setVitesse(int vitesse){
        this.vitesse = vitesse;
    }

    public int getArmure(){
        return armure;
    }
    public void setArmure(int armure){
        this.armure = armure;
    }

}
