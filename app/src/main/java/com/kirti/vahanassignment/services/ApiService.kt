package com.kirti.vahanassignment.services



import com.kirti.vahanassignment.models.UniversityModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val Base_url = "http://universities.hipolabs.com"
interface ApiInterface {


    @GET("/search")
    fun getUniversityList() : Call<ArrayList<UniversityModel>>
}

object ApiService{

    val  apiInstance : ApiInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInstance = retrofit.create(ApiInterface::class.java)

    }
}