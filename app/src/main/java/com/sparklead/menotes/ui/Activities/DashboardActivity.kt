package com.sparklead.menotes.ui.activities

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sparklead.menotes.R
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar?.hide()

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )

//        bottomNavigationView.background = null

    }

    override fun onStart() {
        super.onStart()
//        bottomNavigationView.setupWithNavController(fragmentContainerView.findNavController())
    }
}