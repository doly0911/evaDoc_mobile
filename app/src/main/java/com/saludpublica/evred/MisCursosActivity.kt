package com.saludpublica.evred

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.saludpublica.evred.ui.encuestaCompromiso.EncuestaCompromisoFragment
import com.saludpublica.evred.ui.encuestaDocente.EncuestaDocenteFragment
import com.saludpublica.evred.ui.encuestaDocente.OnFragmentInteractionListener

import kotlinx.android.synthetic.main.activity_mis_cursos.*

class MisCursosActivity : AppCompatActivity(), OnFragmentInteractionListener {
    override fun onFragmentInteraction(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_cursos)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_bar, menu)
        return true
    }

}
