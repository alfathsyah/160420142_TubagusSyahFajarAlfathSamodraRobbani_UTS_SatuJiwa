package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.Global
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.ProfileViewModel
import com.example.adv160420142week4.R

class LoginFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val txtUser = view.findViewById<EditText>(R.id.editUser)
        val txtPass = view.findViewById<EditText>(R.id.editPass)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            var user = txtUser?.text.toString()
            var pass = txtPass?.text.toString()
            viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
            viewModel.fetch(user, pass)

            observeViewModel()

            if (viewModel.profileLD.value?.username == user) {
                if (viewModel.profileLD.value?.password == pass) {
                    Global.username = user
                    Global.password = pass
                    val action = LoginFragmentDirections.actionLogin()
                    Navigation.findNavController(it).navigate(action)
                } else if (viewModel.profileLD.value?.password != pass) {
                    Toast.makeText(activity, "Password wrong", Toast.LENGTH_SHORT).show()
                }
            } else if (viewModel.profileLD.value?.password == pass) {
                if (viewModel.profileLD.value?.username == user) {
                    Global.username = user
                    Global.password = pass
                    val action = LoginFragmentDirections.actionLogin()
                    Navigation.findNavController(it).navigate(action)
                }
            } else {
                Toast.makeText(activity, "Username or Password wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun observeViewModel(){
        var user = "";
        var pass = "";

        viewModel.profileLD.observe(viewLifecycleOwner, Observer{
            user = viewModel.profileLD.value?.username.toString()
            pass = viewModel.profileLD.value?.password.toString()
        })
    }
}