package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class Accessoire {

    public static final String TABLE_NAME = "accessoire";
    private int idAccessoire;
    private String nomAccessoire;
    private String cheminImageAccessoire;
    private int idTypeAccessoire;

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
