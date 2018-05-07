package app.nicbill.assistantrainbowsixsiege;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CArme;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CGadget;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.COperateurs;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;

public class OpsInfosActivity extends AppCompatActivity {

    String opName;
    COperateurs cOperateurs;
    CGadget cGadget;
    CArme cArme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ops_infos);

        cOperateurs = new COperateurs(this);
        cGadget = new CGadget(this);
        opName = getIntent().getStringExtra("OP_NAME");
        cArme = new CArme(this);

        PreparerView();
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    private void PreparerView(){
        HashMap<String, String> hmOpsInfo = cOperateurs.getInfoOperateur(opName);
        HashMap<String, String> hmGadgets = cGadget.getOpGadgetList(opName);

        ImageView imageOp = findViewById(R.id.imageOperateur);
        ImageView iconOp = findViewById(R.id.icon_ops_info);
        ImageView iconType = findViewById(R.id.imageTypeOp);
        ImageView imageSpeedDef = findViewById(R.id.imageSpeedDef);
        ImageView imageGadgetUnique = findViewById(R.id.imageGadgetUnique);
        ImageView imageGadget1 = findViewById(R.id.imageGadget1);
        ImageView imageGadget2 = findViewById(R.id.imageGadget2);

        ImageButton btnIconCTU = findViewById(R.id.ctuBtn);
        TextView txtCodeOp = findViewById(R.id.nomCodeOp);
        TextView txtNomOp = findViewById(R.id.nomReelOperateur);
        TextView txtCTU = findViewById(R.id.abrevCtuOp);
        TextView txtDDN = findViewById(R.id.ddn);
        TextView txtTypeOp = findViewById(R.id.txtTypeOp);
        TextView txtGadgetUnique = findViewById(R.id.txtGadUnique);
        TextView txtGadget1 = findViewById(R.id.txtGadget1);
        TextView txtGadget2 = findViewById(R.id.txtGadget2);

        EditText txtBio = findViewById(R.id.bioOp);
        EditText descGadgetUnique = findViewById(R.id.descGadgetUnique);
        List<String> gadgetList = new ArrayList<>();
        List<String> qteGadgetList = new ArrayList<>();

        //boucle for pour afficher les gadgets
        for (Map.Entry me : hmGadgets.entrySet()) {
            gadgetList.add(me.getKey().toString());
            qteGadgetList.add(me.getValue().toString());
        }

        //boucle for pour afficher les armes
        GenererListeArme();



        int imageOpID = this.getResources().getIdentifier("drawable/image_operateur_" + hmOpsInfo.get("nomCode").toLowerCase() + "_min", null, this.getPackageName());
        int iconOpID = this.getResources().getIdentifier("drawable/icone_operateur_" + hmOpsInfo.get("nomCode").toLowerCase() + "_min", null, this.getPackageName());
        int iconCtuID = this.getResources().getIdentifier("drawable/icone_ctu_" + hmOpsInfo.get("idCTU"), null, this.getPackageName());
        int imageSpeedDefID = this.getResources().getIdentifier("drawable/type_op_" + hmOpsInfo.get("vitesse") + "_" + hmOpsInfo.get("armure"), null, this.getPackageName());
        int imageGadgetUniqueID = this.getResources().getIdentifier("drawable/gadget_unique_" + hmOpsInfo.get("idOperateur"), null, this.getPackageName());
        int imageGadget1ID = this.getResources().getIdentifier("drawable/gadget_" + cGadget.getGadgetID(gadgetList.get(0)), null, this.getPackageName());
        int imageGadget2ID = this.getResources().getIdentifier("drawable/gadget_" + cGadget.getGadgetID(gadgetList.get(1)), null, this.getPackageName());
        int iconTypeID = 0;
        imageOp.setImageResource(imageOpID);
        iconOp.setImageResource(iconOpID);
        btnIconCTU.setImageResource(iconCtuID);
        imageSpeedDef.setImageResource(imageSpeedDefID);
        imageGadgetUnique.setImageResource(imageGadgetUniqueID);
        txtCodeOp.setText(hmOpsInfo.get("nomCode"));
        txtNomOp.setText(hmOpsInfo.get("nomOperateur"));
        txtCTU.setText(hmOpsInfo.get("abrevCTU"));
        txtDDN.setText(hmOpsInfo.get("ddn"));
        txtBio.setText(hmOpsInfo.get("bio"));
        txtGadgetUnique.setText(hmOpsInfo.get("nomCap"));
        descGadgetUnique.setText(hmOpsInfo.get("descCap"));
        imageGadget1.setImageResource(imageGadget1ID);
        imageGadget2.setImageResource(imageGadget2ID);
        txtGadget1.setText(gadgetList.get(0) + " x" + qteGadgetList.get(0));
        txtGadget2.setText(gadgetList.get(1) + " x" + qteGadgetList.get(1));

        switch (hmOpsInfo.get("type")){
            case "Attaquant":
                txtTypeOp.setText("Attaquant");
                iconTypeID = this.getResources().getIdentifier("drawable/icone_attaquant", null, this.getPackageName());
                break;

            case "Défenseur":
                txtTypeOp.setText("Défenseur");
                iconTypeID = this.getResources().getIdentifier("drawable/icone_defenseur", null, this.getPackageName());
                break;
        }
        iconType.setImageResource(iconTypeID);

        txtBio.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                }
                return false;
            }
        });

        descGadgetUnique.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                }
                return false;
            }
        });
    }

    private void GenererListeArme(){
        List<Arme> listArmesPrincipales = cArme.getOpWeaponsList(opName, "1");
        List<Arme> listArmesSecondaires = cArme.getOpWeaponsList(opName, "0");
        List<LinearLayout> listBtnArmesPrincipales = new ArrayList<>();
        List<LinearLayout> listBtnArmesSecondaires = new ArrayList<>();
        List<ImageView> listImageMainWeapons = new ArrayList<>();
        List<ImageView> listImageSideWeapons = new ArrayList<>();
        List<TextView> listTxtMainWeapons = new ArrayList<>();
        List<TextView> listTxtSideWeapons = new ArrayList<>();

        listImageMainWeapons.add((ImageView) findViewById(R.id.imageArme1));
        listImageMainWeapons.add((ImageView) findViewById(R.id.imageArme2));
        listImageMainWeapons.add((ImageView) findViewById(R.id.imageArme3));
        listImageSideWeapons.add((ImageView) findViewById(R.id.imageSideArme1));
        listImageSideWeapons.add((ImageView) findViewById(R.id.imageSideArme2));

        listTxtMainWeapons.add((TextView) findViewById(R.id.txtArme1));
        listTxtMainWeapons.add((TextView) findViewById(R.id.txtArme2));
        listTxtMainWeapons.add((TextView) findViewById(R.id.txtArme3));
        listTxtSideWeapons.add((TextView) findViewById(R.id.txtSideArme1));
        listTxtSideWeapons.add((TextView) findViewById(R.id.txtSideArme2));

        listBtnArmesPrincipales.add((LinearLayout) findViewById(R.id.btnArme1));
        listBtnArmesPrincipales.add((LinearLayout) findViewById(R.id.btnArme2));
        listBtnArmesPrincipales.add((LinearLayout) findViewById(R.id.btnArme3));
        listBtnArmesSecondaires.add((LinearLayout) findViewById(R.id.btnSideArme1));
        listBtnArmesSecondaires.add((LinearLayout) findViewById(R.id.btnSideArme2));

        int i = 0;
        for(Arme arme : listArmesPrincipales)
        {
            String nomArme = arme.getNomArme();
            String idArme = arme.getIdArme();
            int imageArmeID = this.getResources().getIdentifier("drawable/arme_" + idArme + "_min", null, this.getPackageName());
            listImageMainWeapons.get(i).setImageResource(imageArmeID);
            listTxtMainWeapons.get(i).setText(nomArme);
            listBtnArmesPrincipales.get(i).setTag(idArme);
            i++;
        }
        switch(listArmesPrincipales.size()){
            case 1:     listBtnArmesPrincipales.get(0).setVisibility(View.VISIBLE);
                listBtnArmesPrincipales.get(1).setVisibility(View.GONE);
                listBtnArmesPrincipales.get(2).setVisibility(View.GONE);
                break;

            case 2:     listBtnArmesPrincipales.get(0).setVisibility(View.VISIBLE);
                listBtnArmesPrincipales.get(1).setVisibility(View.VISIBLE);
                listBtnArmesPrincipales.get(2).setVisibility(View.GONE);
                break;

            case 3:     listBtnArmesPrincipales.get(0).setVisibility(View.VISIBLE);
                listBtnArmesPrincipales.get(1).setVisibility(View.VISIBLE);
                listBtnArmesPrincipales.get(2).setVisibility(View.VISIBLE);
                break;
        }

        i = 0;
        for(Arme arme : listArmesSecondaires)
        {
            String nomArme = arme.getNomArme();
            String idArme = arme.getIdArme();
            int imageArmeID = this.getResources().getIdentifier("drawable/arme_" + idArme + "_min", null, this.getPackageName());
            listImageSideWeapons.get(i).setImageResource(imageArmeID);
            listTxtSideWeapons.get(i).setText(nomArme);
            listBtnArmesSecondaires.get(i).setTag(idArme);
            i++;
        }
        switch(listArmesSecondaires.size()){
            case 1:     listBtnArmesSecondaires.get(0).setVisibility(View.VISIBLE);
                listBtnArmesSecondaires.get(1).setVisibility(View.GONE);
                break;

            case 2:     listBtnArmesSecondaires.get(0).setVisibility(View.VISIBLE);
                listBtnArmesSecondaires.get(1).setVisibility(View.VISIBLE);
                break;
        }
    }
}
