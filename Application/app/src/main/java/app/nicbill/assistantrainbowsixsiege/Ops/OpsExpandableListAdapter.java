package app.nicbill.assistantrainbowsixsiege.Ops;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.nicbill.assistantrainbowsixsiege.R;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Operateur;

public class OpsExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity _context;
    private List<GroupItem> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<GroupItem, List<Operateur>> _listDataChild;

    public OpsExpandableListAdapter(Activity context, List<GroupItem> listDataHeader, HashMap<GroupItem, List<Operateur>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Operateur operateur = (Operateur) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert infalInflater != null;
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = convertView.findViewById(R.id.lbl_ops_list);
        ImageView iconListChild = convertView.findViewById(R.id.icon_ops_list);

        int imageID = _context.getResources().getIdentifier("drawable/icone_operateur_" + operateur.getNomCode().toLowerCase() + "_min_tn", null, _context.getPackageName());
        txtListChild.setText(operateur.getNomCode());
        iconListChild.setImageResource(imageID);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupItem headerTitle = (GroupItem) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView imageHeader = convertView.findViewById(R.id.imageOpsHeader);
        ImageView imageDrapeau = convertView.findViewById(R.id.drapeauCTU);

        int imageID = _context.getResources().getIdentifier("drawable/icone_list_ops_" + headerTitle.getIdImageGI(), null, _context.getPackageName());
        int drapeauID = _context.getResources().getIdentifier("drawable/drapeau_" + headerTitle.getIdImageGI(), null, _context.getPackageName());
        imageHeader.setImageResource(imageID);
        imageDrapeau.setImageResource(drapeauID);

        TextView lblListHeader = convertView.findViewById(R.id.lbl_type_ops);
        lblListHeader.setText(headerTitle.getNomGI());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}