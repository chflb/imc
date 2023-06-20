package com.example.imc;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button envoyer ;
    TextView imcTxt;
ActivityResultLauncher activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
    @Override
    public void onActivityResult(ActivityResult result) {
   if (result.getResultCode()==RESULT_OK) {
   Intent data=result.getData();
   float imc =data.getFloatExtra("imc", 0);
    imcTxt.setText(imc+"");

   }else if (result.getResultCode()==RESULT_CANCELED){

       }

    }
});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

imcTxt=(TextView)findViewById(R.id.imc);
        envoyer = (Button) findViewById(R.id.start);

        // *************** On attribue un listener au bouton envoyer ********

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MenuActivity.this, MainActivityForDs.class);
                activityResultLauncher.launch(i);
            }
        });

    }
}