package com.example.techugo.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.techugo.R

class OffersFragment : Fragment() {

    companion object {
        fun newInstance() = OffersFragment()
    }

    private lateinit var viewModel: TabViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.offers_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TabViewModel::class.java)
        return view

    }

}