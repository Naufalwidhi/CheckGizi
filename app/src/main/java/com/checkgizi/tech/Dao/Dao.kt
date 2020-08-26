package com.checkgizi.tech.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.checkgizi.tech.Model.DataAnak2


@Dao
interface DataDao {

    @Insert
    fun insertAll(vararg Data: DataAnak2)

    @Delete
    fun delete(movie: DataAnak2)

    @Query("SELECT * FROM DataAnak2")
    fun getAllMovies(): List<DataAnak2>

    @Query("SELECT * FROM DataAnak2 WHERE umur = :umuranak LIMIT 1")
    fun getMovieWithID(umuranak: String): DataAnak2?

}