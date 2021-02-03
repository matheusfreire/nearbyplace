package com.msf.nearby.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.msf.nearby.R
import com.msf.nearby.vm.PlacesViewModel

class CafeFragment : BaseFragment() {

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
        type = "cafe"
    }
}