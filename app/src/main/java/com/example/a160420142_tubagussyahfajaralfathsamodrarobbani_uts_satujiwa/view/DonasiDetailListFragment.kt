package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.Global
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.DonasiDetailViewModel
import com.example.adv160420142week4.R
import com.squareup.picasso.Picasso

class DonasiDetailListFragment : Fragment() {

    private lateinit var detailViewModel: DonasiDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_detail_list, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DonasiDetailViewModel::class.java)

        val donasiID = DonasiDetailListFragmentArgs.fromBundle(requireArguments()).id
        detailViewModel.refresh(donasiID)

        val txtJudul = view.findViewById<TextView>(R.id.txtJudul2)
        val txtTotal = view.findViewById<TextView>(R.id.txtTotal2)
        val txtSisaHari = view.findViewById<TextView>(R.id.txtSisaHari2)
        val imgView = view.findViewById<ImageView>(R.id.imageViewDetail)
        detailViewModel.donasiLD.observe(viewLifecycleOwner)
        {donasiDetail ->
            txtJudul.text = donasiDetail.name.toString()
            txtTotal.text = "Rp. " + donasiDetail.total_donasi.toString()
            txtSisaHari.text = donasiDetail.sisa_hari.toString() + " Hari"
            val url =  donasiDetail.photoUrl
            Picasso.get()
                .load(url)
                .resize(400, 400)
                .centerCrop()
                .error(R.drawable.baseline_error_24)
                .into(imgView)
        }

        val btnDonatur = view.findViewById<Button>(R.id.btnDonatur)
        btnDonatur.setOnClickListener {
            val action = DonasiDetailListFragmentDirections.actionDetailDonatur(Global.id)
            Navigation.findNavController(it).navigate(action)
        }

        val btnComment = view.findViewById<Button>(R.id.btnComment)
        btnComment.setOnClickListener {
            val action = DonasiDetailListFragmentDirections.actionDetailDonatur(Global.id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}