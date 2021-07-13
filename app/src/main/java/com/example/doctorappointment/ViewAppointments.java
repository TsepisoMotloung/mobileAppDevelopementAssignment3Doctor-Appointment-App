package com.example.doctorappointment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public
class ViewAppointments extends AppCompatActivity {

    RecyclerView recView;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_view_appointments );
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);

        recView = findViewById ( R.id.recycler1 );
        recView.setLayoutManager ( new LinearLayoutManager ( this ) );
        PatientRecyclerAdapter adapter;

        FirebaseRecyclerOptions<Patients> options = new FirebaseRecyclerOptions.Builder<Patients>().setQuery ( FirebaseDatabase.getInstance ().getReference ().child("patients"), Patients.class ).setLifecycleOwner(this).build ();

        adapter = new PatientRecyclerAdapter ( options );
        recView.setAdapter ( adapter );

    }


}