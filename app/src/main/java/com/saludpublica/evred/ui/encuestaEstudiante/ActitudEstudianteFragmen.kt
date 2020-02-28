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
import kotlinx.android.synthetic.main.fragment_encuesta_actitud_del_estudiante.*

class ActitudEstudianteFragmen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(
            R.layout.fragment_encuesta_actitud_del_estudiante,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {
            val respuesta22Id = respuesta22.checkedRadioButtonId
            val respuesta23Id = respuesta23.checkedRadioButtonId
            val respuesta24Id = respuesta24.checkedRadioButtonId
            val respuesta25Id = respuesta25.checkedRadioButtonId
            val respuesta26Id = respuesta26.checkedRadioButtonId
            val respuesta27Id = respuesta27.checkedRadioButtonId
            val respuesta28Id = respuesta28.checkedRadioButtonId

            when {
                respuesta22Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 22",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta23Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 23",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta24Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 24",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta25Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 25",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta26Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 26",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta27Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 27",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta28Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 28",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ObservacionesFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        var radioButton: View = respuesta22.findViewById(respuesta22Id)
                        var indice: Int = respuesta22.indexOfChild(radioButton)
                        var respuesta: RadioButton = respuesta22.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta22", respuesta.text.toString())

                        radioButton = respuesta23.findViewById(respuesta23Id)
                        indice = respuesta23.indexOfChild(radioButton)
                        respuesta = respuesta23.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta23", respuesta.text.toString())

                        radioButton = respuesta24.findViewById(respuesta24Id)
                        indice = respuesta24.indexOfChild(radioButton)
                        respuesta = respuesta24.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta24", respuesta.text.toString())

                        radioButton = respuesta25.findViewById(respuesta25Id)
                        indice = respuesta25.indexOfChild(radioButton)
                        respuesta = respuesta25.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta25", respuesta.text.toString())

                        radioButton = respuesta26.findViewById(respuesta26Id)
                        indice = respuesta26.indexOfChild(radioButton)
                        respuesta = respuesta26.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta26", respuesta.text.toString())

                        radioButton = respuesta27.findViewById(respuesta27Id)
                        indice = respuesta27.indexOfChild(radioButton)
                        respuesta = respuesta27.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta27", respuesta.text.toString())

                        radioButton = respuesta28.findViewById(respuesta28Id)
                        indice = respuesta28.indexOfChild(radioButton)
                        respuesta = respuesta28.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta28", respuesta.text.toString())

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