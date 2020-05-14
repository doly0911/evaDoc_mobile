package com.saludpublica.evred.ui.encuestaEstudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import com.saludpublica.evred.ui.Home.HomeFragment
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
        val respuestas = arguments
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener {

            val respuestaItem1Id = root.findViewById<Spinner>(R.id.respuestaItem1)
            val respuestaItem2Id = root.findViewById<Spinner>(R.id.respuestaItem2)
            val respuestaItem3Id = root.findViewById<Spinner>(R.id.respuestaItem3)
            val respuestaItem4Id = root.findViewById<Spinner>(R.id.respuestaItem4)
            val respuestaItem5Id = root.findViewById<Spinner>(R.id.respuestaItem5)
            val respuestaItem6Id = root.findViewById<Spinner>(R.id.respuestaItem6)
            val respuestaItem7Id = root.findViewById<Spinner>(R.id.respuestaItem7)
            val respuestaItem8Id = root.findViewById<Spinner>(R.id.respuestaItem8)
            val respuesta8Id = respuesta8.checkedRadioButtonId
            val respuesta9Id = respuesta9.checkedRadioButtonId
            val respuesta10Id = respuesta10.checkedRadioButtonId
            val respuesta11Id = respuesta11.checkedRadioButtonId
            when {
                respuestaItem1Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 1",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem2Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 2",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem3Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 3",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem4Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 4",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem5Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 5",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem6Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 6",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuestaItem7Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
                    context,
                    "Por favor responder el item 7",
                    Toast.LENGTH_LONG
                )
                    .show()

                respuestaItem8Id.selectedItemId == AdapterView.INVALID_ROW_ID -> Toasty.error(
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

                    if (respuestas != null) {

                        respuestas.putString("respuestaItem1", respuestaItem1.selectedItem.toString())
                        respuestas.putString("respuestaItem2", respuestaItem2.selectedItem.toString())
                        respuestas.putString("respuestaItem3", respuestaItem3.selectedItem.toString())
                        respuestas.putString("respuestaItem4", respuestaItem4.selectedItem.toString())
                        respuestas.putString("respuestaItem5", respuestaItem5.selectedItem.toString())
                        respuestas.putString("respuestaItem6", respuestaItem6.selectedItem.toString())
                        respuestas.putString("respuestaItem7", respuestaItem7.selectedItem.toString())
                        respuestas.putString("respuestaItem8", respuestaItem8.selectedItem.toString())

                        var radioButton:RadioButton= respuesta8.findViewById(respuesta8Id)
                        var indice = respuesta8.indexOfChild(radioButton)
                        var respuesta = respuesta8.getChildAt(indice) as RadioButton
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

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            val fragment = ObjetivosFragment()
            fragment.arguments = respuestas
            fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
            fragmentTransaction?.commit()
        }
        return root
    }
}