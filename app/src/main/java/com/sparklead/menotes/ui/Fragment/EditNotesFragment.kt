package com.sparklead.menotes.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

        //Menu
        setHasOptionsMenu(true)

        binding = FragmentEditNotesBinding.inflate(layoutInflater,container,false)

        setupActionBar()

        //Hide navigation bar
//        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        navBar.visibility = View.GONE

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

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbarEditNotes.inflateMenu(R.menu.dashboard_menu)
        binding.toolbarEditNotes.setOnMenuItemClickListener { menuItem ->
            onOptionsItemSelected(menuItem)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share->{
                val heading = binding.evHeading.text.toString()
                val details = binding.evDetails.text.toString()
                val send = "$heading\n$details"
                shareText(send)
            }
            R.id.action_delete->{
                val dialogBuilder = android.app.AlertDialog.Builder(context,R.style.BottomSheetStyle)
                val view = layoutInflater.inflate(R.layout.dialog_delete_notes, null)
                val yes = view.findViewById<TextView>(R.id.tv_yes)
                val no = view.findViewById<TextView>(R.id.tv_no)
                dialogBuilder.setView(view)
                val alertDialog = dialogBuilder.create()
                alertDialog.show()
                alertDialog.setCancelable(true)
                yes.setOnClickListener {
                    viewModel.deleteNotes(notes.data.id!!)
                    requireActivity().onBackPressed()
                    alertDialog.dismiss()
                }
                no.setOnClickListener {
                    alertDialog.dismiss()
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareText(send: String ) {
        val txtIntent = Intent(Intent.ACTION_SEND)
        txtIntent.type = "text/plain"
//        txtIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        txtIntent.putExtra(Intent.EXTRA_TEXT, send)
        startActivity(Intent.createChooser(txtIntent, "Share"))
    }
}