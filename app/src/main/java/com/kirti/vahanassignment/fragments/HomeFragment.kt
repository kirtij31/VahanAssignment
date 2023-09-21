package com.kirti.vahanassignment.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirti.vahanassignment.viewModels.MyViewModel
import com.kirti.vahanassignment.R
import com.kirti.vahanassignment.adapter.UniversityAdapter
import com.kirti.vahanassignment.adapter.ClickHandler
import com.kirti.vahanassignment.databinding.FragmentHomeBinding


class HomeFragment : Fragment(),ClickHandler {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var universityAdapter: UniversityAdapter
    private lateinit var viewModel: MyViewModel

    private val delay :Long = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.list.observe(viewLifecycleOwner) {
            universityAdapter = UniversityAdapter(context, it, this@HomeFragment)
            binding.recyclerView.adapter = universityAdapter
            binding.recyclerView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun openWebsite(url: String) {
        val bundle = Bundle()
        bundle.putString("url",url)
        findNavController().navigate(R.id.fragment_webView,bundle)
    }


}