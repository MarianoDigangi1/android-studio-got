package com.got.trabajopractico.service

import com.got.trabajopractico.dao.HouseListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceHouse {
    @GET
    fun getCharacterFromTo(@Url url:String): Response<HouseListResponse>
}