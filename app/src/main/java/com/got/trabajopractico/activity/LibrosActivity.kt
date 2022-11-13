package com.got.trabajopractico.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.got.trabajopractico.R
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.got.trabajopractico.adapter.BookAdapter
import com.got.trabajopractico.model.Book
import com.got.trabajopractico.retrofit.RetrofitClient
import com.got.trabajopractico.service.APIService
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibrosActivity : AppCompatActivity() {

    var my_toolbar: Toolbar? = null
    var rvHouseGot: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        inicializarElementos()

        lifecycleScope.launch(Dispatchers.IO){

            val api = RetrofitClient.retrofit.create(APIService::class.java)

            api.getAllBooks("books?page=2&pageSize=6").enqueue(object : Callback<List<Book>> {
                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    Log.d("falla", "Error")
                }

                override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                    Log.d("exitoso", "onResponse: {${response.body()!![0].url}}")

                    showData(response.body()!!)

                }
            })
        }
    }


    private fun inicializarElementos() {
        my_toolbar = findViewById(R.id.mi_toolbar)
        rvHouseGot = findViewById(R.id.recyclerView)
        setSupportActionBar(my_toolbar)
        supportActionBar!!.title = "LIBROS GOT"
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

    private fun showData(books: List<Book>){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@LibrosActivity)
            adapter =
                BookAdapter(
                    books
                )
        }
    }
    private fun paginacionEntreActivitis(claseDestino: Class<*>) {
        val intentGlobal = Intent(this@LibrosActivity, claseDestino)
        startActivity(intentGlobal)
    }
}