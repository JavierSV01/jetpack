package com.example.jetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_operaciones.*


class OperacionesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operaciones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btCalcular.setOnClickListener(){
            if(!txNum2.text.toString().equals("") && !txNum1.text.toString().equals("")) {
                var bundle = Bundle()
                bundle.putString("Num2", txNum2.text.toString())
                if (rbGroup.checkedRadioButtonId == rbSumar.id) {
                    var result =
                        Integer.parseInt(txNum1.text.toString()) + Integer.parseInt(txNum2.text.toString())
                    bundle.putInt("result", result)
                    Navigation.findNavController(it)
                        .navigate(R.id.action_operacionesFragment_to_sumaFragment, bundle)
                }
                if (rbGroup.checkedRadioButtonId == rbRestar.id) {
                    var result =
                        Integer.parseInt(txNum1.text.toString()) - Integer.parseInt(txNum2.text.toString())
                    bundle.putInt("result", result)
                    Navigation.findNavController(it)
                        .navigate(R.id.action_operacionesFragment_to_restaFragment, bundle)
                }
                if (rbGroup.checkedRadioButtonId == rbDividir.id) {
                    var result = Integer.parseInt(txNum1.text.toString())
                        .toFloat() / Integer.parseInt(txNum2.text.toString()).toFloat()
                    bundle.putFloat("result", result)
                    Navigation.findNavController(it)
                        .navigate(R.id.action_operacionesFragment_to_divisionFragment, bundle)
                }
            }else{
                Toast.makeText(super.getContext(), "Error: Debes rellenar los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}