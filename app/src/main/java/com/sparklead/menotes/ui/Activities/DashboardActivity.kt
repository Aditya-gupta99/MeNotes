package com.sparklead.menotes.ui.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.ActivityDashboardBinding
import com.sparklead.menotes.ui.fragment.CreateNotesFragment
import com.sparklead.menotes.ui.fragment.NotesFragment
import com.sparklead.menotes.ui.fragment.TodoFragment
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : BaseActivity() {

    private lateinit var navController : NavController
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val fragmentNotes = NotesFragment()
        val fragmentTodo = TodoFragment()
        val fragmentCreateNotes = CreateNotesFragment()

        replaceCurrentFragment(fragmentNotes)

        fab_notes.setOnLongClickListener {
            mCount=0
            replaceCurrentFragment(fragmentCreateNotes)
//            it.findNavController().navigate(R.id.fragmentContainerView)
            true
        }

        fab_todo.setOnClickListener {
            mCount=0
            replaceCurrentFragment(fragmentTodo)
        }

    }

    private fun replaceCurrentFragment(fragment: Fragment){
        mCount=0
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }

    override fun onBackPressed() {
        if(mCount == 0) {
            goNotesFragment()
        }
        else{
            doubleBackToExit()
        }
        mCount++
    }

    private fun goNotesFragment(){
        val fragmentHome = NotesFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView,fragmentHome)
            commit()
        }
    }

}