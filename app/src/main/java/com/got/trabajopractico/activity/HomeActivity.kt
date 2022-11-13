package com.got.trabajopractico.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.got.trabajopractico.R
import com.got.trabajopractico.model.House
import android.content.Intent
import android.app.PendingIntent
import android.app.AlarmManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.got.trabajopractico.adapter.HousesAdapter
import com.got.trabajopractico.retrofit.RetrofitClient
import com.got.trabajopractico.service.APIService
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomeActivity : AppCompatActivity() {

    var my_toolbar: Toolbar? = null
    var rvHouseGot: RecyclerView? = null
    lateinit var btnNotificacion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        inicializarElementos()

        lifecycleScope.launch(Dispatchers.IO){

            val api = RetrofitClient.retrofit.create(APIService::class.java)
            api.getAllHouses("houses").enqueue(object : Callback<List<House>> {
                override fun onResponse(call: Call<List<House>>, response: Response<List<House>>) {
                    Log.d("exitoso", "onResponse: {${response.body()!![0].name}}")

                    showData(response.body()!!)
                }

                override fun onFailure(call: Call<List<House>>, t: Throwable) {
                    Log.d("falla", "Error")
                }

            })

        }

        btnNotificacion!!.findViewById<View>(R.id.btnNotificacion).setOnClickListener {
            val calendar = Calendar.getInstance()
            val intent = Intent(applicationContext, NotificationActivity::class.java)
            val pendingIntent = PendingIntent.getBroadcast(applicationContext, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, 10000, pendingIntent)
        }
    }

    private fun inicializarElementos() {
        my_toolbar = findViewById(R.id.mi_toolbar)
        rvHouseGot = findViewById(R.id.recyclerView)
        btnNotificacion = findViewById(R.id.btnNotificacion)
        setSupportActionBar(my_toolbar)
        supportActionBar!!.title = "CASAS GOT"
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

    private fun showData(houses: List<House>){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter =
                HousesAdapter(
                    houses
                )
        }
    }

    private fun paginacionEntreActivitis(claseDestino: Class<*>) {
        val intentGlobal = Intent(this@HomeActivity, claseDestino)
        startActivity(intentGlobal)
    }
}