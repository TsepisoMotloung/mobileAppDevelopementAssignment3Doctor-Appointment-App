package com.example.doctorappointment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;


public
class PatientRecyclerAdapter extends FirebaseRecyclerAdapter <Patients, PatientRecyclerAdapter.myviewholder>{

    public
    PatientRecyclerAdapter ( @NonNull @NotNull FirebaseRecyclerOptions < Patients > options ) {
        super ( options );
    }

    @Override
    protected
    void onBindViewHolder ( @NonNull @NotNull PatientRecyclerAdapter.myviewholder holder, int position, @NonNull @NotNull Patients model ) {

        holder.firstname.setText ( model.getP_name ());
        holder.lastname.setText ( model.getP_surname () );
        holder.birthdate.setText ( model.getP_birthday () );
        holder.phoneNumber.setText ( model.getP_phone () );
        holder.appDate.setText ( model.getP_apdate () );
        holder.appTime.setText ( model.p_aptime );
    }

    @NonNull
    @NotNull
    @Override
    public
    myviewholder onCreateViewHolder ( @NonNull @NotNull ViewGroup parent, int viewType ) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.custom_cardview, parent,false );
        return new myviewholder ( view );
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView firstname, lastname, birthdate, appTime, appDate, phoneNumber;

        public
        myviewholder ( @NonNull @NotNull View itemView ) {
            super ( itemView );
            firstname = itemView.findViewById(R.id.firstname);
            lastname = itemView.findViewById ( R.id.lastname );
            birthdate = itemView.findViewById(R.id.birthday1);
            appTime = itemView.findViewById ( R.id.time );
            appDate = itemView.findViewById ( R.id.date );
            phoneNumber = itemView.findViewById ( R.id.phone_number );
        }
    }
}
