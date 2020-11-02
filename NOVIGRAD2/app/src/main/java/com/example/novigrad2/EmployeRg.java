package com.example.novigrad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeRg extends AppCompatActivity {
EditText regEmail , regName, regPrenom, regPassword;
Button inscription ;

FirebaseDatabase rootNode;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_rg);
        regEmail = (EditText) findViewById(R.id.reg_mail);
        regName = (EditText) findViewById(R.id.reg_nom);
        regPrenom = (EditText) findViewById(R.id.reg_prenom);
        regPassword = (EditText) findViewById(R.id.reg_password);
        inscription = (Button) findViewById(R.id.btnINSCRIPTION);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Employe");

                //recueillir toutes les donnees
                String name = regLastName.getEditText().toString();
                String firstName = regFName.getEditText().toString();
                String email = regEmail.getEditText().toString();
                String password = regPassword.getEditText().toString();

                //String id = reference.push().getKey();




                EmployeHelperClass employeHelperClass =new EmployeHelperClass(name,firstName,email,password);

               reference.push().setValue(employeHelperClass);
                Toast.makeText(EmployeRg.this, "OK", Toast.LENGTH_SHORT).show();*/
            }
        });


    }
}