package com.rimapps.PlayGround.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.PlayGround.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rimapps.PlayGround.BaseApplication
import com.rimapps.PlayGround.adapters.NoteListAdapter
import com.rimapps.PlayGround.model.Note
import com.rimapps.PlayGround.viewmodel.NoteViewModel
import com.rimapps.PlayGround.viewmodel.NoteViewModelFactory


class NoteActivity : AppCompatActivity() {

    private val newNoteActivityRequestCode = 1
    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((application as BaseApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val recyclerView = findViewById<RecyclerView>(R.id.rvNotes)
        val adapter = NoteListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@NoteActivity, NewNoteActivity::class.java)
            startActivityForResult(intent, newNoteActivityRequestCode)
        }
        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        noteViewModel.allNotes.observe(this) { notes ->
            // Update the cached copy of the words in the adapter.
            notes.let { adapter.submitList(it) }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newNoteActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewNoteActivity.EXTRA_REPLY)?.let { reply ->
                val note = Note(reply)
                noteViewModel.insert(note)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}
