package com.sparklead.menotes.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentEditNotesBinding
import com.sparklead.menotes.ui.model.Notes
import com.sparklead.menotes.ui.viewModel.NotesViewModel
import java.util.*


class EditNotesFragment : Fragment() {

    val notes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding : FragmentEditNotesBinding
    private val viewModel : NotesViewModel by viewModels()
    private var c = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEditNotesBinding.inflate(layoutInflater,container,false)

        setupActionBar()

        //Hide navigation bar
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.visibility = View.GONE

        binding.evHeading.setText(notes.data.Heading)
        binding.evDetails.setText(notes.data.details)

        binding.fabEditSaveNotes.setOnClickListener {
            updateNotes()
        }



        return binding.root
    }

    private fun setupActionBar(){

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarEditNotes)

        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        if (actionBar !=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        }
        binding.toolbarEditNotes.setNavigationOnClickListener{
            requireActivity().onBackPressed()
        }
    }

    private fun updateNotes( ){

        val heading = binding.evHeading.text.toString()
        val details = binding.evDetails.text.toString()

        val d = Date()
        val notesDate : CharSequence = DateFormat.format("MMMM d, yyyy",d.time)

        val data = Notes(
            notes.data.id,
            heading,
            details,
            notesDate.toString()
        )

        viewModel.update(data)

        if(c==0){
            requireActivity().onBackPressed()
        }

//        Navigation.findNavController(view).navigate(R.id.action_editNotesFragment_to_notesFragment)
    }

    override fun onDestroy() {
        c = 1
        updateNotes()
        super.onDestroy()
    }

}