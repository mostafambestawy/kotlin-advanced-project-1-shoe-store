package com.udacity.shoestore.shoeList


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.annotation.ArrayRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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
        binding.addShoefloatingActionButton.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        var args = ShoeListFragmentArgs.fromBundle(requireArguments())
        if(args.isShoeItemAdded){
            //TODO know why the viewModel.shoeList.value is returned null,
            // although the viewModel exist during the lifecycle and  viewModel.onCleared() not called
           viewModel.addShoeItem(args.shoeItem!!)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                ||
        super.onOptionsItemSelected(item)
    }
    private fun getShoeView(shoe: Shoe): View? {

        val _binding: ShoeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.shoe_item,binding.shoeListLinearLayout,false)
        _binding.shoe = shoe
        if(shoe.images.isNotEmpty())
        context?.let { Glide.with(it).load(shoe.images[0]).into(_binding.shoeImageView) }
        else _binding.shoeImageView.visibility = View.GONE
        return _binding.root

    }

}