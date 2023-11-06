package com.example.sampleapplication.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.FragmentMemoryInfoBinding
import com.example.sampleapplication.utils.application.AppService
import com.example.sampleapplication.utils.extention.getMemoryInfo
import com.example.sampleapplication.utils.tools.HandleErrorTools
import org.koin.android.ext.android.inject

class MemoryInfoFragment : Fragment() {

    private lateinit var binding: FragmentMemoryInfoBinding
    private lateinit var navController: NavController
    private val handleErrorTools: HandleErrorTools by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMemoryInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initNavController()
        initTitleToolbar()
        initSetMemory()
        initOnClick()
    }

    private fun initTitleToolbar() {
        binding.included.toolbarTitle.text = resources.getString(R.string.memory)
    }

    private fun initSetMemory() {
        binding.txtMemoryInfo.text = requireActivity().getMemoryInfo()
    }

    private fun initOnClick() {
        binding.included.imgBtnBack.setOnClickListener { navController.popBackStack() }
    }

    private fun initNavController() {
        navController = Navigation.findNavController(AppService.activity, R.id.my_nav_fragment)
    }

}