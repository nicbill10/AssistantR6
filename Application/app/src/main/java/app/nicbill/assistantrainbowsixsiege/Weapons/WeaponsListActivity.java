package app.nicbill.assistantrainbowsixsiege.Weapons;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.Ops.OpsPagerAdapter;
import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CArme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.TypeArme;

public class WeaponsListActivity extends AppCompatActivity {


    WeaponsExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<TypeArme> listDataHeader;
    HashMap<TypeArme, List<Arme>> listDataChild;
    CArme cArme = new CArme(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons_list);

        // get the listview
        expListView = findViewById(R.id.expTypeArmeList);

        // preparing list data
        prepareListData();

        listAdapter = new WeaponsExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Intent i = new Intent(parent.getContext(),WeaponsInfosActivity.class);
                i.putExtra("WEAPON_ID", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getIdArme());
                startActivity(i);
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        List<Arme> listWeapons;
        List<TypeArme> listType = cArme.getWeaponsTypes();

        for(TypeArme type: listType) {

            listDataHeader.add(type);
            listWeapons = cArme.getWeaponsbyType(type.getIdTypeArme());

            listDataChild.put(listDataHeader.get(listDataHeader.size()-1), listWeapons);

        }
    }
}

