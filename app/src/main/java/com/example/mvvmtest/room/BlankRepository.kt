package com.example.mvvmtest.room

import androidx.lifecycle.LiveData

class BlankRepository(private val blankDao : BlankDao) {
    val blank : LiveData<BlankEntity> = blankDao.getBlank("1")

    suspend fun insert(blank : BlankEntity){
        blankDao.insert(blank)
    }

    suspend fun setField1(id:String, txt1:String){
        blankDao.setField1(id, txt1)
    }
}