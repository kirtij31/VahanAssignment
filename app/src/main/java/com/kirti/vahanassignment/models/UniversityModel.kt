package com.kirti.vahanassignment.models

import com.google.gson.annotations.SerializedName

data class UniversityModel(
    @SerializedName("name"           ) var name           : String?           = null,
    @SerializedName("domains"        ) var domains        : ArrayList<String> = arrayListOf(),
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @SerializedName("web_pages"      ) var webPages       : ArrayList<String> = arrayListOf(),
    @SerializedName("state-province" ) var stateProvince : String?           = null
    )