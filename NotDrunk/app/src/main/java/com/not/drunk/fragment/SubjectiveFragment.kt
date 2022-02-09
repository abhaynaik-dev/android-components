package com.not.drunk.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.not.drunk.databinding.FragmentSubjectiveBinding
import com.not.drunk.viewmodel.NODViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [SubjectiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubjectiveFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentSubjectiveBinding

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: NODViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSubjectiveBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.fragmentNODViewModel = sharedViewModel
            binding.lifecycleOwner = viewLifecycleOwner
            binding.subjectiveFragment = this@SubjectiveFragment
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            sharedViewModel.resetScore()
        }

        requireActivity().getOnBackPressedDispatcher().addCallback(viewLifecycleOwner, callback);
    }

    fun onSubmit(){
        sharedViewModel.checkPlayerAnswer()
        clearUI()
    }

    private fun clearUI(){
        binding.edtPlayerAnswer.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}