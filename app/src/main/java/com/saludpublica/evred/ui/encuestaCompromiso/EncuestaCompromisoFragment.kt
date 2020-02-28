package com.saludpublica.evred.ui.encuestaCompromiso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CompromisoAdapter
import com.saludpublica.evred.R
import java.util.*


class EncuestaCompromisoFragment : Fragment(), CompromisoAdapter.CustomListener {
    var numeroC = 1
    var textId = "Compromiso"
    var list = ArrayList<String>()
    var adapter = CompromisoAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_encuesta_compromiso, container, false)
        val context = root.context
        val addButton: ImageButton = root.findViewById(R.id.AddButton)
        val terminar: Button = root.findViewById(R.id.terminar)
        val rvList: RecyclerView = root.findViewById(R.id.rvList)

        rvList.adapter = adapter

        rvList.layoutManager = LinearLayoutManager(context)


        addButton.setOnClickListener() {
            list.add("")
            adapter = CompromisoAdapter(list, this)
            rvList.setAdapter(adapter)
            adapter.notifyDataSetChanged()

        }

        terminar.setOnClickListener {
            for (item in list) {
                println(item)
            }

        }
        return root
    }

    override fun onTextChange(position: Int, text: String) {
        list.set(position, text)

    }
}