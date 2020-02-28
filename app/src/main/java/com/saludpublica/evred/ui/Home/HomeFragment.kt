package com.saludpublica.evred.ui.Home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CompromisoAdapter
import com.saludpublica.evred.R
import com.saludpublica.evred.ui.encuestaCompromiso.EncuestaCompromisoFragment
import com.saludpublica.evred.ui.encuestaDocente.EncuestaDocenteFragment
import com.saludpublica.evred.ui.encuestaEstudiante.AspectosGeneralesFragment

class HomeFragment : Fragment(), HomeAdapter.OnclickInterface {
    lateinit var view: Context
    lateinit var pref :SharedPreferences
    private val fragmentTransaction = fragmentManager?.beginTransaction()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        view = root.context
        val context = root.context
        lateinit var mRecyclerView: RecyclerView
        val mAdapter = HomeAdapter()
        pref= view.getSharedPreferences(
            "UserData",
            Context.MODE_PRIVATE
        )
        mRecyclerView = root.findViewById(R.id.rvMaterias) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter.HomeAdapter(getMaterias(), this)
        mRecyclerView.adapter = mAdapter
        return root
    }

    fun getMaterias(): MutableList<MateriasModel> {
        var materias: MutableList<MateriasModel> = ArrayList()
        materias.add(
            MateriasModel(
                "matematicas",
                "julio",
                "1"
            )
        )
        materias.add(
            MateriasModel(
                "logica",
                "roberto",
                "2"
            )
        )
        materias.add(
            MateriasModel(
                "calidad",
                "elmo",
                "3"
            )
        )


        return materias
    }

    override fun onItemClick(nombre: TextView, profesor: TextView, id: String) {

        var cargo = pref.getString("cargo", null)
        when (cargo) {
            "estudiante" -> {
                val fragment = AspectosGeneralesFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
            "docente" -> {
                val fragment = EncuestaDocenteFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
            "compromiso" -> {
                val fragment = EncuestaCompromisoFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
        }

    }
}