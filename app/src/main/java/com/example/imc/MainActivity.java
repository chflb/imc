package com.example.imc;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
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

public class MainActivity extends AppCompatActivity {
    // La chaîne de caractères par défaut
    private final String defaut = "Vous devez cliquer sur le bouton « Calculer l'IMC » pour obtenir un résultat.";

    Button envoyer = null;
    Button raz = null;

    EditText poids = null;
    EditText taille = null;

    RadioGroup group = null;

    TextView result = null;

    CheckBox mega = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // **************On récupère toutes les vues dont on a besoin*************

        envoyer = (Button) findViewById(R.id.calcul);

        raz = (Button) findViewById(R.id.raz);

        taille = (EditText) findViewById(R.id.taille);
        poids = (EditText) findViewById(R.id.poids);


        group = (RadioGroup) findViewById(R.id.group);

        result = (TextView) findViewById(R.id.result);


        // *************** On attribue un listener au bouton envoyer ********

        envoyer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // On récupère la taille
                String t = taille.getText().toString();
                // On récupère le poids
                String p = poids.getText().toString();

                float tValue = Float.valueOf(t);

                // Puis on vérifie que la taille est cohérente
                if (tValue == 0)
                    Toast.makeText(MainActivity.this,
                            "Hého, tu es un Minipouce ou quoi ?",
                            Toast.LENGTH_SHORT).show();
                else {
                    float pValue = Float.valueOf(p);
                    // Si l'utilisateur a indiqué que la taille était en
                    // centimètres
                    // On vérifie que la Checkbox sélectionnée est la deuxième à
                    // l'aide de son identifiant
                    if (group.getCheckedRadioButtonId() == R.id.radio2)
                        tValue = tValue / 100;

                    tValue = (float) Math.pow(tValue, 2);
                    float imc = pValue / tValue;
                    result.setText("Votre IMC est " + String.valueOf(imc));
                }

            }
        });


        // *************** On attribue un listener au bouton RAZ ********

        raz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                poids.getText().clear();
                taille.getText().clear();
                result.setText(defaut);
            }
        });


        // *************** On attribue un listener au EditText taille ********

        taille.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                result.setText(defaut);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // *************** On attribue un listener au EditText poids ********

        poids.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                result.setText(defaut);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}