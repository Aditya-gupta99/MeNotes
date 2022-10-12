package com.sparklead.menotes.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentNotesBinding
import com.sparklead.menotes.ui.adapter.NotesAdapter
import com.sparklead.menotes.ui.viewModel.NotesViewModel


class NotesFragment : Fragment() {

    lateinit var binding : FragmentNotesBinding
    val viewModel : NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNotesBinding.inflate(inflater,container,false)

        //navigation to create page
        binding.fabCreateNotes.setOnClickListener {
            findNavController(it).navigate(R.id.action_notesFragment_to_createNotesFragment)
        }

        //show notes
        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.rvAllNotes.layoutManager = GridLayoutManager(context, 2)
            binding.rvAllNotes.adapter = NotesAdapter(context, notesList)

        }



        //show navigation bar
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.visibility = View.VISIBLE

        return binding.root
    }
}