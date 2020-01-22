package com.example.findteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.findteam.databinding.FindTeamFragmentBinding

class FindTeamFragment : Fragment() {
    private lateinit var viewModel: FindTeamViewModel
    private lateinit var binding: FindTeamFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.find_team_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindTeamViewModel::class.java)
    }

    companion object {
        fun newInstance() = FindTeamFragment()
    }

}
