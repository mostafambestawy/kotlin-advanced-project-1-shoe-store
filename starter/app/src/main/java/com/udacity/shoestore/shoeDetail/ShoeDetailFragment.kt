package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeDetailViewModel
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.shoeDetailViewModel = viewModel

        viewModel.eventSaveShoe.observe(viewLifecycleOwner) { event ->
            if (event) {
                val shoe: Shoe? = getValidatedShoe()
                if (shoe != null) {
                    mainActivityViewModel.setShoeToBeAdded(shoe)
                    viewModel.onShoeSaved()
                    findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
                }
            }
        }
        viewModel.eventCancelShoeAdd.observe(viewLifecycleOwner) { event ->
            if (event) {
                viewModel.onShoeAddCancelled()
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }



        return binding.root
    }

    private fun getValidatedShoe(): Shoe? {
        if (viewModel.shoeName.value!!.toString().trim().equals("")
            || viewModel.shoeSize.value!! == 0.0
            || viewModel.shoeCompany.value!!.toString().trim().equals("")
            || viewModel.shoeDescription.value!!.toString().trim().equals("")
        ) {
            Toast.makeText(context, getString(R.string.missing_data), Toast.LENGTH_SHORT).show()
            return null
        }
        if (viewModel.shoeSize.value!!.toString().toDoubleOrNull() == null) {
            Toast.makeText(context, getString(R.string.size_should_be_number), Toast.LENGTH_SHORT)
                .show()
            return null
        }

        return Shoe(
            viewModel.shoeName.value.toString(),
            viewModel.shoeSize.value!!.toDouble(),
            viewModel.shoeCompany.value.toString(),
            viewModel.shoeDescription.value.toString(),
            listOf()
        )

    }


}