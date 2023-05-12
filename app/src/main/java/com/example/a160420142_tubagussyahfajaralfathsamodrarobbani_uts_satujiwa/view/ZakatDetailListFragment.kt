package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.ZakatDetailViewModel
import com.example.adv160420142week4.R
import com.squareup.picasso.Picasso

class ZakatDetailListFragment : Fragment() {

    private lateinit var detailViewModel: ZakatDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat_detail_list, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(ZakatDetailViewModel::class.java)

        val zakatID = ZakatDetailListFragmentArgs.fromBundle(requireArguments()).id
        detailViewModel.refresh(zakatID)
        val txtJudul = view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtTotal = view.findViewById<TextView>(R.id.txtJumlahDonasi)
        val txtDeskripsi = view.findViewById<TextView>(R.id.txtDeskripsi)
        val imgView = view.findViewById<ImageView>(R.id.imageViewDetail2)
        detailViewModel.zakatLD.observe(viewLifecycleOwner)
        {zakatDetail ->
            txtJudul.text = zakatDetail.name.toString()
            txtTotal.text = "Rp. " + zakatDetail.total.toString()
            txtDeskripsi.text = zakatDetail.deskripsi.toString() + " Hari"
            val url =  zakatDetail.photoUrl
            Picasso.get()
                .load(url)
                .resize(400, 400)
                .centerCrop()
                .error(R.drawable.baseline_error_24)
                .into(imgView)
        }
    }
}