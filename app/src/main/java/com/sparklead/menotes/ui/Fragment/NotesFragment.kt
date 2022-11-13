package com.sparklead.menotes.ui.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentNotesBinding
import com.sparklead.menotes.ui.adapter.NotesAdapter
import com.sparklead.menotes.ui.viewModel.NotesViewModel


class NotesFragment : Fragment() {

    lateinit var binding : FragmentNotesBinding
    val viewModel : NotesViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNotesBinding.inflate(inflater,container,false)

        //navigation to create page
        binding.llFabAddNotes.setOnClickListener {
            findNavController(it).navigate(R.id.action_notesFragment_to_createNotesFragment)
        }
        binding.fabCreateNotes.setOnClickListener {
            findNavController(it).navigate(R.id.action_notesFragment_to_createNotesFragment)
        }

        binding.rvAllNotes.setOnScrollChangeListener { _, scrollX,scrollY, _, oldScrollY ->
            when{
                scrollY > oldScrollY ->{
                    binding.tvFab .isVisible = false

                }
                scrollX == scrollY ->{
                    binding.tvFab.isVisible = true
                }
                else->{
                    binding.tvFab.isVisible = true
                }
            }
        }

        //show notes
        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
            val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            binding.rvAllNotes.layoutManager = staggeredGridLayoutManager
            binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
        }

        //show navigation bar
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.visibility = View.VISIBLE

        return binding.root
    }

}