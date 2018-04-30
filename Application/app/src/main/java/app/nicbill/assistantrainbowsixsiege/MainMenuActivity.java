package app.nicbill.assistantrainbowsixsiege;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;

public class MainMenuActivity extends AppCompatActivity {

    public Button btnOps;
    DBHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        chargerBD();

        btnOps = findViewById(R.id.btnOperateurs);

        btnOps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent i = new Intent(MainMenuActivity.this, OperatorsActivity.class);
                startActivity(i);
            }
        });
    }

    private void chargerBD(){
        mDBHelper = new DBHelper(this);
        mDBHelper.openDatabase();
    }
}
