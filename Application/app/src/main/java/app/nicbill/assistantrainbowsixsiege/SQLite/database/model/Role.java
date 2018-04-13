package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Role {

    public static final String TABLE_NAME = "role";

    private int idRole;
    private String nomRole;

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
