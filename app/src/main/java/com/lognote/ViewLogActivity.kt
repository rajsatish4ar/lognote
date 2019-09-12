package com.lognote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.lognote.modal.LogNote
import com.lognote.utils.Constants.LOG_EXTRA
import kotlinx.android.synthetic.main.activity_view_log.*
import kotlinx.android.synthetic.main.toolbar.*

class ViewLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_log)
        toolbar.title="LogNote"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
        val log:LogNote = Gson().fromJson(intent.getStringExtra(LOG_EXTRA),LogNote::class.java)
        noteTitle.text = log.title
        note.text = log.description
    }
}
