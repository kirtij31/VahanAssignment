package com.kirti.vahanassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kirti.vahanassignment.R
import com.kirti.vahanassignment.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebViewBinding.inflate(layoutInflater)


        val url = arguments?.getString("url")
        if (url != null) {
            binding.webView.loadUrl(url)
        }

        return binding.root
    }

}