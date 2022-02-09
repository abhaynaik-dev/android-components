package com.not.drunk.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.not.drunk.R
import com.not.drunk.databinding.FragmentSplashScreenBinding
import com.not.drunk.viewmodel.NODViewModel

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentSplashScreenBinding

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: NODViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            binding.fragmentNODViewModel = sharedViewModel
            binding.splashScreen = this@SplashScreenFragment
            binding.lifecycleOwner = viewLifecycleOwner
        }
    }

    fun beginTheGame(){
        sharedViewModel.getNextQuestion()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}