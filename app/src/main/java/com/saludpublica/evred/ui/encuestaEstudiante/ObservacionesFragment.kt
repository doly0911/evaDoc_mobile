package com.saludpublica.evred.ui.encuestaEstudiante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_encuesta_observaciones_y_concluciones.*

class ObservacionesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        var encuestaEstudianteModel = EncuestaEstudianteModel()
        val root = inflater.inflate(
            R.layout.fragment_encuesta_observaciones_y_concluciones,
            container,
            false
        )
        val context = root.context
        val finalizar: Button = root.findViewById(R.id.finalizar)
        finalizar.setOnClickListener() {
            if (observacion.text.toString() == "") {
                Toasty.error(
                    context,
                    "Por favor llenar el campo de observaciones",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val respuestas = arguments
                if (respuestas != null) {
                    encuestaEstudianteModel.respuesta1 =
                        respuestas.getString("respuesta1").toString()
                    encuestaEstudianteModel.respuesta2 =
                        respuestas.getString("respuesta2").toString()
                    encuestaEstudianteModel.respuesta3 =
                        respuestas.getString("respuesta3").toString()
                    encuestaEstudianteModel.respuesta4 =
                        respuestas.getString("respuesta4").toString()
                    encuestaEstudianteModel.respuesta5 =
                        respuestas.getString("respuesta5").toString()
                    encuestaEstudianteModel.respuesta6 =
                        respuestas.getString("respuesta6").toString()
                    encuestaEstudianteModel.respuestaItem7 =
                        respuestas.getString("respuestaItem1").toString()
                    encuestaEstudianteModel.respuestaItem2 =
                        respuestas.getString("respuestaItem2").toString()
                    encuestaEstudianteModel.respuestaItem3 =
                        respuestas.getString("respuestaItem3").toString()
                    encuestaEstudianteModel.respuestaItem4 =
                        respuestas.getString("respuestaItem4").toString()
                    encuestaEstudianteModel.respuestaItem5 =
                        respuestas.getString("respuestaItem5").toString()
                    encuestaEstudianteModel.respuestaItem6 =
                        respuestas.getString("respuestaItem6").toString()
                    encuestaEstudianteModel.respuestaItem7 =
                        respuestas.getString("respuestaItem7").toString()
                    encuestaEstudianteModel.respuestaItem8 =
                        respuestas.getString("respuestaItem8").toString()
                    encuestaEstudianteModel.respuesta8 =
                        respuestas.getString("respuesta8").toString()
                    encuestaEstudianteModel.respuesta9 =
                        respuestas.getString("respuesta9").toString()
                    encuestaEstudianteModel.respuesta10 =
                        respuestas.getString("respuesta10").toString()
                    encuestaEstudianteModel.respuesta11 =
                        respuestas.getString("respuesta11").toString()
                    encuestaEstudianteModel.respuesta12 =
                        respuestas.getString("respuesta12").toString()
                    encuestaEstudianteModel.respuesta13 =
                        respuestas.getString("respuesta13").toString()
                    encuestaEstudianteModel.respuesta14 =
                        respuestas.getString("respuesta14").toString()
                    encuestaEstudianteModel.respuesta15 =
                        respuestas.getString("respuesta15").toString()
                    encuestaEstudianteModel.respuesta16 =
                        respuestas.getString("respuesta16").toString()
                    encuestaEstudianteModel.respuesta17 =
                        respuestas.getString("respuesta17").toString()
                    encuestaEstudianteModel.respuesta18 =
                        respuestas.getString("respuesta18").toString()
                    encuestaEstudianteModel.respuesta19 =
                        respuestas.getString("respuesta19").toString()
                    encuestaEstudianteModel.respuesta20 =
                        respuestas.getString("respuesta20").toString()
                    encuestaEstudianteModel.respuesta21 =
                        respuestas.getString("respuesta21").toString()
                    encuestaEstudianteModel.respuesta22 =
                        respuestas.getString("respuesta22").toString()
                    encuestaEstudianteModel.respuesta23 =
                        respuestas.getString("respuesta23").toString()
                    encuestaEstudianteModel.respuesta24 =
                        respuestas.getString("respuesta24").toString()
                    encuestaEstudianteModel.respuesta25 =
                        respuestas.getString("respuesta25").toString()
                    encuestaEstudianteModel.respuesta26 =
                        respuestas.getString("respuesta26").toString()
                    encuestaEstudianteModel.respuesta27 =
                        respuestas.getString("respuesta27").toString()
                    encuestaEstudianteModel.respuesta28 =
                        respuestas.getString("respuesta28").toString()

                    encuestaEstudianteModel.observacion = observaciones.text.toString()
                }
            }
        }
        //retornar al inicio
        return root
    }
}