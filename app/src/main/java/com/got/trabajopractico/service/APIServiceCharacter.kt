package com.got.trabajopractico.service

import com.got.trabajopractico.dao.CharacterListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceCharacter {
    @GET
    fun getCharacterFromTo(@Url url:String):Response<CharacterListResponse>
}