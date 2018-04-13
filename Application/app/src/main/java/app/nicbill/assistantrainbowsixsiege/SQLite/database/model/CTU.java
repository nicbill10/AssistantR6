package app.nicbill.assistantrainbowsixsiege.SQLite.database.model;

public class CTU {

    public static final String TABLE_NAME = "ctu";

    private int idCTU;
    private String nomCTU;
    private String abrevCTU;
    private String locationCTU;
    private String descCTU;

    public CTU(int idCTU, String nomCTU, String abrevCTU, String locationCTU, String descCTU) {
        this.idCTU = idCTU;
        this.nomCTU = nomCTU;
        this.abrevCTU = abrevCTU;
        this.locationCTU = locationCTU;
        this.descCTU = descCTU;
    }

    public int getIdCTU(){
        return idCTU;
    }

    public String getNomCTU(){
        return nomCTU;
    }
    public void setNomCTU(String nomCTU){
        this.nomCTU = nomCTU;
    }

    public String getAbrevCTU(){
        return abrevCTU;
    }
    public void setAbrevCTU(String abrevCTU){
        this.abrevCTU = abrevCTU;
    }

    public String getLocationCTU(){
        return locationCTU;
    }
    public void setLocationCTU(String locationCTU){
        this.locationCTU = locationCTU;
    }

    public String getDescCTU(){
        return descCTU;
    }
    public void setDescCTU(String descCTU){
        this.descCTU = descCTU;
    }
}
