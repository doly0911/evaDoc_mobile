package com.saludpublica.evred.ui.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saludpublica.evred.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var materias: MutableList<MateriasModel> = ArrayList()
    lateinit var listener: OnclickInterface

    fun HomeAdapter(materias: MutableList<MateriasModel>, onClick: OnclickInterface) {
        this.materias = materias
        this.listener = onClick

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = materias.get(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.materias_view, parent, false)
        return ViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return materias.size
    }

    class ViewHolder(view: View, listener: OnclickInterface) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var listener: OnclickInterface
        val nombre = view.findViewById(R.id.Nombre) as TextView
        val profesor = view.findViewById(R.id.Profesor) as TextView
        lateinit var id:String

        init {
            view.setOnClickListener(this)
            this.listener = listener
        }

        fun bind(materias: MateriasModel) {
            nombre.text = materias.nombre
            profesor.text = materias.profesor
            id=materias.id

        }

        override fun onClick(v: View?) {
            listener.onItemClick(nombre,profesor,id)
        }


    }

    interface OnclickInterface {
        fun onItemClick(nombre:TextView,profesor:TextView,id:String)
    }
}
