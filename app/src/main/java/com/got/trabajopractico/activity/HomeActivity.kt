package com.got.trabajopractico.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.got.trabajopractico.adapter.HouseAdapter
import android.os.Bundle
import com.got.trabajopractico.R
import com.got.trabajopractico.model.House
import android.content.Intent
import com.got.trabajopractico.activity.NotificationActivity
import android.app.PendingIntent
import android.app.AlarmManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.got.trabajopractico.activity.LibrosActivity
import com.got.trabajopractico.activity.PersonajesActivity
import com.got.trabajopractico.dao.YesNoResponse
import com.got.trabajopractico.retrofit.RetrofitYesNo
import com.got.trabajopractico.service.APIServiceYesNo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class HomeActivity : AppCompatActivity() {
    var my_toolbar: Toolbar? = null
    var rvHouseGot: RecyclerView? = null
    var adapter: HouseAdapter? = null
    lateinit var btnNotificacion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        inicializarElementos()
        adapter = HouseAdapter(house) {
            //Funcionalidad
        }
        rvHouseGot!!.adapter = adapter

        /*val apiYesNo = RetrofitYesNo.retrofit.create(APIServiceYesNo::class.java)
        val callGetPost = apiYesNo.getYesorNo()
        callGetPost.enqueue(object : retrofit2.Callback<List<YesNoResponse>>){
            override fun onResponse(call: Call<List<YesNoResponse>>, response: Response<List<YesNoResponse>>){
                val post = response.body()
                if(post != null){
                    btnNotificacion.findViewById(R.id.btnNotificacion)
                    btnNotificacion
                }
            }
        }*/

        btnNotificacion!!.findViewById<View>(R.id.btnNotificacion).setOnClickListener {
            val calendar = Calendar.getInstance()
            val intent = Intent(applicationContext, NotificationActivity::class.java)
            val pendingIntent = PendingIntent.getBroadcast(applicationContext, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, 10000, pendingIntent)
        }
    }

    /*  private Retrofit getRetrofit(){
        Retrofit build = Retrofit.Builder
                .baseUrl(HttpUrl.parse("https://anapioficeandfire.com/api/houses/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return build;
    }
*/
    private val house: ArrayList<House?>
        private get() = object : ArrayList<House?>() {
            init {
                add(House(1, "Casa Stark", "Adrogue"))
                add(House(2, "Casa Arryn", "Lomas de zamora"))
                add(House(3, "Casa Targaryen", "Merlo"))
                add(House(4, "Casa Lannister", "Palermo"))
            }
        }

    private fun inicializarElementos() {
        my_toolbar = findViewById(R.id.mi_toolbar)
        rvHouseGot = findViewById(R.id.rvHouseGot)
        btnNotificacion = findViewById(R.id.btnNotificacion)
        setSupportActionBar(my_toolbar)
        supportActionBar!!.title = "CASAS GOT"
    }

    //Esto infla el xml
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_libros) {
            paginacionEntreActivitis(LibrosActivity::class.java)
        }
        if (item.itemId == R.id.item_personajes) {
            paginacionEntreActivitis(PersonajesActivity::class.java)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun paginacionEntreActivitis(claseDestino: Class<*>) {
        val intentGlobal = Intent(this@HomeActivity, claseDestino)
        startActivity(intentGlobal)
    }
}