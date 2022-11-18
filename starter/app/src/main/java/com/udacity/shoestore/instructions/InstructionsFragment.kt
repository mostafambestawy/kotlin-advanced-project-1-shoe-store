package com.udacity.shoestore.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.models.Shoe

class InstructionsFragment: Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    private lateinit var viewModel: InstructionsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[InstructionsViewModel::class.java]
        viewModel.acceptInstructions.observe(viewLifecycleOwner, Observer { acceptInstructions ->
            if (acceptInstructions) {

            }
        })
        binding.shoeListingButton.setOnClickListener {
        findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment(false))
        }

        return binding.root
    }


}