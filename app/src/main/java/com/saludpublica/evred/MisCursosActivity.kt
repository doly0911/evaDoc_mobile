package com.saludpublica.evred

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import com.saludpublica.evred.ui.encuestaDocente.OnFragmentInteractionListener


class MisCursosActivity : AppCompatActivity(), OnFragmentInteractionListener {

    lateinit var pref: SharedPreferences
    override fun onFragmentInteraction(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_cursos)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        pref = this.getSharedPreferences(
            "UserData",
            Context.MODE_PRIVATE
        )

        val cargo = pref.getString("cargo", null)
        val navGraph = this.findNavController(R.id.nav_host_fragment).graph;

        if(cargo.equals("compromiso",true)  ){
            navGraph.startDestination = R.id.nav_encuestaCompromisos
            this.findNavController(R.id.nav_host_fragment).graph = navGraph
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav_bar, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            //Caso cuando el menuItem seleccionado es cerrar sesion
            R.id.cerrar_sesion -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
