package com.example.sadia.firebasetutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_post extends AppCompatActivity {
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;
    EditText Date_and_time;
    Spinner spinnerGenre;
    Button buttonAdd;
    // private DatabaseReference databaseUsers = FirebaseDatabase.getInstance().getReference("sadia");;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseUsers = database.getReference("sadia");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final String Doctor_Name = "doctorname";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        //DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sadia");


        editTextName = (EditText) findViewById(R.id.editTextName);
        Date_and_time = (EditText) findViewById(R.id.textViewEmail);
        editTextType = (EditText) findViewById(R.id.editTextGroup);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenre);

        buttonAdd = (Button) findViewById(R.id.buttonAddArtist);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addArtist();
                String name = editTextName.getText().toString().trim();
                String genre = spinnerGenre.getSelectedItem().toString();
                String type = editTextType.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String d_t    = Date_and_time.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    String id = databaseUsers.push().getKey();
                    posts post = new posts(name, genre, type, phone,d_t);
                    databaseUsers.child(id).setValue(post);


                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
                    toast.show();
                }

            }
        });


    }



    /*private void addArtist() {
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();
        String type = editTextType.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String d_t    = Date_and_time.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            String id = databaseUsers.push().getKey();
            posts post = new posts(name, genre, type, phone,d_t);
            databaseUsers.child(id).setValue(post);


        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG); // initiate the Toast with context, message and duration for the Toast
            toast.show();
        }
    }*/
}
