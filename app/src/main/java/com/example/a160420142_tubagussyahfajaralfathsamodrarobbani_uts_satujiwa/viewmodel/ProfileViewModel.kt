package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Profile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProfileViewModel (application: Application):
    AndroidViewModel(application){
    val profileLD = MutableLiveData<Profile>()
    private var queue: RequestQueue? = null

//    fun refresh(profileId: String) {
//
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "https://anmp.000webhostapp.com/api/Detail_Profile.php?id=$profileId"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<Profile>() { }.type
//                val result = Gson().fromJson<Profile>(it, sType)
//                profileLD.value = result
//                Log.d("showvoley", result.toString())
//            },
//            {
//                Log.d("showvoley", it.toString())
//            }
//        )
//
//        queue?.add(stringRequest)
//    }

    fun fetch(user:String?, pass:String?){
        val profile1 = Profile("1","Jamaluddin123","Jamaluddin123","Jamaluddin")
        val profile2 = Profile("2","Indah123","Indah123","Indah")
        val profile3 = Profile("2","Anisa123","Anisa123","Anisa")
        val profile4 = Profile("2","Tirto123","Tirto123","Tirto")

        if(user == "Jamaluddin123" && pass == "Jamaluddin123")
        {
            profileLD.value = profile1
        }
        else if (user == "Indah123" && pass == "Indah123")
        {
            profileLD.value = profile2
        }
        else if (user == "Anisa123" && pass == "Anisa123")
        {
            profileLD.value = profile3
        }
        else if (user == "Tirto123" && pass == "Tirto123")
        {
            profileLD.value = profile4
        }
    }

    override fun onCleared() {
        super.onCleared()
    }


}