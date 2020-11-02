package com.example.novigrad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientRg extends AppCompatActivity {

    private EditText nom_client, prenom_client,pass_client,mail_client;
    private Button inscrire_client;

    DatabaseReference databaseClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_rg);
        nom_client = (EditText)findViewById(R.id.etRecueillirNom);
        prenom_client = (EditText)findViewById(R.id.etRecueillirPrenom);
        pass_client = (EditText)findViewById(R.id.etRecueillirMotDePasse);
        mail_client = (EditText)findViewById(R.id.etRecueillirMail);
        inscrire_client = (Button)findViewById(R.id.btnInscriptionClient);

        databaseClient = FirebaseDatabase.getInstance().getReference("Client");

        inscrire_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addClient();
            }
        });



    }

    private void addClient()
    {


        String name = prenom_client.getText().toString().trim();
        String LastName  = nom_client.getText().toString().trim();
        String email = mail_client.getText().toString().trim();
        String password = pass_client.getText().toString().trim();
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(LastName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
        {

            EmployeHelperClass employeHelperClass = new EmployeHelperClass(LastName,name,email,password);

            databaseClient.child(name).setValue(employeHelperClass);

            Toast.makeText(this, "Client Ajouté ", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this, "Entrez des valeurs valides ", Toast.LENGTH_SHORT).show();
        }
    }
}
