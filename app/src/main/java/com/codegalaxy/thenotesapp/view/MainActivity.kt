package com.codegalaxy.thenotesapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.codegalaxy.thenotesapp.R
import com.codegalaxy.thenotesapp.database.NoteDatabase
import com.codegalaxy.thenotesapp.model.repository.NoteRepository
import com.codegalaxy.thenotesapp.viewmodel.NoteViewModel
import com.codegalaxy.thenotesapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setUpViewModel()
    }

    private fun setUpViewModel(){
        val repository = NoteRepository(NoteDatabase(this))
        val factory = NoteViewModelFactory(repository,application)
        viewModel = ViewModelProvider(this,factory).get(NoteViewModel::class.java)
    }
}