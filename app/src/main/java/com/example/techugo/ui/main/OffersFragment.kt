package com.example.techugo.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.techugo.R
import com.example.techugo.adapter.ImageAdapter
import com.example.techugo.adapter.OfferAdapter
import com.example.techugo.model.Cupons

class OffersFragment : Fragment() {

    companion object {
        fun newInstance() = OffersFragment()
    }

    private lateinit var viewModel: TabViewModel
    var recyclerView: RecyclerView? = null
    var offersRecyclerView: RecyclerView? = null
    lateinit var adapter: ImageAdapter
    lateinit var offerAdapter: OfferAdapter
    var arrayList: ArrayList<String> = ArrayList()
    var cuponsArrayList: ArrayList<Cupons> = ArrayList()
    var mapButton: Button? = null
    var lat: Float? = null
    var lon: Float? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.offers_fragment, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        offersRecyclerView = view.findViewById(R.id.offers_recycler_view)
        mapButton = view.findViewById(R.id.map_btn)
        recyclerView?.layoutManager = LinearLayoutManager(
            this.requireContext()
            , LinearLayoutManager.HORIZONTAL, false
        )
        offersRecyclerView?.layoutManager = LinearLayoutManager(
            this.requireContext()
            , LinearLayoutManager.VERTICAL, false
        )

        viewModel = ViewModelProviders.of(this).get(TabViewModel::class.java)

        viewModel._livedata.observe(viewLifecycleOwner, Observer {
            arrayList.clear()
            cuponsArrayList.clear()
            arrayList.addAll(it.result.banner)
            cuponsArrayList.addAll(it.result.cupons)
            adapter.notifyDataSetChanged()
            offerAdapter.notifyDataSetChanged()

            lat = it.result.latitudes
            lon = it.result.longitude
        })
        adapter = ImageAdapter(arrayList, this.requireContext())
        offerAdapter = OfferAdapter(cuponsArrayList, this.requireContext())
        viewModel.getData()

        recyclerView?.adapter = adapter
        offersRecyclerView?.adapter = offerAdapter

        mapButton?.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW
            , Uri.parse("geo:$lat,$lon"))
            startActivity(intent)
        }

        return view

    }

}