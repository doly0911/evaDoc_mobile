package com.saludpublica.evred.ui.encuestaEstudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_encuesta_objetivos_y_contenidos.*

class ObjetivosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(
            R.layout.fragment_encuesta_objetivos_y_contenidos,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {


            val respuesta4Id = respuesta4.checkedRadioButtonId
            val respuesta5Id = respuesta5.checkedRadioButtonId
            val respuesta6Id = respuesta6.checkedRadioButtonId
            when {
                respuesta4Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 4",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta5Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 5",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta6Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 6",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {


                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = AspectosMetodologicosFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        var radioButton: View = respuesta4.findViewById(respuesta4Id)
                        var indice: Int = respuesta4.indexOfChild(radioButton)
                        var respuesta: RadioButton =
                            respuesta4.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta4", respuesta.text.toString())

                        radioButton = respuesta5.findViewById(respuesta5Id)
                        indice = respuesta5.indexOfChild(radioButton)
                        respuesta = respuesta5.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta5", respuesta.text.toString())

                        radioButton = respuesta6.findViewById(respuesta6Id)
                        indice = respuesta6.indexOfChild(radioButton)
                        respuesta = respuesta6.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta6", respuesta.text.toString())


                        fragment.arguments = respuestas
                        fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                        fragmentTransaction?.commit()
                    }
                }
            }
        }
        return root
    }
}