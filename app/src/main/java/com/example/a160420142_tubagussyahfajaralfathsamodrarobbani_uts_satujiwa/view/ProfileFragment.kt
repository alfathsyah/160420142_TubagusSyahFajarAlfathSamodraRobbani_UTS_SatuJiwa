package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.Global
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.ProfileViewModel
import com.example.adv160420142week4.R

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetch(Global.username, Global.password)

        observeViewModel()
    }

    fun observeViewModel() {
        val txtUsername = view?.findViewById<EditText>(R.id.editTextTextPersonUsername)
        val txtName = view?.findViewById<EditText>(R.id.editTextTextPersonName)

        viewModel.profileLD.observe(viewLifecycleOwner, Observer
        {
            txtUsername?.setText(viewModel.profileLD.value?.username)
            txtName?.setText(viewModel.profileLD.value?.name)
        })
    }
}