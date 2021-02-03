package com.msf.nearby.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.libraries.places.api.model.Place
import com.msf.nearby.network.Repository

class PlacesViewModel : ViewModel() {
    private val _currentFragment = MutableLiveData<Int>()
    private val _adapter = MutableLiveData<List<Place>?>()

    private val repo: Repository by lazy {
        return@lazy Repository()
    }

    val placeLiveData: LiveData<List<Place>?>
        get() {
            return _adapter
        }


    val lastFragmentId: Int
        get() {
            return _currentFragment.value ?: 0
        }

    fun updateActualFragment(id: Int?) {
        _currentFragment.postValue(id)
    }

    fun fetchType(type: String) {
        repo.fetchPlaces(type) {
            _adapter.postValue(it?.success?.places)
        }
    }


}