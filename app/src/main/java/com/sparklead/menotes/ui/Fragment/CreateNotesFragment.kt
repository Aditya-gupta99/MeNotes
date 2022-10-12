package com.sparklead.menotes.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentCreateNotesBinding
import com.sparklead.menotes.ui.model.Notes
import com.sparklead.menotes.ui.viewModel.NotesViewModel
import java.util.*


class CreateNotesFragment : Fragment() {

    private lateinit var binding: FragmentCreateNotesBinding
    val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        //action bar
        setupActionBar()


        //Hide navigation bar
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.visibility = View.GONE


        //save button
        binding.fabSaveNotes.setOnClickListener {
            createNotes(it)
        }


        return binding.root

    }

    private fun setupActionBar(){

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarCreateNotes)

        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        if (actionBar !=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        }
        binding.toolbarCreateNotes.setNavigationOnClickListener{
            requireActivity().onBackPressed()
        }
    }

    private fun createNotes(it : View){

        val heading = binding.evHeading.text.toString()
        val details = binding.evDetails.text.toString()

        val d = Date()
        val notesDate : CharSequence = DateFormat.format("MMMM d, yyyy",d.time)

        val data = Notes(
            null,
            Heading = heading,
            details = details,
            date = notesDate.toString()
        )

        viewModel.addNotes(data)

        Toast.makeText(context,"Notes Created successfully! ",Toast.LENGTH_SHORT).show()


    }
}