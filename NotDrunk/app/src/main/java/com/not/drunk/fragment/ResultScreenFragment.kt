package com.not.drunk.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.not.drunk.databinding.FragmentResultScreenBinding
import com.not.drunk.viewmodel.NODViewModel

class ResultScreenFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentResultScreenBinding

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: NODViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentResultScreenBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            binding.resultScreen = this@ResultScreenFragment
            binding.fragmentNODViewModel = sharedViewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }
    }

    fun resetTheGame(){
        sharedViewModel.resetScore()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}