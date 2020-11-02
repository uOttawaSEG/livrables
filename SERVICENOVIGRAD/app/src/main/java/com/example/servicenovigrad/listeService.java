package com.example.servicenovigrad;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class listeService extends AppCompatActivity {

    TextView tex1,tex2,tex3;
    ListView listViewservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_service);

        tex1=(TextView) findViewById(R.id.textViewpermit);
        tex2=(TextView) findViewById(R.id.textViewcarte);
        tex1=(TextView) findViewById(R.id.textViewPiece);
    }


}