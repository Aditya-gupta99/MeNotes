package com.sparklead.menotes.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


        return binding.root
    }
}