package com.lognote

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.lognote.adapter.NoteAdapter
import com.lognote.modal.Note
import com.lognote.viewModal.NoteViewModal
import kotlinx.android.synthetic.main.content_home.*

class HomeActivity : AppCompatActivity() {

     lateinit var noteViewMoodal:NoteViewModal
    lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
          val intent= Intent(this,NewNoteActivity::class.java)
          startActivityForResult(intent,2000)
        }
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val navView: NavigationView = findViewById(R.id.nav_view)
        noteAdapter = NoteAdapter(this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=noteAdapter
        recyclerView.setHasFixedSize(true)
        noteViewMoodal = ViewModelProviders.of(this).get(NoteViewModal::class.java)
        noteViewMoodal.allNotes.observe(this,object :Observer<List<Note>>{
            override fun onChanged(t: List<Note>?) {
                noteAdapter.setList(t)
            }

        })
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewMoodal.deleteNote(noteAdapter.getItemAt(viewHolder.adapterPosition))
            }


        }).attachToRecyclerView(recyclerView)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==2000 && resultCode== Activity.RESULT_OK){
            val note = Gson().fromJson(data?.getStringExtra("NEW_NOTE"),Note::class.java)
            noteViewMoodal.insertNote(note)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }
}
