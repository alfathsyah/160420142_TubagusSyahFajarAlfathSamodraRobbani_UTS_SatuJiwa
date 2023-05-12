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
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Zakat
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.util.loadImage
import com.example.adv160420142week4.R

class ZakatListAdapter (val zakatList:ArrayList<Zakat>) : RecyclerView.Adapter<ZakatListAdapter.ZakatViewHolder>()
{
    class ZakatViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZakatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.zakat_list_item, parent, false)
        return ZakatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return zakatList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ZakatViewHolder, position: Int) {
        val txtID = zakatList[position].id
        val txtJudul = holder.view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtTotal = holder.view.findViewById<TextView>(R.id.txtJumlahDonasi)
        val txtJenis = holder.view.findViewById<TextView>(R.id.txtJenis)
        txtJudul.text = zakatList[position].name
        txtTotal.text = "Rp. " + zakatList[position].total

        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        btnDetail.setOnClickListener {
            val action = ZakatListFragmentDirections.actionZakatDetail(txtID.toString())
            Navigation.findNavController(it).navigate(action)
        }

        val progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)

        val imgView = holder.view.findViewById<ImageView>(R.id.imageViewZakat)
        imgView.loadImage(zakatList[position].photoUrl, progressBar)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateZakatList(newZakatList: ArrayList<Zakat>) {
        zakatList.clear()
        zakatList.addAll(newZakatList)
        notifyDataSetChanged()
    }
}