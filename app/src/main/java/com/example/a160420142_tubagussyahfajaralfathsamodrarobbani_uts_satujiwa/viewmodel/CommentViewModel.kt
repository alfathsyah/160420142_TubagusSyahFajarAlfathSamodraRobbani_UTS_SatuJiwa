package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Comment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CommentViewModel (application: Application):
    AndroidViewModel(application){
    val commentLD = MutableLiveData<Comment>()
    val commentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(donasiId: String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://anmp.000webhostapp.com/api/Detail_Donatur.php?id=$donasiId"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Comment>() { }.type
                val result = Gson().fromJson<Comment>(it, sType)
                commentLD.value = result
                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                commentLoadErrorLD.value = false
                loadingLD.value = false
            }
        )

        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}