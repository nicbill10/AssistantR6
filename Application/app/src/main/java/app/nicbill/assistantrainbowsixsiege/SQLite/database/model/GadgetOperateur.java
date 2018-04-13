package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class GadgetOperateur {

    public static final String TABLE_NAME = "gadgetOperateur";

    private int idGadget;
    private int idOperateur;
    private int qteGadget;

    public GadgetOperateur(int idGadget, int idOperateur, int qteGadget) {
        this.idGadget = idGadget;
        this.idOperateur = idOperateur;
        this.qteGadget = qteGadget;
    }

    public int getIdGadget(){
        return idGadget;
    }

    public int getIdOperateur(){
        return idOperateur;
    }

    public int getQteGadget() {
        return qteGadget;
    }
    public void setQteGadget(int qteGadget) {
        this.qteGadget = qteGadget;
    }
}
