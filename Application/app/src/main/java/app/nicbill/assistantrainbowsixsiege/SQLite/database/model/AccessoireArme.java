package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class AccessoireArme {
    public static final String TABLE_NAME = "accessoireArme";

    private int idAccessoire;
    private int idArme;

    public AccessoireArme(int idGadget, int idOperateur) {
        this.idAccessoire = idGadget;
        this.idArme = idOperateur;
    }

    public int getIdAccessoire(){
        return idAccessoire;
    }

    public int getIdArme(){
        return idArme;
    }
}
