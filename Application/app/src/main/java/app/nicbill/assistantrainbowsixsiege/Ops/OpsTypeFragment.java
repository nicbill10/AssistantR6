package app.nicbill.assistantrainbowsixsiege.Ops;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.nicbill.assistantrainbowsixsiege.Ops.OpsExpandableListAdapter;
import app.nicbill.assistantrainbowsixsiege.Ops.OpsInfosActivity;
import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.COperateurs;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Operateur;

public class OpsTypeFragment extends Fragment {

    OpsExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<GroupItem> listDataHeader;
    HashMap<GroupItem, List<Operateur>> listDataChild;
    COperateurs cOperateurs = new COperateurs(this.getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.ops_type_fragment, null);

        // get the listview
        expListView = v.findViewById(R.id.expTypeList);

        // preparing list data
        prepareListData();

        listAdapter = new OpsExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Intent i = new Intent(parent.getContext(),OpsInfosActivity.class);
                i.putExtra("OP_NAME", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getNomCode());
                startActivity(i);
                return false;
            }
        });
        return v;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<Operateur> attList = cOperateurs.getOpsListByType("Attaquant");
        List<Operateur> defList = cOperateurs.getOpsListByType("Défenseur");

        listDataHeader.add(new GroupItem("att", "Attaquants"));
        listDataHeader.add(new GroupItem("def", "Défenseurs"));

        listDataChild.put(listDataHeader.get(0), attList);
        listDataChild.put(listDataHeader.get(1), defList);
    }

}

