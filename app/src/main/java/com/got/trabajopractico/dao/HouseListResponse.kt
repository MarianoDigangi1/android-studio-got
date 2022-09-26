package com.got.trabajopractico.dao

import com.google.gson.annotations.SerializedName

data class HouseListResponse (@SerializedName("name") var name:String,
                              @SerializedName("region") var region:String,
                              @SerializedName("coatOfArms") var coatOfArms:String)
