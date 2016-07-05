package fr.adaming.firstproject.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.adaming.firstproject.data.Constante;
import fr.adaming.firstproject.R;
import fr.adaming.firstproject.entity.Eleve;

/**
 * Created by INTI-0332 on 04/07/2016.
 */
public class EleveAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Eleve> eleveList;

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    public EleveAdapter(Context context, List<Eleve> eleveList) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.eleveList = eleveList;
    }

    @Override
    public int getCount() {
        return eleveList.size();
    }

    @Override
    public Eleve getItem(int position) {
        return eleveList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View rowView, ViewGroup parent) {
        //Recyclage via rowView
        if(rowView == null) {
            Log.w(Constante.TAG, "Creation cellule");
            //création
            rowView = mInflater.inflate(R.layout.eleve_cellule, null);
        } else {
            Log.w(Constante.TAG, "Recyclage cellule");
        }

        //Recuperer les infos
        TextView tv_nom = (TextView) rowView.findViewById(R.id.eleve_nom);
        TextView tv_prenom = (TextView) rowView.findViewById(R.id.eleve_prenom);

        //on remplit avec l'objet voulu
        Eleve eleve = getItem(position);
        tv_nom.setText(eleve.getNom());
        tv_prenom.setText(eleve.getPrenom());
        if(!eleve.isMale()) {
            tv_nom.setTextColor(Color.RED);
            tv_prenom.setTextColor(Color.RED);
        } else {
            tv_nom.setTextColor(Color.BLACK);
            tv_prenom.setTextColor(Color.BLACK);
        }

        return rowView;
    }

}
