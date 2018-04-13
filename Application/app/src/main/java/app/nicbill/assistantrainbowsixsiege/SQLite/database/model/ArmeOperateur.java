package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class ArmeOperateur {

    public static final String TABLE_NAME = "armeOperateur";

    private int idArme;
    private int idOperateur;

    public ArmeOperateur(int idArme, int idOperateur) {
        this.idArme = idArme;
        this.idOperateur = idOperateur;
    }

    public int getIdArme(){
        return idArme;
    }

    public int getIdOperateur(){
        return idOperateur;
    }
}
