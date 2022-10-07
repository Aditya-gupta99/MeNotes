package com.sparklead.menotes.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    lateinit var binding : FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotesBinding.inflate(inflater,container,false)

        binding.addNotes.setOnLongClickListener {
            Navigation.findNavController(it).navigate(R.id.action_notesFragment_to_createNotesFragment)
            true
        }

        return binding.root
    }
}