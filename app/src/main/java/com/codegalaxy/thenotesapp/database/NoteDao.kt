package com.codegalaxy.thenotesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.codegalaxy.thenotesapp.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Select * From notes order by  id Desc")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("Select * from NOTES where noteTitle Like :query OR noteDesc LIKE :query")
    fun searchNote(query: String?): LiveData<List<Note>>
}