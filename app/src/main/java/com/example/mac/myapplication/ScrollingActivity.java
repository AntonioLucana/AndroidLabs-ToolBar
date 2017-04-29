package com.example.mac.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        //Se crea y enlaza el toolbar con el XML
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Se crea el boton para volver a la actividad padre (Previamente instanciar los atributos en el Manifest)
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //Aqui instanciamos el boton flotante y al presionarlo generara un Snackbar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar es un mensaje (Parecido al Toast) que nos permite realizar alguna accion
                Snackbar.make(view, "Deseas volver al inicio?", Snackbar.LENGTH_LONG)
                        //Aqui le decimos que hara el momento de presionar el boton
                        .setAction("Volver", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Al precionar la accion del Snackbar regresaremos a la actividad principal
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        }).show();
            }
        });
    }
}
