package app.nicbill.assistantrainbowsixsiege.Weapons;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CArme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.TypeArme;

public class WeaponsInfosActivity extends AppCompatActivity {

    String weaponID;
    CArme cArme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_infos);
        weaponID = getIntent().getStringExtra("WEAPON_ID");
        cArme = new CArme(this);
        PreparerView();
    }

    private void PreparerView(){
        Arme arme = cArme.getWeaponInfo(weaponID);
        TypeArme typeArme = cArme.getType(weaponID);
        setTitle(arme.getNomArme());
        GenererInfosArme(arme, typeArme);

    }

    private void GenererInfosArme(Arme arme, TypeArme typeArme){

        ImageView imageArme = findViewById(R.id.image_weapon);
        TextView nomArme = findViewById(R.id.lbl_weapon);
        ImageView imageTypeArme = findViewById(R.id.image_type_weapon);
        TextView nomTypeArme = findViewById(R.id.lbl_type_weapon);

        int imageArmeID = this.getResources().getIdentifier("drawable/arme_" + arme.getIdArme() + "_min", null, this.getPackageName());
        int imageTypeArmeID = this.getResources().getIdentifier("drawable/type_arme_" + typeArme.getIdTypeArme(), null, this.getPackageName());

        imageArme.setImageResource(imageArmeID);
        nomArme.setText(arme.getNomArme());
        imageTypeArme.setImageResource(imageTypeArmeID);
        nomTypeArme.setText(typeArme.getNomType());
    }
}
