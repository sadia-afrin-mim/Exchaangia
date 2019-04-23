package com.example.sadia.firebasetutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Retrive_post extends AppCompatActivity {
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;
    Spinner spinnerGenre;
    Button button;
    // private DatabaseReference databaseArtists = FirebaseDatabase.getInstance().getReference();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseArtists = database.getReference("sadia");

    ListView listViewDonor;

    List<posts> bloodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // final String Doctor_Name = "doctorname";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekerlist);

        //DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sadia");


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextType = (EditText) findViewById(R.id.editTextGroup);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenre);
        listViewDonor = (ListView) findViewById(R.id.listViewBlood);
        bloodList = new ArrayList<>();



    }



    @Override
    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bloodList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    posts artist = artistSnapshot.getValue(posts.class);
                    bloodList.add(artist);
                }
                All_post adapter = new All_post(Retrive_post.this, bloodList);
                listViewDonor.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}





