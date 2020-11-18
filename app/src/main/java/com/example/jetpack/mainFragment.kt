package com.example.jetpack

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_operaciones.*

class mainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btBuscador.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("web", txWeb.text.toString())
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_buscadorFragment2, bundle)

        }

        btCamara.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_camaraFragment)
        }

        btOperaciones.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_operacionesFragment)
        }

    }


}