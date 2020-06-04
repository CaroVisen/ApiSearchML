package com.example.pruebamercadolibre5

import com.google.gson.annotations.SerializedName

data class Articulo(@SerializedName("id")var id: String,
                    @SerializedName("title") var title: String,
                    @SerializedName("price")var price: Double,
                    @SerializedName("permalink")var permalink: String,
                    @SerializedName("thumbnail")var thumbnail: String) {
}