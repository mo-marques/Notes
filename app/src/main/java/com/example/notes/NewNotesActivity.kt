package com.example.notes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewNotesActivity : AppCompatActivity() {

    private lateinit var editNotesView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_notes)
        editNotesView = findViewById(R.id.edit_notes)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editNotesView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val notes = editNotesView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, notes)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object{
        const val EXTRA_REPLY = "com.example.android.notes.Reply"
    }
}