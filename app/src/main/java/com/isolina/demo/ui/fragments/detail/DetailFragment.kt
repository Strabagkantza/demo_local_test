package com.isolina.demo.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.isolina.demo.R
import com.isolina.demo.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var  binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel.product = args.productSelected
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {act ->
            binding.toolbar.let {
                it.title = ""
                it.setNavigationIcon(R.drawable.back)
                act.setActionBar(it)
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.name.text = viewModel.product.name
        binding.date.text = viewModel.product.getDate()

        context?.let {
            viewModel.product.links.patch.small?.let { image ->
                Glide.with(it).load(image).centerCrop().into(binding.image)
            }
        }
        binding.details.text = viewModel.product.details

    }

}