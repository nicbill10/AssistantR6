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

import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.CCTU;
import app.nicbill.assistantrainbowsixsiege.SQLite.controller.COperateurs;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.CTU;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Operateur;

public class OpsCTUFragment extends Fragment{

    OpsExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<GroupItem> listDataHeader;
    HashMap<GroupItem, List<Operateur>> listDataChild;
    COperateurs cOperateurs = new COperateurs(getContext());
    CCTU cCTU = new CCTU(getContext());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.ops_ctu_fragment, null);

        // get the listview
        expListView = v.findViewById(R.id.expCTUList);

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


    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        List<Operateur> listOps;
        List<CTU> listCTU = cCTU.getCTUList();

        for(CTU ctu: listCTU) {

            listDataHeader.add(new GroupItem(ctu.getIdCTU(), ctu.getAbrevCTU()));
            listOps = cOperateurs.getOpsListByCTU(ctu);

            listDataChild.put(listDataHeader.get(listDataHeader.size()-1), listOps);

        }
    }
}

