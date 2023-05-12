package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Donasi
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Donatur
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DonaturViewModel(application: Application):
    AndroidViewModel(application){
    val donaturLD = MutableLiveData<Donatur>()
    private var queue: RequestQueue? = null

    fun refresh(donasiId: String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://anmp.000webhostapp.com/api/Detail_Donatur.php?id=$donasiId"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Donatur>() { }.type
                val result = Gson().fromJson<Donatur>(it, sType)
                donaturLD.value = result
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
    }
}