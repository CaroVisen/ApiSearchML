package com.example.pruebamercadolibre5

import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    private fun getAPI(): ApiMLSearch {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.mercadolibre.com/sites/MLA/")
            .build();
        return retrofit.create(ApiMLSearch::class.java)
    }

    fun getArticle(q: String, callback: Callback<ListaArticulos>) {
        getAPI().getAllArticles(q).enqueue(callback)
    }
}