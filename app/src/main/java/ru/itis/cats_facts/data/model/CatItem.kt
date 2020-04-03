package ru.itis.cats_facts.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catItems")
data class CatItem (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val fact: String,
    @ColumnInfo(name = "picId")
    val pic_id: String,
    @ColumnInfo(name = "picUrl")
    val pic_url: String
)
