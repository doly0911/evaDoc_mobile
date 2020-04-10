package com.saludpublica.evred.ui.Home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        holder.btnEvaluar.setOnClickListener(View.OnClickListener {
            listener.onItemClick(holder.curso,holder.profesor,holder.codigo.text.toString())
        })
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
        val curso = view.findViewById(R.id.nom_curso_txt) as TextView
        val profesor = view.findViewById(R.id.nom_profesor_txt) as TextView
        val grupo = view.findViewById(R.id.nom_grupo_txt) as TextView
        val codigo = view.findViewById(R.id.nom_codigo_txt) as TextView
        val btnEvaluar = view.findViewById(R.id.btnEvaluar) as Button

        lateinit var id:String

        init {
            view.setOnClickListener(this)
            this.listener = listener
        }

        fun bind(materias: MateriasModel) {
            curso.text = materias.curso
            profesor.text = materias.profesor
            codigo.text = materias.codigo
            grupo.text = materias.grupo
        }


        /**
         * Se quita la funcionalidad del método OnClick
         */
        override fun onClick(v: View?) {
            return
        }


    }

    interface OnclickInterface {
        fun onItemClick(nombre:TextView,profesor:TextView,id:String)
    }
}
