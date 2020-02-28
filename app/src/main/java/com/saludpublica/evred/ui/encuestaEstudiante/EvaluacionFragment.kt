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
import kotlinx.android.synthetic.main.fragment_encuesta_evaluacion.*


class EvaluacionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(
            R.layout.fragment_encuesta_evaluacion,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {

            val respuesta12Id = respuesta12.checkedRadioButtonId
            val respuesta13Id = respuesta13.checkedRadioButtonId
            val respuesta14Id = respuesta14.checkedRadioButtonId
            val respuesta15Id = respuesta15.checkedRadioButtonId
            val respuesta16Id = respuesta16.checkedRadioButtonId
            val respuesta17Id = respuesta17.checkedRadioButtonId

            when {
                respuesta12Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 12",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta13Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 13",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta14Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 14",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta15Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 15",
                    Toast.LENGTH_LONG
                ).show()
                respuesta16Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 16",
                    Toast.LENGTH_LONG
                ).show()
                respuesta17Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 17",
                    Toast.LENGTH_LONG
                ).show()

                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ActitudDocenteFragment()
                    val respuestas = arguments
                    if (respuestas != null) {

                        var radioButton: View = respuesta12.findViewById(respuesta12Id)
                        var indice: Int = respuesta12.indexOfChild(radioButton)
                        var respuesta: RadioButton =
                            respuesta12.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta12", respuesta.text.toString())

                        radioButton = respuesta13.findViewById(respuesta13Id)
                        indice = respuesta13.indexOfChild(radioButton)
                        respuesta = respuesta13.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta13", respuesta.text.toString())

                        radioButton = respuesta14.findViewById(respuesta14Id)
                        indice = respuesta14.indexOfChild(radioButton)
                        respuesta = respuesta14.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta14", respuesta.text.toString())

                        radioButton = respuesta15.findViewById(respuesta15Id)
                        indice = respuesta15.indexOfChild(radioButton)
                        respuesta = respuesta15.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta15", respuesta.text.toString())

                        radioButton = respuesta16.findViewById(respuesta16Id)
                        indice = respuesta16.indexOfChild(radioButton)
                        respuesta = respuesta16.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta16", respuesta.text.toString())

                        radioButton = respuesta17.findViewById(respuesta17Id)
                        indice = respuesta17.indexOfChild(radioButton)
                        respuesta = respuesta17.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta17", respuesta.text.toString())

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