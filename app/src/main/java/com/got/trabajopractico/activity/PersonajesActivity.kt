package com.got.trabajopractico.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.got.trabajopractico.R
import com.got.trabajopractico.adapter.CharacterAdapter
import com.got.trabajopractico.adapter.HousesAdapter
import com.got.trabajopractico.model.Character
import com.got.trabajopractico.model.House
import com.got.trabajopractico.retrofit.RetrofitClient
import com.got.trabajopractico.service.APIService
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonajesActivity : AppCompatActivity() {

    var my_toolbar: Toolbar? = null
    var rvHouseGot: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        inicializarElementos()

        lifecycleScope.launch(Dispatchers.IO){

            val api = RetrofitClient.retrofit.create(APIService::class.java)
            api.getAllCharacter("characters?page=2&pageSize=10").enqueue(object : Callback<List<Character>> {
                override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>
                ) {
                    Log.d("exitoso", "onResponse: {${response.body()!![0].name}}")
                    showData(response.body()!!)
                }

                override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                    Log.d("falla", "Error")
                }

            })
        }

    }

    private fun inicializarElementos() {
        my_toolbar = findViewById(R.id.mi_toolbar)
        rvHouseGot = findViewById(R.id.recyclerView)
        setSupportActionBar(my_toolbar)
        supportActionBar!!.title = "PERSONAJES GOT"
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.item_casas) paginacionEntreActivitis(HomeActivity::class.java)

        if (item.itemId == R.id.item_libros) paginacionEntreActivitis(LibrosActivity::class.java)

        if (item.itemId == R.id.item_personajes) paginacionEntreActivitis(PersonajesActivity::class.java)

        return super.onOptionsItemSelected(item)
    }

    private fun showData(characters: List<Character>){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@PersonajesActivity)
            adapter = CharacterAdapter(characters)
        }
    }

    private fun paginacionEntreActivitis(claseDestino: Class<*>) {
        val intentGlobal = Intent(this@PersonajesActivity, claseDestino)
        startActivity(intentGlobal)
    }
}