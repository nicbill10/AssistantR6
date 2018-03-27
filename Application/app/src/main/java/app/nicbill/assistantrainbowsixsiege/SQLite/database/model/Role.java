package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Role {

    public static final String TABLE_NAME = "role";

    public static final String COLUMN_IDROLE = "idRole";
    public static final String COLUMN_NOMROLE = "nomRole";

    private int idRole;
    private String nomRole;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_IDROLE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NOMROLE + " TEXT"
                    + ")";

    public Role(int idRole, String nomRole) {
        this.idRole = idRole;
        this.nomRole = nomRole;
    }

    public int getIdRole(){
        return idRole;
    }

    public String getNomRole(){
        return nomRole;
    }
    public void setNomRole(String nomRole){
        this.nomRole = nomRole;
    }
}
