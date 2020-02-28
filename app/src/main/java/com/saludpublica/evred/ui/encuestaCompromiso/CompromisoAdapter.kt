package com.example.myapplication

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.saludpublica.evred.R
import java.util.*

class CompromisoAdapter(
    private val list: ArrayList<String>,
    private val listener: CustomListener
) :
    RecyclerView.Adapter<CompromisoAdapter.Holder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.compromiso_view, parent, false)
        return Holder(itemView, listener)
    }

    override fun onBindViewHolder(
        holder: Holder,
        position: Int
    ) {
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder(
        itemView: View,
        private val listener: CustomListener
    ) :
        RecyclerView.ViewHolder(itemView), TextWatcher {
        private val etField: EditText
        override fun beforeTextChanged(
            s: CharSequence,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(
            s: CharSequence,
            start: Int,
            before: Int,
            count: Int
        ) {
        }

        override fun afterTextChanged(s: Editable) {
            listener.onTextChange(adapterPosition, s.toString())
        }

        init {
            etField = itemView.findViewById(R.id.editText)
            etField.addTextChangedListener(this)
        }
    }

    interface CustomListener {
        fun onTextChange(position: Int, text: String)
    }

}