package com.saludpublica.evred.ui.encuestaEstudiante

import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SpinnerFragment: Fragment() , AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        Toast.makeText(parent.context,
            "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
            Toast.LENGTH_SHORT).show();
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}
