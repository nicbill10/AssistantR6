package app.nicbill.assistantrainbowsixsiege;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.nicbill.assistantrainbowsixsiege.Ops.OperatorsListActivity;
import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;
import app.nicbill.assistantrainbowsixsiege.Weapons.WeaponsListActivity;

public class MainMenuActivity extends AppCompatActivity {

    public Button btnOps;
    Button btnArmes;
    DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        chargerBD();

        btnOps = findViewById(R.id.btnOperateurs);
        btnArmes = findViewById(R.id.btnArmes);

        btnOps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent i = new Intent(MainMenuActivity.this, OperatorsListActivity.class);
                startActivity(i);
            }
        });

        btnArmes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent i = new Intent(MainMenuActivity.this, WeaponsListActivity.class);
                startActivity(i);
            }
        });
    }

    private void chargerBD(){
        mDBHelper = new DBHelper(this);
        mDBHelper.openDatabase();
    }
}
