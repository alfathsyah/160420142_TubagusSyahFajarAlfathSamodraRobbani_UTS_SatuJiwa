package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Donatur
import com.example.adv160420142week4.R

class DonaturAdapter(val donaturList:ArrayList<Donatur>) :RecyclerView.Adapter<DonaturAdapter.DonaturViewHolder>()
{
    class DonaturViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonaturViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donatur_list_item, parent, false)
        return DonaturViewHolder(view)
    }

    override fun getItemCount(): Int {
        return donaturList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DonaturViewHolder, position: Int) {
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtJumlah = holder.view.findViewById<TextView>(R.id.txtKomen)
        txtNama.text = donaturList[position].name
        txtJumlah.text = "Rp. " + donaturList[position].jumlah_donasi
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateDonaturList(newDonaturList: Donatur) {
        donaturList.clear()
        donaturList.addAll(listOf(newDonaturList))
        notifyDataSetChanged()
    }
}