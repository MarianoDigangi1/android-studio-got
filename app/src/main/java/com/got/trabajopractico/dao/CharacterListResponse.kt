package com.got.trabajopractico.dao

import com.google.gson.annotations.SerializedName

data class CharacterListResponse (@SerializedName("name") var name:String,
                                  @SerializedName("gender") var gender:String,
                                  @SerializedName("culture") var culture:String)

//El @SerializedName("name") tiene que ser igual a la llamada de la API
