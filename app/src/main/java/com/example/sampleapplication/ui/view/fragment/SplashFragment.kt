package com.example.sampleapplication.ui.view.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapplication.R
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

    private val REQUEST_BLUETOOTH_SCAN_PERMISSION = 1

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

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_BLUETOOTH_SCAN_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
            } else {
                requireActivity().finishAffinity()
            }
        }
    }

    private fun checkBluetoothScanPermission(activity: Activity): Boolean {
        val hasPermission = ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.BLUETOOTH_SCAN
        )
        return hasPermission == PackageManager.PERMISSION_GRANTED
    }

    // Function to request Bluetooth scan permission
    @RequiresApi(Build.VERSION_CODES.S)
    private fun requestBluetoothScanPermission(activity: Activity) {
        val permission = Manifest.permission.BLUETOOTH_SCAN
        if (ContextCompat.checkSelfPermission(
                activity,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                REQUEST_BLUETOOTH_SCAN_PERMISSION
            )
        }
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
            initResult()
        }, INTERVAL)
    }

    private fun initResult() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (checkBluetoothScanPermission(AppService.activity)) {
                navController.popBackStack()
                navController.navigate(R.id.homeFragment)
            } else {
                requestBluetoothScanPermission(AppService.activity)
            }
        }else{
            navController.popBackStack()
            navController.navigate(R.id.homeFragment)
        }
    }

}