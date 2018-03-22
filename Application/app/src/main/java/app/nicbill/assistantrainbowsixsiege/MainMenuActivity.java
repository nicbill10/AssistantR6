package app.nicbill.assistantrainbowsixsiege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    public Button btnOps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnOps = findViewById(R.id.btnOperateurs);

        btnOps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent i = new Intent(MainMenuActivity.this, OperatorsActivity.class);
                startActivity(i);
            }
        });
    }
}
