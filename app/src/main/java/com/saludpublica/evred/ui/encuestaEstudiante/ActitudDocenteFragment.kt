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
import kotlinx.android.synthetic.main.fragment_encuesta_actitud_del_docente.*

class ActitudDocenteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(
            R.layout.fragment_encuesta_actitud_del_docente,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {
            val respuesta18Id = respuesta18.checkedRadioButtonId
            val respuesta19Id = respuesta19.checkedRadioButtonId
            val respuesta20Id = respuesta20.checkedRadioButtonId
            val respuesta21Id = respuesta21.checkedRadioButtonId

            when {
                respuesta18Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 18",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta19Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 19",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta20Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 20",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta21Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 21",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ActitudEstudianteFragmen()
                    val respuestas = arguments
                    if (respuestas != null) {
                        var radioButton: View = respuesta18.findViewById(respuesta18Id)
                        var indice: Int = respuesta18.indexOfChild(radioButton)
                        var respuesta: RadioButton = respuesta18.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta18", respuesta.text.toString())

                        radioButton = respuesta19.findViewById(respuesta19Id)
                        indice = respuesta19.indexOfChild(radioButton)
                        respuesta = respuesta19.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta19", respuesta.text.toString())

                        radioButton = respuesta20.findViewById(respuesta20Id)
                        indice = respuesta20.indexOfChild(radioButton)
                        respuesta = respuesta20.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta20", respuesta.text.toString())

                        radioButton = respuesta21.findViewById(respuesta21Id)
                        indice = respuesta21.indexOfChild(radioButton)
                        respuesta = respuesta21.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta21", respuesta.text.toString())

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