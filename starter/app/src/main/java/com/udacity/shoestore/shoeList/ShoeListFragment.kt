package com.udacity.shoestore.shoeList


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe: Shoe in shoeList) run {
                binding.shoeListLinearLayout.addView(getShoeView(shoe))
            }

        })
        return binding.root
    }

    private fun getShoeView(shoe: Shoe): View? {

        val _binding: ShoeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.shoe_item,binding.shoeListLinearLayout,false)
        _binding.shoe = shoe

        context?.let { Glide.with(it).load(shoe.images[0]).into(_binding.shoeImageView) };
        return _binding.root

    }

}