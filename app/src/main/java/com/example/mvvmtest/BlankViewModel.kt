package com.example.mvvmtest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmtest.room.BlankDatabase
import com.example.mvvmtest.room.BlankEntity
import com.example.mvvmtest.room.BlankRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BlankViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : BlankRepository
    val blank: LiveData<BlankEntity>

    init {
        val blankDao = BlankDatabase.getDatabase(application, viewModelScope).blankDao()
        repository = BlankRepository(blankDao)
        blank = repository.blank
    }

    fun insert(blank : BlankEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(blank)
    }

    fun setField1(id:String, txt1:String) = viewModelScope.launch(Dispatchers.IO) {
        repository.setField1(id, txt1)
    }
}