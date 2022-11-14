package com.got.trabajopractico.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.got.trabajopractico.R
import com.got.trabajopractico.model.House
import android.content.Intent
import android.app.PendingIntent
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
    var btnNotificacion: Button? = null

    companion object{
        const val channelID = "channelID"
        const val channelName = "channelName"
        const val notificationID = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        createNotificacionChannel()
        val notification = NotificationCompat.Builder( this, channelID).also{
            it.setContentTitle("Título de notificación")
            it.setContentText("Este es el contenido de la notificación")
            it.setSmallIcon(R.drawable.ic_notification)
            it.setPriority(NotificationCompat.PRIORITY_HIGH)
        }.build()
        val notificationManager = NotificationManagerCompat.from( this)
        btnNotificacion?.setOnClickListener { notificationManager.notify(notificationID, notification) }


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

        if(item.itemId == R.id.item_cerrar_sesion) paginacionEntreActivitis(LoginActivity::class.java)

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

    //COSAS A BORRAR
    private fun createNotificacionChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(channelID, channelName, importance).apply {
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}