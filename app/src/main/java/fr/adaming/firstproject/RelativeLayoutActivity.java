package fr.adaming.firstproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fr.adaming.firstproject.data.Constante;

public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        this.setTitle("Relative Layout");
        findViews();
    }

    private RadioGroup radioGroup;
    private RadioButton radioJaime;
    private RadioButton jaimepas;
    private EditText editText1;
    private LinearLayout buttonsLayout;
    private Button button4;
    private Button button3;
    private String value = "New Text";

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-07-04 15:43:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioJaime = (RadioButton) findViewById(R.id.radio_jaime);
        jaimepas = (RadioButton) findViewById(R.id.jaimepas);
        editText1 = (EditText) findViewById(R.id.editText1);
        buttonsLayout = (LinearLayout) findViewById(R.id.buttonsLayout);
        button4 = (Button) findViewById(R.id.button4);
        button3 = (Button) findViewById(R.id.button3);

        radioJaime.setOnClickListener(this);
        jaimepas.setOnClickListener(this);
        button4.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-07-04 15:43:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == radioJaime) {
            Log.w(Constante.TAG, radioJaime.getText().toString());
            value = radioJaime.getText().toString();
        } else if (v == jaimepas) {
            Log.w(Constante.TAG, jaimepas.getText().toString());
            value = jaimepas.getText().toString();
        } else if (v == button4) {
            Log.w(Constante.TAG, "button4");
            valider();
        } else if (v == button3) {
            Log.w(Constante.TAG, "button3");
            annuler();
        }
    }

    public void valider() {
        editText1.setText(value);
    }

    public void annuler() {
        value = "New Text";
        editText1.setText(value);
        radioGroup.clearCheck();
    }


}
