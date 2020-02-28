package com.saludpublica.evred.ui.encuestaDocente

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_encuesta_docente.*


class EncuestaDocenteFragment : Fragment() {
    private var numeroPregunta: Int = 1
    private var encuestaDocenteModel = EncuestaDocenteModel()
    private var isChecking = true
    private var mCheckedId: Int = R.id.radioButton171
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_encuesta_docente, container, false)
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        val radionB1: RadioGroup = root.findViewById(R.id.respuesta_1)
        val radionB2: RadioGroup = root.findViewById(R.id.respuesta_2)


        var radioButtonId1: Int
        var radioButtonId2: Int
        var argumentoTxt: String
        var radioButtonView1: View
        var indice1 = 1
        var radioButtonView2: View
        var indice2 = 1
        var radioButtomRespuesta2: RadioButton
        var radioButtomRespuesta1: RadioButton
        var respuesta = ""

        radionB1.setOnCheckedChangeListener { _, checkedId1 ->
            if (checkedId1 != -1) {
                if (checkedId1 != -1 && isChecking) {
                    isChecking = false
                    respuesta_2.clearCheck()
                    mCheckedId = checkedId1
                }
                isChecking = true
            }
        }

        radionB2.setOnCheckedChangeListener { _, checkedId2 ->
            if (checkedId2 != -1) {
                if (checkedId2 != -1 && isChecking) {
                    isChecking = false
                    respuesta_1.clearCheck()
                    mCheckedId = checkedId2
                }
                isChecking = true
            }
        }
        siguiente.setOnClickListener {

            radioButtonId1 = respuesta_1.checkedRadioButtonId
            radioButtonId2 = respuesta_2.checkedRadioButtonId
            argumentoTxt = argumento.text.toString()/*.replace(" ","",false)*/
            if ((radioButtonId1 == -1 && radioButtonId2 == -1) || argumentoTxt == "") {
                Toasty.error(
                    context,
                    "Por favor responder la pregunta",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                when {
                    radioButtonId1 != -1 -> {
                        radioButtonView1 = respuesta_1.findViewById(radioButtonId1)
                        indice1 = respuesta_1.indexOfChild(radioButtonView1)
                    }
                    radioButtonId2 != -1 -> {
                        radioButtonView2 = respuesta_2.findViewById(radioButtonId2)
                        indice2 = respuesta_2.indexOfChild(radioButtonView2)
                    }
                }
                when {
                    indice1 != -1 -> {
                        radioButtomRespuesta2 = respuesta_1.getChildAt(indice2) as RadioButton
                        respuesta = radioButtomRespuesta2.text.toString()
                    }
                    indice2 != -1 -> {
                        radioButtomRespuesta1 = respuesta_1.getChildAt(indice1) as RadioButton
                        respuesta = radioButtomRespuesta1.text.toString()
                    }
                }

                //guardar informacion
                when (numeroPregunta) {
                    1 -> {
                        encuestaDocenteModel.respuesta1 = respuesta
                        encuestaDocenteModel.argumento1 = argumentoTxt
                    }
                    2 -> {
                        encuestaDocenteModel.respuesta2 = respuesta
                        encuestaDocenteModel.argumento2 = argumentoTxt
                    }
                    3 -> {
                        encuestaDocenteModel.respuesta3 = respuesta
                        encuestaDocenteModel.argumento3 = argumentoTxt
                    }
                    4 -> {
                        encuestaDocenteModel.respuesta4 = respuesta
                        encuestaDocenteModel.argumento4 = argumentoTxt
                    }
                    5 -> {
                        encuestaDocenteModel.respuesta5 = respuesta
                        encuestaDocenteModel.argumento5 = argumentoTxt
                    }
                    6 -> {
                        encuestaDocenteModel.respuesta6 = respuesta
                        encuestaDocenteModel.argumento6 = argumentoTxt
                    }
                }
                respuesta_1.clearCheck()
                respuesta_2.clearCheck()
                argumento.text.clear()

                if (numeroPregunta < 6) {
                    numeroPregunta++
                }
                when (numeroPregunta) {
                    2 -> {
                        pregunta.text = getString(R.string.PreguntaD2)
                        atras.visibility = View.VISIBLE

                    }
                    3 -> pregunta.text = getString(R.string.PreguntaD3)
                    4 -> pregunta.text = getString(R.string.PreguntaD4)
                    5 -> pregunta.text = getString(R.string.PreguntaD5)
                    6 -> {
                        pregunta.text = getString(R.string.observaciones)
                        siguiente.text = "Terminar"
                        respuesta_1.visibility = View.GONE
                    }
                }
            }
        }
        val atras: Button = root.findViewById(R.id.atras)
        atras.setOnClickListener {
            numeroPregunta--
            when (numeroPregunta) {
                1 -> {
                    pregunta.text = getString(R.string.PreguntaD1)
                    atras.visibility = View.INVISIBLE
                }
                2 -> pregunta.text = getString(R.string.PreguntaD2)
                3 -> pregunta.text = getString(R.string.PreguntaD3)
                4 -> pregunta.text = getString(R.string.PreguntaD4)
                5 -> {
                    pregunta.text = getString(R.string.PreguntaD5)
                    siguiente.text = "Siguiente"
                    respuesta_1.visibility = View.VISIBLE
                }
            }
            //recargar los valores correspondientes
        }
        return root
    }
}