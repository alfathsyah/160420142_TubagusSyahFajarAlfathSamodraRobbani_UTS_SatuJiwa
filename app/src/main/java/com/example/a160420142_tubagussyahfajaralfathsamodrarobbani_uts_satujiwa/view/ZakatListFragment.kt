package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.DonasiListViewModel
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.viewmodel.ZakatListViewModel
import com.example.adv160420142week4.R

class ZakatListFragment : Fragment() {

    private lateinit var viewModel: ZakatListViewModel
    private val zakatListAdapter = ZakatListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ZakatListViewModel::class.java)
        viewModel.refresh()
        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = zakatListAdapter
        observeViewModel()

        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view.findViewById<TextView>(R.id.txtError)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
        refreshLayout?.setOnRefreshListener {
            recView?.visibility = View.GONE
            txtError?.visibility = View.GONE
            progressLoad?.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

    }

    fun observeViewModel() {
        viewModel.zakatLD.observe(viewLifecycleOwner, Observer {
            zakatListAdapter.updateZakatList(it)
        })

        viewModel.zakatLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view?.findViewById<TextView>(R.id.txtError)
            if (it == true) {
                txtError?.visibility = View.VISIBLE
            } else {
                txtError?.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val recView = view?.findViewById<RecyclerView>(R.id.recView)
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressLoad)
            if (it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })
    }
}