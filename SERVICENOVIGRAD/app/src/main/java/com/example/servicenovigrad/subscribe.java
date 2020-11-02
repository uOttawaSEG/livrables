package com.example.servicenovigrad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class subscribe extends AppCompatActivity {

   private Button enregistrement;
    private EditText idnew , pswrnew ,nom ,prenom;
    private TextView text;
    private static String user ;
    private static String pass ;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

       enregistrement = (Button ) findViewById(R.id.buttonENREGISTRE);
        idnew = (EditText) findViewById(R.id.editTextTextEmailAddressMail);
        pswrnew = (EditText) findViewById(R.id.editTextNumberPasswordNew);
        nom = (EditText) findViewById(R.id.editTextTextPersonNameNOM) ;
       prenom = (EditText) findViewById( R.id.editTextTextPersonNamePRENOM);
        text = (TextView) findViewById(R.id.textViewCOMPTE);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
     /*   if(fAuth.getCurrentUser() !=null) {
           startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }*/

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(c,0);
            }
        });
        enregistrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = idnew.getText().toString().trim();
                pass = pswrnew.getText().toString().trim();
                String name = nom.getText().toString().trim();
                String prenoms= prenom.getText().toString().trim();
              if(TextUtils.isEmpty(user)){
                  idnew.setError("email is required ");
                  return ;
              }
              if(TextUtils.isEmpty((pass) )){
                    pswrnew.setError("le champ est vide ! ");
                    return;
                }
                if(TextUtils.isEmpty((name) )){
                    nom.setError("le champ est vide ! ");
                    return;
                }
                if(TextUtils.isEmpty((prenoms) )){
                    prenom.setError("le champ est vide ! ");
                    return;
                }


              if(pass.length() <6){
                    pswrnew.setError("le mot de pass doit avoir 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                //ENREGISTREMENT
                fAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(subscribe.this, "le client a été crée avec succès", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(subscribe.this, "error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });


    }
}