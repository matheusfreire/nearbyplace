package com.msf.nearby.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msf.nearby.R


class RestaurantsFragment : BaseFragment(){

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_cafe, container, false)
        return root
    }

    override fun onStart() {
        super.onStart()
        type = "restaurant"
    }

}