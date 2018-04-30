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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CGadget;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.COperateurs;

public class OpsInfosActivity extends AppCompatActivity {

    String opName;
    COperateurs cOperateurs;
    CGadget cGadget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ops_infos);

        cOperateurs = new COperateurs(this);
        cGadget = new CGadget(this);
        opName = getIntent().getStringExtra("OP_NAME");

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

        for (Map.Entry me : hmGadgets.entrySet()) {
            gadgetList.add(me.getKey().toString());
            qteGadgetList.add(me.getValue().toString());
        }

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
                txtTypeOp.setText("Defenseur");
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
}
