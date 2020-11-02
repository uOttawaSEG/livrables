package com.example.servicenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choixdusubscribe extends AppCompatActivity {

    Button btnc,btnu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choixdusubscribe);

        btnc = (Button) findViewById(R.id.buttonCLIENTCHOIX);
        btnu = (Button) findViewById(R.id.buttonUTILISATEURCHOIX);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),subscribe.class);
                startActivityForResult(c,0);
            }
        });
        btnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),subscribe.class);
                startActivityForResult(c,0);
            }
        });
    }
}