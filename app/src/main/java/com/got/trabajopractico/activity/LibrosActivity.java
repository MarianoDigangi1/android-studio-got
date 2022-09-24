package com.got.trabajopractico.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.got.trabajopractico.R;
import com.got.trabajopractico.adapter.HouseAdapter;
import com.got.trabajopractico.model.House;

import java.util.ArrayList;

public class LibrosActivity  extends AppCompatActivity {

    Toolbar my_toolbar;
    RecyclerView rvHouseGot;
    HouseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inicializarElementos();

        adapter = new HouseAdapter(getHouse(), new HouseAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(House house) {
                //Funcionalidad
            }
        });
        rvHouseGot.setAdapter(adapter);
    }

    private void inicializarElementos(){
        my_toolbar = findViewById(R.id.mi_toolbar);
        rvHouseGot = findViewById(R.id.rvHouseGot);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("LIBROS GOT");
    }


    private ArrayList<House> getHouse(){
        return new ArrayList<House>() {
            {
                add(new House(1, "Naruto", "1"));
                add(new House(2, "Naruto", "2"));
                add(new House(3, "Naruto", "3"));
                add(new House(4, "Naruto SHIPPUDEN", "1"));
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_libros){
            paginacionEntreActivitis(LibrosActivity.class);
        }
        if(item.getItemId() == R.id.item_personajes){
            paginacionEntreActivitis(PersonajesActivity.class);
        }
        return super.onOptionsItemSelected(item);
    }

    private void paginacionEntreActivitis(Class claseDestino) {
        Intent intentGlobal = new Intent(LibrosActivity.this, claseDestino);
        startActivity(intentGlobal);
    }
}