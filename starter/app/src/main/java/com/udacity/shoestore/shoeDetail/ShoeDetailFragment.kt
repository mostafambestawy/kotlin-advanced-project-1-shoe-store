package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment: Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this


        binding.saveButton.setOnClickListener {
            val shoe:Shoe? = getValidatedShoe()
            if(shoe != null)
          findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(true,shoe,))
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(false))
        }

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
            Toast.makeText(context,"Shoe Size should be a number !!",Toast.LENGTH_SHORT).show()
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