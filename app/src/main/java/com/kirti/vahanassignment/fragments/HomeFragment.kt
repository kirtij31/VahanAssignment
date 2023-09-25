package com.kirti.vahanassignment.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirti.vahanassignment.viewModels.MyViewModel
import com.kirti.vahanassignment.R
import com.kirti.vahanassignment.adapter.UniversityAdapter
import com.kirti.vahanassignment.adapter.OnItemClickListener
import com.kirti.vahanassignment.databinding.FragmentHomeBinding
import com.kirti.vahanassignment.services.ForegroundService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment(),OnItemClickListener {

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

        startTimer()

        viewModel.list.observe(viewLifecycleOwner) {
            universityAdapter = UniversityAdapter(context, it, this@HomeFragment)
            binding.recyclerView.adapter = universityAdapter
            binding.recyclerView.visibility=View.VISIBLE
            binding.progressBar.visibility=View.INVISIBLE
        }
    }

     private fun startTimer(delayTime: Long = 10000, repeatTime: Long = 10000 ) {
         CoroutineScope(Dispatchers.Main).launch {
             viewModel.getUniversityList()
             delay(repeatTime)
             if (repeatTime == delayTime) {
                 while (true) {
                     viewModel.getUniversityList()
                     delay(repeatTime)
                 }
             }
         }
     }

    override fun onItemClick(webUrl: String) {
        val bundle = Bundle()
        bundle.putString("url",webUrl)
        findNavController().navigate(R.id.fragment_webView,bundle)
    }

}