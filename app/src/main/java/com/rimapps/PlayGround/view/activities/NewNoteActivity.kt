package com.rimapps.PlayGround.view.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.PlayGround.R

class NewNoteActivity : AppCompatActivity() {
    private lateinit var editNoteView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        editNoteView = findViewById(R.id.edit_word)
        val button = findViewById<Button>(R.id.button_save)

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editNoteView.text)){
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }
            else{
                val note = editNoteView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, note)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()

        }

    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}