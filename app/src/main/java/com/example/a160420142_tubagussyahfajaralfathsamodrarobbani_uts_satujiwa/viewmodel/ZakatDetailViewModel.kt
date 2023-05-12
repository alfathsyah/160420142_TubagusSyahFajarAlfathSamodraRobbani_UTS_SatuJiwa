package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Zakat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ZakatDetailViewModel(application: Application):
    AndroidViewModel(application){
    val zakatLD = MutableLiveData<Zakat>()
    private var queue: RequestQueue? = null
    val TAG = "volleyTag"

    fun refresh(zakatId: String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://anmp.000webhostapp.com/api/Detail_Zakat.php?id=$zakatId"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Zakat>() { }.type
                val result = Gson().fromJson<Zakat>(it, sType)
                zakatLD.value = result
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
        queue?.cancelAll(TAG)
    }
}