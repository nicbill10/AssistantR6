package app.nicbill.assistantrainbowsixsiege.Ops;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import app.nicbill.assistantrainbowsixsiege.R;

public class OperatorsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the  activity_main.xml layout file
        setContentView(R.layout.activity_operators_list);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.ops_pager);

        // Create an adapter that knows which fragment should be shown on each page
        OpsPagerAdapter adapter = new OpsPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.ops_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
