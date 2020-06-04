package com.example.pruebamercadolibre5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()  {
    lateinit var articulos: ListaArticulos
    lateinit var context: Context

    fun RecyclerAdapter(articulos: ListaArticulos, context: Context){ //constructor
        this.articulos = articulos
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //se fija que elemento del objeto va en que posicion del reciclerview segun su posicion
        val item = articulos.results.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //crea otro item de la lista de la vista
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.activity_articulo, parent, false))
    }

    override fun getItemCount(): Int {
        return articulos.results.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) { //adjunta cada dato de una posicion de la lista al item de la vista
        val tituloArticulo = view.findViewById(R.id.txt_titulo) as TextView
        val price = view.findViewById(R.id.txt_price) as TextView
        val link = view.findViewById(R.id.btn_irPublicacion) as Button
        val imagenArt = view.findViewById(R.id.img_foto) as ImageView

        fun bind(articulo: Articulo, context: Context){
            tituloArticulo.text = articulo.title
            price.text = articulo.price.toString()
            link.text = articulo.permalink
            imagenArt.loadUrl(articulo.thumbnail)
        }
        fun ImageView.loadUrl(url: String) {
            Picasso.get().load(url).into(this)
        }
    }
}