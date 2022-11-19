package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment: Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeDetailViewModel
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this
        viewModel =  ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.shoeDetailviewMode = viewModel
        viewModel.eventSaveShoe.observe(viewLifecycleOwner, Observer { event ->
            if(event){
                val shoe:Shoe? = getValidatedShoe()
                if(shoe != null) mainActivityViewModel.setShoeToBeAdded(shoe)
                viewModel.onShoeSaved()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        })
        viewModel.eventCancelShoeAdd.observe(viewLifecycleOwner, Observer { event ->
            if(event){
                viewModel.onShoeAddCancelled()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        })



        return binding.root
    }

    private fun getValidatedShoe(): Shoe? {
        if(binding.shoeNameEditText.text.toString().trim().equals("")
            ||binding.shoeCompanyEditText.text.toString().trim().equals("")
            || binding.shoeSizeEditText.text.toString().trim().equals("")
            || binding.shoeDescriptionEditText.text.toString().trim().equals("")
        )
        {
            Toast.makeText(context,getString(R.string.missing_data),Toast.LENGTH_SHORT).show()
            return null
        }
        if(binding.shoeSizeEditText.text.toString().toDoubleOrNull() == null){
            Toast.makeText(context,getString(R.string.size_should_be_number),Toast.LENGTH_SHORT).show()
            return null
        }

        return Shoe(binding.shoeNameEditText.text.toString()
            ,binding.shoeSizeEditText.text.toString().toDouble()
            ,binding.shoeCompanyEditText.text.toString().trim()
            ,binding.shoeDescriptionEditText.text.toString().trim()
            , listOf()
        )
    }


}