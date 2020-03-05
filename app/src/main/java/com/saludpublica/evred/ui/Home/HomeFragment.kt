package com.saludpublica.evred.ui.Home

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
    private val TAG = "HomeFragment"


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

        val mAlertDialogBtn = root.findViewById<Button>(R.id.btn_showAlertDialog)
        mAlertDialogBtn.setOnClickListener {
            Log.i(TAG,"Pruebita")
            val mAlertDialog = AlertDialog.Builder (root.context)
                .setTitle("titulo x")
                .setMessage("Pruebita del texto")

                .setPositiveButton("Acepto",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(root.context, "Yep", Toast.LENGTH_SHORT).show()
                    })

                .setNegativeButton("Cancelar"){ dialog: DialogInterface?, which: Int ->
                    dialog?.dismiss()
            }

            // Create the AlertDialog object and return it
            mAlertDialog.show()
        }
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

        val bundle = Bundle()
        val fragmentTransaction = fragmentManager?.beginTransaction()
        var fragment = Fragment()

        var cargo = pref.getString("cargo", null)
        when (cargo) {
            "estudiante" -> {
                fragment = AspectosGeneralesFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
            "docente" -> {
                fragment = EncuestaDocenteFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
            "compromiso" -> {
                fragment = EncuestaCompromisoFragment()
                fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                fragmentTransaction?.commit()
            }
        }
        bundle.putString("curso", nombre.text.toString())
        fragment.arguments = bundle

    }
}