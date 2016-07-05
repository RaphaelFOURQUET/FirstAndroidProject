package fr.adaming.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import fr.adaming.firstproject.data.Constante;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button2;
    private Button button5;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Constante.LOG_DEV_MODE) {
            Log.w(Constante.TAG, "onCreate");
        }

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button5 = (Button) findViewById(R.id.button5);
        button7 = (Button) findViewById(R.id.button7);
        button.setOnClickListener(this);    //Methode 1 : + implements + onClick
        button2.setOnClickListener(this);    //Methode 1 : + implements + onClick
        button5.setOnClickListener(this);
        button7.setOnClickListener(this);
//        //Methode 2
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Constante.LOG_DEV_MODE) {
//                    Log.w(Constante.TAG, "onClick");
//                }
//                activity2(v);
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        if (Constante.LOG_DEV_MODE) {
            Log.w(Constante.TAG, "onClick");
        }
        switch (v.getId()) {
            case (R.id.button):
                activity2(v);
                break;
            case (R.id.button2):
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case (R.id.button5):
                startActivity(new Intent(this, ListActivity.class));
                break;
            case (R.id.button7):
                Toast.makeText(MainActivity.this, "I'm a Toast!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.w(Constante.TAG, "Switch : default case not supposed to happen.");
        }
    }

    public void activity2(View view) {
        // Paramètre
        //intent.putExtra("Cle", "Hello fromMainActivity");
        startActivity(new Intent(this, SecondActivity.class));
        // Tuer l’activité courante
        //finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Constante.LOG_DEV_MODE) {
            Log.w(Constante.TAG, "onResume");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Constante.LOG_DEV_MODE) {
            Log.w(Constante.TAG, "onDestroy");
        }
    }

}
