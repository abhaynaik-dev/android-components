package com.not.drunk.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.not.drunk.*
import com.not.drunk.databinding.FragmentMcqBinding
import com.not.drunk.viewmodel.NODViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MCQFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MCQFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentMcqBinding

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: NODViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentMcqBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            binding.viewModel = sharedViewModel
            binding.lifecycleOwner = viewLifecycleOwner
            binding.mcqFragment = this@MCQFragment
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
            sharedViewModel.resetScore()
        }

        requireActivity().getOnBackPressedDispatcher().addCallback(viewLifecycleOwner, callback);
    }

    fun onSubmit(){
        sharedViewModel.checkPlayerAnswer()
    }

    fun onAnsweredGroup1(view: View){
        binding.mcqRadioGroup2.clearCheck()
        val playerAnswer = when(view){
            binding.radioAnsA -> MCQ_ANSWER_A
            binding.radioAnsB -> MCQ_ANSWER_B
            else -> MCQ_ANSWER_UNDEFINED
        }
        sharedViewModel.playerAnswer.value = playerAnswer
    }

    fun onAnsweredGroup2(view: View){
        binding.mcqRadioGroup1.clearCheck()
        val playerAnswer = when(view){
            binding.radioAnsC -> MCQ_ANSWER_C
            binding.radioAnsD -> MCQ_ANSWER_D
            else -> MCQ_ANSWER_UNDEFINED
        }
        sharedViewModel.playerAnswer.value = playerAnswer
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}