package com.got.trabajopractico.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.got.trabajopractico.R;
import com.got.trabajopractico.adapter.HouseAdapter;
import com.got.trabajopractico.model.House;

import java.util.ArrayList;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    Toolbar my_toolbar;
    RecyclerView rvHouseGot;
    HouseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

  /*  private Retrofit getRetrofit(){
        Retrofit build = Retrofit.Builder
                .baseUrl(HttpUrl.parse("https://anapioficeandfire.com/api/houses/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return build;
    }
*/
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

    private void inicializarElementos(){
        my_toolbar = findViewById(R.id.mi_toolbar);
        rvHouseGot = findViewById(R.id.rvHouseGot);

        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("CASAS GOT");
    }

    //Esto infla el xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
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
        Intent intentGlobal = new Intent(HomeActivity.this, claseDestino);
        startActivity(intentGlobal);
    }
}




