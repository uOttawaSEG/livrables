package com.example.servicenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class connexrecu extends AppCompatActivity {
    TextView textViewconnex;
    DatabaseReference ServiceDatabase;
    Button button,btnl,btnc,btnm,btns,btnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexrecu);
        ServiceDatabase = FirebaseDatabase.getInstance().getReference("Service");
        textViewconnex = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        btnl = (Button) findViewById(R.id.buttonL);
        btnc = (Button) findViewById(R.id.buttonC);
        btnm = (Button) findViewById(R.id.buttonM);
        btns = (Button) findViewById(R.id.buttonS);
        btnv = (Button ) findViewById(R.id.buttonV);
        Intent intent = getIntent();
        if(intent != null ){
            String str ="";
            if (intent.hasExtra("gros")){
                str = intent.getStringExtra("gros");
                textViewconnex.setText(str);
            }
        }
        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),listeService.class);
                startActivityForResult(c,0);
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),creerservice.class);
                startActivityForResult(c,0);
            }
        });

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = "Permis de residence";
                String formulaire = "rien";

                String id =ServiceDatabase.push().getKey();
                Service service = new Service(nom, formulaire);

                ServiceDatabase.child(id).setValue(service);
            }
        });*/
    }


}