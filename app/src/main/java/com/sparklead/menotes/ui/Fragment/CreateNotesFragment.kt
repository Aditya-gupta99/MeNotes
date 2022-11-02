package com.sparklead.menotes.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.text.format.DateFormat
import android.view.*
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
    private val viewModel : NotesViewModel by viewModels()
    private var c = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Menu
        setHasOptionsMenu(true)

        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        //action bar
        setupActionBar()



        //Hide navigation bar
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.visibility = View.GONE


        //save button
        binding.fabSaveNotes.setOnClickListener {
            createNotes()
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

        //toolbar
        binding.toolbarCreateNotes.inflateMenu(R.menu.dashboard_menu)
        binding.toolbarCreateNotes.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbarCreateNotes.inflateMenu(R.menu.dashboard_menu)
        binding.toolbarCreateNotes.setOnMenuItemClickListener { menuItem ->
            onOptionsItemSelected(menuItem)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun createNotes(){

        val heading = binding.evHeading.text.toString()
        val details = binding.evDetails.text.toString()

        val checkHeading = TextUtils.isEmpty(binding.evHeading.text.toString().trim{it<= ' '})
        val checkDetails = TextUtils.isEmpty(binding.evDetails.text.toString().trim{it<= ' '})

        val d = Date()
        val notesDate : CharSequence = DateFormat.format("MMMM d, yyyy",d.time)

        if(checkHeading && checkDetails){
            if(c==0){
                requireActivity().onBackPressed()
            }

        }
        else{
            val data = Notes(
                null,
                Heading = heading,
                details = details,
                date = notesDate.toString()
            )

            viewModel.addNotes(data)
            if(c==0){
                requireActivity().onBackPressed()
            }

        }


//        Toast.makeText(context,"Notes Created successfully! ",Toast.LENGTH_SHORT).show()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share->{
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        c = 1
        createNotes()
        super.onDestroy()
    }
}