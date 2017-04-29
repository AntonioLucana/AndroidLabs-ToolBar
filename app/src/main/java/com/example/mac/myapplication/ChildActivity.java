package com.example.mac.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {

    //Instanciamos las variables toolbar y textview
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        toolbar = (Toolbar) findViewById(R.id.toolb);

        //Enlazamos el toolbar con el XML
        setSupportActionBar(toolbar);

        //Bloqueamos el titulo del toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Se crea el boton para volver a la actividad padre (Previamente instanciar los atributos en el Manifest)
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //Enlazamos el textview con el XML
        textView = (TextView) findViewById(R.id.txt);

        //Creamos y enlazamos el spinner
        Spinner spinnertb = (Spinner) findViewById(R.id.spinnerTb);

        //Creamos un adaptador para nuestro spinner y le enviamos los XML que creamos para personalizarlo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getSupportActionBar().getThemedContext()
        ,R.layout.appbar_filter_title, new String[]{"Opcion 1", "Opcion 2", "Opcion 3"});
        adapter.setDropDownViewResource(R.layout.appbar_filter_list);

        //Enviamos el adaptador a nuestro spinner
        spinnertb.setAdapter(adapter);

        //Este metodo sirve para darle acciones a los items del spinner en este caso cambiaremos el color de fondo de un textview
        spinnertb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Como los items del spinner estan en un vector, los localizamos por su posicion
                switch (position){
                    case 0: textView.setBackgroundColor(Color.parseColor("#f44336"));
                        break;
                    case 1: textView.setBackgroundColor(Color.parseColor("#2196f3"));
                        break;
                    case 2: textView.setBackgroundColor(Color.parseColor("#4caf50"));
                        break;
                }
            }

            //Este metodo srive para que nuestra aplicacion haga algo cuando no seleccionemos ningun item del spinner (Por ahora no nos sirve)
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            });

    }
}
