package com.example.servicenovigrad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class subscribe2 extends AppCompatActivity {
    TextView textViewconnex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe2);

        textViewconnex = (TextView) findViewById(R.id.textViewmodifier);

        Intent intent = getIntent();
        if(intent != null ){
            String str ="";
            if (intent.hasExtra("gros")){
                str = intent.getStringExtra("gros");
                textViewconnex.setText(str);
            }
        }
    }
}