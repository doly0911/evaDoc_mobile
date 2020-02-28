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

import kotlinx.android.synthetic.main.fragment_encuesta_aspectos_metodologicos.*

class AspectosMetodologicosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(
            R.layout.fragment_encuesta_aspectos_metodologicos,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener {

            val respuestaItem1Id = respuestaItem1.checkedRadioButtonId
            val respuestaItem2Id = respuestaItem2.checkedRadioButtonId
            val respuestaItem3Id = respuestaItem3.checkedRadioButtonId
            val respuestaItem4Id = respuestaItem4.checkedRadioButtonId
            val respuestaItem5Id = respuestaItem5.checkedRadioButtonId
            val respuestaItem6Id = respuestaItem6.checkedRadioButtonId
            val respuestaItem7Id = respuestaItem7.checkedRadioButtonId
            val respuestaItem8Id = respuestaItem8.checkedRadioButtonId
            val respuesta8Id = respuesta8.checkedRadioButtonId
            val respuesta9Id = respuesta9.checkedRadioButtonId
            val respuesta10Id = respuesta10.checkedRadioButtonId
            val respuesta11Id = respuesta11.checkedRadioButtonId
            when {
                respuestaItem1Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 1",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem2Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 2",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem3Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 3",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem4Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 4",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem5Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 5",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem6Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 6",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem7Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 7",
                    Toast.LENGTH_LONG
                )
                    .show()

                respuestaItem8Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder el item 8",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta8Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 8",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta9Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 9",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta10Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 10",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta11Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 11",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = EvaluacionFragment()
                    val respuestas = arguments
                    if (respuestas != null) {
                        var radioButton: View = respuestaItem1.findViewById(respuestaItem1Id)
                        var indice: Int = respuestaItem1.indexOfChild(radioButton)
                        var respuesta: RadioButton =
                            respuestaItem1.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem1", respuesta.text.toString())

                        radioButton = respuestaItem2.findViewById(respuestaItem2Id)
                        indice = respuestaItem2.indexOfChild(radioButton)
                        respuesta = respuestaItem2.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem2", respuesta.text.toString())

                        radioButton = respuestaItem3.findViewById(respuestaItem3Id)
                        indice = respuestaItem3.indexOfChild(radioButton)
                        respuesta = respuestaItem3.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem3", respuesta.text.toString())

                        radioButton = respuestaItem4.findViewById(respuestaItem4Id)
                        indice = respuestaItem4.indexOfChild(radioButton)
                        respuesta = respuestaItem4.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem4", respuesta.text.toString())

                        radioButton = respuestaItem5.findViewById(respuestaItem5Id)
                        indice = respuestaItem5.indexOfChild(radioButton)
                        respuesta = respuestaItem5.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem5", respuesta.text.toString())

                        radioButton = respuestaItem6.findViewById(respuestaItem6Id)
                        indice = respuestaItem6.indexOfChild(radioButton)
                        respuesta = respuestaItem6.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem6", respuesta.text.toString())

                        radioButton = respuestaItem7.findViewById(respuestaItem7Id)
                        indice = respuestaItem7.indexOfChild(radioButton)
                        respuesta = respuestaItem7.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem7", respuesta.text.toString())

                        radioButton = respuestaItem8.findViewById(respuestaItem8Id)
                        indice = respuestaItem8.indexOfChild(radioButton)
                        respuesta = respuestaItem8.getChildAt(indice) as RadioButton
                        respuestas.putString("respuestaItem8", respuesta.text.toString())

                        radioButton = respuesta8.findViewById(respuesta8Id)
                        indice = respuesta8.indexOfChild(radioButton)
                        respuesta = respuesta8.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta8", respuesta.text.toString())

                        radioButton = respuesta9.findViewById(respuesta9Id)
                        indice = respuesta9.indexOfChild(radioButton)
                        respuesta = respuesta9.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta9", respuesta.text.toString())

                        radioButton = respuesta10.findViewById(respuesta10Id)
                        indice = respuesta10.indexOfChild(radioButton)
                        respuesta = respuesta10.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta10", respuesta.text.toString())

                        radioButton = respuesta11.findViewById(respuesta11Id)
                        indice = respuesta11.indexOfChild(radioButton)
                        respuesta = respuesta11.getChildAt(indice) as RadioButton
                        respuestas.putString("respuesta11", respuesta.text.toString())

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