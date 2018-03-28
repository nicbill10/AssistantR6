package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Accessoire {

    public static final String TABLE_NAME = "accessoire";

    public static final String COLUMN_IDACCESSOIRE = "idAccessoire";
    public static final String COLUMN_NOMACCESSOIRE = "nomAccessoire";
    public static final String COLUMN_CHEMINIMAGEACCESSOIRE = "cheminImageAccessoire";
    public static final String COLUMN_IDTYPEACCESSOIRE = "idTypeAccessoire";

    private int idAccessoire;
    private String nomAccessoire;
    private String cheminImageAccessoire;
    private int idTypeAccessoire;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDACCESSOIRE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMACCESSOIRE + " TEXT,"
                    + COLUMN_CHEMINIMAGEACCESSOIRE + " TEXT,"
                    + COLUMN_IDTYPEACCESSOIRE + " INT"
                    + ")";

    public Accessoire(int idAccessoire, String nomAccessoire, String cheminImageAccessoire, int idTypeAccessoire) {
        this.idAccessoire = idAccessoire;
        this.nomAccessoire = nomAccessoire;
        this.cheminImageAccessoire = cheminImageAccessoire;
        this.idTypeAccessoire = idTypeAccessoire;
    }

    public int getIdAccessoire(){
        return idAccessoire;
    }

    public String getNomAccessoire(){
        return nomAccessoire;
    }
    public void setNomAccessoire(String nomAccessoire){
        this.nomAccessoire = nomAccessoire;
    }

    public String getCheminImageAccessoire(){
        return cheminImageAccessoire;
    }
    public void setCheminImageAccessoire(String cheminImageAccessoire){
        this.cheminImageAccessoire = cheminImageAccessoire;
    }

    public int getIdTypeAccessoire(){
        return idTypeAccessoire;
    }
    public void setIdTypeAccessoire(int idTypeAccessoire){
        this.idTypeAccessoire = idTypeAccessoire;
    }
}
