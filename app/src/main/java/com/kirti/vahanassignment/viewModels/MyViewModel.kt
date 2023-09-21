package com.kirti.vahanassignment.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirti.vahanassignment.models.UniversityModel
import com.kirti.vahanassignment.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel() {

    private val _list = MutableLiveData<ArrayList<UniversityModel>>()
    val list get()  = _list

    fun getUniversityList(){
        val apiService = ApiService.apiInstance.getUniversityList()
        apiService.enqueue(object : Callback<ArrayList<UniversityModel>> {
            override fun onResponse(call: Call<ArrayList<UniversityModel>>, response: Response<ArrayList<UniversityModel>>) {
                response.body()?.let {
                    println("onResponse is worked")
                    it.let {
                        _list.postValue(it)
                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<UniversityModel>>, t: Throwable) {
                Log.d( "onFailure: ","${t.toString()} $call")
            }
        })
    }
}