package com.lognote

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lognote.adapter.NoteAdapter
import kotlinx.android.synthetic.main.content_home.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.lognote.listener.LogClickListener
import com.lognote.modal.LogNote
import com.lognote.utils.Constants.*
import com.lognote.viewModal.LogViewModal
import kotlinx.android.synthetic.main.app_bar_home.*

@Suppress("UNREACHABLE_CODE")
class HomeActivity : AppCompatActivity() {
      val  NEW_LOG = 1234
     lateinit var logsViewModal: LogViewModal
    lateinit var noteAdapter: NoteAdapter
    lateinit var  drawerLayout :DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
       fab.setOnClickListener { view ->
          val intent= Intent(this,NewNoteActivity::class.java)
          startActivityForResult(intent, NEW_LOG)
        }

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        noteAdapter = NoteAdapter(this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=noteAdapter
        recyclerView.setHasFixedSize(true)
        logsViewModal = ViewModelProviders.of(this).get(LogViewModal::class.java)
        logsViewModal.allLogs.observe(this,
            Observer<List<LogNote>> { t -> noteAdapter.setList(t) })


        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                logsViewModal.deleteNote(noteAdapter.getItemAt(viewHolder.adapterPosition))
            }


        }).attachToRecyclerView(recyclerView)


        noteAdapter.setLogClickListener(object :LogClickListener{
            override fun onClick(log: LogNote) {
                 val intent = Intent(this@HomeActivity,ViewLogActivity::class.java)
                 val asString =Gson().toJson(log)
                 intent.putExtra(LOG_EXTRA,asString)
                 startActivityForResult(intent, VIEW)
            }

        })

        val menu = navView.getMenu()

        val subMenu = menu.addSubMenu("SubMenu Title")
        for (i in 1..2) {

            subMenu.add(123,4343,1, "SubMenu Item $i")
            menu.findItem( 4343 ).setIcon( R.drawable.ic_label_outline )
        }
        val subMenu2 = menu.addSubMenu("SubMenu2 ")
        for (i in 1..2) {
            subMenu2.add("SubMenu2 Item $i")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
//            when(requestCode){
//                NEW_NOTE->  logsViewMoodal.insertNote(NOTE_TO_EDIT)
//                UPDATE_NOTE ->  logsViewMoodal.insertNote(NOTE_TO_EDIT)
//            }
//            NOTE_TO_EDIT=null

        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return false
    }


}

