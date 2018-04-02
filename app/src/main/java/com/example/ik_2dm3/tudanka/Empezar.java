package com.example.ik_2dm3.tudanka;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Empezar extends AppCompatActivity {

    private static final String IDIOMA = "idioma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empezar);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button Hasi =  findViewById(R.id.button8);

        Hasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PresentacionES = new Intent(getApplicationContext(), PresentacionES.class);
                PresentacionES.putExtra(IDIOMA, "Castellano");
                startActivity(PresentacionES);
            }
        });

        Button Empezar =  findViewById(R.id.button7);
        Empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PresentacionES = new Intent(getApplicationContext(), PresentacionES.class);
                PresentacionES.putExtra(IDIOMA, "Euskera");
                startActivity(PresentacionES);
            }
        });
        }
    }


