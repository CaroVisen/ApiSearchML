package com.example.pruebamercadolibre5

import com.google.gson.annotations.SerializedName

data class ListaArticulos(@SerializedName("results") var results: List<Articulo>) {
}