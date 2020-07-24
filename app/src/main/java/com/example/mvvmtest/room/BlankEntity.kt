package com.example.mvvmtest.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blank")
class BlankEntity(
    @ColumnInfo(name = "id") @PrimaryKey val id : String,
    @ColumnInfo(name = "field1") val filed1 : String,
    @ColumnInfo(name = "field2") val filed2 : String
)