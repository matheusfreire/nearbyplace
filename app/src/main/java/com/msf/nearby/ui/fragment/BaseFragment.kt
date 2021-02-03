package com.msf.nearby.ui.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.libraries.places.api.model.Place
import com.msf.nearby.vm.PlacesViewModel

open class BaseFragment : Fragment(){

    private lateinit var placesViewModel: PlacesViewModel

    protected var type: String
        get() {
            return this.type
        }
        set(value) {
            this.type = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        placesViewModel = ViewModelProvider(requireActivity()).get(PlacesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        loading(true)
        if(isOnline()) {
            placesViewModel.fetchType(type)
            placesViewModel.placeLiveData?.observe(this, { list ->
                list?.let {  places ->
                    showItens(places)
                } ?: run {
                    showNoItem()
                }
            })
        } else {
            showProblem()
        }
    }

    private fun showProblem() {

    }

    private fun isOnline(): Boolean {
        val connectivityManager = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun loading(show: Boolean) {
//        loadingView.visibility(if (show) View.VISIBLE else View.INVISIBLE)
    }

    private fun showNoItem() {

    }

    private fun showItens(list: List<Place>) {

    }

}
