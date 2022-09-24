package com.got.trabajopractico.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.got.trabajopractico.R;
import com.got.trabajopractico.adapter.HouseAdapter;
import com.got.trabajopractico.model.House;

import java.util.ArrayList;

public class PersonajesActivity extends AppCompatActivity {

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
        getSupportActionBar().setTitle("PERSONAJES GOT");
    }


    private ArrayList<House> getHouse(){
        return new ArrayList<House>() {
            {
                add(new House(1, "Naruto", "Uzumaki"));
                add(new House(2, "Sasuke", "Uchiha"));
                add(new House(3, "Karin", "Benzema"));
                add(new House(4, "Cristiano", "Ronaldo"));
            }
        };
    }

}
