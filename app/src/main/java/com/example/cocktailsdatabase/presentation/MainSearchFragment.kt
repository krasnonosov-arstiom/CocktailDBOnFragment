package com.example.cocktailsdatabase.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.cocktailsdatabase.databinding.FragmentMainSearchBinding
import com.example.cocktailsdatabase.di.AppComponent
import com.example.cocktailsdatabase.di.ViewModelFactoryInjector
import com.example.cocktailsdatabase.presentation.adapters.CocktailListAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainSearchFragment : Fragment() {

    private lateinit var binding: FragmentMainSearchBinding
    private lateinit var viewModel: MainSearchViewModel
    private lateinit var adapter: CocktailListAdapter

    @Inject
    lateinit var viewModelFactoryInjector: ViewModelFactoryInjector

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        AppComponent.create().inject(this)
        binding = FragmentMainSearchBinding.inflate(inflater, container, false)
        viewModel = viewModelFactoryInjector.create(MainSearchViewModel::class, arguments ?: bundleOf())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CocktailListAdapter()
        observeData()
        setListeners()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.cocktailsListStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collect {
                    adapter.setDataSource(it)
                }
        }
    }

    private fun setListeners() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?) = false

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.onSearchQueryChanged(query.orEmpty())
                binding.header.requestFocus()
                return false
            }
        })
    }

    companion object {

        fun newInstance() = MainSearchFragment()
    }
}