package com.example.doctorappointment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public
class MainActivity extends AppCompatActivity {

    EditText name, surname, birthday, phone, apdate, aptime;
    DatabaseReference patientDB;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);

        name = findViewById ( R.id.in_name );
        surname = findViewById ( R.id.insurname );
        birthday = findViewById ( R.id.inbirthday );
        phone = findViewById ( R.id.inphone );
        apdate = findViewById ( R.id.inappdate );
        aptime  = findViewById ( R.id.inaptime );

        patientDB = FirebaseDatabase.getInstance().getReference().child( "patients");
    }

    //on clicklistener for the button clear
    public
    void clear ( View view ) {
        name.setText ( "" );
        surname.setText ( "" );
        birthday.setText ( "" );
        phone.setText ( "" );
        apdate.setText ( "" );
        aptime.setText ( "" );
    }

    public
    void save ( View view ) {
        insertPatientData();
    }

    private void insertPatientData(){
        String p_name = name.getText().toString();
        String p_surname = surname.getText().toString();
        String p_birthday = birthday.getText().toString();
        String p_phone = phone.getText().toString();
        String p_apdate = apdate.getText().toString();
        String p_aptime = aptime.getText().toString();

        Patients patients = new Patients ( p_name, p_surname, p_birthday, p_phone, p_apdate,p_aptime );

        if(p_name.isEmpty () | p_surname.isEmpty () | p_birthday.isEmpty () | p_phone.isEmpty () | p_apdate.isEmpty () | p_aptime.isEmpty ()){
            Toast.makeText ( this, "Some fields are empty...please fill them all.", Toast.LENGTH_SHORT ).show ( );
        }

        else{
            patientDB.push ().setValue ( patients );

            name.setText ( "" );
            surname.setText ( "" );
            birthday.setText ( "" );
            phone.setText ( "" );
            apdate.setText ( "" );
            aptime.setText ( "" );

            Toast.makeText ( this, "Database successfully edited", Toast.LENGTH_SHORT ).show ();
        }
    }

    public
    void view ( View view ) {

        Intent intent = new Intent ( this, ViewAppointments.class  );
        startActivity ( intent );
    }
}