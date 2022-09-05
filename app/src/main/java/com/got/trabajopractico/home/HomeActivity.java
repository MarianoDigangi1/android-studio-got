package com.got.trabajopractico.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.got.trabajopractico.R;
import com.got.trabajopractico.adapter.HouseAdapter;
import com.got.trabajopractico.model.House;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvHouseGot;
    HouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setUpAdapter();
    }

    private void setUpAdapter(){

        rvHouseGot = findViewById(R.id.rvHouseGot);
        adapter = new HouseAdapter(getHouse(), new HouseAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(House house) {
                //Funcionalidad
            }
        });
        rvHouseGot.setAdapter(adapter);
    }

    private ArrayList<House> getHouse(){
        return new ArrayList<House>() {
            {
            add(new House(1, "Casa Stark", "Adrogue"));
            add(new House(2, "Casa Arryn", "Lomas de zamora"));
            add(new House(3, "Casa Targaryen", "Merlo"));
            add(new House(4, "Casa Lannister", "Palermo"));
            }
        };
    }
}