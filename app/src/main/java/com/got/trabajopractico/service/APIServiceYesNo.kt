package com.got.trabajopractico.service

import com.got.trabajopractico.dao.YesNoResponse
import com.got.trabajopractico.retrofit.RetrofitYesNo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceYesNo {
    @GET
    fun getYesorNo(): Call<RetrofitYesNo>
}