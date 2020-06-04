package com.example.pruebamercadolibre5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerview: RecyclerView
    var mAdapter:RecyclerAdapter=RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_buscar.setOnClickListener { buscar() }
    }

    fun buscar(): ListaArticulos{
        lateinit var articulos: ListaArticulos


        try {

                Api().getArticle(lbl_buscador.text.toString(), object: Callback<ListaArticulos> {
                override fun onFailure(call: Call<ListaArticulos>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<ListaArticulos>, response: Response<ListaArticulos>) {
                    Toast.makeText(this@MainActivity, "Entro", Toast.LENGTH_LONG).show()
                    if (response.isSuccessful) {
                        articulos.results = response.body()!!.results
                       // var lista:List<Articulo> = respuesta!!.results
                       // mAdapter.RecyclerAdapter(lista, this@MainActivity)
                       // mRecyclerview.adapter = mAdapter
                    }
                }
            })

        }catch (e : Exception){
            println(e)
        }
        return articulos
    }

    fun setUpRecyclerView(){
        mRecyclerview = findViewById(R.id.rvListaArticulos)
        mRecyclerview.setHasFixedSize(true)
        mRecyclerview.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(buscar(), this)
        mRecyclerview.adapter = mAdapter
    }
}
