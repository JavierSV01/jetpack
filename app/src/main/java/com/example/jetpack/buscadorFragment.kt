package com.example.jetpack

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_buscador.*

class buscadorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscador, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btAtras.setOnClickListener(View.OnClickListener {
            if (wView.canGoBack()) {
                wView.goBack()
            }
        })

        btAdelante.setOnClickListener(View.OnClickListener {
            if (wView.canGoForward()) {
                wView.goForward()
            }
        })

        var web:String ="https://www.google.es"

        arguments?.let {// si el argumento no es nulo ejecuta el bloque
            val dato = it.getString("web")
            web = dato.toString()
        }
        //wView.webViewClient.shouldOverrideUrlLoading(wView, web)
        wView.setWebViewClient(WebViewClient())
        wView.loadUrl(web)
    }


}