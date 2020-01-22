package com.example.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.consult.databinding.ConsultFragmentBinding

class ConsultFragment : Fragment() {
    private lateinit var viewModel: ConsultViewModel
    private lateinit var binding: ConsultFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.consult_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ConsultViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = ConsultFragment()
    }

}
