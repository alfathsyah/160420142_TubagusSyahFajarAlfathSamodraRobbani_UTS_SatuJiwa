package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.Global
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Donasi
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.util.loadImage
import com.example.adv160420142week4.R

class DonasiListAdapter(val donasiList:ArrayList<Donasi>) :RecyclerView.Adapter<DonasiListAdapter.DonasiViewHolder>()
{
    class DonasiViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donasi_list_item, parent, false)
        return DonasiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return donasiList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DonasiViewHolder, position: Int) {
        val txtID = donasiList[position].id
        Global.id = txtID.toString()
        val txtJudul = holder.view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtTotal = holder.view.findViewById<TextView>(R.id.txtKomen)
        val txtSisaHari = holder.view.findViewById<TextView>(R.id.txtJenis)
        txtJudul.text = donasiList[position].name
        txtTotal.text = "Rp. " + donasiList[position].total_donasi
        txtSisaHari.text = donasiList[position].sisa_hari + " Hari"

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        btnDetail.setOnClickListener {
            val action = DonasiListFragmentDirections.actionDonasiDetail(txtID.toString())
            Navigation.findNavController(it).navigate(action)
        }

        val imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        val progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(donasiList[position].photoUrl, progressBar)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDonasiList(newDonasiList: ArrayList<Donasi>) {
        donasiList.clear()
        donasiList.addAll(newDonasiList)
        notifyDataSetChanged()
    }
}