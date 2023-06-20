package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityForDs extends AppCompatActivity {
    // La chaîne de caractères par défaut
    private final String defaut = "Vous devez cliquer sur le bouton « Calculer l'IMC » pour obtenir un résultat.";


    EditText poids = null;
    EditText taille = null;


    TextView envoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_ds);

        // **************On récupère toutes les vues dont on a besoin*************


        taille = (EditText) findViewById(R.id.taille);
        poids = (EditText) findViewById(R.id.poids);
        envoyer = (Button) findViewById(R.id.calcul);



        envoyer.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                // On récupère la taille
                String t = taille.getText().toString();
                // On récupère le poids
                String p = poids.getText().toString();

                float tValue = Float.valueOf(t);

                // Puis on vérifie que la taille est cohérente
                if (tValue == 0)
                    Toast.makeText(getApplicationContext(),
                            "La taille ne peut pas être nulle",
                            Toast.LENGTH_SHORT).show();
                else {
                    float pValue = Float.valueOf(p);

                    tValue = (float) Math.pow(tValue, 2);
                    float imc = pValue / tValue;


                    Intent i =new Intent();
                    i.putExtra("imc", imc);
                    setResult(RESULT_OK,i);
                    finish();

                }

            }
        });



    }
}