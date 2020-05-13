package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private CardView idProfil, idContact, idTeman, idOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        idProfil = (CardView) findViewById(R.id.id_profil);
        idContact = (CardView) findViewById(R.id.id_contact);
        idTeman = (CardView) findViewById(R.id.id_teman);
        idOther = (CardView) findViewById(R.id.id_other);

        //fungsi onclicklistener
        idProfil.setOnClickListener(this);
        idContact.setOnClickListener(this);
        idTeman.setOnClickListener(this);
        idOther.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.id_profil:
                i = new Intent(this, Profile.class);
                startActivity(i);
                break;
            case R.id.id_contact:
                i = new Intent(this, Contact.class);
                startActivity(i);
                break;
            case R.id.id_teman:
                i = new Intent(this, Teman.class);
                startActivity(i);
                break;
            case R.id.id_other:
                i = new Intent(this, Other.class);
                startActivity(i);
                break;
            default:
                break;

        }
    }
}
