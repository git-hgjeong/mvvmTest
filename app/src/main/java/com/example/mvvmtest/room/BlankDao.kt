package com.example.mvvmtest.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlankDao {
    @Query("SELECT * FROM blank where id=:id")
    fun getBlank(id: String): LiveData<BlankEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: BlankEntity)

    @Query("UPDATE blank SET field1=:txt1 where id=:id")
    fun setField1(id: String, txt1:String)
}