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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private Button  connx , inscription ;
    private EditText id , pswr ;
    String user , passuser , userget, passuserget;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = "admin123@gmail.com";
        passuser = "123456789";
        connx = (Button ) findViewById(R.id.buttonCONNEXION);
        inscription = (Button ) findViewById(R.id.buttonINSCRIPTION);
        id = (EditText) findViewById(R.id.editTextTextEmailAddress);
        pswr= (EditText) findViewById(R.id.editTextTextPassword);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar2);


        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),choixdusubscribe.class);
                startActivityForResult(c,0);
            }
        });

        connx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userget = id.getText().toString().trim();
                passuserget = pswr.getText().toString().trim();

                if(TextUtils.isEmpty(userget)){
                    id.setError("email is required ");
                    return ;
                }
                if(TextUtils.isEmpty((passuserget) )){
                    pswr.setError("le champ est vide ! ");
                    return;
                }

                if(passuserget.length() <6){
                    pswr.setError("le mot de pass doit avoir 6 characters");
                    return;
                }
              //  progressBar.setVisibility(View.VISIBLE);


                //connexuion au niveau de l'admin
                if(userget.equals(user) && passuserget.equals(passuser))
                {
                    Intent c = new Intent(getApplicationContext(),connexrecu.class);
                    c.putExtra("gros", "administrateur");
                    startActivityForResult(c,0);
                }else{

                   progressBar.setVisibility(View.VISIBLE);

                //authetification des utilisateurs clients

                fAuth.signInWithEmailAndPassword(userget,passuserget).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "connexion reussi", Toast.LENGTH_SHORT).show();

                            Intent c = new Intent(getApplicationContext(),subscribe2.class);
                            c.putExtra("gros", "client");
                            startActivityForResult(c,0);
                            //startActivity(new Intent(getApplicationContext(),subscribe2.class));
                        }else{
                            Toast.makeText(MainActivity.this, "error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                }

              //connexuion au niveau de l'admin
              /*  if(userget.equals(user) && passuserget.equals(passuser))
                {
                    Intent c = new Intent(getApplicationContext(),connexrecu.class);
                    c.putExtra("gros", "administrateur");
                startActivityForResult(c,0);
                }*/
            }
        });
    }


}