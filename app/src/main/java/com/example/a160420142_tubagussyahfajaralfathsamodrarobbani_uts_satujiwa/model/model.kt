package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model

import com.google.gson.annotations.SerializedName

data class Donasi(
    val id:String?,
    @SerializedName("nama")
    val name:String?,
    @SerializedName("jumlah_donatur")
    val donatur:String?,
    @SerializedName("total_donasi")
    val total_donasi:String?,
    @SerializedName("sisa_hari")
    val sisa_hari:String?,
    @SerializedName("url")
    val photoUrl:String
)

data class Donatur(
    val id:String?,
    @SerializedName("nama")
    val name:String?,
    @SerializedName("jumlah_donasi")
    val jumlah_donasi:String?,
    @SerializedName("donasi_id")
    val donasi_id:String?
)

data class Zakat(
    val id:String?,
    @SerializedName("nama")
    val name:String?,
    @SerializedName("total")
    val total:String?,
    @SerializedName("deskripsi")
    val deskripsi:String?,
    @SerializedName("url")
    val photoUrl:String
)

data class Profile(
    val id: String?,
    @SerializedName("username")
    val username:String?,
    @SerializedName("password")
    val password:String?,
    @SerializedName("name")
    val name:String?
)

data class Comment(
    val id:String?,
    @SerializedName("nama")
    val name:String?,
    @SerializedName("komen")
    val komen:String?,
    @SerializedName("donasi_id")
    val donasi_id:String?
)
