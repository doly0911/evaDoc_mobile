package com.saludpublica.evred.ui.encuestaEstudiante


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.saludpublica.evred.R
import com.saludpublica.evred.ui.Home.HomeFragment
import com.saludpublica.evred.ui.encuestaDocente.OnFragmentInteractionListener
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_encuesta_aspectos_generales_del_curso.*




class AspectosGeneralesFragment : Fragment() {

    internal var callback: OnFragmentInteractionListener? = null
    private val fragmentTitle = "Evaluación reflexiva"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        callback?.onFragmentInteraction(fragmentTitle)
        val bundle = this.arguments
        if (bundle != null) {
             var miCurso = bundle.getString("curso")
            Log.i("AspectosGenerales", miCurso)
        }

        val root = inflater.inflate(
            R.layout.fragment_encuesta_aspectos_generales_del_curso,
            container,
            false
        )
        val context = root.context
        val siguiente: Button = root.findViewById(R.id.siguiente)
        siguiente.setOnClickListener() {

            val respuesta1Id = respuesta1.checkedRadioButtonId
            val respuesta2Id = respuesta2.checkedRadioButtonId
            val respuesta3Id = respuesta3.checkedRadioButtonId
            when {
                respuesta1Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 1",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta2Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 2",
                    Toast.LENGTH_LONG
                )
                    .show()
                respuesta3Id == -1 -> Toasty.error(
                    context,
                    "Por favor responder la pregunta 3",
                    Toast.LENGTH_LONG
                )
                    .show()
                else -> {

                    val fragmentTransaction = fragmentManager?.beginTransaction()
                    val fragment = ObjetivosFragment()
                    val respuestas = Bundle()
                    var radioButton: View = respuesta1.findViewById(respuesta1Id)
                    var indice: Int = respuesta1.indexOfChild(radioButton)
                    var respuesta: RadioButton = respuesta1.getChildAt(indice) as RadioButton
                    respuestas.putString("respuesta1", respuesta.text.toString())
                   
                    radioButton = respuesta2.findViewById(respuesta2Id)
                    indice = respuesta2.indexOfChild(radioButton)
                    respuesta = respuesta2.getChildAt(indice) as RadioButton
                    respuestas.putString("respuesta2", respuesta.text.toString())

                    radioButton = respuesta3.findViewById(respuesta3Id)
                    indice = respuesta3.indexOfChild(radioButton)
                    respuesta = respuesta3.getChildAt(indice) as RadioButton
                    respuestas.putString("respuesta3", respuesta.text.toString())

                    fragment.arguments = respuestas
                    fragmentTransaction?.replace(R.id.nav_host_fragment, fragment)
                    fragmentTransaction?.commit()
                }
            }
        }
        // Redireccionar al home
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.nav_host_fragment, HomeFragment())
            fragmentTransaction?.commit()
        }
        return root
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        try {
            callback = activity as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement OnFragmentInteractionListener")
        }

    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }
}