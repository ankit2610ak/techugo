package com.example.techugo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.techugo.R

class DetailsFragment : Fragment() {


    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: TabViewModel
    private var pic: ImageView? = null
    private var description: TextView? = null
    private var imagePath: String = " "

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(TabViewModel::class.java)

        pic = view.findViewById(R.id.pic)
        description = view.findViewById(R.id.description_details)

        viewModel._livedata.observe(viewLifecycleOwner, Observer {
            imagePath = it.result.decription_image
            Glide.with(this).load(imagePath).into(pic!!)

            description?.text = it.result.description_body
        })

        viewModel.getData()


        return view

    }

}