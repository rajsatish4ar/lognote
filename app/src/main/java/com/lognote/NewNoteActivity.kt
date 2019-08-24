package com.lognote

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.gson.Gson
import com.lognote.modal.Note
import kotlinx.android.synthetic.main.activity_new_note.*

class NewNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        toolbar.title="New Note"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId.equals(R.id.action_save))
            saveNote()
        return super.onOptionsItemSelected(item)
    }

    private fun saveNote() {
        if(noteTitle.text.isNullOrEmpty() || note.text.isNullOrEmpty())
            return
        val noteOb = Note()
        noteOb.title = noteTitle.text.toString()
        noteOb.body = note.text.toString()
        val noteAsAString = Gson().toJson(noteOb)
        val returnIntent = Intent();
        returnIntent.putExtra("NEW_NOTE",noteAsAString)
        setResult(Activity.RESULT_OK,returnIntent)
        finish()
    }
}
