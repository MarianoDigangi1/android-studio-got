package com.got.trabajopractico.service

import com.got.trabajopractico.model.Book
import com.got.trabajopractico.model.Character
import com.got.trabajopractico.model.House
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    fun getAllCharacter(@Url url:String): Call<List<Character>>

    @GET
    fun getAllHouses(@Url url:String): Call<List<House>>

    @GET
    fun getAllBooks(@Url url:String): Call<List<Book>>

}