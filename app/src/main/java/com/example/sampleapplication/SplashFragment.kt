package com.example.sampleapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapplication.databinding.FragmentSplashBinding
import com.example.sampleapplication.utils.application.AppService
import com.example.sampleapplication.utils.build_config.BuildConfig.Companion.INTERVAL
import com.example.sampleapplication.utils.extention.initVersion
import com.example.sampleapplication.utils.tools.HandleErrorTools
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.android.ext.android.inject

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    private lateinit var navController: NavController
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private val handleErrorTools: HandleErrorTools by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initNavController()
        initSetView()
        initHandler()
    }

    @SuppressLint("SetTextI18n")
    private fun initSetView() {
        binding.txtVersionApp.text =
            "${resources.getString(R.string.version_app)} ${requireContext().initVersion()}"
    }

    private fun initNavController() {
        navController = Navigation.findNavController(AppService.activity, R.id.my_nav_fragment)
    }

    private fun initHandler() {
        Handler().postDelayed({
          navController.popBackStack()
          navController.navigate(R.id.homeFragment)
        }, INTERVAL)
    }

}