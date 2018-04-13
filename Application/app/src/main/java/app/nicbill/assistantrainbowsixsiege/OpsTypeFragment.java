package app.nicbill.assistantrainbowsixsiege;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.SQLite.DBHelper;

public class OpsTypeFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    DBHelper dbHelper;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.ops_type_fragment, null);

        // get the listview
        expListView = v.findViewById(R.id.expTypeList);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return v;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<String> attList = new ArrayList<>();
        // Adding child data

        listDataHeader.add("Attaquants");
        listDataHeader.add("Défenseurs");

        List<String> defList = new ArrayList<>();
        defList.add("Pulse");
        defList.add("Castle");
        defList.add("Kapkan");
        defList.add("Tachanka");
        defList.add("Mute");
        defList.add("Smoke");


        listDataChild.put(listDataHeader.get(0), attList);
        listDataChild.put(listDataHeader.get(1), defList);
    }
}
