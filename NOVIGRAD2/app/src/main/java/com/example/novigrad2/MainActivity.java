package com.example.novigrad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private EditText password ;
    private Button login;
    private Button signup;
    EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.etNOM);
        password = (EditText) findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btnLogin);
        signup = (Button)findViewById(R.id.btnSignUP);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // comparer les informations pour savoir si il peut visiter le portail administrateur
               String id  = userName.getText().toString();
               String pass = password.getText().toString();

                Intent intentA = new Intent(getApplicationContext(),PortailAdministrateur.class);
                startActivity(intentA);

               if ( id == "SCIO" && pass == "ABC")
               {
                   Intent intenti = new Intent(getApplicationContext(),PortailAdministrateur.class);
                   startActivity(intenti);
               }

            }

        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUPRedirection.class);
                startActivity(intent);
            }
        });

    }
}