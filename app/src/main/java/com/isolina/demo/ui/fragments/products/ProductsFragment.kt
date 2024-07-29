package com.isolina.demo.ui.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.isolina.demo.databinding.FragmentProductsBinding
import com.isolina.demo.ui.fragments.products.adapter.ProductItemAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var  binding: FragmentProductsBinding
    private val viewModel: ProductsViewModel by viewModels()
    private lateinit var adapter: ProductItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            viewModel.instance(it)
        }

        adapter = ProductItemAdapter { prod ->
            findNavController().navigate(ProductsFragmentDirections.actionProductsToDetail(prod))
        }
        binding.list.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) {
            binding.swipe.isRefreshing = false
            adapter.submitList(it)
            adapter.notifyDataSetChanged()

        }

        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.visibility = if (it)  View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        ).apply {
            binding.list.layoutManager = this
        }

        binding.swipe.setOnRefreshListener {
            viewModel.products()
        }

    }

}