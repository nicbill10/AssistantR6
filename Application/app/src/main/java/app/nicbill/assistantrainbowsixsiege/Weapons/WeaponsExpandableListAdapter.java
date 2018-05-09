package app.nicbill.assistantrainbowsixsiege.Weapons;
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
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.Arme;
import app.nicbill.assistantrainbowsixsiege.SQLite.database.model.TypeArme;

public class WeaponsExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity _context;
    private List<TypeArme> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<TypeArme, List<Arme>> _listDataChild;

    public WeaponsExpandableListAdapter(Activity context, List<TypeArme> listDataHeader, HashMap<TypeArme, List<Arme>> listChildData) {
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

        final Arme childArme = (Arme) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert infalInflater != null;
            convertView = infalInflater.inflate(R.layout.list_item_weapon, null);
        }

        TextView txtListChild = convertView.findViewById(R.id.lbl_weapon_list);
        ImageView iconListChild = convertView.findViewById(R.id.icon_weapon_list);

        int imageID = _context.getResources().getIdentifier("drawable/arme_" + childArme.getIdArme() + "_min", null, _context.getPackageName());
        txtListChild.setText(childArme.getNomArme());
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
        TypeArme headerTitle = (TypeArme) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_weapon, null);
        }

        ImageView imageType = convertView.findViewById(R.id.imageTypeArme);
        TextView lblListHeader = convertView.findViewById(R.id.lbl_weapon_group);
        lblListHeader.setText(headerTitle.getNomType());

        int imageID = _context.getResources().getIdentifier("drawable/type_arme_" + headerTitle.getIdTypeArme(), null, _context.getPackageName());
        imageType.setImageResource(imageID);
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