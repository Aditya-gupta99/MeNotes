package com.sparklead.menotes.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.findFragment
import com.sparklead.menotes.R
import com.sparklead.menotes.databinding.FragmentNotesBinding
import kotlinx.android.synthetic.main.fragment_create_notes.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNotesBinding.inflate(layoutInflater,container,false)

        return binding.root


    }

//    private fun setupActionBar(){
//
//        val tb = view?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_create_notes)
//
//        (activity as AppCompatActivity).setSupportActionBar(tb)
//
//        val actionBar = (activity as AppCompatActivity).supportActionBar
//        if (actionBar !=null)
//        {
//            actionBar.setDisplayHomeAsUpEnabled(true)
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
//        }
//
//        tb!!.setNavigationOnClickListener{
//            requireActivity().onBackPressed()
//        }
//    }
}