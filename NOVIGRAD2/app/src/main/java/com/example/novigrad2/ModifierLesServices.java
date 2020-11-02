package com.example.novigrad2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ModifierLesServices extends AppCompatActivity {

    DatabaseReference databaseServiceLecture;
    ListView listViewServices;
    List<ServicesHelperClass> servicelist ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_les_services);

        listViewServices = (ListView)findViewById(R.id.listviewServices);
        servicelist = new ArrayList<>();

        databaseServiceLecture = FirebaseDatabase.getInstance().getReference("SERVICES");


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseServiceLecture.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ServiceSnapshot : snapshot.getChildren())
                {
                    ServicesHelperClass servicesHelperClass = ServiceSnapshot.getValue(ServicesHelperClass.class);
                    servicelist.add(servicesHelperClass);
                }

                ServicesList adapter = new ServicesList(ModifierLesServices.this,servicelist);

                listViewServices.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}