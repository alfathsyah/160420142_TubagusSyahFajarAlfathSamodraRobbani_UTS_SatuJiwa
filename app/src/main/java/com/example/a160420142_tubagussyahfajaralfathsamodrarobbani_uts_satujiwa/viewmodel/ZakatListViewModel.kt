package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel

import android.app.Application
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

class ZakatListViewModel(application: Application):
    AndroidViewModel(application){

    val zakatLD = MutableLiveData<ArrayList<Zakat>>()
    val zakatLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        zakatLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://anmp.000webhostapp.com/api/Detail_Zakat.php?"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Zakat>>() { }.type
                val result = Gson().fromJson<ArrayList<Zakat>>(it, sType)
                zakatLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                zakatLoadErrorLD.value = false
                loadingLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}