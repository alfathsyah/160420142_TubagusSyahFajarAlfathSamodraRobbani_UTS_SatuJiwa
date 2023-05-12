package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.DonaturViewModel
import com.example.adv160420142week4.R

class DonaturFragment : Fragment() {

    private lateinit var viewModel: DonaturViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donatur, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DonaturViewModel::class.java)

        val donaturID = DonasiDetailListFragmentArgs.fromBundle(requireArguments()).id
        viewModel.refresh(donaturID)

        val txtNama = view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtJumlah = view.findViewById<TextView>(R.id.txtJumlahDonasi)
        viewModel.donaturLD.observe(viewLifecycleOwner)
        {donaturDetail ->
            txtNama.text = donaturDetail.name.toString()
            txtJumlah.text = "Rp. " + donaturDetail.jumlah_donasi.toString()
        }
    }
}