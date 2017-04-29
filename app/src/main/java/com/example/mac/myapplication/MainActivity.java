package com.example.mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creamos la variable Toolbar
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tb);

        //Vilculamos nuestro toolbar con el XML
        toolbar.setTitle("Toolbar");
        setSupportActionBar(toolbar);
    }

    //Creamos el menu (click derecho en la carpeta res/new Android resuorse file/ lo llaman menu y
    //  eligen que sea del tipo Menu)
    //Creamos el metodo OnCreateOptionsMenu para enlazar nuestro menu creado
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Le decimos que menu utilizaremos en nuestro toolbar
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Creamos este metodo para darle acciones a los items de nuestro menu ubicandolos por sus ID
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                startActivity(new Intent(getApplicationContext(),ChildActivity.class));
                break;
            case R.id.item3:
                startActivity(new Intent(getApplicationContext(),ScrollingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
