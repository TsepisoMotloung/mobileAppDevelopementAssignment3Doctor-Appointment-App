package com.example.doctorappointment;

public
class Patients {
    String p_name;
    String p_surname;
    String p_birthday;
    String p_phone;
    String p_apdate;
    String p_aptime;

    Patients(){

    }

    public
    Patients ( String p_name, String p_surname, String p_birthday, String p_phone, String p_apdate, String p_aptime ) {
        this.p_name     = p_name;
        this.p_surname  = p_surname;
        this.p_birthday = p_birthday;
        this.p_phone    = p_phone;
        this.p_apdate   = p_apdate;
        this.p_aptime   = p_aptime;
    }

    public
    String getP_name ( ) {
        return p_name;
    }

    public
    String getP_surname ( ) {
        return p_surname;
    }

    public
    String getP_birthday ( ) {
        return p_birthday;
    }

    public
    String getP_phone ( ) {
        return p_phone;
    }

    public
    String getP_apdate ( ) {
        return p_apdate;
    }

    public
    String getP_aptime ( ) {
        return p_aptime;
    }


}
