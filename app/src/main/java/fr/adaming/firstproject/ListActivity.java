package fr.adaming.firstproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import fr.adaming.firstproject.Adapter.EleveAdapter;
import fr.adaming.firstproject.data.Constante;
import fr.adaming.firstproject.entity.Eleve;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private MonAT chargementEleveAT = null;

    private Switch switch1;

    private Button button6;
    private Button button8;

    private EditText nom;
    private EditText prenom;


    //Création
    private ListView lv;
    private List<Eleve> eleveList;
    private EleveAdapter eleveAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.setTitle("List");

        nom = (EditText) findViewById(R.id.editTextNom);
        prenom = (EditText) findViewById(R.id.editTextPrenom);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        switch1 = (Switch) findViewById(R.id.switch1);

        eleveList = new ArrayList<Eleve>();
        eleveList.add(new Eleve("FOURQUET", "Raphael"));
        eleveList.add(new Eleve("TESTFEMALE", false, "Audrey"));
        eleveAdapter = new EleveAdapter(this, eleveList);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(eleveAdapter);

//        TextView tv = (TextView) this.findViewById(R.id.eleve_nom);
//        tv.setTextColor(Color.RED);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button6):
                eleveList.add(new Eleve(nom.getText().toString(), (!switch1.isChecked()), prenom.getText().toString()));
                //eleveList.add(new Eleve("FOURQUET", "Raphael"));
                eleveAdapter.notifyDataSetChanged();
                break;
            case (R.id.button8):
                Log.w(Constante.TAG, "Load");
                if (chargementEleveAT == null || chargementEleveAT.getStatus() == AsyncTask.Status.FINISHED) {
                    chargementEleveAT = new MonAT();
                }
                if (chargementEleveAT.getStatus() == AsyncTask.Status.PENDING) {
                    chargementEleveAT.execute();
                }
                break;
            default:
                Log.w(Constante.TAG, "Not supposed to happen");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Appel des que ce n'est plus affiche à l'ecran

        if (chargementEleveAT != null) {
            chargementEleveAT.cancel(true);
        }

    }

    private class MonAT extends AsyncTask<Void, Void, ArrayList<Eleve>> {

        private ProgressDialog pg;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Lancer la progressDialog
            pg = ProgressDialog.show(ListActivity.this, "ProgressDialog", "En cours ...");
        }

        @Override
        protected ArrayList<Eleve> doInBackground(Void... params) {
            ArrayList<Eleve> temp = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                temp.add(new Eleve("Eleve_" + i, "prenom" + i));
                temp.add(new Eleve("EleveF_" + i, false, "prenom" + i));
                SystemClock.sleep(500);
            }
            return temp;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            Log.w(Constante.TAG, "In Progress");
        }

        @Override
        protected void onPostExecute(ArrayList<Eleve> eleves) {
            super.onPostExecute(eleves);
            if (!isCancelled()) {   //Pour ne pas appeler dismiss si on a annule le traitement
                //Enlever la progressDialog
                pg.dismiss();

                eleveList.addAll(eleves);
                eleveAdapter.notifyDataSetChanged();
            }
        }
    }
}
