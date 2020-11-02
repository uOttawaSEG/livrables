package com.example.servicenovigrad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class creerservice extends AppCompatActivity {
    EditText creer,dt;
    Button val;
    ListView listView;

    List<services> servicesList;
     DatabaseReference databaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creerservice);

        databaseService = FirebaseDatabase.getInstance().getReference("SERVICE");
        creer = (EditText) findViewById(R.id.editTextTextPersonNameService);
         val = (Button) findViewById(R.id.valide);
         dt = (EditText)findViewById(R.id.editTextDate);
         listView =(ListView) findViewById(R.id.listeview);
         servicesList = new ArrayList<>();
    val.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addService();
            Intent c = new Intent(getApplicationContext(),connexrecu.class);
           //** startActivityForResult(c,0);

        }
    });


 /*   listView.setOnItemClickListener(new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View view) {

            servicesList services = servicesList.get();
            return false;
        }
    });*/
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            services service = servicesList.get(position);
            showUpdateDialog(service.serviceid,service.serviceName);
          //  Intent c = new Intent(getApplicationContext(),listeService.class);
            //startActivityForResult(c,0);
        }
    });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseService.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                servicesList.clear();
                for(DataSnapshot serviceSnapshot: dataSnapshot.getChildren()){
                    services service = serviceSnapshot.getValue(services.class);

                    servicesList.add(service);
                }
                //nom d'une classe ou activité
                listeafficheService adapter = new listeafficheService(creerservice.this,servicesList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private  void showUpdateDialog(final String serviceId, String serviceName){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update,null);
        dialogBuilder.setView(dialogView);
        final EditText editTextname =(EditText) dialogView.findViewById(R.id.editTextTextPersonNamepop);

     //   final TextView Textname =(TextView) dialogView.findViewById(R.id.textViewpop);
        final Button buttonuptdate =(Button) dialogView.findViewById(R.id.buttonpop);

        dialogBuilder.setTitle("uptdating" +serviceName);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        buttonuptdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = editTextname.getText().toString().trim();
            String dts ="";

                 if(TextUtils.isEmpty(name)){
                        editTextname.setError("champ important");
                        }
                updateService(serviceId,name,dts);
                 alertDialog.dismiss();
            }
        });

    }
    private boolean updateService (String id, String name,String dt){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("service").child(id);
        services  service = new services(id,name,dt);
         databaseReference.setValue(service);
        Toast.makeText(this,"service modifié",Toast.LENGTH_LONG).show();
        return true;
    }
    private void  addService(){
        String nomService = creer.getText().toString().trim();
        String datecreer = dt.getText().toString().trim();
        if(!TextUtils.isEmpty(nomService)){
           String id = databaseService.push().getKey();
           services srv= new services(id,nomService,datecreer);
           databaseService.child(id).setValue(srv);
           Toast.makeText(this,"service crée ",Toast.LENGTH_LONG).show();


        }else Toast.makeText(this,"veillez bien saisir le nom du service ",Toast.LENGTH_LONG).show();
    }
}