package com.lognote

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lognote.databinding.ActivityNewNoteBinding
import com.lognote.modal.LogNote
import com.lognote.viewModal.LogViewModal
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

class NewNoteActivity : AppCompatActivity() {

    lateinit var dBinding:ActivityNewNoteBinding
    val logViewModal by lazy {  ViewModelProviders.of(this).get(LogViewModal::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          dBinding =  DataBindingUtil.setContentView<ActivityNewNoteBinding>(this,R.layout.activity_new_note)
        .apply {
                this.setLifecycleOwner(this@NewNoteActivity)
                this.viewModal = logViewModal
            }

        val tool =dBinding.tool.toolbar
        tool.title ="New Note"
        setSupportActionBar(dBinding.tool.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        saveBtn.setOnClickListener {
            saveNote()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.new_note_menu,menu)
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        if(item!!.itemId.equals(R.id.action_save))
//            saveNote()
        return super.onOptionsItemSelected(item)
    }

    private fun saveNote() {
        if(logViewModal.title.isEmpty() || logViewModal.description.isEmpty())
            return
        val logNote = LogNote()
        logNote.title = logViewModal.title
        logNote.description = logViewModal.description
        logViewModal.insertNote(logNote)
        finish()
    }
}
