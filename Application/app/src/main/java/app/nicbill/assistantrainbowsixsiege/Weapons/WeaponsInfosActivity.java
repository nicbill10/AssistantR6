package app.nicbill.assistantrainbowsixsiege.Weapons;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.Ops.OpsInfosActivity;
import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CArme;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.COperateurs;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Accessoire;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Operateur;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.TypeArme;

public class WeaponsInfosActivity extends AppCompatActivity {

    String weaponID;
    CArme cArme;
    COperateurs cOperateurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_infos);
        weaponID = getIntent().getStringExtra("WEAPON_ID");
        cArme = new CArme(this);
        cOperateurs = new COperateurs(this);
        PreparerView();
    }

    private void PreparerView(){
        Arme arme = cArme.getWeaponInfo(weaponID);
        TypeArme typeArme = cArme.getType(weaponID);
        List<Operateur> listOpsArme = cOperateurs.getOpsListByWeapon(weaponID);
        List<Accessoire> listAccessoireArme = cArme.getAttachements(weaponID);
        setTitle(arme.getNomArme());
        AfficherIconOps(listOpsArme);
        GenererInfosArme(arme, typeArme);
        AfficherAttachements(listAccessoireArme);
    }

    @SuppressLint("SetTextI18n")
    private void GenererInfosArme(Arme arme, TypeArme typeArme){

        ImageView imageArme = findViewById(R.id.image_weapon);
        TextView nomArme = findViewById(R.id.lbl_weapon);
        ImageView imageTypeArme = findViewById(R.id.image_type_weapon);
        TextView nomTypeArme = findViewById(R.id.lbl_type_weapon);
        TextView txtCalibre = findViewById(R.id.txtCalibre);
        TextView txtMagSize = findViewById(R.id.txtMagSize);
        TextView txtMaxAmmo = findViewById(R.id.txtMaxAmmo);
        TextView txtFireRate = findViewById(R.id.txtFireRate);

        int imageArmeID = this.getResources().getIdentifier("drawable/arme_" + arme.getIdArme() + "_min", null, this.getPackageName());
        int imageTypeArmeID = this.getResources().getIdentifier("drawable/type_arme_" + typeArme.getIdTypeArme(), null, this.getPackageName());

        String maxAmmo = arme.getMaxAmmo() + " + " + arme.getMagSize();
        String magSize = arme.getMagSize() + " + 1";
        String fireRate = arme.getFireRate() + " RPM";

        imageArme.setImageResource(imageArmeID);
        nomArme.setText(arme.getNomArme());
        imageTypeArme.setImageResource(imageTypeArmeID);
        nomTypeArme.setText(typeArme.getNomType());

        if(arme.getMagSize() == null){
            txtCalibre.setText("Aucune");
            txtCalibre.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            txtMagSize.setText("Aucune");
            txtMaxAmmo.setText("Aucune");
            txtFireRate.setText("Aucune");
        }
        else{
            txtCalibre.setText(arme.getCalibreBalle());
            txtMagSize.setText(magSize);
            txtMaxAmmo.setText(maxAmmo);
            txtFireRate.setText(fireRate);
        }
    }

    private void AfficherIconOps(List<Operateur> listOps){

        LinearLayout opsLayout = findViewById(R.id.layoutArmeOps);

        for(final Operateur ops: listOps){

            int imageOpID = this.getResources().getIdentifier("drawable/icone_operateur_" + ops.getNomCode().toLowerCase() + "_min_tn", null, this.getPackageName());

            ImageView imageOp = new ImageView(getApplicationContext());

            int layoutSizeDP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());
            int marginDP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(layoutSizeDP,layoutSizeDP);
            params.setMargins(marginDP,0,marginDP,0);

            imageOp.setImageResource(imageOpID);
            imageOp.setLayoutParams(params);
            opsLayout.addView(imageOp);

            /*

            **ERREUR DE MÉMOIRE SI ACTIVÉ**

            imageOp.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), OpsInfosActivity.class);
                        i.putExtra("OP_NAME", ops.getNomCode());
                        startActivity(i);
                    }

                }
            );

            */
        }
    }

    private void AfficherAttachements(List<Accessoire> listAccessoire){

        List<LinearLayout> listLayoutAttach = new ArrayList<>();

        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach1));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach2));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach3));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach4));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach5));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach6));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach7));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach8));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach9));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach10));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach11));
        listLayoutAttach.add((LinearLayout)findViewById(R.id.layoutAttach12));

        for (Accessoire attach: listAccessoire){

            listLayoutAttach.get(attach.getIdAccessoire() - 1).setVisibility(View.VISIBLE);
        }
    }
}
